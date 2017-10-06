package com.acme.edu.PSmartMessage.interfacesAndabstracts.save;

import com.acme.edu.PSmartMessage.Exceptions.OutofByteBoundException;
import com.acme.edu.PSmartMessage.Exceptions.OutofIntegerBoundException;

public abstract class Message {
    public long sum = 0;
    public Message m;
    public void setM(Message m) {
        this.m = m;
    }

    public long getSum() {
        return sum;
    }

    public void clearM(){ m=null;}

    protected Message(){}

    public abstract String iteration(int classmode) throws OutofByteBoundException, OutofIntegerBoundException;//одна строка лога
}
