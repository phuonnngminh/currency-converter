
import java.util.*;

class ProductInventoryManagement {

    static class Product {

        private String name;
        private double price;
        private int quantity;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    List<Product> products = new ArrayList<Product>();

    // Calculate the total inventory value  
    public double caculateTotalInventoryValue() {
        double totalInventoryValue = 0.0;
        for (Product product : products) {
            totalInventoryValue += product.getPrice() * product.getQuantity();
        }
        return totalInventoryValue;
    }

    // Find the most expensive product
    public String findTheMostExpensiveProduct() {
        Product mostExpensiveProduct = products.get(0);
        for (Product product : products) {
            if (product.getPrice() > mostExpensiveProduct.getPrice()) {
                mostExpensiveProduct = product;
            }
        }
        return mostExpensiveProduct.getName();
    }

    // Check if a product named "Headphones" is in stock
    public boolean isProductInStock(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    // Sort products in ascending/descending order with options like by price, quantity
    public List<Product> sort(boolean isAscending, boolean isSortByPrice) {
        List<Product> sortedProducts = new ArrayList<Product>(products);
        if (isSortByPrice) {
            if (isAscending) {
                sortedProducts.sort(Comparator.comparing(Product::getPrice));
            } else {
                sortedProducts.sort(Comparator.comparing(Product::getPrice).reversed());
            }
        } else {
            if (isAscending) {
                sortedProducts.sort(Comparator.comparing(Product::getQuantity));
            } else {
                sortedProducts.sort(Comparator.comparing(Product::getQuantity).reversed());
            }
        }
        return sortedProducts;
    }

    public static void main(String[] args) {

        ProductInventoryManagement productInventoryManagement = new ProductInventoryManagement();

        // Add some products to the inventory  
        productInventoryManagement.products.add(new Product("Laptop", 999.99, 5));
        productInventoryManagement.products.add(new Product("Smartphone", 499.99, 10));
        productInventoryManagement.products.add(new Product("Tablet", 299.99, 0));
        productInventoryManagement.products.add(new Product("Smartwatch", 199.99, 3));

        System.out.println("Product List: \n");
        for (Product product : productInventoryManagement.products) {
            System.out.println(product.getName() + ": "
                    + "price " + product.getPrice() + "," + " "
                    + "quantity " + product.getQuantity());
        }
        System.out.print("\n");

        final String PRODUCT_NAME = "Headphones";

        double totalInventoryValue = productInventoryManagement.caculateTotalInventoryValue();
        String mostExpensiveProduct = productInventoryManagement.findTheMostExpensiveProduct();
        boolean isProductInStock = productInventoryManagement.isProductInStock(PRODUCT_NAME);
        List<Product> sortProductsAscendingByPrice = productInventoryManagement.sort(true, true);
        List<Product> sortProductsAscendingByQuantity = productInventoryManagement.sort(true, false);
        List<Product> sortProductsDescendingByPrice = productInventoryManagement.sort(false, true);
        List<Product> sortProductsDescendingByQuantity = productInventoryManagement.sort(false, false);

        // Output the total inventory value, the most expensive product, and if a product named "Headphones" is in stock
        System.out.print("Total Inventory Value: ");
        System.out.printf("%,.2f\n\n", totalInventoryValue);
        System.out.print("Most Expensive Product: ");
        System.out.println(mostExpensiveProduct+ "\n");
        System.out.print("Is Headphones In Stock: ");
        System.out.println(isProductInStock + "\n");

        // Output the sorted products
        System.out.print("Sort Ascending by Price: \n");
        for (Product productToSort : sortProductsAscendingByPrice) {
            System.out.println(productToSort.getName() + " " + "price: " + productToSort.getPrice() + ", " + "quantity: " + productToSort.getQuantity());
        }
        System.out.print("\n");

        System.out.print("Sort Ascending by Quantity: \n");
        for (Product productToSort : sortProductsAscendingByQuantity) {
            System.out.println(productToSort.getName() + " " + "price: " + productToSort.getPrice() + ", " + "quantity: " + productToSort.getQuantity());
        }
        System.out.print("\n");

        System.out.print("Sort Descending By Price: \n");
        for (Product productToSort : sortProductsDescendingByPrice) {
            System.out.println(productToSort.getName() + " " + "price: " + productToSort.getPrice() + ", " + "quantity: " + productToSort.getQuantity());
        }
        System.out.print("\n");

        System.out.println("Sort Descending by Quantity: ");
        for (Product productToSort : sortProductsDescendingByQuantity) {
            System.out.println(productToSort.getName() + " " + "price: " + productToSort.getPrice() + ", " + "quantity: " + productToSort.getQuantity());
        }
        System.out.print("\n");
    }
}
