module Prototypage {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.media;
	requires javafx.swing;
	requires javafx.web;
	requires javafx.swt;
	requires gs.core;
	requires gs.ui.javafx;
	requires TSPModel.PtiDeb;
	
	opens application to javafx.graphics, javafx.fxml, gs.core, javafx.base;
}
