/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TUBES;

/**
 *
 * @author hani,fuad,lenni
 */
public class Orang {
 	private String nama;
	private String noIdentitas;
 	private String alamat;
 	private String noHp;
 	
 	public Orang(String nama,String noIdentitas,String alamat,String noHp){
 		this.nama=nama;
 		this.noIdentitas=noIdentitas;
 		this.alamat=alamat;
 		this.noHp=noHp;
 	}
 	public void setNama(String nama){
 	this.nama=nama;
 	}
 	public String getNama(){
 		return this.nama;
 	}
 	public void setNoIdentitas(String noIdentitas){
 		this.noIdentitas=noIdentitas;
 	}
 	public String getNoIdentitas(){
 		return this.noIdentitas;
 	}
 	public void setNoHp(String noHp){
 		this.noHp=noHp;
 	}
 	public String getNoHp(){
		return this.noHp;
	}
        
        public void setAlamat(String Alamat){
            this.alamat=alamat;
        }
        
        public String getAlamat(){
            return this.alamat;
        }
        public String toString(){
            return (nama +", "+noIdentitas+", "+noHp+", "+alamat);
        }
}
