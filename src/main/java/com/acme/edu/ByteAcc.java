package com.acme.edu;

import com.acme.edu.interfaces.accumulate.LoggerAccumulate;

public class ByteAcc extends LoggerAccumulate {
    public static byte sum = 0;
    @Override
    public String accumulate(int mode) {
        switch (mode)
        {
            /*case 0:
            {
                sum = deltaB;
                break;
            }*/
            case 1:
            {
                sum+=deltaB;
                break;}
            case 2:
            {
                int tmp = (sum+deltaB);
                sum = 0;
                return ""+tmp;
            }
        }
        return null;
    }
}
