package hw4.puzzle;

import edu.princeton.cs.algs4.MinPQ;
import java.util.HashMap;

/**
 * A* search algorithm implementation solver
 *
 * Created by mancunian100
 */

public class Solver {

    private MinPQ<WorldState> pq = new MinPQ<>();

    /**
     * Constructor which solves the puzzle, computing
     *                  everything necessary for moves() and solution() to
     *                  not have to solve the problem again. Solves the
     *                  puzzle using the A* algorithm. Assumes a solution exists.
     * @param initial WorldSate.
     */
    public Solver(WorldState initial) {
        pq.insert(initial);
    }

    /**
     * Returns the minimum number of moves to solve the puzzle starting
     *                  at the initial WorldState.
     * @return: the minimum number of moves.
     */
    public int moves() {
        return 0;
    }

    /**
     * Returns a sequence of WorldStates from the initial WorldState
     *                  to the solution.
     * @return
     */
    public Iterable<WorldState> solution() {
        return null;
    }
}
