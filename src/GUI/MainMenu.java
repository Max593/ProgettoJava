package GUI;

import Environment.Popolazione;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by max on 20/06/17.
 */
public class MainMenu {
    public static void MainMenu() {
        Label a = new Label("A"), b = new Label("B"), c = new Label("C"),
                spacer1 = new Label(""), val = new Label("Valori");
        spacer1.setPrefWidth(100);
        Label M = new Label("M"), A = new Label("A"), P = new Label("P"),
                S = new Label("S"), pers = new Label("Persone"), spacer2 = new Label("");
        spacer2.setPrefWidth(100);
        TextField aF = new TextField(), bF = new TextField(), cF = new TextField();
        TextField Mf = new TextField(), Af = new TextField(), Pf = new TextField(), Sf = new TextField();
        HBox values = new HBox(10, spacer1, a, b, c);
        HBox valuesIN = new HBox(10, val, aF, bF, cF);
        HBox persone = new HBox(10, spacer2, M, A, P, S);
        HBox personeIN = new HBox(10, pers, Mf, Af, Pf, Sf);
        Button OK = new Button("Ok");
        Button Exit = new Button("Exit");
        HBox buttons = new HBox(10, Exit, OK);
        buttons.setAlignment(Pos.BOTTOM_RIGHT);
        VBox mainW = new VBox(10, values, valuesIN, persone, personeIN, buttons);
        mainW.setPadding(new Insets(12,12,12,12));

        OK.setOnAction(e -> {
            try {
                int va = Integer.valueOf(aF.getText());
                int vb = Integer.valueOf(bF.getText());
                int vc = Integer.valueOf(cF.getText());
                int vM = Integer.valueOf(Mf.getText());
                int vA = Integer.valueOf(Af.getText());
                int vP = Integer.valueOf(Pf.getText());
                int vS = Integer.valueOf(Sf.getText());

                List<Integer> elems = new ArrayList<>();
                elems.addAll(Arrays.asList(va, vb, vc, vM, vA, vP, vS));
                for(int el : elems) { if(el <= 0) { throw new IllegalArgumentException(); } }

                Popolazione pop = new Popolazione(va, vb, vc, vM, vA, vP, vS);
                Gui.setPopolazione(pop);
            } catch (IllegalArgumentException ignore) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning"); alert.setHeaderText(null); alert.setContentText("Valore non corretto");
                alert.showAndWait();
            }
            Graph.Graph();
        });

        Gui.getStage().setScene(new Scene(mainW));
    }
}
