import java.util.Scanner;

public class penjumlahan {
    public static void main(String[] args) {
        int x, y, z;
        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan nilai x\n=> ");
        x = scan.nextInt();
        System.out.print("Masukkan nilai y\n=> ");
        y = scan.nextInt();
        System.out.print("Masukkan nilai z\n=> ");
        z = scan.nextInt();

        int hasil = x+y-z;

        System.out.println(hasil);

    }
}
