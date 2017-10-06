package com.acme.edu.PSmartMessage;

import com.acme.edu.PSmartMessage.Exceptions.LoggerSaverException;
import com.acme.edu.PSmartMessage.interfacesAndabstracts.save.LoggerSaver;

public class FileSaver implements LoggerSaver {
    @Override
    public void save() throws LoggerSaverException{
        throw new LoggerSaverException("Class isn't exist");
    }
}
