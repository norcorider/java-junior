package com.acme.edu.PController.interfaces;

import com.acme.edu.PController.interfaces.accumulate.LoggerAccumulate;

public class ByteAcc extends LoggerAccumulate {
    //public static byte sum = 0;
    @Override
    public String accumulate(int mode) {
        sumI=0;
        countS=0;
        deltaI=0;
        switch (mode) {
            /*case 0:
            {
                sum = deltaB;
                break;
            }*/
            case 1: {
                sumB+=deltaB;
                break;}
            case 2: {
                int tmp = (sumB+deltaB);
                sumB = 0;
                return ""+tmp;
            }
        }
        return null;
    }
}
