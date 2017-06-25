package GUI;

import Environment.Popolazione;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
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
        Label M = new Label("M"), A = new Label("A"), P = new Label("P"),
                S = new Label("S"), pers = new Label("Persone"), spacer2 = new Label("");
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        TextField aF = new TextField(), bF = new TextField(), cF = new TextField();
        TextField Mf = new TextField(), Af = new TextField(), Pf = new TextField(), Sf = new TextField();
        HBox values = new HBox(10, spacer1, a, b, c), valuesIN = new HBox(10, val, aF, bF, cF);
        HBox persone = new HBox(10, spacer2, M, A, P, S), personeIN = new HBox(10, pers, Mf, Af, Pf, Sf);
        Button Default = new Button("Default"), OK = new Button("Ok"), Exit = new Button("Exit");
        HBox buttons = new HBox(10, Default, spacer, Exit, OK);
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

        Default.setOnAction(e -> {
            aF.setText("15");
            bF.setText("20");
            cF.setText("3");
            Mf.setText("1000");
            Af.setText("1000");
            Pf.setText("1000");
            Sf.setText("1000");
        });

        Exit.setOnAction(e -> Gui.getStage().close());

        {
            val.setPrefWidth(50);
            pers.setPrefWidth(50);
            spacer1.setPrefWidth(50);
            spacer2.setPrefWidth(50);
            a.setPrefWidth(100);
            a.setAlignment(Pos.CENTER);
            b.setPrefWidth(100);
            b.setAlignment(Pos.CENTER);
            c.setPrefWidth(100);
            c.setAlignment(Pos.CENTER);
            M.setPrefWidth(100);
            M.setAlignment(Pos.CENTER);
            A.setPrefWidth(100);
            A.setAlignment(Pos.CENTER);
            P.setPrefWidth(100);
            P.setAlignment(Pos.CENTER);
            S.setPrefWidth(100);
            S.setAlignment(Pos.CENTER);
            aF.setPrefWidth(100);
            bF.setPrefWidth(100);
            cF.setPrefWidth(100);
            Mf.setPrefWidth(100);
            Af.setPrefWidth(100);
            Pf.setPrefWidth(100);
            Sf.setPrefWidth(100);
            Default.setPrefWidth(60);
            OK.setPrefWidth(60);
            Exit.setPrefWidth(60);
        }

        Gui.getStage().setTitle("Impostazioni");
        Gui.getStage().setScene(new Scene(mainW));
    }
}
