import java.util.Scanner;

class Pizza {
    private String size;
    private String type;
    private boolean extraCheese;
    private boolean extraToppings;
    private boolean extraSauce;
    private boolean extraGarlic;
    private int basePrice;
    private int cheesePrice = 50;
    private int toppingsPrice = 70;
    private int saucePrice = 30;
    private int garlicPrice = 40;

    public Pizza(String size, String type) {
        this.size = size;
        this.type = type;
        switch (size.toLowerCase()) {
            case "small":
                this.basePrice = type.equalsIgnoreCase("veg") ? 200 : 250;
                break;
            case "medium":
                this.basePrice = type.equalsIgnoreCase("veg") ? 300 : 350;
                break;
            case "large":
                this.basePrice = type.equalsIgnoreCase("veg") ? 400 : 450;
                break;
            default:
                System.out.println("Invalid size. Setting to Medium by default.");
                this.basePrice = 300;
        }
    }

    public void addExtraCheese() {
        this.extraCheese = true;
    }

    public void addExtraToppings() {
        this.extraToppings = true;
    }
    
    public void addExtraSauce() {
        this.extraSauce = true;
    }
    
    public void addExtraGarlic() {
        this.extraGarlic = true;
    }

    public int calculateTotal() {
        int total = basePrice;
        if (extraCheese) total += cheesePrice;
        if (extraToppings) total += toppingsPrice;
        if (extraSauce) total += saucePrice;
        if (extraGarlic) total += garlicPrice;
        return total;
    }

    public void generateBill() {
        System.out.println("\n--- Pizza Bill ---");
        System.out.println("Size: " + size);
        System.out.println("Type: " + type);
        System.out.println("Base Price: Rs." + basePrice);
        if (extraCheese) System.out.println("Extra Cheese: Rs." + cheesePrice);
        if (extraToppings) System.out.println("Extra Toppings: Rs." + toppingsPrice);
        if (extraSauce) System.out.println("Extra Sauce: Rs." + saucePrice);
        if (extraGarlic) System.out.println("Extra Garlic: Rs." + garlicPrice);
        System.out.println("Total: Rs." + calculateTotal());
        System.out.println("-------------------");
    }
}

public class PizzaBillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Pizza Billing System!");
        System.out.print("Enter pizza size (Small/Medium/Large): ");
        String size = scanner.nextLine();
        
        System.out.print("Enter pizza type (Veg/Non-Veg): ");
        String type = scanner.nextLine();

        Pizza pizza = new Pizza(size, type);

        System.out.print("Do you want extra cheese? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            pizza.addExtraCheese();
        }

        System.out.print("Do you want extra toppings? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            pizza.addExtraToppings();
        }
        
        System.out.print("Do you want extra sauce? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            pizza.addExtraSauce();
        }
        
        System.out.print("Do you want extra garlic? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            pizza.addExtraGarlic();
        }

        pizza.generateBill();
        scanner.close();
    }
}
