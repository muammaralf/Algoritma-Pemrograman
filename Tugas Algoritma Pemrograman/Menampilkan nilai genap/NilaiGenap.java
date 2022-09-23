import java.util.Scanner;

public class NilaiGenap {
    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan nilai n = ");
        n = scan.nextInt();
        int i = 1;
        while (i <= 2 * n) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
            i = i + 1;
        }
        System.out.println("");
    }
}