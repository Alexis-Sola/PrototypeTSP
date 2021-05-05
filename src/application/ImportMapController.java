package application;

import java.io.IOException;

import application.tools.Tools;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ImportMapController {
    
    @FXML private javafx.scene.control.Button backButton;

    /**
     * Ouvre la vu d'import de fichier csv
     * @throws IOException
     */
    @FXML
    private void openHomeView() throws IOException {
         
        Scene scene = new Scene(Tools.loadFXML("HomeView"), 600, 600);
        
        Stage stage = new Stage();
        stage.setTitle("Vue principale");
        stage.setScene(scene);
        
        stage.show();
        
        Tools.closePreviousScene(backButton);
    } 

}