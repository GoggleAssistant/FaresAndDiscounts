import java.util.Scanner;

public class FareAndDiscounts {
    // Declare the arrays
    private String[] names;
    private String[] types;
    private double fare;
    private double[] discountedFares;

    public FareAndDiscounts() {
        names = new String[5];
        types = new String[5];
        fare = 60;
        discountedFares = new double[5]; 
    }

    public void getDetails() {
        Scanner detailScanner = new Scanner(System.in);
    
        System.out.print("For types, type in regular, student, or senior.\n");
    
        for (int i = 0; i < names.length; i++) {
            System.out.print("\n");
            System.out.print("Input Passenger " + (i + 1) + ": ");
            names[i] = detailScanner.nextLine();
    
            // Validation loop for passenger type
            String type;
            while (true) {
                System.out.print("Input Passenger " + (i + 1) + " Type: ");
                type = detailScanner.nextLine();
    
                if (type.equalsIgnoreCase("regular") || type.equalsIgnoreCase("student") || type.equalsIgnoreCase("senior")) {
                    types[i] = type;
                    break; // Exit the loop if input is valid
                } else {
                    System.out.println("Invalid type, try again.");
                }
            }
        }
    
        System.out.println("\n\n");
    }
    
    public void calculateDiscountedFares() {
        for (int i = 0; i < types.length; i++) {
            switch (types[i].toLowerCase()) {
                case "student":
                    discountedFares[i] = fare * 0.9; // 10% discount for student
                    break;
                case "senior":
                    discountedFares[i] = fare * 0.8; // 20% discount for senior
                    break;
                default:
                    discountedFares[i] = fare; // No discount for regular
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // Create an instance of the class
        FareAndDiscounts fareAndDiscounts = new FareAndDiscounts();

        // Get details from the user
        fareAndDiscounts.getDetails();

        //calculate discounts
        fareAndDiscounts.calculateDiscountedFares();

        // Print the details of each passenger
        for (int i = 0; i < fareAndDiscounts.names.length; i++) {
            System.out.println("Passenger " + (i + 1) + ": " + fareAndDiscounts.names[i]  + 
                               "\nType: " + fareAndDiscounts.types[i] + 
                               "\nDiscounted Fare: " + fareAndDiscounts.discountedFares[i] + "\n");
        }
    }
}
