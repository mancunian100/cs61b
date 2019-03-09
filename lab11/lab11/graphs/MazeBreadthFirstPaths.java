package lab11.graphs;

import java.util.Queue;
import java.util.ArrayDeque;

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
    private Queue<Integer> heads;


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

        /** arrays for storing the searching heads. */
        heads = new ArrayDeque<>();
        heads.add(v);

        while (!heads.isEmpty()) {
            int h = heads.remove();
            for (int neighbor : maze.adj(h)) {
                if (!marked[neighbor]) {
                    heads.add(neighbor);
                    marked[neighbor] = true;
                    edgeTo[neighbor] = h;
                    distTo[neighbor] = distTo[h] + 1;
                    announce();
                    if (neighbor == t) {
                        targetFound = true;
                        return;
                    }
                    // draw before determining if reaching target;
                }
            }
        }

    }


    @Override
    public void solve() {
        bfs(s);
    }
}

