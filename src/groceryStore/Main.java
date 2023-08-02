package groceryStore;
import groceryStore.model.Bill;
import groceryStore.model.Category;
import groceryStore.model.OrderItem;
import groceryStore.model.Product;
import groceryStore.service.*;
import java.time.LocalDate;
import java.util.*;
public class Main {
    static Common   common = new Common();
    static CategoryService categoryService = new CategoryService();
    static ProductService productService = new ProductService();
    static BillService billService = new BillService();
    static List<Product> listProduct = new ArrayList<>();
    static List<Category> listCategory = new ArrayList<>();
    static List<Bill> listBill = new ArrayList<>();
    static List<OrderItem> listOrderItems = new ArrayList<>();
    public static void main(String[] args) {
        Category c1 = new Category("CAT1H2","GAO",2);
        Category c2 = new Category("CAT9H3","LAO",3);
        listCategory.add(c1);
        listCategory.add(c2);

        Product p1 = new Product("PRO2K4","ST14",15.00, LocalDate.now(),"http://school.com","CAT1H2");
        Product p2 = new Product("PRO1J6","J2B",25.00, LocalDate.now(),"http://school.com","CAT9H3");
        listProduct.add(p1);
        listProduct.add(p2);

        while (true) {
            System.out.println("------------------------------------");
            System.out.println("Menu");
            System.out.println("1.Category  2.Product  3.Bill  4.Out");
            System.out.println("Enter your choice menu: ");
            String choiceModel = common.scanner.next();
            if (choiceModel.equals("1")) {
                Boolean exist = categoryService.handleCategory(listCategory);
                if (exist){
                    continue;
                }
            }
            if (choiceModel.equals("2")) {
                Boolean exist = productService.handleProduct(listProduct, listCategory);
                if (exist) {
                    continue;
                }
            }
            if (choiceModel.equals("3")) {
                Boolean exist = billService.handleBill(listProduct, listOrderItems, listBill);
                if (exist) {
                    continue;
                }
            }
            if (choiceModel.equals("4")) {
                System.out.println("-------------End system-------------");
                break;
            }
        }
    }
}