/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author leni,hani,fuad
 */
public class Aplikasi {
    
    private ArrayList<Pelanggan> daftarPelanggan = new ArrayList<Pelanggan>();
    private ArrayList<TempatWisata> daftarTempatWisata = new ArrayList<TempatWisata>();
    private ArrayList<PaketWisata> daftarPaketWisata = new ArrayList<PaketWisata>();
    private ArrayList<Perjalanan> daftarPerjalanan = new ArrayList<Perjalanan>();
    private String namaPelanggan,noIdentitasPelanggan,alamatPelanggan,noHpPelanggan,namaTempat,lokasi,namaPaket,tgl;
    private int max,hari,minimalKeberangkatan;
    private int noPejln = 0;
    private double harga;
    private LocalDate date;
    Scanner inputString = new Scanner(System.in);
    Scanner inputInt = new Scanner (System.in);
    Scanner inputDouble = new Scanner (System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
    public Petugas pt = new Petugas("a","a","a","a","Admin","12345");

    
    public ArrayList<Pelanggan> getDaftarPelanggan() {
        return daftarPelanggan;
    }
    
    public String[] getListPaketWisata() {
        List idEmp = daftarPaketWisata.stream()
                .map(e -> e.getNamaPaket()).collect(Collectors.toList());
        return (String[]) idEmp.stream().toArray(size -> new String[size]);
    }
    
    public String[] getListPerjalanan() {
        List idEmp = daftarPerjalanan.stream()
                .map(e -> e.getNo_perjalanan()).collect(Collectors.toList());
        return (String[]) idEmp.stream().toArray(size -> new String[size]);
    }
 
    public ArrayList<TempatWisata> getDaftarTempatWisata() {
        return daftarTempatWisata;
    }

    public ArrayList<PaketWisata> getDaftarPaketWisata() {
        return daftarPaketWisata;
    }

    public ArrayList<Perjalanan> getDaftarPerjalanan() {
        return daftarPerjalanan;
    }
    
    //METHOD TAMBAHAN BUAT MVC :
    // 1. Method Edit Pelanggan
    public void EditPelanggan(Pelanggan x,String nama,String no_identitas,String Alamat,String no_Hp){
        x.setNama(nama);
        x.setNoIdentitas(no_identitas);
        x.setAlamat(Alamat);
        x.setNoHp(no_Hp);
    }
   //2. Method New Paket DOANG
    public void newPaket(String namaPaket, int max,double harga, int minimalKeberangkatan, int hari){
        
    }
//====Method Editing Pelanggan====
        
    public void addPelanggan(String nama,String noIdentitas,String alamat,String noHp){
        Pelanggan p = new Pelanggan(nama,noIdentitas,alamat,noHp);
        daftarPelanggan.add(p);
    }
     public void EditPaketWisata(PaketWisata x,String nama,double harga,int min,int hari){
        x.setNamaPaket(namaPaket);
        x.setHarga(harga);
        x.setMinimalKeberangkatan(min);
        x.setMinimalKeberangkatan(hari);
    }
    public void addPerjalanan(Perjalanan P){
        noPejln++;
        String pjln = String.valueOf(noPejln);
        P.setNo_perjalanan(pjln);
        daftarPerjalanan.add(P);
    }
    
    public Pelanggan searchPelanggan(String noIdentitas){
        for (int i = 0; i < daftarPelanggan.size(); i++) {
            if (daftarPelanggan.get(i).getNoIdentitas().equals(noIdentitas)) {
                return daftarPelanggan.get(i);
            }}
            return null; 
    }
    
    public Perjalanan searchPerjalanan(String nomer){
        for (int i = 0;i < daftarPerjalanan.size();i++){
            if (daftarPerjalanan.get(i).getNo_perjalanan()==nomer){
                return daftarPerjalanan.get(i);
            }
        }
        return null;
    }
        
    public void deletePelanggan(Pelanggan p){
        daftarPelanggan.remove(p);
    }
    
    public void menuDaftarPelanggan(){
        System.out.println("Daftar Pelanggan : ");
        for (int i=0; i < daftarPelanggan.size(); i++){
            System.out.println(i+1+". "+daftarPelanggan.get(i));
        }
    }
    
    
    //====Method inserting Pelanggan==
   
    public void menuInsertPelanggan(){
        do{
            System.out.println("Input Pelanggan Baru :");
            System.out.println("No Identitas : ");
            noIdentitasPelanggan= inputString.nextLine();
            if (searchPelanggan(noIdentitasPelanggan)!=null){
                System.out.println("Pelanggan Telah Terdaftar");
            }
        }while(searchPelanggan(noIdentitasPelanggan)!=null);
        System.out.println("Nama Pelanggan  :");
        namaPelanggan = inputString.nextLine();
        System.out.println("Alamat Pelanggan :");
        alamatPelanggan = inputString.nextLine();
        System.out.println("No Handphone : ");
        noHpPelanggan = inputString.nextLine();
        addPelanggan(namaPelanggan,noIdentitasPelanggan,alamatPelanggan,noHpPelanggan);
        System.out.println("Data Terupdate");
    }
    
    public void menuEditPelanggan(){
       Pelanggan p;
       do{
            System.out.println("Edit Pelanggan :");
            System.out.println("No Identitas : ");
            noIdentitasPelanggan= inputString.nextLine();
            p=searchPelanggan(noIdentitasPelanggan);
            if (p==null){
                System.out.println("Data Pelanggan tidak ada");
            }
        }while(p == null);
        System.out.println("Nama "+ p.getNama());
        System.out.print("Nama Baru : ");
        namaPelanggan = inputString.nextLine();
        p.setNama(namaPelanggan);
        System.out.println("No Identitas "+ p.getNoIdentitas());
        System.out.print("No Identitas baru : ");
        noIdentitasPelanggan = inputString.nextLine();
        p.setNoIdentitas(noIdentitasPelanggan);
        System.out.println("Alamat : "+p.getAlamat());
        System.out.print("Alamat baru : ");
        alamatPelanggan = inputString.nextLine();
        p.setAlamat(alamatPelanggan);
        System.out.println("No Handphone : "+p.getNoHp());
        System.out.print("no Handphone baru : ");
        noHpPelanggan = inputString.nextLine();
        p.setNoHp(noHpPelanggan);
        System.out.println("Pelanggan telah di update");
    }
    
    public void menuDeletePelanggan(){
        Pelanggan p=null;
        do{
            System.out.println("Hapus Pelanggan :");
            System.out.println("No Identitas : ");
            noIdentitasPelanggan= inputString.nextLine();
            p=searchPelanggan(noIdentitasPelanggan);
            if (p==null){
                System.out.println("Data Pelanggan tidak ada");
            }
        }while(p == null);
        daftarPelanggan.remove(p);
        System.out.println("Data Pelanggan Telah dihapus");
    }
    
    //=====TempatWisata=========
    
    public void addTempatWisata(String namaTempat,String lokasi){
        TempatWisata tw = new TempatWisata(namaTempat,lokasi);
        daftarTempatWisata.add(tw);
    }
    
    public TempatWisata searchTempatWisata(String namaTempat,String lokasi){
        for (int i = 0; i < daftarTempatWisata.size(); i++) {
            if ((daftarTempatWisata.get(i).getNamaTempat().equals(namaTempat)) && (daftarTempatWisata.get(i).getLokasi().equals(lokasi))) {
                return daftarTempatWisata.get(i);
            }}
            return null;
    }   
        
    public void delete(TempatWisata tw){
        daftarTempatWisata.remove(tw);
    }
    
    public void menuDaftarTempatWisata(){
        for (int i=0; i < daftarTempatWisata.size(); i++){
            System.out.println(i+1+". "+daftarTempatWisata.get(i));
        }
    }
    
    //====insertTempatWisata==
    public void menuInsertTempatWisata(){
        do{
            System.out.println("Tempat Wisata Baru ");
            System.out.print("Nama tempat :");
            namaTempat = inputString.nextLine();
            System.out.print("Lokasi : ");
            lokasi = inputString.nextLine();
            if (searchTempatWisata(namaTempat,lokasi) != null){
                System.out.println("Data Tempat Sudah Ada");
            }
        }while(searchTempatWisata(namaTempat,lokasi)!=null);
        addTempatWisata(namaTempat,lokasi);
        System.out.println("Data paket wisata berhasil ditambah");
    }
    
    public void menuDeleteTempatWisata(){
        TempatWisata tw = null;
        do{
            System.out.println("Hapus Tempat Wisata");
            System.out.print("Nama tempat :");
            namaTempat = inputString.nextLine();
            System.out.print("Lokasi : ");
            lokasi = inputString.nextLine();
            tw = searchTempatWisata(namaTempat,lokasi);
            if (tw == null){
                System.out.println("Data Tempat Tidak Ada");
            }
        }while (tw == null );
        daftarTempatWisata.remove(tw);
        System.out.println("Data Tempat Wisata Telah Terhapus");
    }
    
    
    //Method PaketWisata
    public void addPaketWisata(PaketWisata pw){
        daftarPaketWisata.add(pw);
    }
    
    public void addPaketWisata(String namaPaket,int max, double harga, int minimalKeberangkatan, int hari,TempatWisata[] tempatWisata){
        PaketWisata pw = new PaketWisata(namaPaket,max,harga,minimalKeberangkatan,hari);
        for (int i= 0; i<tempatWisata.length;i++){
            pw.addTempatWisata(tempatWisata[i]);
        }
        daftarPaketWisata.add(pw);
    }
    
    
    
    public PaketWisata searchPaketWisata(String namaPaket){
        for (int i = 0; i < daftarPaketWisata.size(); i++) {
            if (daftarPaketWisata.get(i).getNamaPaket().equals(namaPaket)) {
                return daftarPaketWisata.get(i);
            }}
            return null; 
    }
    
    public void deletePaketWisata(PaketWisata paketWisata){
        daftarPaketWisata.remove(paketWisata);
    }
    
    public void menuDaftarPaketWisata(){
        System.out.println("Daftar Paket Wisata :");
        for (int i=0; i < daftarPaketWisata.size(); i++){
            System.out.println("paket ke-"+(i+1));
            daftarPaketWisata.get(i).tampil();
        }
    }
    public void menuDeletePaketWisata(){
        PaketWisata pw=null;
        do{
            System.out.println("Hapus Paket Wisata ");
            System.out.println("Masukkan nama Paket Wisata: ");
            namaPaket = inputString.nextLine();
            pw=searchPaketWisata(namaPaket);
            if (pw==null){
                System.out.println("Data paket wisata tidak ada");
            }
        }while(pw == null);
        daftarPaketWisata.remove(pw);
        System.out.println("Data paket wisata telah dihapus");
    }
    
    //METHOD LOGIN
    public boolean login(String idPetugas, String Password){
        if((pt.getIdPetugas()==idPetugas)&&(pt.getPassword()==Password)){
            return true;
        }
        return false;
    }
    
    public void menuNewPaket(){
        try{
        System.out.println("Insert New Paket Wisata : ");
        System.out.print("Nama paket :");
        namaPaket=inputString.nextLine();
        System.out.print("Harga : ");
        harga=inputDouble.nextDouble();
        System.out.print("Lama hari : ");
        hari=inputInt.nextInt();
        System.out.print("Minimal orang :");
        minimalKeberangkatan=inputInt.nextInt();
        System.out.print("Jumlah Wisata :");
        max =inputInt.nextInt();
        TempatWisata[] tempatWisata =new TempatWisata[max];
        for (int i=0;i<max;i++){
           TempatWisata tw=null;
            do{
                System.out.println("Tempat ke-"+(i+1));
                System.out.print("Masukkan Nama Tempat : ");
                namaTempat=inputString.nextLine();
                System.out.print("Masukkan Nama Lokasi : ");
                lokasi=inputString.nextLine();
                tw = searchTempatWisata(namaTempat,lokasi);
                if (tw == null){
                    System.out.println("Tempat Wisata tidak ada ");
                }
            }while(tw == null);
            tempatWisata[i]=tw;
         }
        addPaketWisata(namaPaket,max,harga,minimalKeberangkatan,hari,tempatWisata);
        System.out.println("Paket Baru telah diupdate");
        }catch(Exception E){
            System.out.println("Format Input salah ");
            inputDouble.next();
            inputInt.next();
        }
     }
    public void menuEditPaketWisata(){
        PaketWisata pw1=null;
        do{
            System.out.println("Edit Paket Wisata");
            System.out.print("Nama Paket yang ingin di Edit :");
            namaPaket=inputString.nextLine();
            pw1=searchPaketWisata(namaPaket);
            if (pw1 == null){
                System.out.println("Data tidak ada ");
        }}while(pw1 == null);
        System.out.print("Nama paket :");
        namaPaket=inputString.nextLine();
        try{
        System.out.print("Harga : ");
        harga=inputDouble.nextDouble();
        System.out.print("Lama hari : ");
        hari=inputInt.nextInt();
        System.out.print("Minimal orang :");
        minimalKeberangkatan=inputInt.nextInt();
        System.out.print("Jumlah Wisata :");
        max =inputInt.nextInt();
        TempatWisata[] tempatWisata =new TempatWisata[max];
        for (int i=0;i<max;i++){
           TempatWisata tw=null;
            do{
                System.out.println("Tempat ke-"+(i+1));
                System.out.print("Masukkan Nama Tempat : ");
                namaTempat=inputString.nextLine();
                System.out.print("Masukkan Nama Lokasi : ");
                lokasi=inputString.nextLine();
                tw = searchTempatWisata(namaTempat,lokasi);
                if (tw == null){
                    System.out.println("Tempat Wisata tidak ada ");
                }
            }while(tw == null);
            tempatWisata[i]=tw;
        }
        pw1.setNamaPaket(namaPaket);
        pw1.setHarga(harga);
        pw1.setHari(hari);
        pw1.setMinimalKeberangkatan(minimalKeberangkatan);
        pw1.setDaftarTempatWisata(tempatWisata);
        System.out.println("Paket Wisata telah diupdate");   
        }catch(Exception E){
            System.out.println("Format Input Salah");
            inputDouble.next();
            inputInt.next();
        }
        inputString.nextLine();
    }
    
    //Method Perjalanan
    public void addPerjalanan(PaketWisata paketWisata,String tanggal,int max,Pelanggan[] pelanggan){
        Perjalanan pjln = new Perjalanan(paketWisata,tanggal,max);
        for (int i= 0; i<pelanggan.length;i++){
            pjln.addPelanggan(pelanggan[i]);
         };
         noPejln++;
         String npjln = String.valueOf(noPejln);
         pjln.setNo_perjalanan(npjln);
         daftarPerjalanan.add(pjln);
    }
    
    public void menuInsertPerjalanan(){
        try{
        System.out.println("Insert Jadwal Perjalanan");
        PaketWisata pw=null;
        do{
            System.out.print("Nama paket wisata :");
            namaPaket=inputString.nextLine();
            pw=searchPaketWisata(namaPaket);
            if(pw == null){
                System.out.println("nama paket wisata tidak ada");
            }
         
        }while(pw == null);
        System.out.print("Tanggal  (format YYYY-MM-DD) : ");
        tgl=inputString.nextLine();
        //LocalDate date1 = LocalDate.parse(tgl, formatter);
        //date=date1;
        System.out.print("Jumlah Pelanggan : ");
        max=inputInt.nextInt();
        Pelanggan[] pelanggan = new Pelanggan[max];
        for (int i=0;i<max;i++){
           Pelanggan p=null;
            do{
                System.out.println("Pelanggan ke-"+(i+1));
                System.out.print("Masukkan No Identitas : ");
                noIdentitasPelanggan=inputString.nextLine();
                p = searchPelanggan(noIdentitasPelanggan);
                if (p == null){
                    System.out.println("Pelanggan tidak ada ");
                }
            }while(p == null);
            pelanggan[i]=p;
        }
        addPerjalanan(pw,tgl,max,pelanggan);
        System.out.println("Jadwal Perjalanan telah diupdate");
        } catch(DateTimeParseException e){
            System.out.println("Tanggal Tidak Sesuai dengan format");
        }
    }
    
    public void menuViewPerjalanan(){
        System.out.println("Daftar Perjalanan :");
        for (int i=0; i<daftarPerjalanan.size();i++){
            System.out.println("Perjalanan ke-"+i+1+" : ");
            daftarPerjalanan.get(i).tampil();
            System.out.println();
        }
    }
    
    int pil;
    Scanner s = new Scanner(System.in);
    
    public void MenuPelanggan() /*throws InterruptedException*/{
        System.out.println("Menu Pelanggan");
        System.out.println();
        System.out.println("1.Insert Pelanggan");
        System.out.println("2.Edit Pelanggan");
        System.out.println("3.Delete Pelanggan");
        System.out.println("4.Daftar Pelanggan");
        System.out.println("5. Kembali ke menu utama");
        try{
        pil = s.nextInt();
        switch(pil){
            case 1:
                menuInsertPelanggan();
                break;
            case 2:
                menuEditPelanggan();
                break;
            case 3:
                menuDeletePelanggan();
                break;
            case 4:
                menuDaftarPelanggan();
                break;
            case 5:
                menuUtama();
                break;
            default:
                System.out.println("Salah input");
                inputString.nextLine();
                MenuPelanggan();     
        }
        }catch(Exception e){
            System.out.println("Salah Input ");
            s.next(); 
         }
        inputString.nextLine();
        MenuPelanggan();
}
    
    public void MenuTempatWisata() /*throws InterruptedException*/{
        System.out.println("Menu Tempat Wisata");
        System.out.println();
        System.out.println("1.Insert Tempat Wisata");
        System.out.println("3.Delete Tempat Wisata");
        System.out.println("3.Daftar Tempat Wisata");
        System.out.println("4. Kembali ke menu utama");
        try{
        pil = s.nextInt();
        switch(pil){
            case 1:
                menuInsertTempatWisata();
                break;
            case 2:
                menuDeleteTempatWisata();
                break;
            case 3:
                menuDaftarTempatWisata();
                break;
            case 4:
                menuUtama();
                break;
            default:
                System.out.println("Salah input");
                inputString.nextLine();
                MenuTempatWisata();
                
    }
        MenuTempatWisata();
     } catch(Exception e){
            System.out.println("Salah Input ");
            s.next(); 
         }
        inputString.nextLine();
        MenuTempatWisata();
}
    public void MenuPaketWisata() /*throws InterruptedException*/{
        System.out.println("Menu Paket Wisata");
        System.out.println();
        System.out.println("1.New Paket");
        System.out.println("2.Edit Paket");
        System.out.println("3.Delete Paket");
        System.out.println("4.Daftar Paket");
        System.out.println("5. Kembali ke menu utama");
        try{
        pil = s.nextInt();
        switch(pil){
            case 1:
                menuNewPaket();
                break;
            case 2:
                menuEditPaketWisata();
                break;
            case 3:
                menuDeletePaketWisata();
                break;
            case 4:
                menuDaftarPaketWisata();
                break;
            case 5:
                menuUtama();
                break;
            default:
                System.out.println("Salah input");
                inputString.nextLine();
                MenuPaketWisata();
    }
    } catch(Exception e){
            System.out.println("Salah Input ");
            s.next(); 
      }
        inputString.nextLine();
        MenuPaketWisata();
}
 public void MenuJadwalPerjalanan() /*throws InterruptedException*/{
        System.out.println("Menu Jadwal Perjalanan");
        System.out.println();
        System.out.println("1.Insert");
        System.out.println("2.View");
        System.out.println("3. Kembali ke menu utama");
        try{
        pil = s.nextInt();
        switch(pil){
            case 1:
                menuInsertPerjalanan();
                break;
            case 2:
                menuViewPerjalanan();
                break;
            case 3:
                menuUtama();
                break;
            default:
                System.out.println("Salah input");
                inputString.nextLine();
                MenuJadwalPerjalanan();
        }
        } catch(Exception e){
            System.out.println("Salah Input ");
            s.next(); 
         }
        inputString.nextLine();
        MenuJadwalPerjalanan();
    }   
 public void menuUtama() {
     System.out.println("Menu");
     System.out.println();
     System.out.println("1. Pelanggan");
     System.out.println("2. Tempat Wisata");
     System.out.println("3. Paket Wisata");
     System.out.println("4. Jadwal Perjalanan");
     System.out.println("5. Exit");
     try{
         pil = s.nextInt();
            switch(pil){
                case 1:
                    MenuPelanggan();
                    break;
                case 2:
                    MenuTempatWisata();
                    break;
                case 3:
                    MenuPaketWisata();
                    break;
                case 4:
                    MenuJadwalPerjalanan();
                    break;
                case 5:
                    break;
                default:
                    break;    
            }
        } catch(Exception e){
            System.out.println("Salah Input ");
            s.next(); 
         }
        inputString.nextLine();
        menuUtama();   
    }
}