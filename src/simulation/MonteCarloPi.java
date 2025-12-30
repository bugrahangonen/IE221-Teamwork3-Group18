package simulation;

/*
 * TODO:
 * Implemented by Person C
 * Task: Monte Carlo estimation of Pi
 * Output: results/figures/pi.png
 */

public class MonteCarloPi {
    public static void main(String[] args) {
        // implementation will be added
 package simulation;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class MonteCarloPi {

    public static void main(String[] args) {

        int N = 20000;
        int inside = 0;

        Random rnd = new Random();

        XYSeries piSeries = new XYSeries("Pi Estimate");
        XYSeries truePiSeries = new XYSeries("True Pi = 3.14159");

        double truePi = Math.PI;

        for (int i = 1; i <= N; i++) {
            double x = rnd.nextDouble();
            double y = rnd.nextDouble();

            if (x * x + y * y <= 1) {
                inside++;
            }

            double piEstimate = 4.0 * inside / i;
            piSeries.add(i, piEstimate);
            truePiSeries.add(i, truePi);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(piSeries);
        dataset.addSeries(truePiSeries);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Monte Carlo Estimation of Pi",
                "Number of Points",
                "Pi Estimate",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        String outPath = "results/figures/pi.png";
        File outFile = new File(outPath);
        outFile.getParentFile().mkdirs();

        try {
            ChartUtilities.saveChartAsPNG(outFile, chart, 1200, 700);
            System.out.println("✅ pi.png kaydedildi!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Final Pi Estimate = " + (4.0 * inside / N));
    }
}   }
}
