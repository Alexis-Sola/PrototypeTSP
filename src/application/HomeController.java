package application;

import java.io.IOException;

import application.tools.Tools;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController {
    
    @FXML private javafx.scene.control.Button importButton;

    
    /**
     * Ouvre la vu d'import de fichier csv
     * @throws IOException
     */
    @FXML
    private void openImportMapView() throws IOException {
         
        Scene scene = new Scene(Tools.loadFXML("ImportMapView"), 400, 500);
        
        Stage stage = new Stage();
        stage.setTitle("Importer une carte");
        stage.setScene(scene);
        
        stage.show();
        
        Tools.closePreviousScene(importButton);
    } 

}