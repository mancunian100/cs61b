package hw4.puzzle;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;

import java.lang.reflect.WildcardType;

/**
 * A* search algorithm implementation solver
 *
 * Created by mancunian100
 */

public class Solver {

    private Stack<WorldState> solution;

    /** nested class SearchNode. */
    private class SearchNode implements Comparable<SearchNode> {
        private WorldState world;
        private int moves;
        private SearchNode prev;
        private int priority;

        private SearchNode(WorldState w, int m, SearchNode p) {
            /** state for now. */
            world = w;
            /** moves has made. */
            moves = m;
            /** previous SearchNode. */
            prev = p;
            /** caching for the priority compare. */
            priority = moves + w.estimatedDistanceToGoal();
        }


        @Override
        public int compareTo(SearchNode s) {
            return (this.priority - s.priority);
        }

        public WorldState getWorldState() {
            return world;
        }

        public int moves() {
            return moves;
        }

        public SearchNode prev() {
            return prev;
        }

    }

    /**
     * Constructor which solves the puzzle, computing
     *                  everything necessary for moves() and solution() to
     *                  not have to solve the problem again. Solves the
     *                  puzzle using the A* algorithm. Assumes a solution exists.
     * @param initial WorldSate.
     */
    public Solver(WorldState initial) {

        solution = new Stack<>();

        MinPQ<SearchNode> pq = new MinPQ<>();
        pq.insert(new SearchNode(initial, 0, null));

        while (!pq.min().getWorldState().isGoal()) {
            SearchNode F = pq.delMin();
            for (WorldState N : F.getWorldState().neighbors()) {
                /** critical optimization. */
                if (F.prev() == null || N != F.prev().getWorldState()) {
                    pq.insert(new SearchNode(N, F.moves() + 1, F));
                }
            }
        }

        SearchNode s = pq.min();
        while (s != null) {
            solution.push(s.getWorldState());
            s = s.prev();
        }
    }

    /**
     * Returns the minimum number of moves to solve the puzzle starting
     *                  at the initial WorldState.
     * @return: the minimum number of moves.
     */
    public int moves() {
        return (solution.size() - 1);
    }

    /**
     * Returns a sequence of WorldStates from the initial WorldState
     *                  to the solution.
     * @return
     */
    public Iterable<WorldState> solution() {
        return solution;
    }
}
