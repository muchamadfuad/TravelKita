/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hani,fuad,lenni
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
public class Perjalanan{
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        private String no_perjalanan;
	private Pelanggan[] pelanggan;
	private String tanggal;
	private double totalHarga;
	private PaketWisata paketWisata;
	private int max;
	private int jum= 0;
	
	public Perjalanan(PaketWisata paketWisata,String tanggal,int max){
                this.no_perjalanan = no_perjalanan;
		this.paketWisata = paketWisata;
		this.tanggal = tanggal;
		this.max = max;
		pelanggan = new Pelanggan[max];
	}

         public void setNo_perjalanan(String no_perjalanan) {
            this.no_perjalanan = no_perjalanan;
        }   

         public String getNo_perjalanan() {
            return no_perjalanan;
        }
        
        public Perjalanan(PaketWisata paketWisata,String tanggal,int max,String no_perjalanan){
                this.no_perjalanan = no_perjalanan;
		this.paketWisata = paketWisata;
		this.tanggal = tanggal;
		this.max = max;
		pelanggan = new Pelanggan[max];
	}
	
	public void setTanggal(String tanggal){
		this.tanggal=tanggal;
	}
        
        public Pelanggan getPelanggan(Integer i){
            return pelanggan[i];
        }
        
        public int getJumlah(){
            return jum;
        }
	
	public String getTanggal(){
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
                hitungHarga();
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
        
      public void tampil(){
          System.out.println("Paket Wisata : "+paketWisata.getNamaPaket());
          System.out.println("Tanggal  : "+tanggal);
          System.out.println("Total Harga :"+totalHarga);
          System.out.println("Daftar Pelanggan :");
          for(int i=0;i<max;i++){
                    System.out.println((i+1)+". "+getPelanggan(i));  
	  }
      } 
}
