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
        
        public String toString(){
            return (namaTempat +" "+lokasi);
            
        }
}