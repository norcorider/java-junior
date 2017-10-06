package com.acme.edu.PSmartMessage.Typemessage;

import com.acme.edu.PSmartMessage.Exceptions.OutofByteBoundException;
import com.acme.edu.PSmartMessage.Exceptions.OutofIntegerBoundException;
import com.acme.edu.PSmartMessage.interfacesAndabstracts.save.Message;

public class BoolMessage extends Message {
    boolean value;
    public BoolMessage(boolean b)
    {
        value = b;
    }
    @Override
    public String iteration(int classmode) throws OutofByteBoundException, OutofIntegerBoundException {
        return value+"";
    }
}
