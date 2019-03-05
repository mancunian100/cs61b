package hw4.puzzle;

import edu.princeton.cs.algs4.Queue;

public class Board implements WorldState {

    private final int BLANK = 0;
    private int size;
    private int[][] board;

    /** Constructs a board from an N-by-N array of tiles where
     tiles[i][j] = tile at row i, column j. */
    public Board(int[][] tiles) {
        size = tiles.length;
        board = new int[size][size];
        for (int i = 0; i < size(); i += 1) {
            for (int j = 0; j < size(); j += 1) {
                board[i][j] = tiles[i][j];
            }
        }
    }

    public int tileAt(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            return board[i][j];
        }
    }

    public int size() {
        return size;
    }

    /** implemented by Josh Hug.
     * source: http://joshh.ug/neighbors.html
     */
    @Override
    public Iterable<WorldState> neighbors() {
        Queue<WorldState> neighbors = new Queue<>();
        int s = size();
        int blankI = -1;
        int blankJ = -1;
        for (int i = 0; i < s; i += 1) {
            for (int j = 0; j < s; j += 1) {
                if (tileAt(i, j) == BLANK) {
                    blankI = i;
                    blankJ = j;
                }
            }
        }
        int[][] neighbor = new int[s][s];
        for (int i = 0; i < s; i += 1) {
            for (int j = 0; j < s; j += 1) {
                neighbor[i][j] = tileAt(i, j);
            }
        }
        for (int i = 0; i < s; i += 1) {
            for (int j = 0; j < s; j += 1) {
                if (Math.abs(-blankI + i) + Math.abs(-blankJ + j) == 1) {
                    neighbor[blankI][blankJ] = neighbor[i][j];
                    neighbor[i][j] = BLANK;
                    Board N = new Board(neighbor);
                    neighbors.enqueue(N);
                    neighbor[i][j] = neighbor[blankI][blankJ];
                    neighbor[blankI][blankJ] = BLANK;
                }
            }
        }
        return neighbors;
    }

    public int hamming() {
        int count = 0;
        for (int i = 0; i < size(); i += 1) {
            for (int j = 0; j < size(); j += 1) {
                int goal = i * size() + j + 1;
                if (tileAt(i, j) != goal) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public int manhattan() {
        int count = 0;
        for (int i = 0; i < size(); i += 1) {
            for (int j = 0; j < size(); j += 1) {
                int num = tileAt(i, j);
                if (num != BLANK) {
                    int goalI = (num - 1) / size();
                    int goalJ = (num - 1) % size();
                    count += Math.abs(goalI - i) + Math.abs(goalJ - j);
                }
            }
        }
        return count;
    }

    @Override
    public int estimatedDistanceToGoal() {
        return manhattan();
    }

    @Override
    public boolean equals(Object y) {
        if (this == y) {
            return true;
        }
        if (y == null || y.getClass() != this.getClass()) {
            return false;
        }
        Board newY = (Board) y;
        for (int i = 0; i < size(); i += 1) {
            for (int j = 0; j < size(); j += 1) {
                if (board[i][j] != newY.tileAt(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    /** Returns the string representation of the board.
     * Uncomment this method. */
    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i, j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }

}
