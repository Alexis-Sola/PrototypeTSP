package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import application.tools.Tools;


public class Main extends Application {
	
	  private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(Tools.loadFXML("HomeView"), 640, 600);
        stage.setScene(scene);
        stage.show();
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
