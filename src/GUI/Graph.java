package GUI;

import Environment.Generazione;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by max on 20/06/17.
 */
public class Graph {
    public static void Graph(int M, int A, int P, int S, int a, int b, int c) {
        Map<Integer, Generazione> gens = Gui.getPopolazione().getMap();  //
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Generazione");
        yAxis.setLabel("Percentuale");
        final LineChart<Number,Number> lineChart = new LineChart<>(xAxis,yAxis);

        lineChart.setTitle("Popolazione");
        lineChart.setCreateSymbols(false);
        XYChart.Series seriesM = new XYChart.Series(); seriesM.setName("M");
        XYChart.Series seriesA = new XYChart.Series(); seriesA.setName("A");
        XYChart.Series seriesP = new XYChart.Series(); seriesP.setName("P");
        XYChart.Series seriesS = new XYChart.Series(); seriesS.setName("S");

        for(int i = 1; i <= gens.entrySet().size(); i++) {
            seriesM.getData().add(new XYChart.Data(i, (gens.get(i).getNumeroTipoM()/gens.get(i).getNumeroMaschi())));
            seriesA.getData().add(new XYChart.Data(i, (gens.get(i).getNumeroTipoA()/gens.get(i).getNumeroMaschi())));
            seriesP.getData().add(new XYChart.Data(i, (gens.get(i).getNumeroTipoP()/gens.get(i).getNumeroFemmine())));
            seriesS.getData().add(new XYChart.Data(i, (gens.get(i).getNumeroTipoS()/gens.get(i).getNumeroFemmine())));
        }
        for(XYChart.Series i : Arrays.asList(seriesM, seriesA, seriesP, seriesS)) {
            lineChart.getData().add(i);
        }

        Button Back = new Button("Back");
        Button Exit = new Button("Exit");
        Back.setOnAction(e ->  MainMenu.MainMenu());
        Exit.setOnAction(e -> Gui.getStage().close());
        HBox bottomBox = new HBox(10, Back, Exit);
        bottomBox.setAlignment(Pos.BOTTOM_RIGHT);

        Label details = new Label("Dettagli: "); details.setStyle("-fx-font-weight: bold");
        Text text = new Text("Popolazione iniziale:"+
                "\nM: "+M+
                "\nA: "+A+
                "\nP: "+P+
                "\nS: "+S+"\n"+
                "\nValori di payoff: "+
                "\na: "+a+
                "\nb: "+b+
                "\nc: "+c);
        VBox detailsBox = new VBox(10, details, text);
        //detailsBox.setAlignment(Pos.CENTER);

        BorderPane panel = new BorderPane(lineChart); panel.setPadding(new Insets(12,12,12,12));
        panel.setBottom(bottomBox);
        panel.setRight(detailsBox);

        Scene scene = new Scene(panel);
        Gui.getStage().setTitle("Grafo"); Gui.getStage().setScene(scene);

    }
}
