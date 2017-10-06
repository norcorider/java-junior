package com.acme.edu.PSmartMessage.Typemessage;

import com.acme.edu.PSmartMessage.Exceptions.OutofByteBoundException;
import com.acme.edu.PSmartMessage.Exceptions.OutofIntegerBoundException;
import com.acme.edu.PSmartMessage.interfacesAndabstracts.save.Message;

public class CharMessage extends Message {
    char ch;
    public CharMessage(char c)
    {
        ch = c;
    }
    @Override
    public String iteration(int classmode) throws OutofByteBoundException, OutofIntegerBoundException {
        return ch+"";
    }
}
