import java.util.Scanner;

public class Siakad {

    static Mahasiswa mhsw = new Mahasiswa();
    static Mahasiswa[] mahasiswa = new Mahasiswa[100];
    static int jumlahData = 0;

    public static void tambahData() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Silakan Tambah Data");
        System.out.print("NIM => ");
        String nim = scan.nextLine();
        System.out.print("Nama => ");
        String nama = scan.nextLine();
        mahasiswa[jumlahData] = new Mahasiswa();
        mahasiswa[jumlahData].setNim(nim);
        mahasiswa[jumlahData].setNama(nama);
        jumlahData++;
    }

    public static void lihatData() {

        System.out.println("Berikut data Anda");
        int i = 0;
        while (i < jumlahData) {
            System.out.println(mahasiswa[i].getNim()+ " " + mahasiswa[i].getNama());
            i++;
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menu;

        do {
            System.out.println("Menu Siakad");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Keluar");
            System.out.print("Pilih Menu\n=> ");
            menu = scan.nextInt();
            switch (menu) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    lihatData();
                    break;
                case 3:
                    System.out.println("Selesai");
                    System.exit(0);
            }
        } while (true);

    }
}
