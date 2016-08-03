package org.xman.trainings.spring.hello.impl;


import org.xman.trainings.spring.hello.HelloWorld;

public class HelloWorldImpl implements HelloWorld {

    @Override
    public void printHelloWorld(String msg) {

        System.out.println("Hello : " + msg);
    }

}