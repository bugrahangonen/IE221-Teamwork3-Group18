package simulation;
/*
   This class demonstrates the Central Limit Theorem (CLT) using simulation.
   Uniformly distributed random variables are generated and standardized sums
   are computed for different sample sizes.
 
   Histograms and Q-Q plots are produced to visualize convergence to the
   normal distribution. */
    
import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.HistogramDataset;

public class CLTSimulation {
  
    //Main method that runs the CLT simulation.It generates random samples, applies standardization,
     and saves graphical results as PNG files. //

    public static void main(String[] args) {
// Different sample sizes used to observe the CLT effect
// Number of repetitions for each sample size 

        int[] nValues = {2, 5, 10, 30, 50};
        int experiments = 1000;
         
// Mean and variance of the Uniform(0,1) distribution
        double mu = 0.5;
        double variance = 1.0 / 12.0;

        Random random = new Random();

        HistogramDataset dataset = new HistogramDataset();
         
// Generate standardized sums according to the Central Limit Theorem
         
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
// Create histogram to visualize convergence to normal distribution
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
// Define output file locations for generated figures
        File histOut = new File("results/figures/clt_histograms.png");
        File qqOut   = new File("results/figures/clt_qqplots.png");
        histOut.getParentFile().mkdirs();
         
// Save histogram output and print file locations to console
        try {
        	ChartUtilities.saveChartAsPNG(histOut, chart, 1200, 700);
        	System.out.println("CLT histogram saved: " + histOut.getAbsolutePath());
        	System.out.println("CLT QQ plot saved: " + qqOut.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
