package com.acme.edu.PController.interfaces;

import com.acme.edu.PController.interfaces.accumulate.LoggerAccumulate;

public class IntAcc extends LoggerAccumulate {


    @Override
    public String accumulate(int mode) {
        sumB = 0;
        countS = 0;
        deltaB = 0;
        switch (mode) {
            /*case 0:
            {
                sum = deltaI;
                break;
            }*/
            case 1: {
                sumI+=deltaI;
                break;
            }
            case 2: {
                int tmp = (sumI+deltaI);
                sumI = 0;
                return ""+tmp;
            }

        }
        return null;
    }
}
