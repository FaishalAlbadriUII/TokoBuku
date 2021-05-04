package tokobuku;

/**
 *
 * @author Ahmad Faishal Albadri
 * @nim 20523166
 */
public class DataBuku {
    
    private String judulBuku, kodeBuku;
    private int stokBuku, hargaBuku;

    public DataBuku() {
    }

    public DataBuku(String judulBuku, String kodeBuku, int stokBuku, int hargaBuku) {
        this.judulBuku = judulBuku;
        this.kodeBuku = kodeBuku;
        this.stokBuku = stokBuku;
        this.hargaBuku = hargaBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }

    public int getStokBuku() {
        return stokBuku;
    }

    public void setStokBuku(int stokBuku) {
        this.stokBuku = stokBuku;
    }

    public int getHargaBuku() {
        return hargaBuku;
    }

    public void setHargaBuku(int hargaBuku) {
        this.hargaBuku = hargaBuku;
    }

    @Override
    public String toString() {
        return "Kode Buku : " + kodeBuku + ", Judul Buku : " + judulBuku + ", Stok Buku : " + stokBuku + ", Harga Buku : " + hargaBuku;
    }  
}
