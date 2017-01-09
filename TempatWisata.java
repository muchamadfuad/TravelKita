public class TempatWisata{
	private String namaTempat;
	private String lokasi;
	
	public TempatWisata(String namaTempat){
		this.namaTempat=namaTempat;
	}
	public TempatWisata(String namaTempat, String lokasi){
		this.namaTempat=namaTempat;
		this.lokasi=lokasi;
	}
	public void setNamaTempat(String namaTempat){
		this.namaTempat=namaTempat;
	}
	public String getNamaTempat(){
		return namaTempat;
	}
	public void setLokasi(String lokasi){
		this.lokasi=lokasi;
	}
	public String getLokasi(){
		return lokasi;
	}
}