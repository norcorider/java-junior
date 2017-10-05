package com.acme.edu.PSmartMessage.Exceptions;

public class OutofIntegerBoundException extends Exception {
    public OutofIntegerBoundException(String msg, Throwable cause)
    {super(msg,cause);}
    public OutofIntegerBoundException (String msg)
    {super(msg);}
}