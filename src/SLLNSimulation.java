package slln;

import java.util.Random;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * SLLNSimulation
 *
 * This class provides a simulation-based demonstration of the
 * Strong Law of Large Numbers (SLLN).
 *
 * The simulation generates i.i.d. random variables from the
 * Uniform[0,1] distribution and computes the cumulative sample mean.
 * According to the SLLN, the sample mean converges almost surely
 * to the expected value μ = 0.5 as the number of observations increases.
 *
 * A line chart is used to visualize the convergence behavior.
 */
public class SLLNSimulation {

    /**
     * The main method executes the SLLN simulation and displays
     * the convergence of the cumulative mean.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {

        // Total number of observations
        int n = 10000;

        // Expected value of the Uniform[0,1] distribution
        double mu = 0.5;

        // Random number generator
        Random rand = new Random();

        // Time series for cumulative mean values
        XYSeries meanSeries = new XYSeries("Cumulative Mean");

        // Reference line corresponding to the true mean μ = 0.5
        XYSeries referenceLine = new XYSeries("μ = 0.5");

        // Variable to store the running sum of observations
        double sum = 0.0;

        // Generate random observations and compute cumulative mean
        for (int i = 1; i <= n; i++) {

            // Generate a random number from U[0,1]
            double x = rand.nextDouble();

            // Update cumulative sum
            sum += x;

            // Compute cumulative sample mean
            double cumulativeMean = sum / i;

            // Add data points to the plot series
            meanSeries.add(i, cumulativeMean);
            referenceLine.add(i, mu);
        }

        // Combine both series into a dataset
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(meanSeries);
        dataset.addSeries(referenceLine);

        // Create the line chart for visualization
        JFreeChart chart = ChartFactory.createXYLineChart(
                "SLLN Simulation (U[0,1])",
                "Number of Observations (n)",
                "Cumulative Mean",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // Display the chart in a window
        ChartPanel panel = new ChartPanel(chart);
        JFrame frame = new JFrame("SLLN Simulation");
        frame.setContentPane(panel);
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
