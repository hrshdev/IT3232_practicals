import java.util.Scanner;

public class q3 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = scanner.nextInt();
    
        System.out.print("Given number in reverse : ");
    
        for(int i=n; i>0; i=i/10) {
            System.out.print(i%10);
        }
    
        System.out.println();
    
        scanner.close();
    }
}