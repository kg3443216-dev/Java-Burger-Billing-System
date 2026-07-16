package idea; // Package declaration - classes ko "idea" package ke andar rakhta hai

// Base Burger Class
class Burger {

    String name;          // Burger ka naam store karega
    int basePrice;        // Burger ki original/base price
    boolean hasCheese;    // Cheese add hui hai ya nahi
    boolean hasPatty;     // Extra patty add hui hai ya nahi

    // Constructor - jab Burger object banega tab ye automatically chalega
    Burger(String name, int basePrice) {
        this.name = name;             // Current object ka name set karna
        this.basePrice = basePrice;   // Current object ki base price set karna
        this.hasCheese = false;       // Starting me cheese nahi hogi
        this.hasPatty = false;        // Starting me extra patty nahi hogi
    }

    // Cheese add karne ka method
    public void addCheese() {
        hasCheese = true; // Cheese available mark kar do
    }

    // Patty add karne ka method
    public void addPatty() {
        hasPatty = true; // Patty available mark kar do
    }

    // Final price calculate karne ka method
    public int calculatePrice() {

        int total = basePrice; // Total price base price se start hogi

        // Agar cheese add hai to Rs.30 add karo
        if (hasCheese) {
            total += 30;
        }

        // Agar patty add hai to Rs.50 add karo
        if (hasPatty) {
            total += 50;
        }

        return total; // Final total return karo
    }

    // Bill print karne ka method
    public void printBill() {

        System.out.println("------- Burger Bill -------"); // Heading print

        System.out.println("Burger: " + name); // Burger ka naam print

        System.out.println("Base Price: Rs. " + basePrice); // Base price print

        // Agar cheese add hai to uska charge print karo
        if (hasCheese) {
            System.out.println("Extra Cheese: Rs. 30");
        }

        // Agar patty add hai to uska charge print karo
        if (hasPatty) {
            System.out.println("Extra Patty: Rs. 50");
        }

        System.out.println("---------------------------"); // Line print

        // Total amount print karo
        System.out.println("Total: Rs. " + calculatePrice());
    }
}

// ---------------- Veg Burger ----------------

// VegBurger class Burger ko inherit karti hai
class VegBurger extends Burger {

    // Default constructor
    VegBurger() {

        // Dusre constructor ko call karta hai
        this("Veg Burger", 120);
    }

    // Parameterized constructor
    VegBurger(String name, int price) {

        // Parent class Burger ka constructor call hota hai
        super(name, price);
    }
}

// ---------------- Non-Veg Burger ----------------

// NonVegBurger class Burger ko inherit karti hai
class NonVegBurger extends Burger {

    // Default constructor
    NonVegBurger() {

        // Dusre constructor ko call karta hai
        this("Non-Veg Burger", 180);
    }

    // Parameterized constructor
    NonVegBurger(String name, int price) {

        // Parent constructor call
        super(name, price);
    }
}

// ---------------- Veg Deluxe Burger ----------------

// VegDeluxeBurger class VegBurger ko inherit karti hai
class VegDeluxeBurger extends VegBurger {

    // Default constructor
    VegDeluxeBurger() {

        // Parent constructor call
        super("Veg Deluxe Burger", 220);

        // Deluxe burger me cheese already included hai
        addCheese();

        // Deluxe burger me patty bhi already included hai
        addPatty();
    }
}

// ---------------- Non-Veg Deluxe Burger ----------------

// NonVegDeluxeBurger class NonVegBurger ko inherit karti hai
class NonVegDeluxeBurger extends NonVegBurger {

    // Default constructor
    NonVegDeluxeBurger() {

        // Parent constructor call
        super("Non-Veg Deluxe Burger", 280);

        // Cheese automatically add
        addCheese();

        // Patty automatically add
        addPatty();
    }
}

// ---------------- Main Class ----------------

// Program execution yahi se start hota hai
public class Main {

    // Main method
    public static void main(String[] args) {

        // VegBurger ka object banana
        VegBurger veg = new VegBurger();

        // Cheese add karna
        veg.addCheese();

        // Patty add karna
        veg.addPatty();

        // Veg burger ka bill print karna
        veg.printBill();

        // Blank line print
        System.out.println();

        // NonVegBurger object banana
        NonVegBurger nonVeg = new NonVegBurger();

        // Cheese add karna
        nonVeg.addCheese();

        // Bill print karna
        nonVeg.printBill();

        // Blank line
        System.out.println();

        // Veg Deluxe Burger object banana
        VegDeluxeBurger vegDeluxe = new VegDeluxeBurger();

        // Bill print (Cheese aur Patty pehle se added hain)
        vegDeluxe.printBill();

        // Blank line
        System.out.println();

        // NonVeg Deluxe Burger object banana
        NonVegDeluxeBurger nonVegDeluxe = new NonVegDeluxeBurger();

        // Bill print
        nonVegDeluxe.printBill();
    }
}