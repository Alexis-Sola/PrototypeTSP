module Prototypage {
	requires javafx.controls;
	requires javafx.graphics;
	requires gs.core;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml, gs.core;
}
