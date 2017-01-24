package test;

import code.Tries.UrlHash;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UrlHashTest {
    private UrlHash tester = new UrlHash();

    public UrlHashTest() {
        this.tester.addUrl("www.google.com");
        this.tester.addUrl("www.yahoo.com");
        this.tester.addUrl("www.goal.com");
    }

    @Test
    public void add_urls_expect_true() {
        assertEquals(true, this.tester.hasUrl("www.goal.com"));
    }

    @Test
    public void add_urls_expect_false() {
        assertEquals(false, this.tester.hasUrl("www.goal.comm"));
    }

    @Test
    public void add_urls_corner_case_expect_false() {
        assertEquals(false, this.tester.hasUrl("www.goal.co"));
    }
}
