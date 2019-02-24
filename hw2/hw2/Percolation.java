package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import static org.junit.Assert.*;

public class Percolation {
    /** the grid of percolation system. */
    private int[][] grid;
    /** number of open sites. */
    private int sizeOfOpen;
    /** a WeightedQuickUnionUF instance. */
    private WeightedQuickUnionUF WQU;
    /** represent the top node. */
    private int top;
    /** represent the bottom node. */
    private int bottom;

    /** create N-by-N grid, with all sites initially blocked. */
    public Percolation(int N) {
        /** validate the N is greater than 0. */
        if (N < 0) {
            throw new IllegalArgumentException(N + " is not greater or equal to 0!");
        }

        grid = new int[N][N]; // by default each grid number is 0.

        sizeOfOpen = 0;

        WQU = new WeightedQuickUnionUF(N * N + 2);

        top = 0;
        bottom = N * N + 1;
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

    /**
     * private helper method.
     *
     * transform the 2d grid index to 1d index.
     */
    private int xyTo1D(int i, int j) {
        int n = grid.length;
        return (i * n + j + 1);
    }

    /** open the site (row, col) if it is not open already. */
    public void open(int row, int col) {
        /** validate the row and col is valid index. */
        validate(row);
        validate(col);

        if (grid[row][col] != 1) {
            grid[row][col] = 1;
            sizeOfOpen += 1;

            int N = grid.length;
            int index = xyTo1D(row, col);
            /**
             * union the top, bottom and neighbor sites.
             */
            /** check if at top. */
            if (index <= N) {
                WQU.union(top, index);
            }
            /** check if at bottom. */
            if (index > N * N - N) {
                WQU.union(bottom, index);
            }
            /** check neighbors. */
            if (row > 0 && isOpen(row - 1, col)) {
                WQU.union(index, xyTo1D(row - 1, col));
            }
            if (row < N - 1 && isOpen(row + 1, col)) {
                WQU.union(index, xyTo1D(row + 1, col));
            }
            if (col > 0 && isOpen(row, col - 1)) {
                WQU.union(index, xyTo1D(row, col - 1));
            }
            if (col < N - 1 && isOpen(row, col + 1)) {
                WQU.union(index, xyTo1D(row, col + 1));
            }
        }
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
        /** validate the row and col is valid index. */
        validate(row);
        validate(col);

        int index = xyTo1D(row, col);
        return WQU.connected(index, top);
    }

    /** number of open sites. */
    public int numberOfOpenSites() {
        return sizeOfOpen;
    }

    /** does the system percolate? */
    public boolean percolates() {
        return WQU.connected(top, bottom);
//        int N = grid.length;
//        for (int i = 0; i < N; i += 1) {
//            if (WQU.connected(top, xyTo1D(N - 1, i))) {
//                return true;
//            }
//        }
//        return false;
    }

    public static void main(String[] args) {
        /** test constructor. */
        Percolation pTest = new Percolation(10);
        assertEquals(10, pTest.grid.length);

        /** test open() isFull(), and isOpen(). */
        pTest.open(0, 4);
        boolean actualOpen = pTest.isOpen(0, 4);
        assertEquals(true, actualOpen);
        boolean actualFull = pTest.isFull(0, 4);
        assertEquals(true, actualFull);
        /** test numOfOpe. */
        int actualSize = pTest.sizeOfOpen;
        assertEquals(1, actualSize);

        /** test percolates. */
        assertFalse(pTest.percolates());
        for (int i = 0; i < pTest.grid.length; i += 1) {
            pTest.open(i, 4);
        }
        assertTrue(pTest.percolates());

        /** test numOfOpe. */
        int actualSize2 = pTest.sizeOfOpen;
        assertEquals(10, actualSize2);
    }
}
