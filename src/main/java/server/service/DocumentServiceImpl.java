package server.service;

import server.exception.DocumentAlreadyExist;
import server.exception.DocumentNotFound;
import server.model.Document;
import server.repository.DocumentRepository;
import server.repository.DocumentRepositoryImp;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "server.service.DocumentService")
public class DocumentServiceImpl implements DocumentService {

    DocumentRepository documentRepositoryImp = new DocumentRepositoryImp();

    @Override
    public Document findById(Integer id) throws DocumentNotFound {
        return this.documentRepositoryImp.findById(id);
    }

    @Override
    public void save(Document document) throws DocumentAlreadyExist {
        this.documentRepositoryImp.save(document);
    }

    @Override
    public void delete(Document document) throws DocumentNotFound {
        this.documentRepositoryImp.delete(document);
    }

    @Override
    public List<Document> findAll() {
        return this.documentRepositoryImp.findAll();
    }
}
