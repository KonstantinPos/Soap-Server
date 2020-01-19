package server.service;

import server.exception.DocumentAlreadyExist;
import server.exception.DocumentNotFound;
import server.model.Document;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface DocumentService {

    @WebMethod
    Document findById(Integer id) throws DocumentNotFound;

    @WebMethod
    void save(Document document) throws DocumentAlreadyExist;

    @WebMethod
    void delete(Document document) throws DocumentNotFound;

    @WebMethod
    List<Document> findAll();

}
