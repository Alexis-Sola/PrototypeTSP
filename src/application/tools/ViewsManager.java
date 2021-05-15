package application.tools;

import java.io.IOException;

import application.ressources.BundleResource;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewsManager extends BundleResource{
	
	/*
	 * Ouvre l'écran d'accueil
	 */
	public static void OpenHomeView() throws IOException  {
		
		//On récupère les propriétés de la vue
		int x = Integer.parseInt(bundle.getString("x.size.homeview"));
    	int y = Integer.parseInt(bundle.getString("y.size.homeview"));
    	String viewName =  bundle.getString("name.homeview");
    	String title =  bundle.getString("title.homeview");
    	
        Scene scene = new Scene(Tools.loadFXML(viewName), x, y);
        
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        
        stage.setResizable(false);
        
        stage.show();
	}
	
	/*
	 * Ouvre la vue permettant de choisir un csv
	 */
	public static void OpenImportMapView() throws IOException{
		
		int x = Integer.parseInt(bundle.getString("x.size.importview"));
    	int y = Integer.parseInt(bundle.getString("y.size.importview"));
    	String viewName =  bundle.getString("name.importview");
    	String title =  bundle.getString("title.importview");
		
        Scene scene = new Scene(Tools.loadFXML(viewName), x, y);
        
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        
        stage.setResizable(false);
        
        stage.show();
        
	}
	
	/*
	 * Ouvre la vue où l'on peut créer un modèle
	 */
	public static void OpenAddEntriesView() throws IOException{
		
		int x = Integer.parseInt(bundle.getString("x.size.addview"));
    	int y = Integer.parseInt(bundle.getString("y.size.addview"));
    	String viewName =  bundle.getString("name.addview");
    	String title =  bundle.getString("title.addview");
		
        Scene scene = new Scene(Tools.loadFXML(viewName), x, y);
        
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        
        stage.setResizable(false);
        
        stage.show();
        
	}
	
	/*
	 * Ouvre la où le TSP va se dérouler
	 */
	public static void OpenTSPView() throws IOException{
		
		int x = Integer.parseInt(bundle.getString("x.size.tspview"));
    	int y = Integer.parseInt(bundle.getString("y.size.tspview"));
    	String viewName =  bundle.getString("name.tspview");
    	String title =  bundle.getString("title.tspview");
		
        Scene scene = new Scene(Tools.loadFXML(viewName), x, y);
        
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        
        //stage.setResizable(false);
        
        stage.show();
        
	}


}
