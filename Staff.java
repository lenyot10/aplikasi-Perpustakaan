package allibrary;

public class Staff{
    String  idStaff, namaStaff;
   
    public Staff(String is, String ns){
        this.idStaff   = is;
        this.namaStaff = ns;
    }

    public void setIs(String idStaff){
        this.idStaff = idStaff;
    }
    public void setNama(String namaStaff){
        this.namaStaff = namaStaff;
    }

    public String getIs(){
        return this.idStaff;
    }
    public String getNama(){
        return this.namaStaff;
    }
}
