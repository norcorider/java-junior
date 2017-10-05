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
                if(getDelta() == Byte.MAX_VALUE |
                        getDelta() == Byte.MIN_VALUE) {
                    if (((ByteMessage) m).getDelta() == Byte.MAX_VALUE |
                            ((ByteMessage) m).getDelta() == Byte.MIN_VALUE) {
                        sum = 0;
                        return "" + delta;
                    } else {
                        sum = 0;
                        return "" + m.sum + "\n" + delta;
                    }
                }
                else {
                    sum = delta + m.sum;
                    break;
                }
            }
            case 2: {
                if(((IntMessage)m).getDelta() == Integer.MAX_VALUE |
                        ((IntMessage)m).getDelta() == Integer.MIN_VALUE)
                {
                    if(getDelta() == Byte.MAX_VALUE |
                            getDelta() == Byte.MIN_VALUE)
                    {
                        sum = 0;
                        return ""+getDelta();
                    }else {
                        sum = delta;
                        return "";
                    }
                }
                else
                {
                    if(getDelta() == Byte.MAX_VALUE |
                            getDelta() == Byte.MIN_VALUE)
                    {
                        sum = 0;
                        return ""+m.sum +"\n"+getDelta();
                    }else {
                        String result = "" + m.sum;
                        sum = delta;
                        return result;
                    }
                }
            }
            case 3: {
                if(getDelta() == Byte.MAX_VALUE |
                        getDelta() == Byte.MIN_VALUE) {
                    if(m.sum>1)
                        return ((StringMessage) m).getStr() + " (x" + m.sum + ")";
                    else
                        return ((StringMessage) m).getStr();
                }
                else {
                    String result;
                    if(m.sum>1)
                        result = ((StringMessage) m).getStr() + " (x" + m.sum + ")";
                    else
                        result = ((StringMessage) m).getStr();
                    //String result = ((StringMessage) m).getStr() + " (x" + m.sum + ")";
                    sum = delta;
                    return result;
                }
            }
        }
        //}
        return "";
    }

    public byte getDelta() {
        return delta;
    }
}
