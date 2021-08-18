package entity;

import java.util.Date;
import java.util.List;

public class Invoice extends AbstractEntity {

    private Date date;

    private String from;

    private String to;

    private String baseDescription;

    private String issuer;

    private String recipient;

    private boolean deleted = false;

    private List<Item> items;

    public Invoice() {
    }

    public Invoice(Date date, String from, String to, String baseDescription, String issuer, String recipient, List<Item> items) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.baseDescription = baseDescription;
        this.issuer = issuer;
        this.recipient = recipient;
        this.items = items;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBaseDescription() {
        return baseDescription;
    }

    public void setBaseDescription(String baseDescription) {
        this.baseDescription = baseDescription;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "date=" + date +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", baseDescription='" + baseDescription + '\'' +
                ", issuer='" + issuer + '\'' +
                ", recipient='" + recipient + '\'' +
                ", items=" + items +
                '}';
    }
}
