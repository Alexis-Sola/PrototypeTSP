package application;

import java.io.IOException;

import application.tools.Tools;
import application.tools.ViewsManager;
import javafx.fxml.FXML;

public class ImportMapController {
    
    @FXML private javafx.scene.control.Button backButton;

    /**
     * Ouvre la vu d'import de fichier csv
     * @throws IOException
     */
    @FXML
    private void openHomeView() throws IOException {
         
    	ViewsManager.OpenHomeView();   
        Tools.closePreviousScene(backButton);
    } 

}