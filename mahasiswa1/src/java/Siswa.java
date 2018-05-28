/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author intel
 */
public class Siswa {
    private Double nim;
    private String nama;
    private Double ipk ;

    /**
     * @return the nim
     */
    public Siswa (){
        
    }
    
    public Siswa ( String nama, Double ipk, Double nim){
       
        this.nim = nim; 
      
        
    }
       public Siswa(Double nim, Double ipk, String nama) {
        this.nama = nama;
        this.nim = nim;
        this.ipk = ipk;
    }

    Siswa(Double nim, String nama, Double ipk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Siswa(double nim) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Siswa(String nama, Double ipk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public Double getNim() {
        return nim;
    }

    /**
     * @param nim the nim to set
     */
    public void setNim(Double nim) {
        this.nim = nim;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the ipk
     */
    public Double getIpk() {
        return ipk;
    }

    /**
     * @param ipk the ipk to set
     */
    public void setIpk(Double ipk) {
        this.ipk = ipk;
    }
}
