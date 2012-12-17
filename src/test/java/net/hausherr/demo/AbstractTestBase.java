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
     *
     * @param context
     */
    @BeforeSuite
    public void beforeSuite(ITestContext context) {
        out.println("@BeforeSuite called on "+getClass().getName());
        context.setAttribute("foo", "I was set in @BeforeSuite");
    }

    @AfterSuite
    public void afterSuite(ITestContext context) {
        out.println("@AfterSuite called on "+getClass().getName());
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest(ITestContext context) {
        out.println("@BeforeTest called on "+getClass().getName());
        context.setAttribute("bar", "I was set in @BeforeTest");
    }

    @AfterTest
    public void afterTest(ITestContext context) {
        out.println("@AfterTest called on "+getClass().getName());
    }

    @BeforeClass
    public void beforeClass(ITestContext context) {
        out.println("@BeforeClass called on "+getClass().getName());
        foo = (String) context.getAttribute("foo");
        bar = (String) context.getAttribute("bar");

    }

    @AfterClass
    public void afterClass(ITestContext context) {
        out.println("@AfterClass called on "+getClass().getName());
    }

}
