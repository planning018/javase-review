package com.planning.design.factory;

/**
 * concrete class
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square :: draw() method...");
    }
}
