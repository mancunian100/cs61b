package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    /** the grid of percolation system. */
    private int[][] grid;
    /** number of open sites. */
    int sizeOfOpen;

    /** create N-by-N grid, with all sites initially blocked. */
    public Percolation(int N) {
        /** validate the N is greater than 0. */
        if (N < 0) {
            throw new IllegalArgumentException(N + "is not greater or equal to 0!");
        }

        grid = new int[N][N]; // by default each grid number is 0.
        sizeOfOpen = 0;
    }

    /**
     * private helper method.
     *
     * validate that p is a valid index.
     */
    private void validate(int p) {
        int n = grid.length;
        if (p < 0 || p >= n) {
            throw new IndexOutOfBoundsException("index " + p + "is not bettween 0 and " + (n - 1));
        }
    }

    /** open the site (row, col) if it is not open already. */
    public void open(int row, int col) {
        /** validate the row and col is valid index. */
        validate(row);
        validate(col);

        grid[row][col] = 1;
        sizeOfOpen += 1;
    }

    /** is the site (row, col) open? */
    public boolean isOpen(int row, int col) {
        /** validate the row and col is valid index. */
        validate(row);
        validate(col);

        return (grid[row][col] == 1);
    }

    /** is the site (row, col) full? */
    public boolean isFull(int row, int col) {
        return false;
    }

    /** number of open sites. */
    public int numberOfOpenSites() {
        return sizeOfOpen;
    }

    /** does the system percolate? */
    public boolean percolates() {
        return false;
    }
}
