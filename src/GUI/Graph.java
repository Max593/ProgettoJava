package GUI;

import Environment.Generazione;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by max on 20/06/17.
 */
public class Graph {
    public static void Graph() {
        Map<Integer, Generazione> gens = Gui.getPopolazione().getMap();  //
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Generazione");
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

        Scene v = new Scene(lineChart);
        Gui.getStage().setScene(v);
    }
}
