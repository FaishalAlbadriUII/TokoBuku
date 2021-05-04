package tokobuku;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ahmad Faishal Albadri
 * @nim 20523166
 */

public class TokoBuku {
    public static Scanner scannerMenu;
    public static DataBuku dataBuku;
    public static ArrayList<DataBuku> listDataBuku;
    
    public static void main(String[] args) {
        
        int pilihan = 0;
        scannerMenu = new Scanner(System.in);
        listDataBuku = new ArrayList<DataBuku>();
        dataBuku = new DataBuku();
        
        daftarMenu();
        pilihMenu(pilihan);
    }

    private static void daftarMenu() {
        System.out.println(
                "======== Daftar Menu Aplikasi Toko Buku ========" + 
                        "\n1. Isi Data Buku (Khusus Pengelola)" +
                        "\n2. Mencari Data Buku" +
                        "\n3. Update Data Buku (Khusus Pengelola)" +
                        "\n4. Lihat Data Buku" +
                        "\n5. Pembelian Buku (Khusus Pembeli)" +
                        "\n6. Keluar Aplikasi"
                        );
    }

    private static void pilihMenu(int pilihan) {
        System.out.print("\nPilih Berdasarkan Angka : ");
        while (!scannerMenu.hasNextInt()) {
            System.err.println("MASUKKAN ANGKA!!!!");
            scannerMenu.next();
            System.out.print("Pilih Berdasarkan Angka : ");
        }
        pilihan = scannerMenu.nextInt();
        menuSwitch(pilihan);
    }

    private static void menuSwitch(int pilihan) {
        switch(pilihan) {
            case 1 :
                System.out.println("\n");
                createBuku();
                break;
                
            case 2 :
                System.out.println("\n");
                searchBuku();
                break;
            
            case 3 :
                System.out.println("\n");
                updateBuku();
                break;
                            
            case 4 :
                System.out.println("\n");
                getBuku();
                break;  
            
            case 5 :
                System.out.println("\n");
                buyBook();
                break;  
            
            default:
                System.out.println("\nKeluar Dari Aplikasi");
                System.exit(0);
                break;
        }
    }
    
    private static void repeatProgram(int pilihan) {
        System.out.println("");
        daftarMenu();
        pilihMenu(pilihan);
    }

    private static void createBuku() {
        int repeat = 0;
        Scanner scRepeat = new Scanner(System.in);
        System.out.println("======== Halaman Memasukkan Data Buku ========");
        System.out.print("Banyak buku yang di masukkan: ");
        while (!scRepeat.hasNextInt()) {
            System.err.println("MASUKKAN ANGKA!!!!");
            scRepeat.next();
            System.out.print("Banyak buku yang di masukkan: ");
        }
        repeat = scRepeat.nextInt();
        
        for (int i = 0; i < repeat; i++) {
            Scanner scCreateBuku = new Scanner(System.in);
            String kodeBuku, judulBuku;
            int hargaBuku, stokBuku;
            int dataKe = 1 + i;
            System.out.println("\n======== Masukkan Data Buku ke " + dataKe + " ========");
            System.out.print("Input Kode Buku : ");
            kodeBuku = scCreateBuku.nextLine();
            System.out.print("Input Judul Buku : ");
            judulBuku = scCreateBuku.nextLine();
      
            System.out.print("Input Stok Buku: ");
            while (!scCreateBuku.hasNextInt()) {
                System.err.println("MASUKKAN ANGKA!!!!");
                scCreateBuku.next();
                System.out.print("Input Stok Buku: ");
            }
            stokBuku = scCreateBuku.nextInt();
        
            System.out.print("Input Harga Buku: ");
            while (!scCreateBuku.hasNextInt()) {
                System.err.println("MASUKKAN ANGKA!!!!");
                scCreateBuku.next();
                System.out.print("Input Harga Buku: ");
            }
            hargaBuku = scCreateBuku.nextInt();
        
            listDataBuku.add(new DataBuku(judulBuku, kodeBuku, stokBuku, hargaBuku));
        }
        repeatProgram(0);
    }

    private static void searchBuku() {
        String cariKodeBuku;
        boolean dataPencarian = false;
        Scanner scSearchBuku = new Scanner(System.in);
        System.out.println("======== Halaman Mencari Data Buku ========");
        System.out.print("Masukkan Kode Buku : ");
        cariKodeBuku = scSearchBuku.nextLine();
        
        if (listDataBuku.size() > 0) {
            for (int i = 0; i < listDataBuku.size(); i++) {
                if (cariKodeBuku.equals(listDataBuku.get(i).getKodeBuku())) {
                    dataPencarian = true;
                    dataBuku.setJudulBuku(listDataBuku.get(i).getJudulBuku());
                    dataBuku.setKodeBuku(listDataBuku.get(i).getKodeBuku());
                    dataBuku.setStokBuku(listDataBuku.get(i).getStokBuku());
                    dataBuku.setHargaBuku(listDataBuku.get(i).getHargaBuku());
                    System.out.println("Hasil Pencarian = " + dataBuku.toString());
                }
            }
        } else {
            dataPencarian = true;
            System.out.println("Database Buku Kosong");
        }
        
        if (dataPencarian == false) {
            System.out.println("Data Buku Tidak Ditemukan");
        } 
        repeatProgram(0);
    }

    private static void getBuku() {
        System.out.println("======== Halaman Data Buku ========");
        if (listDataBuku.size() > 0) {
            for (int i = 0; i < listDataBuku.size(); i++) {
                dataBuku.setJudulBuku(listDataBuku.get(i).getJudulBuku());
                dataBuku.setKodeBuku(listDataBuku.get(i).getKodeBuku());
                dataBuku.setStokBuku(listDataBuku.get(i).getStokBuku());
                dataBuku.setHargaBuku(listDataBuku.get(i).getHargaBuku());
                System.out.println(dataBuku.toString());
            }
        } else {
            System.out.println("Tidak Ada Data Buku");
        }
        repeatProgram(0);
    }

    private static void updateBuku() {
        String cariKodeBuku;
        boolean dataPencarian = false;
        ArrayList<DataBuku> listData = new ArrayList<DataBuku>();
        listData.addAll(listDataBuku);
        listDataBuku.clear();
        Scanner scUpdateBuku = new Scanner(System.in);
        System.out.println("======== Halaman Update Data Buku ========");
        System.out.print("Masukkan Kode Buku : ");
        cariKodeBuku = scUpdateBuku.nextLine();

        if (listData.size() > 0) {
            for (int i = 0; i < listData.size(); i++) {
                String judulBuku = listData.get(i).getJudulBuku();
                String kodeBuku = listData.get(i).getKodeBuku();
                int stokBuku = listData.get(i).getStokBuku();
                int hargaBuku = listData.get(i).getHargaBuku();
                
                if (cariKodeBuku.equals(kodeBuku)) {
                    dataPencarian = true;
                    System.out.print("Input Judul Buku Baru : ");
                    judulBuku = scUpdateBuku.nextLine();
                    System.out.print("Input Stok Buku Baru: ");
                    while (!scUpdateBuku.hasNextInt()) {
                        System.err.println("MASUKKAN ANGKA!!!!");
                        scUpdateBuku.next();
                        System.out.print("Input Stok Buku Baru: ");
                    }
                    stokBuku = scUpdateBuku.nextInt();
                    
                    System.out.print("Input Harga Buku Baru: ");
                    while (!scUpdateBuku.hasNextInt()) {
                        System.err.println("MASUKKAN ANGKA!!!!");
                        scUpdateBuku.next();
                        System.out.print("Input Harga Buku Baru: ");
                    }
                    hargaBuku = scUpdateBuku.nextInt();
                    
                }
                
                listDataBuku.add(new DataBuku(judulBuku, kodeBuku, stokBuku, hargaBuku));
            }
        } else {
            dataPencarian = true;
            System.out.println("Database Buku Kosong");
        }
        
        if (dataPencarian == false) {
            System.out.println("Data Buku Tidak Ditemukan");
        } 
        repeatProgram(0);
    }

    private static void buyBook() {
        System.out.println("======== Halaman Pembelian Buku ========");
        Scanner scBuyBook = new Scanner(System.in);
        String kodeBuku = "";
        int stokBuku = 0;
        boolean beliBuku = false;
        if (listDataBuku.size() > 0) {
            for (int i = 0; i < listDataBuku.size(); i++) {
                dataBuku.setJudulBuku(listDataBuku.get(i).getJudulBuku());
                dataBuku.setKodeBuku(listDataBuku.get(i).getKodeBuku());
                dataBuku.setStokBuku(listDataBuku.get(i).getStokBuku());
                dataBuku.setHargaBuku(listDataBuku.get(i).getHargaBuku());
                int nomor = 1 + i;
                System.out.println(nomor + ". " +dataBuku.toString());
            }
            
            System.out.print("Input Kode Buku Yang Mau Dibeli : ");
            kodeBuku = scBuyBook.nextLine();
            
            System.out.print("Input Jumlah Buku Yang Mau Dibeli: ");
            while (!scBuyBook.hasNextInt()) {
                System.err.println("MASUKKAN ANGKA!!!!");
                scBuyBook.next();
                System.out.print("Input Jumlah Buku Yang Mau Dibeli: ");
            }
            stokBuku = scBuyBook.nextInt();
            
            for (int i = 0; i < listDataBuku.size(); i++) {
                if (kodeBuku.equals(listDataBuku.get(i).getKodeBuku())) {
                    if (stokBuku <= listDataBuku.get(i).getStokBuku()) {
                        int hargaBuku = listDataBuku.get(i).getHargaBuku();
                        int totalHarga = stokBuku * hargaBuku;
                        System.out.println("Selamat Pembelian Berhasil\n" + "Total Harga Yang Harus dibayar adalah " + totalHarga);
                        beliBuku = true;
                    } else {
                        System.out.println("Jumlah Buku Yang Dibeli Melebihi Stok Buku");
                    }
                }
            }
            
            if (beliBuku == true) {
                ArrayList<DataBuku> listData = new ArrayList<DataBuku>();
                listData.addAll(listDataBuku);
                listDataBuku.clear();
                for (int i = 0; i < listData.size(); i++) {
                    String judulBukuUpdate = listData.get(i).getJudulBuku();
                    String kodeBukuUpdate = listData.get(i).getKodeBuku();
                    int stokBukuUpdate = listData.get(i).getStokBuku();
                    int hargaBukuUpdate = listData.get(i).getHargaBuku();
                    if (kodeBuku.equals(kodeBukuUpdate)) {
                        stokBukuUpdate = stokBukuUpdate - stokBuku;
                    }
                    listDataBuku.add(new DataBuku(judulBukuUpdate, kodeBukuUpdate, stokBukuUpdate, hargaBukuUpdate));
                }
            }
        } else {
            System.out.println("Tidak Ada Data Buku");
        }
        repeatProgram(0);
    }
    
}
