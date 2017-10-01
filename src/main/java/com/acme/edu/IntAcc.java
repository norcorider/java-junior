package com.acme.edu;

import com.acme.edu.interfaces.accumulate.LoggerAccumulate;

public class IntAcc extends LoggerAccumulate {
    public static int sum = 0;

    @Override
    public String accumulate(int mode) {
        switch (mode)
        {
            /*case 0:
            {
                sum = deltaI;
                break;
            }*/
            case 1:
            {
                sum+=deltaI;
                break;
            }
            case 2:
            {
                int tmp = (sum+deltaI);
                sum = 0;
                return ""+tmp;
            }

        }
        return null;
    }
}
