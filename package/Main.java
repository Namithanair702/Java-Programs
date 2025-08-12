package main;

import demo.Demo;

public class Main {
    public static void main(String[] args) {
        // Create an object of Demo class
        Demo helper = new Demo();

        // Access public variable and method from Demo
        System.out.println(helper.greeting);
        helper.showDetails();
    }
}
