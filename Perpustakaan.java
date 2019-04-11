package allibrary;

import java.util.HashMap;
import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.io.IOException;


public class Perpustakaan{
    String noTransaksi, tgl;
    String isbnBuku, idCustomer, idStaff;
    int jumlahPinjam,lamaPinjam, denda, batasWaktu, tanggalPinjam, tanggalKembali, totalBuku;
    
    static BufferedReader input = new BufferedReader(new InputStreamReader( System.in));
    static int menu;
    static HashMap<String, Buku> book = new HashMap<String, Buku>();   
    static HashMap<String, Peminjam> reader = new HashMap<String, Peminjam>();
    static HashMap<String, Staff>  pstkwn = new HashMap<String, Staff>();
    static HashMap<String, Peminjaman> brrw = new HashMap<String, Peminjaman>();

    public int totalDenda(){
        return this.denda * this.lamaPinjam;
    }

    public static Boolean hasBuku(String isbn){
        if(book.containsKey(isbn)){
           return true;
        }
        return false;
    }

    public static void cekBuku(String isbn){
        if(book.containsKey(isbn)){
            System.out.println("Buku dengan ISBN "+isbn+" Tersedia, dengan nama "+book.get(isbn).getJudul());
        }else{
            System.out.println("Buku dengan ISBN tersebut tidak di temukan di Pencarian");
        }
    }


    public static Boolean hasMember(String id){
        if(reader.containsKey(id)){
           return true;
        }
        return false;

    }
    public static void cekMember(String id){
        if(reader.containsKey(id)){
            System.out.println("Member dengan ID "+id+" Sukses meminjam buku, dengan nama "+reader.get(id).getNama());
        }else{
            System.out.println("Member tersebut tidak meminjam buku");
        }
    }


   /* public static void cekStaff(String is){
        if(pstkwn.containsKey(is)){
            System.out.println("Staff dengan ID "+is+" Ada, dengan nama "+ pstkwn.get(is).getNama());
        }else{
            System.out.println("Staff sedang tidak ada di Gudang");
        }
    }
    */
    public static void pinjamBuku() throws IOException{
        
          book.put("ISBN 817525766-0", new Buku("ISBN 817525766-0", "Laskar Pelangi", "Andrea Hirata ", "Gramedia Pustaka Utama", "312", 55));
          book.put("ISBN 189230441-1", new Buku("ISBN 189230441-1", "Sang Pemimpi", "Andrea Hirata ", "Elexmedia Komputindo", "200", 50));
          book.put("ISBN 290213998-2", new Buku("ISBN 290213998-2", "Cinta di dalam Gelas", "Andrea Hirata", "Gagas Media", "150", 150));
          book.put("ISBN 057475021-3", new Buku("ISBN 057475021-3", "Sebelas Patriot", "Andrea Hirata", "Gramedia Widiasarana Indonesia", "299", 100));
          
  
          
          for(String i : book.keySet()){
              System.out.println("ISBN              : " + book.get(i).getIsbn());
              System.out.println("Judul Buku        : " + book.get(i).getJudul());
              System.out.println("Penerbit Buku     : " + book.get(i).getPnrbt());
              System.out.println("Penulis Buku      : " + book.get(i).getPenulis());
              System.out.println("Jumlah Halaman    : " + book.get(i).getJmlh() +  "\n");
          }
          
          reader.put("P0902", new Peminjam("Febriana", "BPA Blok FF no.09", "Febriananur09@gmail.com" , "P0902"));
          reader.put("P2902", new Peminjam("Alyssa", "BPA Blok EE no. 16 ", "Queen.alyssa29@yahoo.com", "P2902"));
          reader.put("P1802", new Peminjam("Ambar", "BPA Blok EE no. 09 ", "Ambarsulistyorini@gmail.com", "P1802"));
          reader.put("P1406", new Peminjam("Ria", "BPA Blok FF no. 18", "inniriaa14@gmail.com", "P1406"));
          reader.put("B1408", new Peminjam("Pertiwi", "BPA Blok DD no. 18", "dpertiwi18@gmail.com", "P1408"));
  
  
       /*   for(String i : people.keySet()){
              System.out.println("Nama Member         : " + people.get(i).getNama());
              System.out.println("Alamat Member       : " + people.get(i).getAlamat());
              System.out.println("Email Member        : " + people.get(i).getEml());
              System.out.println("ID Member           : " + people.get(i).getId());
              System.out.println("Jenis Kelamin       : " + people.get(i).getJk() + "\n");
             
          }
  
      */    
          pstkwn.put("K2606", new Staff("Aditya", "K2606"));
          pstkwn.put("K1809", new Staff("Rifky" , "K1809"));
          pstkwn.put("K0506", new Staff("Dini", "K0506"));
          pstkwn.put("K0312", new Staff("Kiki", "K3012"));
          pstkwn.put("K0510", new Staff("Alifro", "K0510"));
          
    

          System.out.print("Silakan masukkan kode Member : ");
          String idMember = input.readLine();
          if(hasMember(idMember) == false){
              System.exit(1);
          }
      
          System.out.print("Silakan masukkan ISBN Buku yang akan di pinjam : ");
          String isbn = input.readLine().toUpperCase();
      
        
          if(hasBuku(isbn) == false){
              System.exit(1);
          }
          
      System.out.print("Jumlah Pinjam : ");
      int jumlahPinjam = Integer.parseInt(input.readLine());
      Perpustakaan trx = new Perpustakaan();
      trx.noTransaksi = reader.get(idMember).getIm()+book.get(isbn).getIsbn();
      trx.isbnBuku = book.get(isbn).getIsbn();
      trx.idCustomer = reader.get(idMember).getIm();
      trx.tgl = "21/02/2019";
      trx.jumlahPinjam = jumlahPinjam;
      if(jumlahPinjam > book.get(isbn).getStock()){
          System.out.println("Maaf karena Stock Buku tidak Tersedia, Silahkan Pilih Buku Yang Lain");
      }
      else{
  
        trx.totalBuku = book.get(isbn).getStock();
        trx.book.get(isbn).barangDipinjam(jumlahPinjam);
        //trx.stock(kode);
        System.out.println("Stock Buku dengan Judul tersebut Saat ini : " + book.get(isbn).getStock());
        
          /* Print Struk */
          System.out.println("\n\n==========================================================");
          System.out.println("+               Selamat Datang di Allibrary       ");
          System.out.println("+                    Bukti Peminjaman                  ");
          System.out.println("+           Ruko Boulevard Kav.11 No 12 Jakarta          ");
          System.out.println("+             www.Allibrary.com / 02920000211                  ");
          System.out.println("===========================================================");
          System.out.println("+ Tanggal                     : "+trx.tgl);
          System.out.println("+ No. Transaksi               : "+trx.noTransaksi);
          System.out.println("+ No. ISBN                    : "+trx.isbnBuku);
          System.out.println("+ Nama Member                 : "+reader.get(idMember).getIm()+" - "+reader.get(idMember).getNama());
          System.out.println("+ Judul Buku                  : "+book.get(isbn).getIsbn()+" - "+book.get(isbn).getJudul());
          System.out.println("+ Jumlah Denda                : Rp."+trx.denda+",-");
          System.out.println("+ Jumlah Pinjam               : "+trx.jumlahPinjam+" buah");
          System.out.println("===========================================================");
          System.out.println("+ TOTAL               : Rp."+trx.totalDenda()+",-");
          System.out.println("===========================================================");
          System.out.println("+                                Kasir           ");
          System.out.println("+");
          System.out.println("+                               "  + pstkwn.get("K1809").getNama());
          System.out.println("===========================================================");
      
      }
   }   
    public static void menu() throws IOException{
        boolean run = true;
        while(run == true){
        System.out.println("================================================");
        System.out.println("                Aplikasi Penjualan                  ");
        System.out.println("================================================");
        System.out.println("                        MENU                    ");
        System.out.println("------------------------------------------------");
        System.out.println("    Kode        Aksi                               ");
        System.out.println("    1.      Pinjam Buku                             ");
        System.out.println("    2.      Kembalikan Buku                         ");
        System.out.println("    3.      Input Member                            ");
        System.out.println("    4.      Input Staff                             ");
        System.out.println("------------------------------------------------");
        System.out.print("    Silakan pilih menu :");
        //menu = Integer.parseInt(input.readLine());
        String pilihan = input.readLine();
        if(pilihan.equalsIgnoreCase("X")){
            run = false;
            System.out.println("================================================");
        }
        else{
            run = true;
            menu = Integer.parseInt(pilihan);
            System.out.println("================================================");
                if(menu == 1){
                    pinjamBuku();

                   
                }
                else if(menu == 2){
                    kembalikanBuku();
                }
                else if(menu == 3){
                    inputMember();
                }
                else if(menu == 4){
                    inputStaff();
                }
                else{
                    System.exit(1);
                }
            }
        }
    }

    public static void kembalikanBuku() throws IOException{
        System.out.println("================================================");
        System.out.println("               Data Pengembalian Buku                 ");
        System.out.println("================================================");
        System.out.println("Masukkan jumlah buku yang akan di kembalikan [B untuk ke menu utama]: ");
        String in = input.readLine();
        System.out.println(in);
        if(in.equalsIgnoreCase("B")){
            menu();
        } 
        else{
            try{
            int jumlah = Integer.parseInt(in);
        for(int a=1; a <= jumlah;a++){
        
            book.put("ISBN 817525766-0", new Buku("ISBN 817525766-0", "Laskar Pelangi", "Andrea Hirata ", "Gramedia Pustaka Utama", "312", 55));
            book.put("ISBN 189230441-1", new Buku("ISBN 189230441-1", "Sang Pemimpi", "Andrea Hirata ", "Elexmedia Komputindo", "200", 50));
            book.put("ISBN 290213998-2", new Buku("ISBN 290213998-2", "Cinta di dalam Gelas", "Andrea Hirata", "Gagas Media", "150", 150));
            book.put("ISBN 057475021-3", new Buku("ISBN 057475021-3", "Sebelas Patriot", "Andrea Hirata", "Gramedia Widiasarana Indonesia", "299", 100));
            
              /* Tampilin list barang di layar */
              for(String i : book.keySet()){
                System.out.println("ISBN              : " + book.get(i).getIsbn());
                System.out.println("Judul Buku        : " + book.get(i).getJudul());
                System.out.println("Penerbit Buku     : " + book.get(i).getPnrbt());
                System.out.println("Penulis Buku      : " + book.get(i).getPenulis());
                System.out.println("Jumlah Halaman    : " + book.get(i).getJmlh() +  "\n");
            }


          reader.put("P0902", new Peminjam("Febriana", "BPA Blok FF no.09", "Febriananur09@gmail.com" , "P0902"));
          reader.put("P2902", new Peminjam("Alyssa", "BPA Blok EE no. 16 ", "Queen.alyssa29@yahoo.com", "P2902"));
          reader.put("P1802", new Peminjam("Ambar", "BPA Blok EE no. 09 ", "Ambarsulistyorini@gmail.com", "P1802"));
          reader.put("P1406", new Peminjam("Ria", "BPA Blok FF no. 18", "inniriaa14@gmail.com", "P1406"));
          reader.put("B1408", new Peminjam("Pertiwi", "BPA Blok DD no. 18", "dpertiwi18@gmail.com", "P1408"));

          System.out.print("Silakan masukkan kode Member : ");
          String idMember = input.readLine();
          if(hasMember(idMember) == false){
              System.exit(1);
          }
      
          System.out.print("Silakan masukkan ISBN Buku yang akan di pinjam : ");
          String isbn = input.readLine().toUpperCase();
      
        
          if(hasBuku(isbn) == false){
              System.exit(1);
          } 

          trx.totalBuku = book.get(isbn).getStock();
          trx.book.get(isbn).barangDipinjam(jumlahPinjam);
          //trx.stock(kode);
          System.out.println("Stock Buku dengan Judul tersebut Saat ini : " + book.get(isbn).getStock());
          
            System.out.println("Buku berhasil diinput untuk di Kembalikan!");
            System.out.println("================================================");
            System.out.println(" ");
            System.out.println("================================================");
            System.out.println("        Rincian Data Inputan Pengembalian Buku             ");
            System.out.println("================================================");
                }   
               
        
            menu(); 
        }
        
            catch (Exception e){
                System.out.println("Sorry, salah input. Try Again, Please:)");
            }
        }
    }

    public static void inputMember() throws IOException{
        System.out.println("================================================");
        System.out.println("                Input Member                 ");
        System.out.println("================================================");
        System.out.println("Masukkan nama member yang akan di input [B untuk ke menu utama]: ");
        String mem = input.readLine();
        System.out.println(mem);
        if(mem.equalsIgnoreCase("B")){
            menu();
        } 
        else{
            try{
            int jumlah = Integer.parseInt(mem);
        for(int i=1; i <= jumlah;i++){
            System.out.print("ID Member    :");
            String id = input.readLine().toUpperCase();
            System.out.print("Nama Member    :");
            String nama = input.readLine();
            System.out.print("Alamat Member    :");
            String almt = input.readLine();
            System.out.print("Email Member   :");
            String eml = input.readLine();
            reader.put(id,new Peminjam(id,nama,almt,eml));
            System.out.println("\n Data Member berhasil diinput ! \n");
            System.out.println("================================================");
            System.out.println(" ");
            System.out.println("================================================");
            System.out.println("        Rincian Data Inputan Member             ");
            System.out.println("================================================");
                }   
                 /* Tampilin list barang di layar */
        for(String i: reader.keySet()){
            System.out.println("ID Member    : " + reader.get(i).getIm());
            System.out.println("Nama Member  : " + reader.get(i).getNama());
            System.out.println("Alamat       : " + reader.get(i).getAlamat());
            System.out.println("Email        : " + reader.get(i).getEml() + "\n");
            }
            menu(); 
        }
        
            catch (Exception e){
                System.out.println("Sorry,salah input. Try Again, Please:)");
            }
        }
            
    }

    public static void inputStaff() throws IOException{
        System.out.println("================================================");
        System.out.println("                Input Staff                 ");
        System.out.println("================================================");
        System.out.println("Masukkan nama staff yang akan di input [B untuk ke menu utama]: ");
        String staff = input.readLine();
        System.out.println(staff);
        if(staff.equalsIgnoreCase("B")){
            menu();
        } 
        else{
            try{
            int jumlah = Integer.parseInt(staff);
        for(int i=1; i <= jumlah;i++){
            System.out.print("ID Staff    :");
            String is = input.readLine().toUpperCase();
            System.out.print("Nama Staff    :");
            String nama = input.readLine();
            pstkwn.put(is,new Staff(is,nama));
            System.out.println("\n Data Staff berhasil diinput ! \n");
            System.out.println("================================================");
            System.out.println(" ");
            System.out.println("================================================");
            System.out.println("        Rincian Data Inputan Staffs            ");
            System.out.println("================================================");
        }   
                 /* Tampilin list barang di layar */
        for(String i: pstkwn.keySet()){
            System.out.println("ID Staff : " + pstkwn.get(i).getIs());
            System.out.println("Nama Staff  : " + pstkwn.get(i).getNama());
            }
            menu(); 
        }
        
            catch (Exception e){
                System.out.println("Sorry,salah input. Try Again, Please:)");
            }
        }
            
    }


    public static void main(String[] args) throws IOException{
        boolean run = true;
       
        menu();
        
    }   
}


