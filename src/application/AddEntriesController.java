package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import application.ressources.BundleResource;
import application.tools.Tools;
import application.tools.ViewsManager;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

public class AddEntriesController extends BundleResource {

	  @FXML private javafx.scene.control.Button backButton;
	  
	  // Partie ajout à la main
	  @FXML private javafx.scene.control.Button add_manual_points;
	  @FXML private javafx.scene.control.TextField x_position;
	  @FXML private javafx.scene.control.TextField y_position;
	
	  // Partie ajout auto
	  @FXML private javafx.scene.control.Button add_auto_points;
	  @FXML private javafx.scene.control.TextField number_of_points;
	  
	  // Delete tab
	  @FXML private javafx.scene.control.Button delete_tab;
  
	  // Tableau de points
	  @FXML private javafx.scene.control.TableView<Point2D> table;
	  
	  // Texte qui affiche une erreur
	  @FXML private javafx.scene.text.Text textError;
	  
	  // Listes de points de l'appli
	  public ArrayList<Point2D> pointList = new ArrayList<Point2D>();
	  
  	  private int maxPoints = Integer.parseInt(BundleResource.bundle.getString("points.max"));

	
	    /**
	     * Ouvre la vu de création d'un modèle
	     * @throws IOException
	     */
	    @FXML
	    private void openHomeView() throws IOException {
	         
	    	ViewsManager.OpenHomeView();   
	        Tools.closePreviousScene(backButton);
	    }
	    
	    /*
	     * Initialise les composants de base
	     * Le tableau
	     */
		@FXML
	    public void initialize() {
	    	
	    	TableColumn<Point2D, String> xColumn = new TableColumn<Point2D, String>("Position 1");
	    	xColumn.setCellValueFactory(new PropertyValueFactory<>("x"));

	    	TableColumn<Point2D, String> yColumn = new TableColumn<Point2D, String>("Position 2");
	    	yColumn.setCellValueFactory(new PropertyValueFactory<>("y"));
	    	
	    	xColumn.setPrefWidth(180);
	    	yColumn.setPrefWidth(180);
    	
	    	table.getColumns().addAll(xColumn, yColumn);
	    	
	    	textError.setFill(Color.DARKRED);
	    }
	    
	    /*
	     * Gère l'ajout manuel
	     */
	    @FXML
	    private void addPointsToTab() {
	    	
	    	String text = bundle.getString("user.hints.error");
	    	
	    	// Il y a une nombre max de points
	    	if(!pointList.isEmpty() && pointList.size() > maxPoints + 1)
	    		text = bundle.getString("max.points.reach");	
	    	else
	    	{   
	    		// On vérifie que le champ n'est pas vide
		    	if(x_position.getText() != null && y_position.getText() != null) 
		    	{
		    		String pos_x = x_position.getText();
		    		String pos_y = y_position.getText();
		    		
		    		// Check que l'on a bien des nombres
		    		if(pos_x.matches("-?\\d+") && pos_y.matches("-?\\d+"))
		    		{
		    			int x = Integer.parseInt(pos_x);
		    			int y =Integer.parseInt(pos_y);
		    			
		    	    	Point2D newPoint = new Point2D(x, y);
		    	    	
		    	    	// Check si le point n'existe pas déjà
		    	    	if(!isAlreadyExist(pointList, newPoint))
		    	    	{
		    	    		pointList.add(newPoint);
			    	    	table.getItems().add(newPoint);
			    	    	text = "";
		    	    	}	    	    		
		    		}
		    	} 
	    	}
    		textError.setText(text);
	    }
	    
	    /*
	     * Gère l'ajout automatique des points
	     */
	    @FXML
	    private void addAutoPoints() {
	    	
	    	String text = "";
	    	
	    	// Check si l'on ne depasse pas le nombre max de point
	    	if(!pointList.isEmpty() && pointList.size() > maxPoints + 1)
	    		text = bundle.getString("max.points.reach");	
	    	else 
	    	{
		    	int nbPoints;		    	
		    	// Si le champ n'est pas vide
		    	if(number_of_points.getText() != null)
		    	{
		    		// Check si l'on a bien des nombres entrés
		    		if(number_of_points.getText().matches("-?\\d+"))
		    			nbPoints = Integer.parseInt(number_of_points.getText());
		    		else
		    			return;
		    	}
		    	else
		    		return;
		    	
		        Random rand = new Random();
		        
		        // Génération de points aléatoires
		    	for(int i = 0; i < nbPoints; i++)
		    	{
			    	if(!pointList.isEmpty() && pointList.size() > maxPoints + 1)
			    		break;

		    	    int x = rand.nextInt(maxPoints) + 1;
		    	    int y = rand.nextInt(maxPoints) + 1;
    		
	    	    	Point2D newPoint = new Point2D(x, y);
	
	    	    	if(!isAlreadyExist(pointList, newPoint))
	    	    	{
	    	    		pointList.add(newPoint);
		    	    	table.getItems().add(newPoint);
	    	    	}
	    	    	// Si le point existe déja on retente de générer un nombre
	    	    	else
	    	    		i--;
		    	}
	    	}
    		textError.setText(text);
	    } 
	    
	    
	    /*
	     * Reset le tableau
	     */
	    @FXML
	    private void deleteTableContent()
	    {
	    	table.getItems().clear();
	    	pointList.clear();
	    }

	    /*/
	     * Ouvre la page suivante et sauvegarde la configuration
	     */
	    @FXML
	    private void valider() throws IOException
	    {
	    	textError.setText("");
	    	if(!pointList.isEmpty())
	    	{
	    		Communication.staticPointList = pointList;
	    		Tools.writePoint2DInCSVFile(pointList);
	    		ViewsManager.OpenTSPView();
	    		Tools.closePreviousScene(backButton);
	    		return;
	    	}
	    	textError.setText(bundle.getString("points.missing"));
	    }
	    
	    /*
	     * Check si un point est déjà entré
	     * Evite les doublons
	     */
	    private boolean isAlreadyExist(ArrayList<Point2D> list, Point2D pointToTest)
	    {
	    	if(list.isEmpty())
	    			return false;
	    	
	    	for(Point2D val : list)
	    		if(val.getX() == pointToTest.getX() && val.getY() == pointToTest.getY())
	    			return true;
	    	
	    	return false;
	    }
}
