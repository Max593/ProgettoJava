package GUI;

import Environment.Generazione;
import Environment.Popolazione;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;

import java.util.Map;

/**
 * Created by max on 20/06/17.
 */
public class Graph {
    public static void Graph() {
        Map<Integer, Generazione> gens = Gui.getPopolazione().getMap();
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Generazione");
        final LineChart<Number,Number> lineChart = new LineChart<>(xAxis,yAxis);

        lineChart.setTitle("Popolazione");
        lineChart.setCreateSymbols(false);
        XYChart.Series seriesM = new XYChart.Series();
        seriesM.setName("M");
        for(int i = 1; i <= gens.entrySet().size(); i++) {
            seriesM.getData().add(new XYChart.Data(i, (gens.get(i).getNumeroTipoM()/gens.get(i).getNumeroMaschi())));
        }
        lineChart.getData().add(seriesM);

        Scene v = new Scene(lineChart);
        Gui.getStage().setScene(v);
    }
}
