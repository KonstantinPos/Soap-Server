import org.junit.Before;
import org.junit.Test;
import server.exception.DocumentAlreadyExist;
import server.exception.DocumentNotFound;
import server.model.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class DocumentRepositoryTest {
    List<Document> documentList;

    @Before
    public void initTest() {
        documentList = new ArrayList<>();
        documentList.add(new Document(1, "заработная плата", new BigDecimal("500.05"), 1234567897, 1234567897));
        documentList.add(new Document(2, "заработная плата", new BigDecimal("50000.05"), 1234567897, 1234567897));
        documentList.add(new Document(3, "заработная плата", new BigDecimal("500800.05"), 1234567897, 1234567897));
    }

    @Test
    public void findById() throws DocumentNotFound {
        Document document1 = findById(2);
        assertTrue(document1.getAmount().equals(new BigDecimal("50000.05")));

    }

    @Test(expected = DocumentNotFound.class)
    public void notFound() throws DocumentNotFound {
        Document document1 = findById(5);
    }

    public Document findById(final Integer id) throws DocumentNotFound {
        for (Document document : documentList) {
            if (document.getId().equals(id)) {
                return document;
            }
        }
        throw new DocumentNotFound();
    }

    @Test
    public void deleteDocument() throws DocumentNotFound {
        Document document = new Document(1, "заработная плата", new BigDecimal("500.05"), 1234567897, 1234567897);
        delete(document);
        assertTrue(documentList.size() == 2);
    }

    @Test(expected = DocumentNotFound.class)
    public void documentNotFound() throws DocumentNotFound {
        Document document = new Document(5, "заработная плата", new BigDecimal("500.05"), 1234567897, 1234567897);
        delete(document);
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

    @Test
    public void saveDocument() throws DocumentAlreadyExist {
        Document document = new Document(5, "заработная плата", new BigDecimal("500.05"), 1234567897, 1234567897);
        save(document);
        assertTrue(documentList.size() == 4);
    }

    @Test(expected = DocumentAlreadyExist.class)
    public void documentAlreadyExist() throws DocumentAlreadyExist {
        Document document = new Document(1, "заработная плата", new BigDecimal("500.05"), 1234567897, 1234567897);
        save(document);
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
}
