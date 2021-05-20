package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


import application.tools.Tools;
import application.tools.ViewsManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ImportMapController {
	
	File file;
    final FileChooser fileChooser = new FileChooser();

    
    @FXML private Button backButton;
    @FXML private Button parcourir;
    
	@FXML private TextArea fileSelected;

    /*
     * Ouvre la vu d'import de fichier csv
     * @throws IOException
     */
    @FXML
    private void openHomeView() throws IOException {
         
    	ViewsManager.OpenHomeView();   
        Tools.closePreviousScene(backButton);
    }
    
    /*
     * Chercher un fichier
     */
    public void browse()
    {
        Stage stage = (Stage) backButton.getScene().getWindow();

    	file = fileChooser.showOpenDialog(stage);
    	
    	if (file != null) 
    		fileSelected.appendText(file.getAbsolutePath() + "\n");     
    }
    
    /*
     * Affiche la vue TSP
     */
    public void valider() throws FileNotFoundException, IOException
    {
    	if(file != null)
    	{
	    	Communication.staticPointList = Tools.readCSVFile(file);
	    	Tools.closePreviousScene(backButton);
	    	ViewsManager.OpenTSPView();
    	}
    }

}