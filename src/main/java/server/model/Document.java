package server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(schema = "MCS", name = "DOCUMENT")
public class Document {
    @Id
    @NotNull
    private Integer id;

    @Column(name = "DESTINATION", length = 255)
    private String destination;

    @Column(name = "AMOUNT")
    @NotNull
    private BigDecimal amount;

    @Column(name = "BILL_WRITE")
    @Size(min = 10, max = 10, message = "Wrong length field!")
    private Integer billWrite;

    @Column(name = "BILL_REMOVE")
    @Size(min = 10, max = 10, message = "Wrong length field!")
    private Integer billRemove;

    public Document() {
    }

    public Document(@NotNull Integer id, String destination, @NotNull BigDecimal amount,
                    @Size(min = 10, max = 10, message = "Wrong length field!") Integer billWrite,
                    @Size(min = 10, max = 10, message = "Wrong length field!") Integer billRemove) {
        this.id = id;
        this.destination = destination;
        this.amount = amount;
        this.billWrite = billWrite;
        this.billRemove = billRemove;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getBillWrite() {
        return billWrite;
    }

    public void setBillWrite(Integer billWrite) {
        this.billWrite = billWrite;
    }

    public Integer getBillRemove() {
        return billRemove;
    }

    public void setBillRemove(Integer billRemove) {
        this.billRemove = billRemove;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(id, document.id) &&
                Objects.equals(destination, document.destination) &&
                Objects.equals(amount, document.amount) &&
                Objects.equals(billWrite, document.billWrite) &&
                Objects.equals(billRemove, document.billRemove);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, destination, amount, billWrite, billRemove);
    }
}
