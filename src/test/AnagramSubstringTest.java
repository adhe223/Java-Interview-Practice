package test;

import org.junit.Test;
import code.Strings.AnagramSubstring;
import static org.junit.Assert.assertEquals;

public class AnagramSubstringTest {
    @Test
    public void testAnagramTrue() {
        String a = "dog";
        String b = "bagodfjk";
        AnagramSubstring tester = new AnagramSubstring(a, b);

        assertEquals(true, tester.isAnagramSubstringv2(a, b));
    }

    @Test
    public void testAnagramFalse() {
        String a = "dog";
        String b = "jhpdohks";
        AnagramSubstring tester = new AnagramSubstring(a, b);

        assertEquals(false, tester.isAnagramSubstringv2(a, b));
    }
}
