package server.exception;

import javax.xml.ws.WebFault;

@WebFault
public class DocumentNotFound extends Exception {

    public DocumentNotFound() {
        super("The specified document does not exist");
    }
}
