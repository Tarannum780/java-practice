import java.util.Scanner;
public class classworkTask2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		int[] a = new int[100];
        Scanner input = new Scanner(System.in);

        
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 10000);
        }

        try {
            System.out.print("Enter an index to access (0-99): ");
            int index = input.nextInt();

            
            System.out.println("Value at index " + index + " is: " + a[index]);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: The index is out of array size.");
        } catch (Exception e) {
            System.out.println("Error: Invalid input entered.");
        }

        input.close();
	}

}
