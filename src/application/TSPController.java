package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

import org.graphstream.graph.Edge;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.fx_viewer.FxViewPanel;
import org.graphstream.ui.fx_viewer.FxViewer;
import TSPModel_PtiDeb.TSPModel_PtiDeb;
import application.tools.Tools;
import application.tools.ViewsManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

@SuppressWarnings("deprecation")
public class TSPController implements Observer {
	
	// Variables utilisées dans le tsp et l'affichage
	SingleGraph graph;
	SingleGraph graphCopy;
	Thread t;
	TSPModel_PtiDeb tsp;
	FxViewer viewer2;
	ArrayList<Point2D> points = Communication.staticPointList;

	// On récupère les éléments de la page
	
	@FXML private Pane leftPane;
	@FXML private Pane rightPane;
	
	@FXML private Button start;
	@FXML private Button stop;
	@FXML private Button pause;
	@FXML private Button restart;
	@FXML private Button stepBack;
	@FXML private Button stepForward;
	@FXML private Button back;

	@FXML private Slider slider;
	
	@FXML private CheckBox allowStep;
	
	 @FXML private Text textInfo;

	
	/*
	 * Initialise des composants au chargement de la vue
	 */
	@FXML
    public void initialize() throws IOException {
		
		// Initialisation du slider
		slider.setMin(100);
		slider.setMax(1000);
		slider.setValue(500);
		slider.setBlockIncrement(25);
		
    	textInfo.setFill(Color.BLUE);

		// Création des graphs
		graph = new SingleGraph("Graph 1"); 
		graphCopy = new SingleGraph("graph 2");

		// Viewer pour convertir un Viewer Swing en Pane
		FxViewer viewer = new FxViewer(graph, FxViewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
		FxViewer viewer2 = new FxViewer(graphCopy, FxViewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);

				
		// Initialisation du graph de recherche
		int cpt = 1;
		for(Point2D point : points)
		{
			graph.addNode("" + cpt);
			graph.getNode("" + cpt).setAttribute("xy", point.getX(), point.getY());
			graph.getNode("" + cpt).setAttribute("ui.style", "fill-color: rgb(0,100,255);");
			
			cpt++;
		}
	 	
		// Initialisation du graph meilleure solution
		cpt = 1;
		for(Point2D point : points)
		{
			graphCopy.addNode("" + cpt);
			graphCopy.getNode("" + cpt).setAttribute("xy", point.getX(), point.getY());
			graphCopy.getNode("" + cpt).setAttribute("ui.style", "fill-color: rgb(255, 87,51);");
			cpt++;
		}
		

		FxViewPanel v1 =  (FxViewPanel)viewer.addDefaultView(false);
		FxViewPanel v2 =  (FxViewPanel)viewer2.addDefaultView(false) ;
		
		// On set notre pane
		leftPane.getChildren().setAll(v1);
		rightPane.getChildren().setAll(v2);

    }

	/*
	 * Initialise les points pour le TSP
	 */
	private void initTSP()
	{
		tsp = new TSPModel_PtiDeb(this);
		
		int cpt = 1;
		for(Point2D point : points)
		{
			tsp.addPoint(cpt, point.getX(), point.getY());
			cpt++;
		}
	}
	
	/*
	 * Recréer le graph de de la meilleure solution
	 */
	private void initGraphCopy()
	{		
		int cpt = 1;
		for(Point2D point : points)
		{
			graphCopy.addNode("" + cpt);
			graphCopy.getNode("" + cpt).setAttribute("xy", point.getX(), point.getY());
			graphCopy.getNode("" + cpt).setAttribute("ui.style", "fill-color: rgb(255, 87,51);");
			cpt++;
		}	
	}

	/*
	 * Ouvre la vue d'accueil
	 */
	public void openHome() throws IOException
	{
		ViewsManager.OpenHomeView();   
        Tools.closePreviousScene(back);
	}
	
	/*
	 * Démarre le tsp lors du clique sur la vue
	 */
	@FXML
	public void startTSP() throws IOException
	{
    	textInfo.setText("La recherche est en cours...");

		initTSP();
		
		start.setDisable(true);
		stop.setDisable(false);
		pause.setDisable(false);
		
		t = new Thread(tsp);
		t.start();
	}
	
	/*
	 * Arrete le TSP et réinitialise les graphs
	 */
	@FXML
	public void stopTSP() throws IOException
	{
    	textInfo.setText("La recherche est remise à zéro");

		start.setDisable(false);
		stop.setDisable(true);
		pause.setDisable(true);
		restart.setDisable(true);

		tsp.clear();
		t.stop();	
		initialize();
	}
	
	/*
	 * Met en pause le TSP
	 */
	@FXML
	public void pauseTSP()
	{
		if(tsp.getPause())
		{		
			tsp.setPause(false);
			pause.setText("METTRE EN PAUSE");
	    	textInfo.setText("La recherche reprend...");
			t.resume();
		}
		else
		{
			tsp.setPause(true);
			pause.setText("ENLEVER LA PAUSE");
	    	textInfo.setText("La recherche est en pause");
			t.suspend();
		}
	}
	
	/*
	 * Relancer le TSP
	 */
	@FXML
	public void restartTSP() throws IOException
	{
		stopTSP();
		startTSP();
    	textInfo.setText("La recherche est en cours");
	}

	/*
	 * Change les éléments de la vue pour la méthode pas à pas
	 */
	public void allowStepByStep()
	{
		if(allowStep.isSelected())
		{
			stepForward.setVisible(true);
			pause.setDisable(true);
			pauseTSP();
		}
		else
		{
			stepForward.setVisible(false);
			pause.setDisable(false);
			pauseTSP();
		}
	}
	
	/*
	 * Fait un pas en avant
	 */
	public void makeStepForward()
	{
		pauseTSP();
	}
	
	/*
	 * Update de l'observer
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
				
		int idP1 = tsp.getSegmentP1();
		int idP2 = tsp.getSegmentP2();
		
		String strId1 = "" + idP1;
		String strId2 = "" + idP2;
		
		String idEdge = "" + idP1 + "" + idP2;


		// Actions lors des différents états du tsp
		if(tsp.getAction().toString() == "Add")
			graph.addEdge(idEdge, strId1, strId2);
		
		else if(tsp.getAction().toString() == "Remove")
			graph.removeEdge(idEdge);
		
		else if(tsp.getAction().toString() == "NewBest")	
			fillGraphBestSolution();
		
		else if(tsp.getAction().toString() == "Finish")
		{
			stop.setDisable(true);
			pause.setDisable(true);
			restart.setDisable(false);
	    	textInfo.setText("Recherche terminée avec le meilleur chemin trouvé !");
		}
		
		// Si l'on est en mode pas à pas
		if(allowStep.isSelected() && stepForward.isVisible())
		{
			pauseTSP();
		}
		else
		{
			try {
				t.sleep((int)slider.getValue());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * Affiche le graphe de la meilleure solution trouvée par le TSP
	 */
	private void fillGraphBestSolution()
	{
		graphCopy.clear();
		
		// On récupère tous les liens
        List<Edge> result = graph.edges().collect(Collectors.toList());
        
        // On réinitialise le graphe
        initGraphCopy();
        	
	    for(Edge e : result) {
	    	
	    	String segment = e.toString();
	    	
	    	String id1 = "";
	    	String id2 = "";

	    	// Extraction des nom des sommets 
	    	for(int i = 0; i < segment.length(); i++)
	    	{
	    		if(segment.charAt(i) == '[')
	    		{
	    	    	for(int j = i + 1; j < segment.length(); j++)
	    	    	{
	    	    		if(segment.charAt(j) == '-')
	    	    			break;
	    	    		id1 += segment.charAt(j);
	    	    	}

	    		}
	    		
	    		if(segment.charAt(i) == '-')
	    		{
	    	    	for(int j = i; j < segment.length(); j++)
	    	    	{
	    	    		if(segment.charAt(j) == ']')
	    	    			break;
	    	    		if(segment.charAt(j) != '-')
	    	    			id2 += segment.charAt(j);
	    	    	}
	    	    	break;
	    		}
	    	}

			String idEdge = "" + id1 + "" + id2;

			// On ajoute le sommet
	        graphCopy.addEdge(idEdge, Integer.parseInt(id1) - 1, Integer.parseInt(id2) - 1);
	    }
	}

}
