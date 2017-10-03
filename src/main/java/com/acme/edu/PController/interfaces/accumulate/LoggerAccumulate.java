package com.acme.edu.PController.interfaces.accumulate;

public abstract class LoggerAccumulate {
    protected byte deltaB;
    protected int deltaI;


    protected String str;
    public static byte sumB = 0;
    public static int sumI = 0;
    public static int countS = 0;

    public static int getCountS() {
        return countS;
    }

    public void setDeltaB(byte deltaB) {
        this.deltaB = deltaB;
    }

    public void setDeltaI(int deltaI) {
        this.deltaI = deltaI;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public abstract String accumulate(int mode);
}
