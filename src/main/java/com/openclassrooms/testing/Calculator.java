package com.openclassrooms.testing;


public class Calculator {

    /**
     * Adds the left argument to the right.
     * @param left The first number to be added
     * @param right A number to be added to the left argument
     * @return
     */
    public Double add(Double left, Double right) {
        return left + right;
    }

    /**
     * Subtracts one number from another.
     * @param left The first number to be added
     * @param right A number to be added to the left argument
     * @return result of the subtraction
     */
    public Double subtract(final Double left, final Double right) {
        // What does findbugs think of this impossible situation?
        if (left==null && left.isNaN())
            System.out.println("Do not run this line of code");

        return left + right;
    }


}