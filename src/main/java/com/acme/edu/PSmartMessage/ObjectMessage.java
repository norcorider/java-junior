package com.acme.edu.PSmartMessage;

import com.acme.edu.PSmartMessage.Exceptions.OutofByteBoundException;
import com.acme.edu.PSmartMessage.Exceptions.OutofIntegerBoundException;
import com.acme.edu.PSmartMessage.interfacesAndabstracts.save.Message;

public class ObjectMessage extends Message {
    public ObjectMessage(Object o) {
    }

    @Override
    public String iteration(int classmode) throws OutofByteBoundException, OutofIntegerBoundException {
        return "reference: @";
    }
}
