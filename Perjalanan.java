
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
public class Perjalanan{
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
	private Pelanggan[] pelanggan;
	private LocalDate tanggal;
	private double totalHarga;
	private PaketWisata paketWisata;
	private int max;
	private int jum= 0;
	
	public Perjalanan(PaketWisata paketWisata,LocalDate tanggal,int max){
		this.paketWisata = paketWisata;
		this.tanggal = tanggal;
		this.max = max;
		pelanggan = new Pelanggan[max];
	}
	
	public void setTanggal(LocalDate tanggal){
		this.tanggal=tanggal;
	}
	
	public LocalDate getTanggal(){
		return tanggal;
	}
        
        public void setPaketWisata(PaketWisata paketWisata){
            this.paketWisata = paketWisata;
        }
        
        public PaketWisata getPaketWisata(){
            return paketWisata;
        }
	
	public void addPelanggan(Pelanggan pelanggan){
		if(jum != max){
			this.pelanggan[jum]=pelanggan;
			jum++;
		}
	}
	
	public Pelanggan getPelanggan(int i){
		return pelanggan[i];
	}
	
	public double hitungHarga(){
		if (jum<20){
			totalHarga=jum*paketWisata.getHarga();
		}
		else if(jum<50){
			totalHarga = 0.95*jum*paketWisata.getHarga();
		}
		else{
			totalHarga = 0.9*jum*paketWisata.getHarga();
		}
		return totalHarga;
	}

}

		this.tanggal = tanggal;
		this.max = max;
		pelanggan = new Pelanggan[max];
	}
	
	public void setTanggal(Date tanggal){
		this.tanggal=tanggal;
	}
	
	public Date getTanggal(){
		return tanggal;
	}
	
	public void addPelanggan(Pelanggan pelanggan){
		if(jum != max){
			this.pelanggan[jum]=pelanggan;
			jum++;
		}
	}
	
	public Pelanggan getPelanggan(int i){
		return pelanggan[i];
	}
	
	public double hitungHarga(){
		if (jum<20){
			totalHarga=jum*paketWisata.getHarga();
		}
		else if(jum<50){
			totalHarga = 0.95*jum*paketWisata.getHarga();
		}
		else{
			totalHarga = 0.9*jum*paketWisata.getHarga();
		}
		return totalHarga;
	}

}