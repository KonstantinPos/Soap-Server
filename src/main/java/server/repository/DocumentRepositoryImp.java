package server.repository;

import server.exception.DocumentAlreadyExist;
import server.exception.DocumentNotFound;
import server.model.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DocumentRepositoryImp implements DocumentRepository {

    public List<Document> documentList;

    public DocumentRepositoryImp() {
        documentList = new ArrayList<>();
        documentList.add(new Document(1, "заработная плата", new BigDecimal("50000.05"), 1234567897, 1234567897));
        documentList.add(new Document(2, "заработная плата", new BigDecimal("50000.05"), 1234567897, 1234567897));
        documentList.add(new Document(3, "заработная плата", new BigDecimal("50000.05"), 1234567897, 1234567897));
    }

    public Document findById(final Integer id) throws DocumentNotFound {
        List<Document> documents = findAll();
        for (Document document : documents) {
            if (document.getId().equals(id)) {
                return document;
            }
        }
        throw new DocumentNotFound();
    }

    public void save(Document document) throws DocumentAlreadyExist {
        while (documentList.listIterator().hasNext()) {
            if (documentList.listIterator().next().getId().equals(document.getId())) {
                throw new DocumentAlreadyExist();
            } else {
                documentList.listIterator().add(document);
                break;
            }
        }
    }

    public void delete(Document document) throws DocumentNotFound {
        Iterator<Document> documentIterator = documentList.iterator();

        List<Integer> ids = new ArrayList<>();

        while (documentIterator.hasNext()) {
            Document document1 = documentIterator.next();
            if (document1.getId().equals(document.getId())) {
                documentIterator.remove();
            }
            ids.add(document1.getId());
        }
        if (!ids.contains(document.getId())) {
            throw new DocumentNotFound();
        }
    }

    public List<Document> findAll() {
        return documentList;
    }
}
