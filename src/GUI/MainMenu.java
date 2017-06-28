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
                S = new Label("S"), spacer2 = new Label(""), pers = new Label("Persone");
        Region spacer = new Region();  //Spacer tra i pulsanti in basso alla finestra, si adatta alla finestra.
        HBox.setHgrow(spacer, Priority.ALWAYS);

        TextField aF = new TextField(), bF = new TextField(), cF = new TextField();
        TextField Mf = new TextField(), Af = new TextField(), Pf = new TextField(), Sf = new TextField();
        CheckBox cb = new CheckBox("Incontri");  //Nel caso introduciamo gli incontri (switch)
        Button Default = new Button("Default"), OK = new Button("Ok"), Exit = new Button("Exit");
        HBox values = new HBox(10, spacer1, a, b, c), valuesIN = new HBox(10, val, aF, bF, cF, cb);
        HBox persone = new HBox(10, spacer2, M, A, P, S), personeIN = new HBox(10, pers, Mf, Af, Pf, Sf);
        HBox buttons = new HBox(10, Default, spacer, Exit, OK); buttons.setAlignment(Pos.BOTTOM_RIGHT);

        VBox mainW = new VBox(10, values, valuesIN, persone, personeIN, buttons);
        mainW.setStyle("-fx-padding: 12 12 12 12");

        OK.setOnAction(e -> {  //Tenere in conto il CheckBox nel caso introduciamo gli incontri
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
            Graph.Graph(Integer.parseInt(Mf.getText()), Integer.parseInt(Af.getText()),
                    Integer.parseInt(Pf.getText()), Integer.parseInt(Sf.getText()),
                    Integer.parseInt(aF.getText()), Integer.parseInt(bF.getText()), Integer.parseInt(cF.getText()));
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
            for(Label i : Arrays.asList(val, pers, spacer1, spacer2)) {
                i.setStyle("-fx-font-weight: bold; -fx-pref-width: 60");
            }
            for(Label i : Arrays.asList(a, b, c, M, A, P, S)) {
                i.setStyle("-fx-pref-width: 100; -fx-alignment: center");
            }
            for(TextField i : Arrays.asList(aF, bF, cF, Mf, Af, Pf, Sf)) {
                i.setStyle("-fx-pref-width: 100");
            }
            for(Button i : Arrays.asList(OK, Exit)) {
                i.setStyle("-fx-pref-width: 60");
            }
            Default.setPrefWidth(80);
        }

        Gui.getStage().setTitle("Impostazioni"); Gui.getStage().setScene(new Scene(mainW));
    }
}
