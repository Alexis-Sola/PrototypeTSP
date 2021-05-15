package application;

import java.io.IOException;
import java.util.ArrayList;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.fx_viewer.FxViewPanel;
import org.graphstream.ui.fx_viewer.FxViewer;
import org.graphstream.ui.javafx.FxGraphRenderer;
import org.graphstream.ui.view.Viewer;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TSPController {
	
	@FXML private javafx.scene.layout.Pane leftPane;
	@FXML private javafx.scene.layout.Pane rightPane;

	@FXML
    public void initialize() throws IOException {
		
		ArrayList<Point2D> points = Communication.staticPointList;

		SingleGraph graph = new SingleGraph("Graph 1"); 
		FxViewer viewer = new FxViewer(graph, FxViewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
		
		int cpt = 1;
		for(Point2D point : points)
		{
			graph.addNode("" + cpt);
			graph.getNode("" + cpt).setAttribute("xy", point.getX(), point.getY());
			graph.getNode("" + cpt).setAttribute("ui.style", "fill-color: rgb(0,100,255);");
			cpt++;
		}
	 		
		SingleGraph graphCopy = new SingleGraph("graph 2");
		
		cpt = 1;
		for(Point2D point : points)
		{
			graphCopy.addNode("" + cpt);
			graphCopy.getNode("" + cpt).setAttribute("xy", point.getX(), point.getY());
			graphCopy.getNode("" + cpt).setAttribute("ui.style", "fill-color: rgb(255, 87,51);");
			cpt++;
		}
		
		FxViewer viewer2 = new FxViewer(graphCopy, FxViewer.ThreadingModel.GRAPH_IN_GUI_THREAD);

		FxViewPanel v1 =  (FxViewPanel)viewer.addDefaultView(false);
		FxViewPanel v2 =  (FxViewPanel)viewer2.addDefaultView(false) ;
			
		leftPane.getChildren().setAll(v1);
		rightPane.getChildren().setAll(v2);

    }

}
