package application.tools;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import application.Main;
import application.Point2D;
import application.ressources.BundleResource;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Tools extends BundleResource{
		
	 public static Parent loadFXML(String fxml) throws IOException {
	        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
	        return fxmlLoader.load();
	    }
	 
    public static void closePreviousScene(Node obj) throws IOException {
         
        Stage stage = (Stage) obj.getScene().getWindow();
        stage.close();
    }
    
    public static void hideView(Node obj) throws IOException {
        
        Stage stage = (Stage) obj.getScene().getWindow();
        stage.hide();
    }
    
    /*
     * Write csv file with Point2d
     */
    public static void writePoint2DInCSVFile(ArrayList<Point2D> list) throws IOException
    {
    	String path = bundle.getString("path.csv.name");
    	UUID uuid = UUID.randomUUID();


    	FileWriter csvWriter = new FileWriter(path + "model" + uuid + ".csv");
    	
    	csvWriter.append("position x");
    	csvWriter.append(",");
    	csvWriter.append("position y");
    	csvWriter.append("\n");

    	for (Point2D val : list) 
    	{
        	csvWriter.append(String.valueOf(val.getX()));
        	csvWriter.append(",");
        	csvWriter.append(String.valueOf(val.getY()));
        	csvWriter.append("\n");
    	}

    	csvWriter.flush();
    	csvWriter.close();	
    }

}
