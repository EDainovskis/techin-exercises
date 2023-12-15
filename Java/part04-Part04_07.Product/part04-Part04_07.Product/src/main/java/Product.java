public class Product {


    private String initialName;
    private double initialPrice;
    private int initialQuantity;


    public Product(String name, double price, int quantity) {
        this.initialName = name;
        this.initialPrice = price;
        this.initialQuantity = quantity;

    }

    public void printProduct() {
        System.out.println("Name: " + initialName);
        System.out.println("Price: " + initialPrice);
        System.out.println("Quantity: " + initialQuantity);
    }


}
