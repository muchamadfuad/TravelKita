public class Petugas extends Orang
 {
 	private String idPetugas;
 	private String Password;
 	
 	public Petugas(String nama,String noIdentitas,String alamat,String noHp,String idPetugas,String Password){
 		super(nama,noIdentitas,alamat,noHp);
 		this.idPetugas=idPetugas;
 		this.Password=Password;
 	}
 	public void setIdPetugas(String idPetugas){
 		this.idPetugas=idPetugas;
 	}
 	public String getIdPetugas(){
 		return this.idPetugas;
 	}
 	public void setPasswordPetugas(String Password){
 		this.Password=Password;
 	}
 	public String getPassword(){
 		return this.Password;
 	}
 }