import java.util.Scanner;

public class Siakad {

    static Mahasiswa mhsw = new Mahasiswa();
    static Mahasiswa[] mahasiswa = new Mahasiswa[100];
    static int jumlahData = 0;
    static char yn;

    public static void tambahData() {
        while (true) {
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
            System.out.print ("Apakah ingin menambah daata lagi? (y/t) => ");
            yn = scan.next().charAt(0);
            if (yn != 'y') {
                break;
            }
        }
    }

    public static void lihatData() {

        System.out.println("Berikut data Anda");
        int i = 0;
        while (i < jumlahData) {
            System.out.println(mahasiswa[i].getNim()+ " " + mahasiswa[i].getNama());
            i++;
        }
    }

    public static void urutkanData() {

        Scanner scan = new Scanner(System.in);
        int menu;


        System.out.println("Metode Pengurutan");
        System.out.println("1. Exchange Short");
        System.out.print("Pilih Menu\n=> ");
        menu = scan.nextInt();

        //menu untuk memilih metode pengurutan
        switch (menu) {
            case 1: {
                exchangeShort();
                break;
            }
        }
    }

    public static void exchangeShort() {
        for (int x = 0; x < jumlahData-1; x++) {
            for (int y = x + 1; y < jumlahData; y++) {
                if (mahasiswa[x].getNim().compareTo(mahasiswa[y].getNim()) >= 1) {
                    Mahasiswa temp = mahasiswa[x];
                    mahasiswa[x] = mahasiswa[y];
                    mahasiswa[y] = temp;

                }
            }
        }

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menu;

        do {
            System.out.println("Menu Siakad");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Urutkan Data");
            System.out.println("4. Keluar");
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
                    urutkanData();
                    break;
                case 4:
                    System.out.println("Selesai");
                    System.exit(0);
            }
        } while (true);

    }
}
