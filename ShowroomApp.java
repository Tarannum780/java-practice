import java.util.ArrayList;
import java.util.Scanner;


class UnapprovedItemException extends Exception {
    public UnapprovedItemException(String message) {
        super(message);
    }
}


class ShowroomNew {
    String name;
    String location;
    double baseRent;

    public ShowroomNew(String name, String location, double baseRent) {
        this.name = name;
        this.location = location;
        this.baseRent = baseRent;
    }
    
    
    public double calculateYearlyRent() {
        return baseRent;
    }
}



class JewelryShowroom extends ShowroomNew {
    String material;
    ArrayList<String> jewelryItems = new ArrayList<String>();
    String[] authorizedItems = {"Necklaces", "Rings", "Earrings", "Bracelets"};

    public JewelryShowroom(String name, String location, double baseRent, String material) {
        super(name, location, baseRent); 
        this.material = material;
    }
    
    
    public void setMaterial(String material) {
        this.material = material;
        this.jewelryItems.clear(); 
    }
    
    
    public void addItem(String model) throws UnapprovedItemException {
        boolean valid = false;
        for (int i = 0; i < authorizedItems.length; i++) {
            if (authorizedItems[i].equalsIgnoreCase(model)) {
                valid = true;
                break;
            }
        }
        
        
        if (valid == false) {
            throw new UnapprovedItemException("Not an authorized jewelry item");
        }
        
        if (!jewelryItems.contains(model)) {
            jewelryItems.add(model);
        }
    }

    @Override
    public double calculateYearlyRent() {
        return baseRent + (jewelryItems.size() * 250);
    }
    
    
    
    public void displayInfo() {
        System.out.println("Jewelry Showroom: " + name);
        System.out.println("Location: " + location);
        System.out.println("Rent: " + calculateYearlyRent());
        System.out.println("Items: " + jewelryItems);
    }
}


class ElectronicsShowroom extends ShowroomNew {
    String brand;
    ArrayList<String> electronicsItems = new ArrayList<String>();
    String[] authorizedItems = {"Television", "Refrigerator", "Microwave Oven", "Rice Cooker", "Toaster"};

    public ElectronicsShowroom(String name, String location, double baseRent, String brand) {
        super(name, location, baseRent); 
        this.brand = brand;
    }
    
    
    public void setElecBrand(String brand) {
        this.brand = brand;
        this.electronicsItems.clear();
    }
    
    
    public void addItem(String model) throws UnapprovedItemException {
        boolean valid = false;
        for (int i = 0; i < authorizedItems.length; i++) {
            if (authorizedItems[i].equalsIgnoreCase(model)) {
                valid = true;
                break;
            }
        }
        
        
        if (valid == false) {
            throw new UnapprovedItemException("Not an authorized electronics item");
        }

        if (!electronicsItems.contains(model)) {
            electronicsItems.add(model);
        }
    }

    @Override
    public double calculateYearlyRent() {
        return baseRent + (electronicsItems.size() * 750);
    }

    public void displayInfo() {
        System.out.println("Electronics Showroom: " + name);
        System.out.println("Location: " + location);
        System.out.println("Rent: " + calculateYearlyRent());
        System.out.println("Items: " + electronicsItems);
    }
}


public class ShowroomApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner input = new Scanner(System.in);

        JewelryShowroom jShow = new JewelryShowroom("Luxury Gems", "Mall Drive", 5000, "Gold");
        ElectronicsShowroom eShow = new ElectronicsShowroom("Tech World", "Main St", 8000, "Samsung");

        System.out.println("Enter 3 items for Jewelry:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Item " + (i + 1) + ": ");
            try {
                jShow.addItem(input.nextLine());
            } catch (UnapprovedItemException e) {
               
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nEnter 3 items for Electronics:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Item " + (i + 1) + ": ");
            try {
                eShow.addItem(input.nextLine());
            } catch (UnapprovedItemException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nFINAL DETAILS");
        jShow.displayInfo();
        System.out.println();
        eShow.displayInfo();
        
        input.close();

	}

}
