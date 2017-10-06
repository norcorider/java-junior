package com.acme.edu.PSmartMessage;

import com.acme.edu.PSmartMessage.Exceptions.OutofByteBoundException;
import com.acme.edu.PSmartMessage.Exceptions.OutofIntegerBoundException;
import com.acme.edu.PSmartMessage.interfacesAndabstracts.save.Message;

public class IntArrayMessage extends Message {
    int[] arr;
    public IntArrayMessage(int[] arr) {
        this.arr = arr;
    }

    @Override
    public String iteration(int classmode) throws OutofByteBoundException, OutofIntegerBoundException {
        String str = "primitives array: " + "{";
        for (int i = 0; i < arr.length - 1; i++) {
            str += arr[i] + ", ";
        }
        str+=arr[arr.length - 1] + "}";
        return str;
    }
}
