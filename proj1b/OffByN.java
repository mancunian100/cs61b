/**
 * Created by mancunian100 on 2019/01/14
 */

public class OffByN implements CharacterComparator {

    private int N;

    /** constructor.
    * Args: the two characters are off by n.
    */
    public OffByN(int n) {
        N = n;
    }

    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == N;
    }
}
