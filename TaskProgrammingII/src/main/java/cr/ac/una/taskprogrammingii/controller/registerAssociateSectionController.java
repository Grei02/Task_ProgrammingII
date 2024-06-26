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
     IntegerSpinnerModel spinnerModel = new IntegerSpinnerModel(5);
     
    @FXML
    private Button btnCancel;
     
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
        String expresionRegular = "^[a-zA-Z]+$";
        if((txtuserName.getText().matches("^[a-zA-Z]+(\\s[a-zA-Z]+)*$"))&&(txtUserLastName.getText().matches(expresionRegular))&&
                (txtSecondUserLastName.getText().matches(expresionRegular))){
            associated.setName(txtuserName.getText().trim());
            associated.setLastName(txtUserLastName.getText().trim());
            associated.setAge(Integer.toString(spnAge.getValue()));
            associated.setSecondLastName(txtSecondUserLastName.getText().trim());
            if(!existsAssociate()){
                permissionsTakePhotos();
            }
            else{
                message.show(Alert.AlertType.WARNING, "Alerta", "Ya hay una persona registrada con el mismo nombre");
                cleanComponents();
            }
        }
        else{
                message.show(Alert.AlertType.WARNING, "Advertencia", "Recuerda que solo el nombre puede llevar dos palabras, no se permiten los espacios al inicio o final y sobre todo revisa no haber dejado ningun espacio en blanco");
        }
    }
    
    @FXML
    void onActionbtnSave(ActionEvent event) throws IOException  {
         if ((BufferedImage)AppContext.getInstance().get("bufferedImageAssociated")!=null) {
             savePhoto();
             //userCard();
             //Desktop.getDesktop().open(new File (System.getProperty("user.dir")+"\\UserCard\\"+associated.getFolio()+".pdf"));
             
             listDeserialization= fileManager.deserialize("ListAssociated.txt");
             listDeserialization.add(associated);
             fileManager.serialization(listDeserialization,"ListAssociated.txt");
             message.show(Alert.AlertType.INFORMATION, "Confirmacion", "Te has registrado existosamente");
             cleanComponents();
        }
        else{
            message.show(Alert.AlertType.WARNING, "Alerta", "Para guardar debes tomarte una foto.");
        }
    }
    
    @FXML
    void onAntionBtnCancel(ActionEvent event) {
        cleanComponents();
    }
    
    public void cleanComponents(){
             AppContext.getInstance().set("bufferedImageAssociated", null);
             txtuserName.setText(null);
             txtUserLastName.setText(null);
             txtSecondUserLastName.setText(null);
             txtFolio.setText(null);
             spnAge.setValue(5);
    }
    
    public Boolean existsAssociate(){
        String fullNameCompare;
        associatedList=fileManager.deserialize("ListAssociated.txt");
        String fullName=associated.getName().toUpperCase().replace(" ", " ")+associated.getLastName().toUpperCase().replace(" ", " ")+
                associated.getSecondLastName().toUpperCase().replace(" ", " ");
         for(Associated compareAssociated:associatedList){
              fullNameCompare=compareAssociated.getName().toUpperCase().replace(" ", " ")+compareAssociated.getLastName().toUpperCase().replace(" ", " ")+
                compareAssociated.getSecondLastName().toUpperCase().replace(" ", " ");
            if(fullNameCompare.equals(fullName)){
                return true;
            }
        }
        return false;
    }
    
    public void permissionsTakePhotos(){
        if (!associated.getName().isBlank() && !associated.getLastName().isBlank() && !associated.getAge().isBlank()&&
                !associated.getSecondLastName().isBlank()) {
            createFolio();
            FlowController.getInstance().goViewInWindowModal("PhotographyView", getStage(), Boolean.FALSE);
        }
        else{
            message.show(Alert.AlertType.WARNING, "Alerta", "Has dejado un espacio en blanco, por favor llenalo o no podras registarte.");
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
            if(compareAssociated.getFolio().equals(folio)){
                return true;
            }
        }
        return false;
    }
    
    public void savePhoto(){
     String routeRoot = System.getProperty("user.dir");
     String  dirección=associated.getFolio()+".png";
     File savePhoto = new File(dirección);
     associated.setAddressPhotography(dirección);
      try {
          ImageIO.write((BufferedImage)AppContext.getInstance().get("bufferedImageAssociated"), "png", savePhoto);
      }
      catch (IOException e){
          System.out.println("Error:"+e);
      }
    }

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
            
            Paragraph paragraphName=new Paragraph("Nombre: "+associated.getName()+" "+associated.getLastName()+" "+associated.getSecondLastName())
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
          System.out.println("Error:"+e);
        }
    }
    
    public void initializeComponents(){
        txtFolio.setDisable(true);
        spinnerModel.setMin(5);
        spnAge.setSpinnerModel (spinnerModel);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeComponents();
    }

    @Override
    public void initialize() {
         initializeComponents();
    }

}
