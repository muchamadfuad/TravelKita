/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TUBES;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
/**
 *
 * @author hani,fuad,lenni
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
public void clrscr() {
        try {
            if (System.getProperty("os.name").startsWith("Window")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException e) {
            for (int i = 0; i < 1000; i++) {
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        
      String string = "March 11, 2016";
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
      LocalDate d1 = LocalDate.parse(string, formatter);
      System.out.println(d1);
      
      
   
      Pelanggan pel1 = new Pelanggan("Hani","ktp2","bogor","012");
      Pelanggan pel2 = new Pelanggan("Lenni","ktp3","Medan","121");
      TempatWisata tw1 = new TempatWisata("Jungle Land","Bogor");
      PaketWisata pkt1 = new PaketWisata("Hayuk ke Bogor",1,50000,2,1);
      pkt1.addTempatWisata(tw1);
      Perjalanan per1 = new Perjalanan(pkt1,d1,2);
      per1.addPelanggan(pel1);
      per1.addPelanggan(pel2);
      
      
      System.out.println("Perjalanan : ");
      per1.getPaketWisata().tampil();
      System.out.println("Total Harga : "+per1.hitungHarga());
      System.out.println("Tanggal Keberangkatan : "+per1.getTanggal());
      System.out.println("Pelanggan : ");
      System.out.println("1. "+per1.getPelanggan(0).getNama());
      System.out.println("2. "+per1.getPelanggan(1).getNama());
      per1.tampil();
    } 
}
