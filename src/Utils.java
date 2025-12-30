public class Utils {
    public static double standardize(double sum, int n) {
        double mu = 0.5;
        double sigma = Math.sqrt(1.0 / 12.0);
        return (sum - n * mu) / (sigma * Math.sqrt(n));
    }
}
