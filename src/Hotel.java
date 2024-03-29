import java.util.*;

class KamarHotel { //Kelas Kamar Hotel
    private String nomorKamar;
    private String tipeKamar;
    private String statusKamar;

    public KamarHotel(String nomorKamar, String tipeKamar) {
        this.nomorKamar = nomorKamar;
        this.tipeKamar = tipeKamar;
        this.statusKamar = "Kosong";
    }
//.
    public String getNomorKamar() {
        return nomorKamar;
    }

    public String getTipeKamar() {
        return tipeKamar;
    }

    public String getStatusKamar() {
        return statusKamar;
    }

    public void setStatusKamar(String status) {
        this.statusKamar = status;
    }
}

class Tamu {//Kelas Tamu
    private String kodePesanan;
    private String nama;
    private String NIK;
    private String jenisKelamin;
    private String alamat;
    private String nomorTelepon;
    private String nomorKamar;
    private String tanggalCheckIn;
    private String tanggalCheckOut;
    private String jenisPembayaran;
    private double jumlahDibayarkan;

    public Tamu(String kodePesanan, String nama, String NIK, String jenisKelamin, String alamat, String nomorTelepon,
                String nomorKamar, String tanggalCheckIn, String tanggalCheckOut, String jenisPembayaran, double jumlahDibayarkan) {
        this.kodePesanan = kodePesanan;
        this.nama = nama;
        this.NIK = NIK;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
        this.nomorKamar = nomorKamar;
        this.tanggalCheckIn = tanggalCheckIn;
        this.tanggalCheckOut = tanggalCheckOut;
        this.jenisPembayaran = jenisPembayaran;
        this.jumlahDibayarkan = jumlahDibayarkan;
    }

    public String getKodePesanan() {
        return kodePesanan;
    }

    public String getNama() {
        return nama;
    }

    public String getNIK() {
        return NIK;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public String getNomorKamar() {
        return nomorKamar;
    }

    public String getTanggalCheckIn() {
        return tanggalCheckIn;
    }

    public String getTanggalCheckOut() {
        return tanggalCheckOut;
    }

    public String getJenisPembayaran() {
        return jenisPembayaran;
    }

    public double getJumlahDibayarkan() {
        return jumlahDibayarkan;
    }
}

public class Hotel { //Kelas Hotel
    private static List<KamarHotel> kamar = new ArrayList<>();
    private static List<Tamu> tamu = new ArrayList<>();

    public static void main(String[] args) {
        inisialisasiKamar();

        Scanner scanner = new Scanner(System.in);
        int pilihan;
        //Perulangan do-while
        do {
            System.out.println("Menu:");
            System.out.println("1. Pemesanan Kamar");
            System.out.println("2. Data Kamar");
            System.out.println("3. Data Tamu");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Mengonsumsi newline
//Pengkondisian switch case
            switch (pilihan) {
                case 1:
                    pesanKamar(scanner);
                    break;
                case 2:
                    tampilkanDataKamar();
                    break;
                case 3:
                    tampilkanDataTamu();
                    break;
                case 0:
                    System.out.println("Terima kasih, program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak valid.");
            }
        } while (pilihan != 0);

        scanner.close();
    }

    private static void inisialisasiKamar() {
        kamar.add(new KamarHotel("101", "Single Bed"));
        kamar.add(new KamarHotel("102", "Single Bed"));
        kamar.add(new KamarHotel("201", "Double Bed"));
        kamar.add(new KamarHotel("202", "Double Bed"));
    }

    private static void pesanKamar(Scanner scanner) {
        // Membuat kode pesanan otomatis
        String kodePesanan = UUID.randomUUID().toString().substring(0, 8);

        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("NIK: ");
        String NIK = scanner.nextLine();
        System.out.print("Jenis Kelamin: ");
        String jenisKelamin = scanner.nextLine();
        System.out.print("Alamat: ");
        String alamat = scanner.nextLine();
        System.out.print("Nomor Telepon: ");
        String nomorTelepon = scanner.nextLine();
        System.out.print("Nomor Kamar (Contoh: 101, 102, 201, 202): ");
        String nomorKamar = scanner.nextLine();
        System.out.print("Tanggal Check-in: ");
        String tanggalCheckIn = scanner.nextLine();
        System.out.print("Tanggal Check-out: ");
        String tanggalCheckOut = scanner.nextLine();
        System.out.print("Jenis Pembayaran: ");
        String jenisPembayaran = scanner.nextLine();
        System.out.print("Jumlah Uang yang Dibayarkan: ");
        double jumlahDibayarkan = scanner.nextDouble();
        scanner.nextLine(); // Mengonsumsi newline

        // Pengkondisian Update status kamar menjadi "Ditempati"
        for (KamarHotel kamar : kamar) {
            if (kamar.getNomorKamar().equals(nomorKamar)) {
                kamar.setStatusKamar("Ditempati");
                break;
            }
        }

        tamu.add(new Tamu(kodePesanan, nama, NIK, jenisKelamin, alamat, nomorTelepon, nomorKamar, tanggalCheckIn,
                tanggalCheckOut, jenisPembayaran, jumlahDibayarkan));
        System.out.println("Pemesanan berhasil.");
    }

    private static void tampilkanDataKamar() {
        System.out.println("Data Kamar:");
        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-15s %-15s %-15s\n", "Nomor Kamar", "Tipe Kamar", "Status Kamar");
        System.out.println("-----------------------------------------------------------");
        for (KamarHotel kamar : kamar) {
            System.out.printf("%-15s %-15s %-15s\n", kamar.getNomorKamar(), kamar.getTipeKamar(), kamar.getStatusKamar());
        }
        System.out.println("-----------------------------------------------------------");
    }

    private static void tampilkanDataTamu() {
        System.out.println("Data Tamu:");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-10s %-10s %-20s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Kode Pesanan", "Nama", "NIK",
                "Jenis Kelamin", "Alamat", "Nomor Telepon", "Nomor Kamar", "Check-in Date", "Check-out Date",
                "Jenis Pembayaran", "Jumlah Dibayarkan");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        for (Tamu tamu : tamu) {
            System.out.printf("%-10s %-15s %-10s %-10s %-20s %-15s %-15s %-15s %-15s %-15s %-15s\n",
                    tamu.getKodePesanan(), tamu.getNama(), tamu.getNIK(), tamu.getJenisKelamin(), tamu.getAlamat(),
                    tamu.getNomorTelepon(), tamu.getNomorKamar(), tamu.getTanggalCheckIn(), tamu.getTanggalCheckOut(),

                    tamu.getJenisPembayaran(), tamu.getJumlahDibayarkan());
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
    }
}
//bawadehek
