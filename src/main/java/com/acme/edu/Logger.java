
package com.acme.edu;

import static com.acme.edu.Logger.logString;

public class Logger {
    public static void log(int message) {
        System.out.println("primitive: " + message);
    }

    public static void logString(String message){
        System.out.println(message);
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    public static void main(String[] args) {
        logString("HW!!");
    }
}

class Main {
    public static void main(String[] args) {
        logString("HW!!");
    }
    public void m() {

    }
}

class Rt{
    public static void main(String[] args) {
        byte b;
        System.out.println(b);
    }
}