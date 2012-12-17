package net.hausherr.demo;

import org.testng.ITestContext;
import org.testng.annotations.*;

import static java.lang.System.out;

/**
 * Abstract base class for tests demonstrating configuration data handover via @BeforeTest and @BeforeClass.
 *
 * @author Jens Hausherr <a href="https://github.com/jabbrwcky">jabbrwcky@github</a>
 */
public abstract class AbstractTestBase {

    /** Property Foo is set once per Suite */
    protected String foo;

    /** Property Foo is set once per Test */
    protected String bar;

    /**
     * As this method is executed only once for all inheriting instances before the test suite starts this method puts
     * any configuration/resources needed by test implementations into the test context.
     *
     * @param context test context for storing test conf data
     */
    @BeforeSuite
    public void beforeSuite(ITestContext context) {
        out.println("@BeforeSuite called on " + getClass().getName());
        context.setAttribute("foo", "I was set in @BeforeSuite");
    }

    @AfterSuite
    public void afterSuite(ITestContext context) {
        out.println("@AfterSuite called on " + getClass().getName());
    }

    /**
     * As this method is executed only once for all inheriting instances before the test starts this method puts any
     * configuration/resources needed by test implementations into the test context.
     *
     * @param context test context for storing test conf data
     */
    @BeforeTest(alwaysRun = true)
    public void beforeTest(ITestContext context) {
        out.println("@BeforeTest called on " + getClass().getName());
        context.setAttribute("bar", "I was set in @BeforeTest");
    }

    @AfterTest
    public void afterTest(ITestContext context) {
        out.println("@AfterTest called on " + getClass().getName());
    }

    /**
     * This method is run before the first method of a test instance is started and gets all required configuration from
     * the test context.
     *
     * @param context test context to retrieve conf data from.
     */
    @BeforeClass
    public void beforeClass(ITestContext context) {
        out.println("@BeforeClass called on " + getClass().getName());
        foo = (String) context.getAttribute("foo");
        bar = (String) context.getAttribute("bar");

    }

    @AfterClass
    public void afterClass(ITestContext context) {
        out.println("@AfterClass called on " + getClass().getName());
    }

}
