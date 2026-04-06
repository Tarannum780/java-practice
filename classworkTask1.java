import java.util.Scanner;
public class classworkTask1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
        int sum = 0;
        int count = 0;

        while (count < 10) {
            try {
                System.out.print("Enter positive integer " + (count + 1) + ": ");
                int num = input.nextInt();

                if (num < 0) {
                    throw new Exception("Input positive integer only");
                }

                sum += num;
                count++;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("The total sum is: " + sum);
        input.close();
		

	}

}
