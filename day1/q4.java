public class q4 {
    public static void main(String args[]) {
        System.out.print("Odd numbers between 1 o 20 : ");

        for(int i=1; i<=20; i++) {
            if(i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
    }
}