public class PaketWisata{
	private String namaPaket;
	private TempatWisata[] tempatWisata;
	private double harga;
	private int minimalKeberangkatan;
	private int hari;
	private int jum=0;
	private int max;
	
	public PaketWisata(String namaPaket, int max, double harga, int minimalKeberangkatan, int hari){
		this.namaPaket=namaPaket;
		tempatWisata = new TempatWisata[max];
		this.harga=harga;
		this.max=max;
		this.minimalKeberangkatan=minimalKeberangkatan;
		this.hari=hari;
	}
	public void setNamaPaket(String namaPaket){
		this.namaPaket=namaPaket;
	}
	public String getNamaPaket(){
		return namaPaket;
	}
	public int getJum(){
		return jum;
	}
	public void addTempatWisata(TempatWisata tempatWisata){
		if(jum != max){
			this.tempatWisata[jum] = tempatWisata;
			jum++;
		}
	}
	public TempatWisata getTempatWisata(int i){
		return tempatWisata[i];
	}
	public void setHarga(double harga){
		this.harga=harga;
	}
	public double getHarga(){
		return harga;
	}
	public void setMinimalKeberangkatan(int minimalKeberangkatan){
		this.minimalKeberangkatan=minimalKeberangkatan;
	}
	public int getMinimalKeberangkatan(){
		return minimalKeberangkatan;
	}
	public void setHari(int hari){
		this.hari=hari;
	}
	public int getHari(){
		return hari;
	}
	public void tampil(){
		System.out.println("Nama Paket: "+namaPaket);
		System.out.println("Tempat Wisata: ");
		for(int i=0;i<=max;i++){
		System.out.println((i+1)+tempatWisata[i].getNamaTempat());
		}
		System.out.println("Harga: "+harga);
		System.out.println("Minimal keberangkatan: "+minimalKeberangkatan);
		
	}
}