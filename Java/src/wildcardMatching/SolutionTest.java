package wildcardMatching;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Solution2 test1 = new Solution2();
		boolean result = test1.isMatch("acaabbaccbbacaabbbb", "a*?*b*?*a*aa*a*");
		System.out.println(result);
	}

}
