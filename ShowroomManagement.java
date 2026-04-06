import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;



class UnauthorizedModelException extends Exception {
	
 private String message;
 
 public UnauthorizedModelException(String message) { 
	 this.message = message;
	          }
 @Override
 public String toString() { 
	 return "UnauthorizedModelException: " + message;
	 }
}


class Showroom {
    private String name;
    private String location;
    private double rent; 

    public Showroom() {
    	
    }
    public Showroom(String name, String location, double rent) {
        this.name = name;
        this.location = location;
        this.rent = rent;
    }

    public String getName() { 
    	return name; 
    	   }
    public String getLocation() { 
    	return location;
    	     }
    public double getRent() { 
    	return rent;
    	          }

    public double calculateYearlyRent() {
        return rent * 12;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Yearly Rent: " + calculateYearlyRent());
    }
}


class AutomobileShowroom extends Showroom {
    private String carBrand;
    private ArrayList<String> carModels;

    public AutomobileShowroom(String name, String location, double rent, String carBrand) {
        super(name, location, rent);
        this.carBrand = carBrand;
        this.carModels = new ArrayList<>();
    }

    public String getCarBrand() { 
    	return carBrand;
    	     }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
        this.carModels.clear(); 
    }

    public void addModel(String model) {
        if (!carModels.contains(model)) {
            carModels.add(model);
        }
    }

    @Override
    public double calculateYearlyRent() {
        
        return super.calculateYearlyRent() + (carModels.size() * 500);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Car Brand: " + carBrand);
        System.out.println("Models: " + carModels);
    }
}
public class ShowroomManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

        
        String[] toyota = {"2024 Camry", "2024 Corolla", "2024 GR Supra", "2023 Prius", "2023 GR86", "2023 Mirai"};
        String[] ford = {"2023 Bronco", "2023 Bronco Sport", "2024 Expedition", "2024 Escape"};
        String[] mercedes = {"E-Class Coupe", "EQS Sedan", "GLE Coupe", "C-Class Cabriolet"};

        
        AutomobileShowroom myAuto = new AutomobileShowroom("Grand Wheels", "Sector 7", 4000.0, "Toyota");

        System.out.println("Welcome to " + myAuto.getName() + " (" + myAuto.getCarBrand() + ")");

        int count = 0;
        while (count < 3) {
            System.out.print("Enter model name to add: ");
            String inputModel = sc.nextLine();

            try {
               
                boolean isAuthorized = false;
                for (String m : toyota) { 
                    if (m.equalsIgnoreCase(inputModel)) {
                        isAuthorized = true;
                        break;
                    }
                }

                if (isAuthorized) {
                    myAuto.addModel(inputModel);
                    System.out.println("Success: Added " + inputModel);
                    count++;
                } else {
                    throw new UnauthorizedModelException("Model '" + inputModel + "' is not authorized for Toyota.");
                }

            } catch (UnauthorizedModelException e) {
                System.out.println(e.toString());
            }
        }

        
        System.out.println("\n Final Showroom Information");
        myAuto.displayInfo();
        
        sc.close();

	}

}
