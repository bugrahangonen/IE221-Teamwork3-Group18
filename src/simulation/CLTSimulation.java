package simulation;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;

public class CLTSimulation {

    public static void main(String[] args) {

        int[] nValues = {2, 5, 10, 30, 50};
        int experiments = 1000;

        double mu = 0.5;
        double variance = 1.0 / 12.0;

        Random random = new Random();
        HistogramDataset dataset = new HistogramDataset();

        for (int n : nValues) {
            double[] zValues = new double[experiments];

            for (int i = 0; i < experiments; i++) {
                double sum = 0.0;

                for (int j = 0; j < n; j++) {
                    sum += random.nextDouble();
                }

                double z = (sum - n * mu) / Math.sqrt(n * variance);
                zValues[i] = z;
            }

            dataset.addSeries("n = " + n, zValues, 40);
        }

        JFreeChart chart = ChartFactory.createHistogram(
                "Central Limit Theorem Simulation",
                "Z value",
                "Frequency",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        File output = new File("results/figures/clt.png");
        output.getParentFile().mkdirs();

        try {
            ChartUtilities.saveChartAsPNG(output, chart, 1200, 700);
            System.out.println("CLT graph saved: " + output.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
