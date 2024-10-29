package com.kyalo.example;


public class MyFirstClass {
    private String myVar;

    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello() {
        return "Jambo from MyFirstClass ==> myVar = " + myVar;
    }
}
