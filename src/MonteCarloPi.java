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

/**
 * Monte Carlo simulation to estimate the value of Pi.
 * This class demonstrates the Law of Large Numbers (SLLN) by generating random points
 * in a unit square and calculating the ratio of points falling inside the unit circle.
 *
 * It generates a convergence plot using the JFreeChart library.
 */
public class MonteCarloPi {

    /**
     * The main method that executes the Monte Carlo simulation.
     *
     * Steps:
     * 1. Generates random (x, y) coordinates.
     * 2. Checks if the point lies within the unit circle.
     * 3. Updates the Pi estimate iteratively.
     * 4. Saves the resulting convergence graph as a PNG file.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {

        // Configuration parameters
        int N = 20000; // Total number of iterations (sample size)
        int inside = 0; // Counter for points inside the quarter circle

        Random rnd = new Random();

        // Series for plotting the estimated value vs. the true value
        XYSeries piSeries = new XYSeries("Pi Estimate");
        XYSeries truePiSeries = new XYSeries("True Pi = 3.14159");

        double truePi = Math.PI;

        // Main simulation loop
        for (int i = 1; i <= N; i++) {
            // Generate random point (x, y) in the range [0, 1]
            double x = rnd.nextDouble();
            double y = rnd.nextDouble();

            // Check if the point is inside the unit circle: x^2 + y^2 <= r^2 (where r=1)
            if (x * x + y * y <= 1) {
                inside++;
            }

            // Monte Carlo Formula: Area of Circle / Area of Square = (Pi*r^2) / (2r)^2 = Pi/4
            // Therefore, Pi ~ 4 * (inside points / total points)
            double piEstimate = 4.0 * inside / i;

            // Add data points to the chart series
            piSeries.add(i, piEstimate);
            truePiSeries.add(i, truePi);
        }

        // Prepare the dataset for JFreeChart
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(piSeries);
        dataset.addSeries(truePiSeries);

        // Create the XY Line Chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Monte Carlo Estimation of Pi", // Chart title
                "Number of Points (n)",         // X-Axis Label
                "Pi Estimate",                  // Y-Axis Label
                dataset,                        // Data
                PlotOrientation.VERTICAL,
                true,                           // Include legend
                true,                           // Tooltips
                false                           // URLs
        );

        // Define output path for the graph
        String outPath = "results/figures/pi.png";
        File outFile = new File(outPath);

        // Ensure the directory exists before saving
        outFile.getParentFile().mkdirs();

        try {
            // Save the chart as a high-resolution PNG
            ChartUtilities.saveChartAsPNG(outFile, chart, 1200, 700);
            System.out.println("✅ pi.png successfully saved to " + outPath);
        } catch (IOException e) {
            System.err.println("Error saving the chart.");
            e.printStackTrace();
        }

        // Print the final numerical result to the console
        System.out.println("Final Pi Estimate = " + (4.0 * inside / N));
    }
}
