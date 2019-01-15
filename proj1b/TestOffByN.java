import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

	static CharacterComparator offby5 = new OffByN(5);

	@Test
	public void testOffByN() {
        char a = 'a';
        char b = 'f';
		boolean expected = true;
		boolean actual = offby5.equalChars(a, b);
		assertEquals(expected, actual);
	}
}
