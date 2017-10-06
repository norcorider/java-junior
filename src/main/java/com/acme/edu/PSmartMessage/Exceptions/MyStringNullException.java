package com.acme.edu.PSmartMessage.Exceptions;

public class MyStringNullException extends Exception {
    public MyStringNullException(String msg, Throwable cause)
    {super(msg,cause);}
    public MyStringNullException(String msg)
    {super(msg);}
}
