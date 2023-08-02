package groceryStore.service;
import groceryStore.model.Bill;
import groceryStore.model.OrderItem;
import groceryStore.model.Product;
import java.util.ArrayList;
import java.util.List;
interface BillServiceInterface {
    OrderItem createOrderItem(List<Product> listProduct, List<OrderItem> listOrderItems, String productId, Integer quantity);
    Boolean handleBill(List<Product> listProduct, List<OrderItem> listOrderItems, List<Bill> listBill);
    Double totalAmount(List<Product> listProduct, List<OrderItem> listOrderItems);
    Bill createBill(List<Bill> listBill, List<Product> listProduct, String id, String customerName, List<OrderItem> listOrderItems);
}
public class BillService implements BillServiceInterface {
    static Common common = new Common();
    static ProductService productService = new ProductService();
    public Boolean handleBill(List<Product> listProduct, List<OrderItem> listOrderItems, List<Bill> listBill) {
        while (true) {
            String prefix = "BIL";
            String id_bill = common.generateRandom(prefix);
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Bill");
            System.out.println("1.Create orderItem  2.View orderItem  3.Create bill  4.View bill  5.Exit");
            System.out.println("Enter your choice order: ");
            String choiceOrder = common.scanner.next();
            if (choiceOrder.equals("1")) {
                System.out.println("------------");
                System.out.println("Create order");
                System.out.println("Enter ID Product: ");
                String id_product = common.scanner.next();
                Product product = productService.findProductById(listProduct, id_product);
                if (product != null) {
                    System.out.println("Enter quantity order: ");
                    Integer quantityOrder = common.checkInteger();
                    OrderItem create = createOrderItem(listProduct, listOrderItems, id_product, quantityOrder);
                    if (create != null){
                        System.out.println("Create orderItem done!!!");
                        continue;
                    }
                }
                System.out.println("Product id not found");
                System.out.println("Create orderItem failed!!!");
                continue;
            }
            if (choiceOrder.equals("2")) {
                System.out.println("----------");
                System.out.println("View order");
                System.out.println(listOrderItems);
                continue;
            }
            if (choiceOrder.equals("3")) {
                System.out.println("-----------");
                System.out.println("Create bill");
                System.out.println("Enter customer name: ");
                common.scanner.nextLine();
                String customerName = common.scanner.nextLine();
                Bill create = createBill(listBill, listProduct, id_bill, customerName, listOrderItems);
                listOrderItems.clear();
                System.out.println(listBill);
                if (create != null){
                    System.out.println("Create bill done!!!");
                    continue;
                }
            }
            if (choiceOrder.equals("4")) {
                System.out.println("---------");
                System.out.println("View bill");
                System.out.println(listBill);
                continue;
            }
            if (choiceOrder.equals("5")) {
                break;
            }
        }
        return true;
    }
    public OrderItem createOrderItem(List<Product> listProduct, List<OrderItem> listOrderItems, String productId, Integer quantity) {
        for ( Product product : listProduct) {
            if (product.getId().equals(productId)) {
                OrderItem orderItem = new OrderItem(productId, quantity);
                listOrderItems.add(orderItem);
                return orderItem;
            }
        }
        return null;
    }
    public Double totalAmount(List<Product> listProduct, List<OrderItem> listOrderItems) {
        Double totalAmount = 0.00;
        for( OrderItem orderItem : listOrderItems) {
            for (Product product : listProduct ){
                if (orderItem.getProductId().equals(product.getId())) {
                    totalAmount = totalAmount + product.getPrice() * orderItem.getQuantity();
                }
            }
        }
        return totalAmount;
    }
    public Bill createBill(List<Bill> listBill, List<Product> listProduct, String id, String customerName, List<OrderItem> listOrderItems) {
        System.out.println("Enter promotion price: ");
        Double promotionPrice = common.checkDouble();
        List<OrderItem> listOrderBill = new ArrayList<>();
        listOrderBill.addAll(listOrderItems);
        Double totalAmount = totalAmount(listProduct, listOrderItems);
        Bill bill = new Bill(id, customerName, listOrderBill, promotionPrice, totalAmount, common.getTime(),null);
        String payment = common.inputPayment();
        if (common.checkPayment(payment)) {
            bill.setPayment(payment);
        }       listBill.add(bill);
        return bill;
    }
}
