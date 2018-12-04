package vista.borrar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import vista.MainApp;

public class BotonEnviarEventHandler implements EventHandler<ActionEvent> {

    private TextField campoNombre;
    private Label j1,j2,titulo, aux;
    private boolean pase = false;
    private MainApp main;

    public BotonEnviarEventHandler(TextField campoNombre, Label j1, Label j2, Label titulo, MainApp main) {
        this.campoNombre = campoNombre;
        this.j1 = j1;
        this.j2 = j2;
        this.titulo = titulo;
        aux = j1;
        this.main = main;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (this.campoNombre.getText().trim().equals("")) {
        	
            this.aux.setText("Debe ingresar un nombre");
            this.aux.setTextFill(Color.FIREBRICK);
           

        } else {

            this.aux.setText(this.campoNombre.getText());
            this.aux.setTextFill(Color.BLUE);

            if (!pase)
            {
            j1=aux;
            aux= j2;
                this.titulo.setText("Ingrese Nombre J2");
                pase=true;
                campoNombre.setText("");
            }else{

                j2 = aux;
                campoNombre.setText("");
               main.llamar(j1,j2);

            }
        }
        

    }
}
