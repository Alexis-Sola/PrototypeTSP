package application;

import java.io.IOException;

import application.tools.Tools;
import application.tools.ViewsManager;
import javafx.fxml.FXML;

public class HomeController {
    
    @FXML private javafx.scene.control.Button createButton;

    
    /**
     * Ouvre la vu d'import de fichier csv
     * @throws IOException
     */
    @FXML
    private void openImportMapView() throws IOException {
               
        ViewsManager.OpenImportMapView();
        Tools.closePreviousScene(createButton);
    } 
    
    @FXML
    private void openAddEntriesView() throws IOException {
               
        ViewsManager.OpenAddEntriesView();
        Tools.closePreviousScene(createButton);
    } 

}