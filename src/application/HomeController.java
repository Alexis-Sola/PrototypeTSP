package application;

import java.io.IOException;

import application.tools.Tools;
import application.tools.ViewsManager;
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
               
        ViewsManager.OpenImportMapView();
        Tools.closePreviousScene(importButton);
    } 
    
    @FXML
    private void openAddEntriesView() throws IOException {
               
        ViewsManager.OpenAddEntriesView();
        Tools.closePreviousScene(importButton);
    } 

}