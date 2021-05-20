package application.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import application.Main;
import application.Point2D;
import application.ressources.BundleResource;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Tools extends BundleResource{
		
	/*
	 * Charge la vue de départ
	 */
	 public static Parent loadFXML(String fxml) throws IOException {
	        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
	        return fxmlLoader.load();
	    }
	 
	 /*
	  * Ferme la vue précédente
	  */
    public static void closePreviousScene(Node obj) throws IOException {
         
        Stage stage = (Stage) obj.getScene().getWindow();
        stage.close();
    }
    
    /*
     * Cache une vue
     */
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
    
    /*
     * Read csv file
     */
    public static ArrayList<Point2D> readCSVFile(File file) throws FileNotFoundException, IOException
    {
    	ArrayList<Point2D> records = new ArrayList<>();
    	
    	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    	    String line;
    	    int cpt = 0;
    	    while ((line = br.readLine()) != null) {
    	    	if(cpt > 0)
    	    	{
	    	        String[] values = line.split(",");
	    	        int x = Integer.parseInt(values[0]);
	    	        int y = Integer.parseInt(values[1]);
	
	    	        Point2D newPoint = new Point2D(x, y);
	    	        records.add(newPoint);
    	    	}
    	    	cpt++;
    	    }
    	}
    	
    	return records;
    }

}
