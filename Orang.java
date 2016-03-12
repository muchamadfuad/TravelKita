public abstract class Orang
{
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
	public void setNoHp(){
		this.noHp=noHp;
	}
	public String getNoHp(){
		return this.noHp;
	}	
}
