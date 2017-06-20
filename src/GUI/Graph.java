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
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("Popolazione");
        XYChart.Series series = new XYChart.Series();
        series.setName("M");
        for(int i = 1; i <= gens.entrySet().size(); i++) {
            series.getData().add(new XYChart.Data(i, (gens.get(i).getNumeroTipoM()/gens.get(i).getNumeroMaschi())));
        }
        lineChart.getData().add(series);

        Scene v = new Scene(lineChart);
        Gui.getStage().setScene(v);
    }
}
