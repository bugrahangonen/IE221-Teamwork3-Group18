package simulation;

/*
 * TODO:
 * This file will be implemented by Person B.
 * Task: Strong Law of Large Numbers (SLLN)
 * Output: results/figures/slln.png
 */

public class SLLNSimulation {
    public static void main(String[] args) {
        public static void main(String[] args) {

        int n = 10000;          
        double mu = 0.5;        
        Random rand = new Random();

        XYSeries meanSeries = new XYSeries("Cumulative Mean");
        XYSeries referenceLine = new XYSeries("μ = 0.5");

        double sum = 0.0;

        for (int i = 1; i <= n; i++) {
            double x = rand.nextDouble(); // U[0,1]
            sum += x;
            double cumulativeMean = sum / i;

            meanSeries.add(i, cumulativeMean);
            referenceLine.add(i, mu);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(meanSeries);
        dataset.addSeries(referenceLine);

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

        ChartPanel panel = new ChartPanel(chart);
        JFrame frame = new JFrame("SLLN");
        frame.setContentPane(panel);
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
