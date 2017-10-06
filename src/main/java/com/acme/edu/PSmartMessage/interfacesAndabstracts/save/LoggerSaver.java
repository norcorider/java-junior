package com.acme.edu.PSmartMessage.interfacesAndabstracts.save;

import com.acme.edu.PSmartMessage.Exceptions.LoggerSaverException;

public interface LoggerSaver {

    public void save() throws LoggerSaverException;
}
