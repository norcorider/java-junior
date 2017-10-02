package com.acme.edu;

import com.acme.edu.interfaces.accumulate.LoggerAccumulate;

public class StringAcc extends LoggerAccumulate {
    public static int count = 0;
    @Override
    public String accumulate(int mode) {
        switch(mode)
        {
            /*case 0:
            {
                count = 1;
                break;
            }*/
            case 1:
            {
                count++;
                break;
            }
            case 2:
            {
                int tmp = count;
                count = 0;
                return ""+tmp;
            }
        }
        return null;
    }
}
