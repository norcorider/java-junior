package com.acme.edu.PSmartMessage.Typemessage;

import com.acme.edu.PSmartMessage.interfacesAndabstracts.save.Message;

public class IntMessage extends Message {
    public int delta;
    public IntMessage(int i) {
        super();
        delta = i;
    }


    @Override
    public String iteration(int classmode) {

        switch(classmode)
        {
            case 0:
            {
                sum = delta;
                break;
            }
            case 1:
            {
                String result = ""+m.sum;
                sum = delta;
                return result;
            }
            case 2:
            {
                /*if((long)delta+m.sum>=Integer.MAX_VALUE |
                        (long)delta+m.sum<=Integer.MIN_VALUE)
                {
                    return ""+m.sum+"\n"+ delta;
                }*/
                sum=delta+m.sum;
                break;
            }
            case 3:
            {
                String result = ((StringMessage)m).getStr() + " (x"+m.sum+")";
                sum=delta;
                return result;
            }
        }
        return "";
    }
}
