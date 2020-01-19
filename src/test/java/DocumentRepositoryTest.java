import org.junit.Test;
import server.exception.DocumentAlreadyExist;
import server.exception.DocumentNotFound;
import server.model.Document;
import server.repository.DocumentRepositoryImp;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

public class DocumentRepositoryTest {
    DocumentRepositoryImp documentRepositoryImp = new DocumentRepositoryImp();

    @Test
    public void findById() throws DocumentNotFound {
        Document document1 = documentRepositoryImp.findById(2);
        assertTrue(document1.getAmount().equals(new BigDecimal("50000.05")));

    }

    @Test(expected = DocumentNotFound.class)
    public void notFound() throws DocumentNotFound {
        Document document1 = documentRepositoryImp.findById(5);
    }

    @Test
    public void deleteDocument() throws DocumentNotFound {
        Document document = new Document(1, "заработная плата", new BigDecimal("500.05"), 1234567897, 1234567897);
        documentRepositoryImp.delete(document);
        assertTrue(documentRepositoryImp.documentList.size() == 2);
    }

    @Test(expected = DocumentNotFound.class)
    public void documentNotFound() throws DocumentNotFound {
        Document document = new Document(5, "заработная плата", new BigDecimal("500.05"), 1234567897, 1234567897);
        documentRepositoryImp.delete(document);
    }

    @Test
    public void saveDocument() throws DocumentAlreadyExist {
        Document document = new Document(5, "заработная плата", new BigDecimal("500.05"), 1234567897, 1234567897);
        documentRepositoryImp.save(document);
        assertTrue(documentRepositoryImp.documentList.size() == 4);
    }

    @Test(expected = DocumentAlreadyExist.class)
    public void documentAlreadyExist() throws DocumentAlreadyExist {
        Document document = new Document(1, "заработная плата", new BigDecimal("500.05"), 1234567897, 1234567897);
        documentRepositoryImp.save(document);
    }
}
