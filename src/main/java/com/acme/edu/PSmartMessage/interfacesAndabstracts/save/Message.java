package com.acme.edu.PSmartMessage.interfacesAndabstracts.save;

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

    public abstract String iteration(int classmode);//одна строка лога
}
