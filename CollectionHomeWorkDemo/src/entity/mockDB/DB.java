package entity.mockDB;

import entity.Invoice;
import entity.Item;
import entity.Warehouse;
import entity.enums.MeasureType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DB {

    private static DB instance = null;

    private List<Invoice> invoices = null;

    private List<Warehouse> warehouses = Arrays.asList(
            new Warehouse(1, "Склад1"),
            new Warehouse(2, "Склад2"),
            new Warehouse(3, "Склад3")
    );

    private Map<Long, String> issuers = Map.of(1l, "Вова", 2l, "Петя", 3l, "Вадим");

    public DB(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public Map<Long, String> getIssuers() {
        return issuers;
    }

    public static DB getInstance() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        List<Item> items = Arrays.asList(
                new Item(1, "Печенье", MeasureType.kg, 10, 100),
                new Item(2, "Лопата", MeasureType.piece, 3, 500),
                new Item(3, "Варенье", MeasureType.tank, 27, 13)
        );
        List<Item> items2 = Arrays.asList(
                new Item(1, "не Печенье", MeasureType.kg, 10, 100),
                new Item(2, "не Лопата", MeasureType.piece, 3, 500),
                new Item(3, "не Варенье", MeasureType.tank, 27, 13)
        );
        if (instance == null) {
            instance = new DB(
                    Arrays.asList(new Invoice(
                            sdf.parse("15.08.2021"),
                            "Петя",
                            "Вове",
                            "Очень важнное основание",
                            "Петя",
                            "Вова",
                            items
                    ), new Invoice(
                            sdf.parse("15.08.2021"),
                            "Петя",
                            "Вове",
                            "Очень важнное основание",
                            "Петя",
                            "Вова",
                            items2
                    ))
            );
            return instance;
        }
        return instance;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }
}
