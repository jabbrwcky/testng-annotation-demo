package net.hausherr.demo;

import org.testng.annotations.Test;

import static net.hausherr.demo.Group.FOO;
import static org.testng.Assert.assertNotNull;

/**
 * Sample inherited test
 *
 * @author Jens Hausherr <a href="https://github.com/jabbrwcky">jabbrwcky@github</a>
 */
public class TestA extends AbstractTestBase {

    @Test
    public void testBar() {
        System.out.println("@Test testBar");
        assertNotNull(bar);
    }

    @Test(groups = {FOO})
    public void testFooBar() {
        System.out.println("@Test testFooBar");
        assertNotNull(foo);
    }

}
