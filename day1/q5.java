import java.util.Scanner;

public class q5 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        int mid = (n + 1) / 2;
        
        for (int i = 1; i <= n; i++) {
            if (i < mid) {
                System.out.print((mid - i) + " "); // Left decreasing sequence
            } else if (i == mid) {
                System.out.print(mid + " "); // Print mid
            } else {
                System.out.print((n - (i - 1 - mid)) + " "); // Right decreasing sequence
            }
        }

        scanner.close();
    }
}
