package server.repository;

import server.exception.DocumentAlreadyExist;
import server.exception.DocumentNotFound;
import server.model.Document;

import java.util.List;

public interface DocumentRepository {

    Document findById(Integer id) throws DocumentNotFound;

    void save(Document document) throws DocumentAlreadyExist;

    void delete(Document document) throws DocumentNotFound;

    List<Document> findAll();
}
