package hw2;

import static org.junit.Assert.*;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

//import java.util.ArrayList;
//import java.util.List;

public class PercolationStats {
    /** the T times experiments. */
    private double[] results;
//    /** the mean fraction of open sites in computational experiment. */
//    private double mu = this.mean();
//    /** the standard deviation. */
//    private double sigma = this.stddev();


    /** perform T independent experiments on an N-by-N grid. */
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N < 0) {
            throw new IllegalArgumentException(N + " is not greater or equal to 0!");
        }

        if (T < 1) {
            throw new IllegalArgumentException(T + " is not greater or equal to 1!");
        }

        results = new double[T];

        int count = 0;

        /** conduct T times experiments. */
        for (int i = 0; i < T; i += 1) {
            Percolation pi = pf.make(N);

            while (!pi.percolates()) {
                /** random open a site. */
                int r = StdRandom.uniform(0, N);
                int c = StdRandom.uniform(0, N);
                pi.open(r, c);
                count += 1;
            }

//            results[i] = pi.numberOfOpenSites() / (N * N);
            results[i] = count / (N * N);
        }

    }

    /** sample mean of percolation threshold. */
    public double mean() {
        return StdStats.mean(results);
    }

    /** sample standard deviation of percolation threshold. */
    public double stddev() {
        return StdStats.stddev(results);
    }

    /** low endpoint of 95% confidence interval. */
    public double confidenceLow() {
        double lowEndpoint = this.mean() - 1.96 * this.stddev() / Math.sqrt(results.length);
        return lowEndpoint;
    }

    /** high endpoint of 95% confidence interval. */
    public double confidenceHigh() {
        double highEndpoint = this.mean() + 1.96 * this.stddev() / Math.sqrt(results.length);
        return highEndpoint;
    }
}
