package application;
	
import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import org.graphstream.graph.implementations.*;
import org.graphstream.graph.*;
import org.graphstream.ui.spriteManager.*;
import java.util.Vector;

public class ManageGraph{
	/*@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}*/
	private int n;
	private Vector<Character> vec;
	private int nbNodes;
	private Graph graph;
	
	public ManageGraph(int n) {
		this.n = n;
		this.vec = new Vector<Character>(26);
		for(char i = 'A'; i <= 'Z'; ++i) {
			this.vec.add(i);
		}
		this.nbNodes = 0;
		this.graph = new SingleGraph("Mon Graph");
	}
	
	
	public char getVec(int index) {
		return vec.get(index);
	}


	public int getN() {
		return n;
	}


	public void setN(int n) {
		this.n = n;
	}


	public int getNbNodes() {
		return nbNodes;
	}


	public void setNbNodes(int nbNodes) {
		this.nbNodes = nbNodes;
	}


	public Graph getGraph() {
		return graph;
	}


	public void setGraph(Graph graph) {
		this.graph = graph;
	}


	public void setVec(Vector<Character> vec) {
		this.vec = vec;
	}

	/**
	 * Ajoute un noeud au graph
	 * 
	 * 
	 * 
	 */
	public void putNode(int x, int y) {
		this.graph.addNode(String.valueOf(this.vec.get(nbNodes)));
		Node node = graph.getNode(String.valueOf(this.vec.get(nbNodes)));
		node.setAttribute("xy", x, y);
		this.nbNodes++;
	}
	
	/**
	 * Ajoute les labels des nodes
	 */
	public void labelling() {
	    for (Node node : this.graph) {
	        node.setAttribute("ui.label", node.getId());
	    }
	}
	

}
