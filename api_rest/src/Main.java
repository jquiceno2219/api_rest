import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import domain.enums.*;
import domain.models.*;

public class Main {
    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<Customer>();

        Customer customer1 = new Customer(1, "Juan", CustomerTier.T1);
        Customer customer2 = new Customer(2, "Pepita", CustomerTier.T2);

        customers.add(customer1);
        customers.add(customer2);
        customers.toString();

        List<Product> products = new ArrayList<Product>();

        Product product1 = new Product(1, "Libro 1", CategoryType.BOOKS, 1100.00);
        Product product2 = new Product(2, "Max Steel", CategoryType.TOYS, 22000.00);
        Product product3 = new Product(3, "Libro 2", CategoryType.BOOKS, 22000.00);
        Product product4 = new Product(3, "Baby 1", CategoryType.BABY, 22000.00);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.toString();

        Scanner scanner = new Scanner(System.in);
        int opt = 0;

        while (opt != 11) {
            System.out.print
                    ("Ingrese su elección: \n");
            System.out.println
                    ("1. Obtener una lista de productos pertenecientes a la categoría “Libros” con precio > 100");
            System.out.println
                    ("2. Obtener una lista de pedidos con productos pertenecientes a la categoría “Bebé”");
            System.out.println
                    ("3. Obtenga una lista de productos con categoría= \"Juguetes\" y luego aplique un " +
                    "10% de descuento");
            System.out.println
                    ("4. Obtenga una lista de productos pedidos por el cliente del nivel 2 entre el 01" +
                    "de febrero de 2021 y el 01 de abril de 2021");

            opt = scanner.nextInt();

            switch (opt) {
                case 1:
                    listByPrice(products);
                    break;

                case 2:
                    filterByBaby(products);
                    break;

                case 3:
                    toysTenDiscountFilter(products);
                    break;

                case 4:


                    /* TEST DE QUE Cx funciona
                    System.out.println(customers);
                    break;
                    */

                case 11:
                    System.out.println("Exiting program.");
                    break;
            }
        }
    }

    //METODO UNO
    private static List<Product> listByPrice(List<Product> products) {
        String category ="Libros";
        List<Product> filteredProducts =  products.stream()
                .filter(e->e.getCategory().equals(CategoryType.fromValue(category)))
                .filter(e->e.getPrice()>100)
                .toList();
            for (Product product : filteredProducts) {
                System.out.println(product);
                }
        return filteredProducts;
    }

    //MÉTODO DOS
    private static List<Product> filterByBaby(List<Product> products) {
        String category ="Bebé";
        List<Product> filteredByBaby =  products.stream()
                .filter(e->e.getCategory().equals(CategoryType.fromValue(category)))
                .toList();
        for (Product product : filteredByBaby) {
            System.out.println(product);
        }

        return filteredByBaby;

    }

    //MÉTODO TRES
    private static List<Product> toysTenDiscountFilter(List<Product> products) {
        String category ="Juguetes";
        List<Product> filteredByToys =  products.stream()
                .filter(e->e.getCategory().equals(CategoryType.fromValue(category)))
                .map(e -> new Product(e.getId(), e.getName(), e.getCategory(), applyToyDiscount(e.getPrice())))
                .collect(Collectors.toList());
        for (Product product : filteredByToys) {
            System.out.println(product);
        }
        return filteredByToys;
    }

    //Para aplicar el descuento al juguete de 0.1 (duh), usado en el map arriba
    private static double applyToyDiscount(double price){
        double discount = 0.1;
        return price - (price * discount);
    }

    //MÉTODO CUATROOOO nombres para método cuatro :> nideabro
    //private static filterByDate&Tier


}


//si el ej dice filtre o list .filter
//si el ej dice aplique o transforme, use .map