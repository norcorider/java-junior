package com.acme.edu.PController.interfaces;

import com.acme.edu.PController.interfaces.accumulate.LoggerAccumulate;

public class StringAcc extends LoggerAccumulate {
    //public static int count = 0;
    @Override
    public String accumulate(int mode) {
        sumB = 0;
        sumI = 0;
        deltaB = 0;
        deltaI = 0;
        switch(mode)
        {
            /*case 0:
            {
                count = 1;
                break;
            }*/
            case 1:
            {
                countS++;
                break;
            }
            case 2:
            {
                int tmp = ++countS;
                countS = 0;
                return ""+tmp;
            }
        }
        return null;
    }
}
