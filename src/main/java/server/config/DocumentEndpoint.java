package server.config;

import server.service.DocumentServiceImpl;

import javax.xml.ws.Endpoint;

public class DocumentEndpoint {
    public static void main(String[] args) {

        Endpoint.publish("http://localhost:4789/document", new DocumentServiceImpl());
        System.out.println("Done");
    }
}
