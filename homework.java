import java.util.Scanner;
public class homework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

        System.out.println("Task 1: (Evens)");
        handleEvenIntegers(sc);

        System.out.println("\nTask 2: (Vowels)");
        handleVowels(sc);

        System.out.println("\nTask 3: (Array Error)");
        handleArrayBounds();

        sc.close();

	}
	
   
	public static void handleEvenIntegers(Scanner sc) {
        int[] evens = new int[5];
        int sum = 0;
        int maxSquare = 0;
        int i = 0;

        while (i < 5) {
            try {
                System.out.print("Enter even number for index " + i + ": ");
                int val = sc.nextInt(); 

                if (val % 2 != 0) {
                    throw new Exception("Even integers only");
                }

                evens[i] = val;
                sum = sum + val;
                int sq = val * val;
                if (sq > maxSquare) {
                    maxSquare = sq;
                }
                
                i++; 
            } catch (Exception e) {
                System.out.println(e.getMessage());
                sc.nextLine(); 
            }
        }
        System.out.println("Total Sum: " + sum);
        System.out.println("Max Square: " + maxSquare);
    }

    public static void handleVowels(Scanner sc) {
        char[] vowels = new char[10];
        int i = 0;
        sc.nextLine(); 
        while (i < 10) {
            try {
                System.out.print("Enter vowel " + (i + 1) + ": ");
                String input = sc.nextLine().toLowerCase();
                
                if (input.length() == 1) {
                    char c = input.charAt(0);
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                        vowels[i] = c;
                        i++;
                    } else {
                        throw new Exception("Vowels Only");
                    }
                } else {
                    throw new Exception("Vowels Only");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        System.out.print("The vowels are: ");
        for (int j = 0; j < vowels.length; j++) {
            System.out.print(vowels[j] + " ");
        }
        System.out.println();
    }

    public static void handleArrayBounds() {
        int[] arr = new int[20];
       
        for (int i = 0; i < 20; i++) {
            arr[i] = i + 1;
        }

        try {
            
            int val = arr[24]; 
            System.out.println(val);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("This is an array of size 20!");
        }
    }
   
   
}
