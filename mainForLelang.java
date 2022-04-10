import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class mainForLelang {
    public static void main(String[] args) {
        masyarakat ind = new masyarakat();
        petugasLelang idn = new petugasLelang();
        Barang lelang = new Barang();
        prosesLelang perlelang = new prosesLelang(ind, idn, lelang);
    }
}

interface dataUtama {
    public void setNama(String nama);

    public void setAlamat(String alamat);

    public void setTelepon(String telepon);

    public abstract String getNama(int id);

    public abstract String getAlamat(int id);

    public abstract String getTelepon(int id);
}

class masyarakat implements dataUtama {
    private ArrayList<String> namaOrang = new ArrayList<String>();
    private ArrayList<String> alamat = new ArrayList<String>();
    private ArrayList<String> telepon = new ArrayList<String>();

    public masyarakat() {
        namaOrang.add("Atharafi");
        alamat.add("Malang");
        telepon.add("085855008901");

        namaOrang.add("Ino");
        alamat.add("Malang");
        telepon.add("085855008902");

        namaOrang.add("Ana");
        alamat.add("Malang");
        telepon.add("085855008903");

    }

    @Override
    public void setNama(String nama) {
        this.namaOrang.add(nama);
    }

    @Override
    public void setAlamat(String alamat) {
        this.alamat.add(alamat);
    }

    @Override
    public void setTelepon(String telepon) {
        this.telepon.add(telepon);
    }

    @Override
    public String getNama(int id) {
        return this.namaOrang.get(id);
    }

    @Override
    public String getAlamat(int id) {
        return this.alamat.get(id);
    }

    @Override
    public String getTelepon(int id) {
        return this.telepon.get(id);
    }

}

class petugasLelang implements dataUtama {
    public petugasLelang() {
        this.nama.add("Almas");
        this.alamat.add("Kepanjen");
        this.telepon.add("085888901234");
    }

    private ArrayList<String> nama = new ArrayList<String>();
    private ArrayList<String> alamat = new ArrayList<String>();
    private ArrayList<String> telepon = new ArrayList<String>();


    @Override
    public void setNama(String nama) {
        this.nama.add(nama);
    }

    @Override
    public void setAlamat(String alamat) {
        this.alamat.add(alamat);
    }

    @Override
    public void setTelepon(String telepon) {
        this.telepon.add(telepon);
    }


    @Override
    public String getNama(int id) {
        return nama.get(id);
    }

    @Override
    public String getAlamat(int id) {
        return alamat.get(id);
    }

    @Override
    public String getTelepon(int id) {
        return telepon.get(id);
    }

}

class Barang {
    private ArrayList<String> namaBarang = new ArrayList<String>();
    private ArrayList<Integer> idMasyarakat = new ArrayList<Integer>();
    private ArrayList<Integer> hargaAwal = new ArrayList<Integer>();
    private ArrayList<Boolean> status = new ArrayList<Boolean>();
    Barang() {
        namaBarang.add("Toyota Supra");
        hargaAwal.add(950000);
        status.add(false);

        namaBarang.add("Yamaha YZF-R15");
        hargaAwal.add(7000);
        status.add(false);

        namaBarang.add("Asus ROG G513-QM");
        hargaAwal.add(4000);
        status.add(false);

        idMasyarakat.add(0);
        idMasyarakat.add(1);
        idMasyarakat.add(2);

    }
    public void setNamaBarang(String namaBarang) {
        this.namaBarang.add(namaBarang);
    }
    public String getNamaBarang(int id) {
        return this.namaBarang.get(id);
    }
    public int getIndexBarang(String namaBuku) {
        return this.namaBarang.indexOf(namaBuku);
    }
    public void setStatus(int indexNamaBarang, boolean status) {
        this.status.set(indexNamaBarang, status);
    }
    public boolean getStatus(int idBarang){
        return this.status.get(idBarang);
    }
    public void setHarga(int harga) {
        this.hargaAwal.add(harga);
    }
    public Integer getHarga(int id) {
        return this.hargaAwal.get(id);
    }
    public void removeBarang(int indexBarang){
        this.namaBarang.remove(namaBarang);
    }
}
class prosesLelang {
    private ArrayList<Integer> hargaBID = new ArrayList<Integer>();
    private ArrayList<String> namaBider = new ArrayList<String>();
    private ArrayList<Integer> idBider = new ArrayList<Integer>();
    Scanner input = new Scanner(System.in);
    prosesLelang(masyarakat masyarakat, petugasLelang petugas, Barang barang) {
        System.out.println("Wellcome to MyBID");
        int confirm;
        try {

        do {
            System.out.println("Main menu: \n 1. Masuk ke proses lelang \n 99. keluar");
            confirm = input.nextInt();
            if (confirm == 1){
                char[] animationChars = new char[]{'|', '/', '-', '\\'};
                for (int i = 0; i <= 100; i++) {
                    System.out.print("Processing: " + i + "% " + animationChars[i % 4] + "\r");

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Masukkan id barang yang akan dilelang: ");
                int idBarang = input.nextInt();
                System.out.println("Barang yang akan dilelang adalah: " + barang.getNamaBarang(idBarang));
                if (!barang.getStatus(idBarang)) {
                    System.out.println("anda ingin mengubah item: " + barang.getNamaBarang(idBarang) + " menjadi bisa ditawar?");
                    System.out.println("Y/N");
                    String option = input.next();
                    if (option.equalsIgnoreCase("Y")){
                        barang.setStatus(idBarang, true);
                        System.out.println("Nama Item: " + barang.getNamaBarang(idBarang) + "Kondisi barang: " + barang.getStatus(idBarang));
                        if (barang.getStatus(idBarang)) {
                            System.out.println("Barang sudah bisa di lelang");
                            System.out.println("Maksimal 5 kali bid");
                            int maksimal = 0;
                            do {
                                System.out.println("Masukkan bid pertama. (Minimal Bid "+ barang.getHarga(idBarang) + ")");
                                System.out.println("Masukkan ID pe-lelang: ");
                                int inputID = input.nextInt();
                                System.out.println("Masukkan harga yang ditawar");
                                int nilaiBID = input.nextInt();
                                if (nilaiBID <= barang.getHarga(idBarang)) {
                                    System.out.println("Harga BID Kurang");
                                    maksimal--;
                                }else if(nilaiBID > barang.getHarga(idBarang)){
                                    hargaBID.add(nilaiBID);
                                    idBider.add(inputID);
                                }
                                maksimal++;
                            }while(maksimal !=3);
                            if (maksimal ==3){
                                barang.setStatus(idBarang, false);
                                int maxValue = Collections.max(hargaBID);
                                int getIndex = hargaBID.indexOf(maxValue);
                                int winner = idBider.get(getIndex);
                                System.out.println("Pemenang lelang = " + masyarakat.getNama(winner) + "\nBarang yang terjual = " + barang.getNamaBarang(idBarang) + "\ndengan harga beli sebesar = " + maxValue);
                                barang.removeBarang(idBarang);
                            }
                        }

                    }else if (option.equalsIgnoreCase("N")){
                        confirm =99;
                    }
                }else {
                    System.out.println("Terjadi kesalahan dan error");
                }
            }else{
                char[] animationChar = new char[]{'|', '/', '-', '\\'};
                for (int i = 0; i <= 100; i++) {
                    System.out.print("Processing: " + i + "% " + animationChar[i % 4] + "\r");

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
        }while(confirm !=99);
        System.out.println("Exit from system");

        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}