package com.acme.edu.PSmartMessage.Exceptions;

public class OutofByteBoundException extends Exception {
    public OutofByteBoundException(String msg, Throwable cause)
    {super(msg,cause);}
    public OutofByteBoundException(String msg)
    {super(msg);}
}
