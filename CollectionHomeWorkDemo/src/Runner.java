import entity.Invoice;
import entity.Warehouse;
import entity.mockDB.DB;
import service.WarehouseService;

import java.text.ParseException;

public class Runner {

    private static WarehouseService warehouseService = new WarehouseService();


    public static void main(String[] args) throws Exception {
        DB db = DB.getInstance();
        Warehouse wh0 = db.getInstance().getWarehouses().get(0);
        Warehouse wh1 = db.getInstance().getWarehouses().get(1);
        Invoice in0 = db.getInvoices().get(0);
        Invoice in1 = db.getInvoices().get(1);
        warehouseService.runInvoice(wh0, in0);
        warehouseService.runInvoice(wh1, in1);
        warehouseService.printItems(wh0);
        warehouseService.printItems(wh1);
    }

}
