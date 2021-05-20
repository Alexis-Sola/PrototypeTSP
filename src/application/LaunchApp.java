package application;

import java.io.IOException;

import application.tools.ViewsManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class LaunchApp extends Application {
	
	 @Override
    public void start(Stage stagee) throws IOException {
    	ViewsManager.OpenHomeView();
	
    }
	 
	 public void test()
	 {
		 launch();
	 }
	
}
