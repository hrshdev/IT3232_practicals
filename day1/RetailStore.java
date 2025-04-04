import java.util.Scanner;

abstract class Product {
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

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract void display();
}

class Fruit extends Product {
    public Fruit(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public void display() {
        System.out.println("Fruit - Name: " + getName() + ", Price: $" + getPrice() + ", Qty: " + getQuantity());
    }
}

class Vegetable extends Product {
    public Vegetable(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public void display() {
        System.out.println("Vegetable - Name: " + getName() + ", Price: $" + getPrice() + ", Qty: " + getQuantity());
    }
}

class Grocery extends Product {
    public Grocery(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public void display() {
        System.out.println("Grocery - Name: " + getName() + ", Price: $" + getPrice() + ", Qty: " + getQuantity());
    }
}

// Main Store Class
public class RetailStore {
    static Product[] inventory = new Product[100];
    static int count = 0;
    static Scanner scanner = new Scanner(System.in);

    // Preload some grocery products
    static void preloadProducts() {
        inventory[count++] = new Fruit("Apple", 3.50, 20);
        inventory[count++] = new Fruit("Banana", 1.20, 50);
        inventory[count++] = new Vegetable("Carrot", 2.10, 40);
        inventory[count++] = new Vegetable("Tomato", 2.50, 30);
        inventory[count++] = new Grocery("Rice", 40.00, 50);
        inventory[count++] = new Grocery("Sugar", 15.75, 60);
    }

    static void addProduct() {
        if (count >= inventory.length) {
            System.out.println("Inventory is full!");
            return;
        }

        System.out.print("Enter product type (Fruit/Vegetable/Grocery): ");
        String type = scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter quantity: ");
        int qty = scanner.nextInt();
        scanner.nextLine();

        Product p = null;
        switch (type.toLowerCase()) {
            case "fruit" -> p = new Fruit(name, price, qty);
            case "vegetable" -> p = new Vegetable(name, price, qty);
            case "grocery" -> p = new Grocery(name, price, qty);
            default -> {
                System.out.println("Invalid type!");
                return;
            }
        }
        inventory[count++] = p;
        System.out.println("Product added successfully!");
    }

    static void editProduct() {
        System.out.print("Enter product name to edit: ");
        String name = scanner.nextLine();
        for (int i = 0; i < count; i++) {
            if (inventory[i].getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new price: ");
                inventory[i].setPrice(scanner.nextDouble());
                System.out.print("Enter new quantity: ");
                inventory[i].setQuantity(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Product updated!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    static void deleteProduct() {
        System.out.print("Enter product name to delete: ");
        String name = scanner.nextLine();
        for (int i = 0; i < count; i++) {
            if (inventory[i].getName().equalsIgnoreCase(name)) {
                for (int j = i; j < count - 1; j++) {
                    inventory[j] = inventory[j + 1];
                }
                inventory[--count] = null;
                System.out.println("Product deleted!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    static void displayProducts() {
        if (count == 0) {
            System.out.println("No products available.");
        } else {
            for (int i = 0; i < count; i++) {
                inventory[i].display();
            }
        }
    }

    public static void main(String[] args) {
        preloadProducts(); // Add pre-stored groceries

        boolean running = true;
        while (running) {
            System.out.println("\n1. Add Product\n2. Edit Product\n3. Delete Product\n4. Display Products\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> displayProducts();
                case 2 -> addProduct();
                case 3 -> editProduct();
                case 4 -> deleteProduct();
                case 5 -> running = false;
                default -> System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }
}
