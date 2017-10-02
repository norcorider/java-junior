package com.acme.edu.PSmartMessage.Typemessage;

import com.acme.edu.PSmartMessage.interfacesAndabstracts.save.Message;

public class ByteMessage extends Message {
    public byte delta;
    public ByteMessage(byte b) {
        super();
        delta = b;
    }

    @Override
    public String iteration(int classmode) {
        switch (classmode) {
            case 0: {
                sum = delta;
                break;
            }
            case 1: {
                /*if((long)delta+m.sum>=Byte.MAX_VALUE |
                        (long)delta+m.sum<=Byte.MIN_VALUE)
                {
                    return ""+m.sum+"\n"+ delta;
                }*/
                sum = delta + m.sum;
                break;
            }
            case 2: {
                String result = "" + m.sum;
                sum = delta;
                return result;
            }
            case 3: {
                String result = ((StringMessage) m).getStr() + " (x" + m.sum + ")";
                sum = delta;
                return result;
            }
        }
        //}
        return "";
    }
}
