package lab11.graphs;

import java.util.HashSet;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;


    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs(int v) {
        marked[v] = true;
        announce();

        if (v == t) {
            targetFound = true;
        }
        if (targetFound) {
            return;
        }

        /** arrays for storing the searching heads. */
        HashSet<Integer> heads = new HashSet<>();
        heads.add(v);

        while (!targetFound) {
            HashSet<Integer> temp = new HashSet<>();

            for (int h : heads) {
                if (h == t) {
                    targetFound = true;
                    return;
                }
                for (int neighbor : maze.adj(h)) {
                    if (!marked[neighbor]) {
                        temp.add(neighbor);
                        distTo[neighbor] = distTo[h] + 1;
                        edgeTo[neighbor] = h;
                        announce();
                        marked[neighbor] = true;
                    }
                }
            }
            heads = temp;
        }

    }


    @Override
    public void solve() {
        bfs(s);
    }
}

