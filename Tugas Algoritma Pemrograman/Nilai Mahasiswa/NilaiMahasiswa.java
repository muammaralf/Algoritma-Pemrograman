import java.util.Scanner;

public class NilaiMahasiswa {
    public static void main(String[] args) {
        int nilai = 55;
        String nama = "Andre";

        Scanner scan = new Scanner(System.in);

        if (nilai > 60) {
            System.out.println(nama+" dinyatakan LULUS");
        } else {
            System.out.println(nama + " dinyatakan TIDAK LULUS");
        }
    }
}
