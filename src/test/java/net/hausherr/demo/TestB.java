package net.hausherr.demo;

import org.testng.annotations.Test;

import static net.hausherr.demo.Group.FOO;
import static org.testng.Assert.assertNotNull;

/**
 * Sample inherited test
 *
 * @author Jens Hausherr <a href="https://github.com/jabbrwcky">jabbrwcky@github</a>
 */
public class TestB extends AbstractTestBase {

    @Test
    public void testBaz() {
        System.out.println("@Test testBaz");
        assertNotNull(bar);
    }

    @Test(groups = {FOO})
    public void testFooBaz() {
        System.out.println("@Test testFooBaz");
        assertNotNull(foo);
    }
}
