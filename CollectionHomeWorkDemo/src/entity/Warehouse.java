package entity;

import java.util.ArrayList;
import java.util.List;

public class Warehouse extends AbstractEntity {

    private String address;

    private List<Item> items = new ArrayList();

    private List<Invoice> invoices;

    public Warehouse() {
        super();
    }

    public Warehouse(long id, String address) {
        setId(id);
        this.address = address;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "address='" + address + '\'' +
                ", items=" + items +
                '}';
    }
}
