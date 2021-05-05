package application.tools;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Tools {
	
	 public static Parent loadFXML(String fxml) throws IOException {
	        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
	        return fxmlLoader.load();
	    }
	 
    public static void closePreviousScene(Node obj) throws IOException {
         
        Stage stage = (Stage) obj.getScene().getWindow();
        stage.close();
    }

}
