package vista;


import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MenuInferior extends HBox{
	private static ChoiceBox<String> selecOpciones=new ChoiceBox<String>();
	private static TextArea log = new TextArea();
	
	public MenuInferior(Stage stage){
    	ContenedorPrincipal.setAlignment(this, Pos.BOTTOM_CENTER);
    	selecOpciones.getItems().addAll("Mover","Atacar","Crear Edificio" ,"Atacar","Crear Unidad","Reparar");
    	selecOpciones.getSelectionModel().selectFirst();
    	selecOpciones.setPrefWidth(300);
    	log.setEditable(false);
    	log.setPrefWidth(250);
    	log.setPrefHeight(120);
    	//
    	log.setWrapText(true);
    	log.insertText(0, "");
    	log.setTranslateY ( -40 );
    	this.setSpacing(100);
    	this.getChildren().addAll(log,selecOpciones);
    	this.setAlignment(Pos.BASELINE_CENTER);
	}

	public static TextArea getLog(){
		return log;
	}

	public static ChoiceBox<String> getSelecOpciones(){
		return selecOpciones;
	}

}
