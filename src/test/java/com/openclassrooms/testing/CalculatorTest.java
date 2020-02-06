package com.openclassrooms.testing;

import org.junit.*;

import java.time.Duration;
import java.time.Instant;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Part 1 - Chapter 5
 * Here are some nice reminders of how you can use the standard annotations we covered.
 * Try running the tests. Fix the broken one. Break the working ones and see what happens.
 * @author Raf Gemmail
 */

public class CalculatorTest {

    private static Instant startedAt;
    private Calculator calculatorUnderTest;

    @BeforeClass
    public static void beforeClass() {
        // lets capture the time when the test was run
        System.out.println("Before class ");
        startedAt = Instant.now();
    }

    @AfterClass
    public static void afterClass() {
        // Not the way to do it. Just illustrating @AfterClass
        // How long did the tests take?
        Instant endedAt = Instant.now();
        Duration duration = Duration.between(startedAt, endedAt);
        System.out.println("Tests took " + duration.toString());
    }

    @Before
    public void setUp() {
        // Recreate the calculator before each test
        calculatorUnderTest = new Calculator();
        System.out.println("Before Test: " + Instant.now());
    }

    @After
    public void tearDown() {
        // set calculator to null after each test
        calculatorUnderTest = null;
        System.out.println("After Test " + Instant.now());
    }

    // Checkout this site to see other popular naming conventions
    // https://dzone.com/articles/7-popular-unit-test-naming
    @Test(expected = Exception.class)
    public void add_returnsTheSum_OfTwoPositiveNumbers() throws Exception {
        Double expected = 3.0;
        Double sum = calculatorUnderTest.add(1.0, 2.0);
        assertThat(expected, is(equalTo(sum)));
        // pretend this wass from your code!
        throw new Exception("We expect an Exception");
    }

    @Test(timeout = 3000)
    public void add_returnsTheSum_OfTwoNegativeNumbers() throws Exception {
        Double expected = -3.0;
        Double sum = calculatorUnderTest.add(-1.0, -2.0);
        assertThat(expected, is(equalTo(sum)));
        // Let's timeout our test
        Thread.sleep(2000);
    }


}



