package com.acme.edu.PSmartMessage.Typemessage;

import com.acme.edu.PSmartMessage.interfacesAndabstracts.save.Message;

public class StringMessage extends Message {

    public String str;

    public StringMessage(String s) {
        super();
        str=s;
    }



    public String getStr() {
        return str;
    }

    @Override
    public String iteration(int classmode) {
        switch(classmode)
            {
                case 0:
                {
                    sum = 1;
                    break;
                }
                case 1:
                {
                    String result = ""+m.sum;
                    sum = 1;
                    return result;
                }
                case 2:
                {
                    String result = ""+m.sum;
                    sum = 1;
                    return result;
                }
                case 3:
                {
                    if(str.equals(((StringMessage) m).getStr()))
                    {
                        sum = m.sum+1;
                        break;
                    }
                    else {
                        sum = 1;
                        return ((StringMessage) m).getStr() + " (x" + m.sum + ")";
                    }
                }
            }
            return "";
    }
}
