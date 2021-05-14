package application.tools;

import java.io.IOException;

import application.ressources.BundleResource;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewsManager {
	
	/*
	 * Ouvre l'écran d'accueil
	 */
	public static void OpenHomeView() throws IOException  {
		
		//On récupère les propriétés de la vue
		int x = Integer.parseInt(BundleResource.bundle.getString("x.size.homeview"));
    	int y = Integer.parseInt(BundleResource.bundle.getString("y.size.homeview"));
    	String viewName =  BundleResource.bundle.getString("name.homeview");
    	String title =  BundleResource.bundle.getString("title.homeview");
    	
        Scene scene = new Scene(Tools.loadFXML(viewName), x, y);
        
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        
        stage.setResizable(false);
        
        stage.show();
	}
	
	public static void OpenImportMapView() throws IOException{
		
		int x = Integer.parseInt(BundleResource.bundle.getString("x.size.importview"));
    	int y = Integer.parseInt(BundleResource.bundle.getString("y.size.importview"));
    	String viewName =  BundleResource.bundle.getString("name.importview");
    	String title =  BundleResource.bundle.getString("title.importview");
		
        Scene scene = new Scene(Tools.loadFXML(viewName), x, y);
        
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        
        stage.setResizable(false);
        
        stage.show();
        
	}
	
	public static void OpenAddEntriesView() throws IOException{
		
		int x = Integer.parseInt(BundleResource.bundle.getString("x.size.addview"));
    	int y = Integer.parseInt(BundleResource.bundle.getString("y.size.addview"));
    	String viewName =  BundleResource.bundle.getString("name.addview");
    	String title =  BundleResource.bundle.getString("title.addview");
		
        Scene scene = new Scene(Tools.loadFXML(viewName), x, y);
        
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        
        stage.setResizable(false);
        
        stage.show();
        
	}


}
