import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Siakad {

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

        if (jumlahData > 0) {
            System.out.println("Berikut data Anda");
            int i = 0;
            while (i < jumlahData) {
                System.out.println(mahasiswa[i].getNim() + " " + mahasiswa[i].getNama());
                i++;
            }
        } else {
            System.out.println("Tidak ada data\nSilakan tambah data terlebih dahulu");
        }
    }

    public static void urutkanData() {

        if (jumlahData > 0) {
            Scanner scan = new Scanner(System.in);
            int menu;


            System.out.println("Metode Pengurutan");
            System.out.println("1. Exchange Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Quick Sort");
            System.out.println("4. Insertion Sort");
            System.out.println("5. Bubble Sort");
            System.out.println("6. Shell Sort");
            System.out.println("7. Binary Insertion Sort");
            System.out.print("Pilih Menu\n=> ");
            menu = scan.nextInt();

            //menu untuk memilih metode pengurutan
            switch (menu) {
                case 1: {
                    exchangeSort();
                    break;
                }
                case 2: {
                    selectionSort();
                    break;
                }
                case 3: {
                    quickSort(mahasiswa, 0, jumlahData - 1);
                }
                case 4: {
                    insertionSort();
                    break;
                }
                case 5: {
                    bubbleSort();
                    break;
                }
                case 6: {
                    shellSort();
                    break;
                }
                case 7: {
                    bInsertionSort();
                    break;
                }
            }
        } else {
            System.out.println("Tidak ada data\nSilakan tambah data terlebih dahulu");
        }
    }

    public static void exchangeSort() {
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

    public static void selectionSort() {
        for (int x = 0; x < jumlahData; x++) {
            // Mencari nilai terkecil
            int minInd = x;
            for (int y = x + 1; y < jumlahData; y ++) {
                if (mahasiswa[x].getNim().compareTo(mahasiswa[y].getNim()) >= 1) {
                    minInd = y;
                }
            }
            // Menukar nilai terkecil dengan nilai pertama pada urutan
            Mahasiswa temp = mahasiswa[x];
            mahasiswa[x] = mahasiswa[minInd];
            mahasiswa[minInd] = temp;
        }
    }

    public static void quickSort(Mahasiswa[] data, int left, int right) {

        if (left < right) {
            int pivotInd = partisi(data, left, right);
            quickSort(data, left, pivotInd-1);
            quickSort(data, pivotInd+1, right);
        }
    }

    public static int partisi(Mahasiswa[] data, int left, int right) {
        Mahasiswa pivot = data [right];
        int x = left-1;

        for (int y = left; y < right; y++) {
            if (mahasiswa[y].getNim().compareTo(mahasiswa[y].getNim()) < 0){
                x++;
                Mahasiswa temp = data[y];
                data[y] = data[x];
                data[x] = temp;
            }
        }

        Mahasiswa temp = data[x+1];
        data[x+1] = data[right];
        data[right] = temp;

        return x + 1;
    }

    public static void insertionSort() {
        // perulangan untuk setiap nilai dalam array
        for (int x = 1; x < jumlahData; x++) {
            Mahasiswa current = mahasiswa[x];
            int y = x - 1;
            // mencari posisi yang tepat
            while (y >= 0 && mahasiswa[y].getNim().compareTo(current.getNim()) > 0) {
                mahasiswa[y+1] = mahasiswa[y];
                y--;
            }
            // menempatkan nilai saat ini ke posisi yang tepat
            mahasiswa[y+1] = current;
        }
    }

    public static void bubbleSort() {
        // perulangan setiap nilai
        for (int x = 0; x < jumlahData; x++) {
            for (int y = 0; y < jumlahData - x - 1; y++) {
                // pertukaran posisi
                if (mahasiswa[y].getNim().compareTo(mahasiswa[y+1].getNim()) > 0) {
                    Mahasiswa temp = mahasiswa[y];
                    mahasiswa[y] = mahasiswa[y+1];
                    mahasiswa[y+1] = temp;
                }
            }
        }
    }

    public static void shellSort() {
        // menentukan jarak antar elemen yang dibandingkan
        int gap = jumlahData/2;
        while (gap > 0) {
            for (int x = gap; x < jumlahData; x++) {
                Mahasiswa current = mahasiswa[x];
                int y = x - gap;

                // mencari posisi yang tepat untuk elemen saat ini
                while (y >= 0 && mahasiswa[y].getNim().compareTo(current.getNim()) > 0) {
                    mahasiswa[y+gap] = mahasiswa[y];
                    y -= gap;
                }
                // menempatkan elemen pada posisi yang tepat
                mahasiswa[y+gap] = current;
            }
            // mengurangi gap pada setiap iterasi
            gap /= 2;
        }
    }

    public static void bInsertionSort() {
        // perulangan setiap elemen pada array
        for (int x = 1; x < jumlahData; x++) {
            Mahasiswa current = mahasiswa[x]; // elemen saat ini
            int left = 0;
            int right = x - 1;
            // mencari posisi yang tepat dengan binary search untuk elemen saat ini
            while (left <= right) {
                int mid = (left + right)/2;
                if (mahasiswa[mid].getNim().compareTo(current.getNim()) > 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // menyisipkan elemen saat ini ke posisi yang tepat
            for (int y = x - 1; y >= left; y-- ) {
                mahasiswa[y+1] = mahasiswa[y];
            }
            mahasiswa[left] = current;
        }
    }

    public static void cariData() {
        Scanner scan = new Scanner(System.in);
        int menu;

        System.out.println("Pilih metode pencarian");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        menu = scan.nextInt();
        switch (menu) {
            case 1:
                linearSearch();
                break;
            case 2:
                binarySearch();
                break;
        }
    }

    public static void linearSearch() {
        Scanner scan = new Scanner(System.in);
        String cari = null;
        System.out.println("Masukkan nama mahasiswa yang ingin Anda cari");
        System.out.print("=> ");
        cari = scan.nextLine();

        // perulangan untuk elemen pada array
        for (int x = 0; x < jumlahData; x++) {
            // mecocokkan elemen dengan data yang diinput
            if (mahasiswa[x].getNama().compareTo(cari) == 0) {
                System.out.println("Data ditemukan.");
                System.out.println("Nama: " + mahasiswa[x].getNama() + " NIM: " + mahasiswa[x].getNim());
            } else {
                System.out.println("Data tidak ditemukan.");
            }
        }
    }

    public static void binarySearch() {
        Scanner scan = new Scanner(System.in);
        String cari = null;
        System.out.println("Masukkan nama mahasiswa yang ingin Anda cari");
        System.out.print("=> ");
        cari = scan.nextLine();

        // mengurutkan nama
        urutNama();

        // proses binary search
        int left = 0;
        int right = jumlahData-1;
        int x = 0;
        boolean ditemukan = false;
        String nama = null, nim = null;
        while (left <= right) {
            int mid = (left + right)/2;
            if (mahasiswa[mid].getNama().compareTo(cari)==0) {
                ditemukan = true;
                break;
            } else if (mahasiswa[mid].getNama().compareTo(cari) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            x++;
        }
        // tampil hasil pencarian
        if (ditemukan) {
            System.out.println("Data ditemukan.");
            System.out.println("Nama: " + mahasiswa[x].getNama() + " NIM: " + mahasiswa[x].getNim());
        } else {
            System.out.println("Data tidak ditemukan.");
        }
        bubbleSort();
    }

    public static void urutNama() {
        // perulangan setiap nilai
        for (int x = 0; x < jumlahData; x++) {
            for (int y = 0; y < jumlahData - x - 1; y++) {
                // pertukaran posisi
                if (mahasiswa[y].getNama().compareTo(mahasiswa[y+1].getNama()) > 0) {
                    Mahasiswa temp = mahasiswa[y];
                    mahasiswa[y] = mahasiswa[y+1];
                    mahasiswa[y+1] = temp;
                }
            }
        }
    }

    public static void hapusData() {
        Scanner scan = new Scanner(System.in);
        // memilih nim atau nama
        System.out.println("Hapus berdasar nama atau NIM?");
        System.out.print("=> ");
        String keyword = scan.nextLine().toLowerCase(Locale.ROOT);

        if (keyword.equals("nama")) {
            System.out.println("Masukkan nama");
            System.out.print("=> ");
            String hapusNama = scan.nextLine();
            for (int x = 0; x < jumlahData; x++) {
                if (mahasiswa[x].getNama().equalsIgnoreCase(hapusNama)) {
                    mahasiswa[x] = mahasiswa[jumlahData - 1];
                    mahasiswa[jumlahData - 1] = null;
                    jumlahData -= 1;
                } else {
                    System.out.println("Data tidak ditemukan.");
                }
            }
        } else if (keyword.equals("nim")) {
            System.out.println("Masukkan NIM");
            System.out.print("=> ");
            String hapusNIM = scan.nextLine();
            for (int x = 0; x < jumlahData; x++) {
                if (mahasiswa[x].getNim().equalsIgnoreCase(hapusNIM)) {
                    mahasiswa[x] = mahasiswa[jumlahData - 1];
                    mahasiswa[jumlahData - 1] = null;
                    jumlahData -= 1;
                } else {
                    System.out.println("Data tidak ditemukan.");
                }
            }
        } else {
            System.out.println("Hanya nama atau NIM.");
            hapusData();
        }
    }

    public static void editData() {
        Scanner scan = new Scanner(System.in);
        // memilih nim atau nama
        System.out.println("Edit berdasar nama atau NIM?");
        System.out.print("=> ");
        String keyword = scan.nextLine().toLowerCase(Locale.ROOT);

        if (keyword.equals("nama")) {
            System.out.println("Masukkan nama");
            System.out.print("=> ");
            String editNama = scan.nextLine();
            for (int x = 0; x < jumlahData; x++) {
                if (mahasiswa[x].getNama().equals(editNama)) {
                    System.out.println("Nama yang lama.");
                    System.out.println(mahasiswa[x].getNama());
                    System.out.println("Masukkan nama yang baru.");
                    System.out.print("=> ");
                    String namaBaru = scan.nextLine();
                    mahasiswa[x].setNama(namaBaru);
                    System.out.println("NIM yang lama.");
                    System.out.println(mahasiswa[x].getNim());
                    System.out.println("Masukkan NIM yang baru");
                    String nimBaru = scan.nextLine();
                    mahasiswa[x].setNim(nimBaru);
                } else {
                    System.out.println("Data tidak ditemukan.");
                }
            }
        } else if (keyword.equals("nim")) {
            System.out.println("Masukkan NIM");
            System.out.print("=> ");
            String editNIM = scan.nextLine();
            for (int x = 0; x < jumlahData; x++) {
                if (mahasiswa[x].getNama().equals(editNIM)) {
                    System.out.println("Masukkan nama yang baru.");
                    System.out.print("=> ");
                    String namaBaru = scan.nextLine();
                    mahasiswa[x].setNama(namaBaru);
                    System.out.println("Masukkan nim yang baru");
                    String nimBaru = scan.nextLine();
                    mahasiswa[x].setNim(nimBaru);
                } else {
                    System.out.println("Data tidak ditemukan.");
                }
            }
        } else {
            System.out.println("Hanya nama atau NIM.");
            editData();
        }
    }

    public static void UAS() {
        if (jumlahData == 0) {
            System.out.println("Tidak ada data\nSilakan tambah data terlebih dahulu");
        } else {
            int jarak = jumlahData,
                    susut = 13,
                    urut = 0;

            while (urut == 0) {
                jarak = (jarak*10)/susut;
                if (jarak <= 1) {
                    jarak = 1;
                    urut = 1;
                }
                for (int i = 0; i + jarak < jumlahData; i++) {
                    if (mahasiswa[i].getNim().compareTo(mahasiswa[i+jarak].getNim()) > 0) {
                        Mahasiswa temp = mahasiswa[i];
                        mahasiswa[i] = mahasiswa[i+jarak];
                        mahasiswa[i+jarak] = temp;
                        urut = 0;
                    }
                }
            }
            System.out.println("Data telah diurutkan\nSilakan tampilkan data");
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
            System.out.println("4. Cari Data");
            System.out.println("5. Hapus Data");
            System.out.println("6. Edit Data");
            System.out.println("7. UAS");
            System.out.println("8. Keluar");
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
                    System.out.println("Data telah diurutkan.");
                    break;
                case 4:
                    cariData();
                    break;
                case 5:
                    hapusData();
                    break;
                case 6:
                    editData();
                    break;
                case 7:
                    UAS();
                    break;
                case 8:
                    System.out.println("Selesai");
                    System.exit(0);
            }
        } while (true);
    }
}
