import java.util.Scanner;

public class BintangRataKiri {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan nilai n " +
                "\n=> ");
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = n; j > i + 1; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();

        }

    }
}
