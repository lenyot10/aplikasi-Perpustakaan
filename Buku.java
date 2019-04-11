package allibrary;

public class Buku{
    protected String isbnBuku, judulBuku, penulisBuku, penerbitBuku, jmlHal;
    protected int stockBuku;

    public Buku(String ib, String jb, String peb, String pb, String jh, int sb){
        this.isbnBuku = ib;
        this.judulBuku = jb;
        this.penulisBuku = peb;
        this.penerbitBuku = pb;
        this.jmlHal = jh;
        this.stockBuku = sb;
       
    }


    public String getIsbn(){
        return this.isbnBuku;
    }
    public String getJudul(){
        return this.judulBuku;
    }
    public String getPenulis(){
        return this.penulisBuku;
    }
    public String getPnrbt(){
        return this.penerbitBuku;
    }
    public String getJmlh(){
        return this.jmlHal;
    }
    public int getStock(){
        return this.stockBuku;
    }
    


    public void setIsbn(String x){
        this.isbnBuku = x;
    }
    public void setJudul(String x){
        this.judulBuku = x;
    }
    public void setPenulis(String x){
        this.penulisBuku = x;
    }
    public void setPnrbt(String x){
        this.penerbitBuku = x;
    }
    public void setJmlh(String x){
        this.jmlHal = x;
    }
    public void setStock(int x){
        this.stockBuku = x;
    }
   
    

    public void barangDipinjam(int jumlahPinjam){
        this.stockBuku -= jumlahPinjam;
    }

    public void barangdiKembalikan(int jumlahPinjam){
        this.stockBuku += jumlahPinjam;
    }
}

