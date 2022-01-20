module Prototypage {
	requires javafx.controls;
	requires javafx.fxml;
	requires gs.core;
	requires gs.ui.javafx;
	requires TSPModel.PtiDeb;
	
	opens application to javafx.graphics, javafx.fxml, gs.core, javafx.base;
	exports application;
}
