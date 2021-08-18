package service;

import entity.Invoice;
import entity.Warehouse;
import entity.mockDB.DB;

import java.text.ParseException;

public class WarehouseService {

    public void printItems(Warehouse warehouse) {
        System.out.println("Предметы на складе по адресу: " + warehouse.getAddress());
        warehouse.getItems().forEach(
                System.out::println
        );
    }

    public void printIssuers() throws ParseException {
        DB.getInstance().getIssuers().forEach(
                (k, v) -> {
                    System.out.printf("Номер поставщика: %d, имя поставщика: %s\n", k, v);
                }
        );
    }

    public Warehouse runInvoice(Warehouse warehouse, Invoice invoice) throws Exception {
        if (!invoice.isDeleted()) {
            invoice.getItems().forEach(item ->
                    warehouse.getItems().add(item)
            );
            invoice.setDeleted(true);
        } else {
            throw new Exception("Накладная уже использована");
        }
        return warehouse;
    }

    /** ДЗ №1 (Товары могут поступать как от внешних поставщиков, так и перемещаться между
     складами компании.):
     *
     * - Создать метод трансферу между складами (на вход приходят склад1, склад2, идПрдметов)
     * - Сгенерировать накладную с предметами для перемещения
     * - Удаляете предметы из склада 1
     * - Вызываете метод runInvoice с созданной накладной для склада 2
     *
     * ДЗ №2:
     * - искать товар на складе по наименованию.
     */
}
