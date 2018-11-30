package vista;


import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MenuInferior extends HBox{
	public static ChoiceBox<String> selecOpciones=new ChoiceBox<String>();
	public static TextArea log = new TextArea();
	
	public MenuInferior(Stage stage){
    	ContenedorPrincipal.setAlignment(this, Pos.BOTTOM_CENTER);
    	selecOpciones.getItems().addAll("Mover","Atacar","Transformar","Fusionar");
    	selecOpciones.getSelectionModel().selectFirst();
    	selecOpciones.setPrefWidth(300);
    	log.setEditable(false);
    	log.setPrefWidth(250);
    	log.setPrefHeight(120);
    	log.setTranslateY(50);
    	log.setWrapText(true);
    	log.insertText(0, "");
    	log.setTranslateY ( -10 );


    	this.setSpacing(100);
    	this.getChildren().addAll(log,selecOpciones);
    	this.setAlignment(Pos.BASELINE_CENTER);
	}

}
