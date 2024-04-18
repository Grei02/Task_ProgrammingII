/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.taskprogrammingii.controller;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import cr.ac.una.taskprogrammingii.model.Account;
import cr.ac.una.taskprogrammingii.model.Associated;
import cr.ac.una.taskprogrammingii.model.FileManager;
import cr.ac.una.taskprogrammingii.util.AppContext;
import cr.ac.una.taskprogrammingii.util.FlowController;
import cr.ac.una.taskprogrammingii.util.Mensaje;
import io.github.palexdev.materialfx.controls.MFXSpinner;
import io.github.palexdev.materialfx.controls.models.spinner.IntegerSpinnerModel;
import io.github.palexdev.materialfx.utils.SwingFXUtils;
import java.awt.Desktop;
import java.awt.image.BufferedImage;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.imageio.ImageIO;


public class registerAssociateSectionController extends Controller implements Initializable {
    
     private Associated associated=new Associated();
     private FileManager fileManager= new FileManager();
     private Mensaje message=new Mensaje();
     private List<Associated> associatedList=new ArrayList<>();
     private List<Associated> listDeserialization= new ArrayList<>();
     
        @FXML
    private Button btnSave;

    @FXML
    private Button btnTakePhoto;

    @FXML
    private MFXSpinner<Integer> spnAge;

    @FXML
    private TextField txtFolio;

    @FXML
    private TextField txtSecondUserLastName;

    @FXML
    private TextField txtUserLastName;

    @FXML
    private TextField txtuserName;

    @FXML
    void onActionBtnTakePhoto(ActionEvent event) {
        associated.setName(txtuserName.getText().trim());
        associated.setLastName(txtUserLastName.getText().trim());
        associated.setAge(Integer.toString(spnAge.getValue()));
        
        if (!associated.getName().isBlank() && !associated.getLastName().isBlank() && !associated.getAge().isBlank()) {
            createFolio();
            FlowController.getInstance().goView("PhotographyView");
        }
        else{
            message.show(Alert.AlertType.WARNING, "Alerta", "Has dejado un espacio en blanco, por favor llenalo o no podras registarte.");
        } 
      
    }
    
    @FXML
    void onActionbtnSave(ActionEvent event) throws IOException  {
         if ((BufferedImage)AppContext.getInstance().get("bufferedImageAssociated")!=null) {
             savePhoto();
             userCard();
             Desktop.getDesktop().open(new File (System.getProperty("user.dir")+"\\UserCard\\"+associated.getFolio()+".pdf"));
             AppContext.getInstance().set("bufferedImageAssociated", null);
             
//             List <Account> cuentalista=new ArrayList<>();
//             cuentalista.add(new Account("hola",0));
//             cuentalista.add(new Account("adios",0));
//             associated.setAcountList(cuentalista);
             listDeserialization= fileManager.deserialize("ListAssociated.txt");
             listDeserialization.add(associated);
             fileManager.serialization(listDeserialization,"ListAssociated.txt");
             message.show(Alert.AlertType.INFORMATION, "Confirmacion", "Te has registrado existosamente");
             txtuserName.setText(null);
             txtUserLastName.setText(null);
             spnAge.setValue(0);
            // txtUserAge.setText(null);
        }
        else{
            message.show(Alert.AlertType.WARNING, "Alerta", "Para guardar debes tomarte una foto.");
        }
    }
    
    private void createFolio() {
        if(associated.getFolio()==null){
        String folio=null;
        Random random=new Random();
        char letter=associated.getLastName().charAt(0);
        do{
           folio=Character.toUpperCase(letter)+String.valueOf(random.nextInt(401) + 99);
        } while (existsFolio(folio));
        associated.setFolio(folio);
        txtFolio.setText(folio);
        }
    }
    
    private Boolean existsFolio(String folio){
        associatedList=fileManager.deserialize("ListAssociated.txt");
        for(Associated compareAssociated:associatedList){
            if(compareAssociated.getFolio()==folio){
                return true;
            }
        }
        return false;
    }
    
    public void savePhoto(){
     String routeRoot = System.getProperty("user.dir");
     String  dirección="\\AssociatedPhotographs\\"+associated.getFolio()+".png";
     File savePhoto = new File(routeRoot+dirección);
     associated.setAddressPhotography(dirección);
      try {
          ImageIO.write((BufferedImage)AppContext.getInstance().get("bufferedImageAssociated"), "png", savePhoto);
      }
      catch (Exception e){
          System.out.println("Error:"+e);
      }
    }
    
//    public void showPhoto(){
//         if((BufferedImage)AppContext.getInstance().get("bufferedImageAssociated")!=null){
//            BufferedImage bufferedImage=(BufferedImage)AppContext.getInstance().get("bufferedImageAssociated");
//             Image userImage= SwingFXUtils.toFXImage(bufferedImage, null);
//             imvUserImage.setImage(userImage);
//            }
//    }
    
    public void userCard(){
        String address=System.getProperty("user.dir")+"\\UserCard\\"+associated.getFolio()+".pdf";
        String backgroundImagePath="src/main/resources/cr/ac/una/taskprogrammingii/resources/UserCard.png";
        String addresAssociatedPhotograsphs="AssociatedPhotographs/"+associated.getFolio()+".png";
        Document document;
        try{
            PdfWriter writePdf=  new PdfWriter(address);
            PdfDocument pdf= new PdfDocument(writePdf);
            PageSize pdfSize= new PageSize(549, 303);
            
            pdf.setDefaultPageSize(pdfSize);
            document=new Document(pdf);
            
            ImageData backgroundImage=ImageDataFactory.create(backgroundImagePath);
            PdfCanvas canva= new PdfCanvas(pdf.addNewPage());
            canva.addImage(backgroundImage, 0,0,pdfSize.getWidth(), false);
            
            ImageData imageDataUser =ImageDataFactory.create(addresAssociatedPhotograsphs);
            canva.addImage(imageDataUser,new Rectangle(420, 100, 115, 91), false);
            
            Paragraph paragraphName=new Paragraph("Nombre: "+associated.getName()+" "+associated.getLastName())
                .setFontSize(14)
                .setMarginTop(97)
                .setMarginLeft(35);
            
            Paragraph paragraphAge=new Paragraph("Edad: "+associated.getAge())
                .setFontSize(14)
                .setMarginTop(6)
                .setMarginLeft(35);
            
            Paragraph paragraphFolio=new Paragraph("Folio: "+associated.getFolio())
                .setFontSize(14)
                .setMarginTop(6)
                .setMarginLeft(35);
            
            
            
            document.add(paragraphName);
            document.add(paragraphAge);
            document.add(paragraphFolio);
            
            document.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void initializeComponents(){
        txtFolio.setDisable(true);
        spnAge.setSpinnerModel (new IntegerSpinnerModel (0));
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//       associatedList=fileManager.deserialize("ListAssociated.txt");
//       txtuserName.setText(associatedList.get(2).getName());
//       txtUserLastName.setText(associatedList.get(2).getLastName());
//       txtUserAge.setText(associatedList.get(2).getAge());
//        System.out.println(associatedList.get(2).getFolio());
//        Image userImage= new Image("file:///"+associatedList.get(2).getAddressPhotography());
//        imvUserImage.setImage(userImage);
    }

    @Override
    public void initialize() {
         initializeComponents();
         
    }

}
