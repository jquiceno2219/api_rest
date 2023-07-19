import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.enums.CategoryType;
import domain.models.*;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "tu mama", 1);
        Customer customer2 = new Customer(2, "tu papa", 2);

        List<Product> products = new ArrayList<Product>();

        Product product1 = new Product(1, "at", CategoryType.BOOKS, 1100.00);
        Product product2 = new Product(2, "tt", CategoryType.FOOD, 22000.00);


        products.add(product1);
        products.add(product2);
        products.toString();

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 11) {
            System.out.print("Ingrese su elección: \n");
            System.out.println("1. Obtener una lista de productos pertenecientes a la categoría “Libros”" +
                    "con precio > 100");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    System.out.println(listByPrice(products, 100000.00, CategoryType.BOOKS));

                    break;
                case 2:
                    System.out.println("blah");
            }
        }
    }
    public static List<Product> listByPrice(List<Product> products,Double price, CategoryType type){
        return products.stream()
                .filter(p -> p.getPrice()>100)
                .filter(p -> p.getCategory().equals(type))
                .toList();
    }
}


//si el ej dice filtre o list .filter
//si el ej dice aplique o transforme, use .map