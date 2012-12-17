package net.hausherr.demo;

import org.testng.ITestContext;
import org.testng.annotations.*;

import static java.lang.System.out;
import static net.hausherr.demo.Group.FOO;

/**
 * Basic test
 *
 * @author Jens Hausherr <a href="https://github.com/jabbrwcky">jabbrwcky@github</a>
 * */
public class BasicTest {

    @BeforeSuite
    public void beforeSuite(ITestContext context) {
        out.println("@BeforeSuite called on " + getClass().getName());
    }

    @AfterSuite
    public void afterSuite(ITestContext context) {
        out.println("@AfterSuite called on " + getClass().getName());
    }

    @BeforeTest
    public void beforeTest(ITestContext context) {
        out.println("@BeforeTest called on " + getClass().getName());
    }

    @AfterTest
    public void afterTest(ITestContext context) {
        out.println("@AfterTest called on " + getClass().getName());
    }

    @BeforeClass
    public void beforeClass(ITestContext context) {
        out.println("@BeforeClass called on " + getClass().getName());
    }

    @AfterClass
    public void afterClass(ITestContext context) {
        out.println("@AfterClass called on " + getClass().getName());
    }

    @BeforeMethod
    public void beforeMethod() {
        out.println("@BeforeMethod called on " + getClass().getName());
    }

    @AfterMethod
    public void afterMethod() {
        out.println("@AfterMethod called on " + getClass().getName());
    }

    @BeforeGroups({FOO})
    public void beforeGroupFoo() {
        out.println("@BeforeGroups('foo') called on " + getClass().getName());
    }

    @AfterGroups({FOO})
    public void afterGroupFoo() {
        out.println("@AfterGroups('foo') called on " + getClass().getName());
    }


    @Test(groups = {FOO})
    public void testFoo() {
        out.println("FooTest");
    }

}
