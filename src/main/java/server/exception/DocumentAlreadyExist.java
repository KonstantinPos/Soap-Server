package server.exception;

import javax.xml.ws.WebFault;

@WebFault
public class DocumentAlreadyExist extends Exception {

    public DocumentAlreadyExist() {
        super("This document already exists");
    }
}
