package application;
	
import java.io.IOException;

import application.tools.ViewsManager;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	
	 @Override
    public void start(Stage stage) throws IOException {
    	ViewsManager.OpenHomeView();
	
    }

    /*static void setRoot(String fxml) throws IOException {
        scene.setRoot(Tools.loadFXML(fxml));
    }*/

	
	public static void main(String[] args) {
		launch();
		/*Graph graph = new SingleGraph("Tutorial 1");

		graph.addNode("A" );
		graph.addNode("B" );
		graph.addNode("C" );
		graph.addEdge("AB", "A", "B");
		graph.addEdge("BC", "B", "C");
		graph.addEdge("CA", "C", "A");
		graph.display();*/

	}
}
