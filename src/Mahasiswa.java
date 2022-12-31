public class Mahasiswa implements Comparable<Mahasiswa> {
    private String Nama;
    private String NIM;

    public void setNim(String NIM) {
        this.NIM = NIM;
    }

    public String getNim() {
        return this.NIM;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getNama() {
        return this.Nama;
    }

    @Override
    public int compareTo(Mahasiswa o) {
        return this.Nama.compareTo(o.getNama());
    }
}
