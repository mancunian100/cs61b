/**
 * Created by mancunian100 on 2019/01/14
 */

public class OffByOne implements CharacterComparator {
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }
}
