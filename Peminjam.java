package allibrary;

public class Peminjam{
    protected  String idMember, namaMember, alamatMember, emailMember;

public Peminjam(String nm, String am, String em, String im){
    this.namaMember = nm;
    this.alamatMember = am;
    this.emailMember = em;
    this.idMember = im;
  
}

    public void setId(String im){
        this.idMember = im;
    }
    public void setNama(String nama){
    this.namaMember = nama;
    }
    public void setAlamat(String almt){
        this.alamatMember = almt;
    }
    public void setEmail(String eml){
        this.emailMember = eml;
    }
   

    public String getIm(){
        return this.idMember;
    }
    public String getAlamat(){
        return this.alamatMember;
    }
    public String getNama(){
        return this.namaMember;
    }
    public String getEml(){
        return this.emailMember;
    }

}