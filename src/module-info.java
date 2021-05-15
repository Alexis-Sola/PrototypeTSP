module Prototypage {
	requires javafx.controls;
	requires javafx.graphics;
	requires gs.core;
	requires javafx.fxml;
	requires gs.ui.javafx;
	
	opens application to javafx.graphics, javafx.fxml, gs.core, javafx.base;
}
