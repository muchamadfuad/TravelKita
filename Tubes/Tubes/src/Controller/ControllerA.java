/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.objects.NativeObject;
import view.*;
import model.*;
/**
 *
 * @author fuad,hani,lenni
 */

 
public class ControllerA extends MouseAdapter implements ActionListener{
    private Aplikasi model;
    
    private MainMenu mMenu;
    private mnInsertJadwalPerjalanan IJp;
    private mnDaftarPerjalanan dperjalanan;
    private mnInsertPaketWisata ipaket;
    private mnInsertPaketWisataTW ipaketTW;
    private mnDeletePaketWisata delPaket;
    private mnEditPaketWisata EPWis;
    private mnEditPaketWisata2 EPWis2;
    private mnDaftarPaketWisata DPwis;
    private mnInsertTempatWisata ITp;
    private mnDeleteTempatWisata delTP;
    private mnDaftarTempatWisata dafTP;
    private mnInsertPelanggan inPel;
    private mnDaftarPelanggan dafPel;
    private mnDeletePelanggan delPel;
    private mnEditPelanggan EPel;
    private mnEditPelanggan2 EPel2;
    private mnInsertJadwalPerjalanAP IJp2;
    
    private String tmpString;
    private Pelanggan tmpPel;
    private PaketWisata tmpPktWis,tmpPktWis2;
    private TempatWisata[] tmptWisArray;
    private Pelanggan[] ArrayPelanggan;
    private Integer tmpint;
    private Integer tmpintWis;
    private Perjalanan tmpPerjalanan;
    DefaultTableModel tabelModel;
    DefaultTableModel tabelModel2;
    
 
    private String currentView;
    private JPanel mainpanel;

    public ControllerA(Aplikasi model) {
        this.model = model;
        this.mMenu= new MainMenu();
        
        
        IJp = new mnInsertJadwalPerjalanan();
        dperjalanan = new mnDaftarPerjalanan();
        ipaket = new mnInsertPaketWisata();
        delPaket = new mnDeletePaketWisata();
        EPWis = new mnEditPaketWisata();
        EPWis2 = new mnEditPaketWisata2();
        DPwis = new mnDaftarPaketWisata();
        ITp = new mnInsertTempatWisata();
        delTP = new mnDeleteTempatWisata();
        dafTP = new mnDaftarTempatWisata();
        inPel = new mnInsertPelanggan();
        dafPel = new mnDaftarPelanggan();
        delPel = new mnDeletePelanggan();
        EPel = new mnEditPelanggan();
        EPel2 = new mnEditPelanggan2();
        ipaketTW = new mnInsertPaketWisataTW();
        IJp2 = new mnInsertJadwalPerjalanAP();
//        IJp.addListener(this);
       /*dperjalanan.addListener(this);
       
        
        EPWis.addListener(this);
       
        DPwis.addListener(this);
        dafTP.addListener(this);
        */
        dperjalanan.addAdapter(this);
        IJp.addListener(this);
        IJp2.addListener(this);
        EPWis.addListener(this);
        EPWis2.addListener(this);
        delPaket.addListener(this);
        ipaketTW.addListener(this);
        DPwis.addAdapter(this);
        ipaket.addListener(this);
        delPel.addListener(this);
        mMenu.addListener(this);
        delTP.addListener(this);
        ITp.addListener(this);
        inPel.addListener(this);
        EPel.addListener(this);
        EPel2.addListener(this);
        delPel.addListener(this);
        
        
        mainpanel = mMenu.getjPanel1();
        mainpanel.add(IJp, "1");
        mainpanel.add(dperjalanan,"2");
        mainpanel.add(ipaket,"3");
        mainpanel.add(delPaket,"4");
        mainpanel.add(EPWis,"5");
        mainpanel.add(EPWis2 ,"6");
        mainpanel.add(DPwis, "7");
        mainpanel.add(ITp, "8");
        mainpanel.add(delTP, "9");
        mainpanel.add(dafTP, "10");
        mainpanel.add(inPel, "11");
        mainpanel.add(dafPel, "12");
        mainpanel.add(delPel, "13");
        mainpanel.add(EPel, "14");
        mainpanel.add(EPel2, "15");
        mainpanel.add(ipaketTW,"16");
        mainpanel.add(IJp2, "17");
        currentView = "1";
        
        mMenu.getCardLayout().show(mainpanel,currentView);
        mMenu.setVisible(true);
        mMenu.addListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(mMenu.getMnInsertJadwalPerjalanan())){
            currentView = "1";
            mMenu.getCardLayout().show(mainpanel, currentView);
        }else if (source.equals(mMenu.getMnViewJadwalPerjalanan())){
            currentView = "2";
            dperjalanan.setListPerjalanan(model.getListPerjalanan());
            mMenu.getCardLayout().show(mainpanel, currentView);
        }else if (source.equals(mMenu.getMnNewPaket())){
            currentView = "3";
            mMenu.getCardLayout().show(mainpanel, currentView);    
        }else if (source.equals(mMenu.getMnDeletePaket())){
            currentView="4";
            mMenu.getCardLayout().show(mainpanel,currentView);
        }else if (source.equals(mMenu.getMnEditPaket())){
            currentView="5";
            mMenu.getCardLayout().show(mainpanel,currentView);
        }else if (source.equals(mMenu.getMnDaftarPaket())){
            DPwis.setListPaketWisata(model.getListPaketWisata());
            currentView="7";
            mMenu.getCardLayout().show(mainpanel, currentView);
        }else if (source.equals(mMenu.getMnInsertTempatWisata())){
            currentView="8";
            mMenu.getCardLayout().show(mainpanel, currentView);
        }else if (source.equals(mMenu.getMnDeleteTempatWisata())){
            currentView="9";
            mMenu.getCardLayout().show(mainpanel, currentView);
        }else if (source.equals(mMenu.getMnDaftarTempatWisata())){
            currentView="10";
            mMenu.getCardLayout().show(mainpanel, currentView);
        }else if (source.equals(mMenu.getMnInsertPelanggan())){
            currentView="11";
            mMenu.getCardLayout().show(mainpanel, currentView);
        }else if (source.equals(mMenu.getMnDaftarPelanggan())){
            currentView = "12";
            mMenu.getCardLayout().show(mainpanel, currentView);
        }else if (source.equals(mMenu.getMnDeletePelanggan())){
            currentView = "13";
            mMenu.getCardLayout().show(mainpanel, currentView);
        }else if (source.equals(mMenu.getMnEditPelanggan())){
            currentView = "14";
            mMenu.getCardLayout().show(mainpanel, currentView);
        }
     
        if (currentView.equals("1")){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            if(source.equals(IJp.getSelanjutnya())) {
                PaketWisata pw = model.searchPaketWisata(IJp.getPaketWisata());
                try{
                if((pw == null ) || (IJp.getTanggal().equals(""))){
                    IJp.insertJadwalPerjalanan1gagal();
                }else{   
                    //LocalDate date1 = LocalDate.parse(IJp.getTanggal(), formatter);
                    tmpPerjalanan = new Perjalanan(tmpPktWis,IJp.getTanggal(),999);    
                    currentView="17";   
                    mMenu.getCardLayout().show(mainpanel,"17");
                    String nmKolom [] = {"No Identitas", "Nama"};
                    tabelModel = new javax.swing.table.DefaultTableModel(null, nmKolom);
                    for (Pelanggan x : model.getDaftarPelanggan()){
                        String nama = x.getNama();
                        String no_identitas = x.getNoIdentitas();
                        tabelModel.addRow(new String []{no_identitas,nama});
                    }
                    IJp2.getDaftarPelanggan().setModel(tabelModel);
                    ArrayPelanggan = null;
                    tmpint = 0;
                    tabelModel2 = new javax.swing.table.DefaultTableModel(null, nmKolom);    
                }}catch(Exception e){
                    
                }
                
            }
        }else if (currentView.equals("2")){
            
        }else if (currentView.equals("3")){
            if(source.equals(ipaket.getKonfirmasi())){
                try{
                if(ipaket.getBiaya().equals("") || ipaket.getKuota().equals("") || ipaket.getLamahari().equals("") || ipaket.getNama()
                        .equals("")){
                    
                }else{
                double biaya =Double.parseDouble(ipaket.getBiaya());
                int kuota =Integer.parseInt(ipaket.getKuota());
                int lamahari = Integer.parseInt(ipaket.getLamahari());
                tmpPktWis = new PaketWisata(ipaket.getNama() ,100,biaya,kuota,lamahari);
                String nmKolom [] = {"Nama Tempat","Lokasi"};
                tabelModel = new javax.swing.table.DefaultTableModel(null,nmKolom);
                for (TempatWisata x : model.getDaftarTempatWisata()){
                    String nama = x.getNamaTempat();
                    String lokasi = x.getLokasi();
                    tabelModel.addRow(new String[]{nama,lokasi});
                }
                ipaketTW.getDaftarTempat().setModel(tabelModel);
                tmptWisArray = new TempatWisata[100];
                tmpintWis =0;
                currentView ="16";
                mMenu.getCardLayout().show(mainpanel, currentView);
                }}catch(Exception e){
                 ipaket.insertPWgagal();
            }
            }      
        }else if (currentView.equals("4")){
            try {
                if (source.equals(delPaket.getHapus())) {
                    if (model.searchPaketWisata(delPaket.getNamapaket()) == null) {
                        delPaket.deletePwgagal();
                    } else {
                        model.deletePaketWisata(model.searchPaketWisata(delPaket.getNamapaket()));
                        delPaket.setNamapaket("");
                        delPaket.deletePwberhasil();
                    }
                }
            } catch (Exception e) {

            }
        }else if (currentView.equals("5")){
           if(source.equals(EPWis.getCari())){
              tmpPktWis2 = model.searchPaketWisata(EPWis.getNamaPaket());              
              try{
              if (tmpPktWis2 != null) {
                  String harga = Double.toString(tmpPktWis2.getHarga());
                  String lamahari = Integer.toString(tmpPktWis2.getHari());
                  String jum = Integer.toString(tmpPktWis2.getMinimalKeberangkatan());
                  EPWis2.setKuota(jum);
                  EPWis2.setLamahari(lamahari);
                  EPWis2.setBiaya(harga);
                  EPWis2.setNamaPkt(tmpPktWis2.getNamaPaket());
                  currentView="6";
                  mMenu.getCardLayout().show(mainpanel,currentView);
              }else{
                  EPWis.searchPWgagal();
              }
           }catch(Exception e){
               
           }
           }
        }else if (currentView.equals("6")){
            if (source.equals(EPWis2.getSelesai())){
                if (EPWis2.getBiaya().equals("")||EPWis2.getKuota().equals("")||EPWis2.getLamahari().equals("")||EPWis2.getNamaPkt().equals("")){
                    EPWis2.editPWgagal();
                }else{
                try{
                double biaya =Double.parseDouble(EPWis2.getBiaya());
                int kuota =Integer.parseInt(EPWis2.getKuota());
                int lamahari = Integer.parseInt(EPWis2.getLamahari());
                model.deletePaketWisata(tmpPktWis2);
                tmpPktWis2.setNamaPaket(EPWis2.getNamaPkt());
                tmpPktWis2.setHarga(biaya);
                tmpPktWis2.setMinimalKeberangkatan(kuota);
                tmpPktWis2.setHari(lamahari);
                model.addPaketWisata(tmpPktWis2);
                currentView="5";
                mMenu.getCardLayout().show(mainpanel,currentView);
                tmpPktWis2=null;
                EPWis.setNamaPaket("");
                EPWis2.editPWberhasil();
                }catch(Exception e){
                    EPWis2.editPWgagal();
                }}
            }
        }else if (currentView.equals("7")){
            
        }else if (currentView.equals("8")){
            if (source.equals(ITp.getKonfirmasi())){
                try{
                if (ITp.getNamatempat().equals("")||ITp.getLokasi().equals("")){
                    ITp.insertTWgagal();
                }else{
                model.addTempatWisata(ITp.getNamatempat(), ITp.getLokasi());
                ITp.setNamatempat("");
                ITp.setLokasi("");
                ITp.insertTWberhasil();
                }}catch(Exception e){
                    
                }}
        }else if (currentView.equals("9")){
            if (source.equals(delTP.getDelete())){
                try{
                if (model.searchTempatWisata(delTP.getNamaTempat(), delTP.getLokasi()) != null){
                    model.delete(model.searchTempatWisata(delTP.getNamaTempat(), delTP.getLokasi()));
                    delTP.deleteTWberhasil();
                }else{
                    delTP.deleteTWgagal();
                }}catch(Exception e){
                      
            }}
        }else if (currentView.equals("10")){
            String nmKolom [] = {"Nama Tempat","Lokasi"};
            tabelModel = new javax.swing.table.DefaultTableModel(null,nmKolom);
            for (TempatWisata x : model.getDaftarTempatWisata()){
                String nama = x.getNamaTempat();
                String lokasi = x.getLokasi();
                tabelModel.addRow(new String[]{nama,lokasi});
            }
            dafTP.getTabelTempat().setModel(tabelModel);
        }else if (currentView.equals("11")){
            if (source.equals(inPel.getKonfirmasi())) {
                try {
                    if (inPel.getNama().equals("") || (inPel.getNo_identitas().equals("") || (inPel.getAlamat().equals("")) || (inPel.getNo_hp().equals("")))) {
                        inPel.insertPelgagal();
                    } else {
                        model.addPelanggan(inPel.getNama(), inPel.getNo_identitas(), inPel.getAlamat(), inPel.getNo_hp());
                        inPel.setNo_identitas("");
                        inPel.setAlamat("");
                        inPel.setNama("");
                        inPel.setNo_hp("");
                        inPel.insertPelberhasil();
                    }
                } catch (Exception ex) {
                    System.out.println("error");
                }
            }
        }else if (currentView.equals("12")){
            String nmKolom [] = {"Nama","No Identitas","Alamat","No HP"};
            tabelModel = new javax.swing.table.DefaultTableModel(null, nmKolom);
            for (Pelanggan x : model.getDaftarPelanggan()){
                String nama = x.getNama();
                String noIdentitas = x.getNoIdentitas();
                String alamat = x.getAlamat();
                String noHp = x.getNoHp();
                tabelModel.addRow(new String []{nama,noIdentitas,alamat,noHp});
            }
            dafPel.getTabel().setModel(tabelModel);
        }else if (currentView.equals("13")){
            if (source.equals(delPel.getDelete())) {
                    try{
                    if (model.searchPelanggan(delPel.getNo_identitas())!=null) {
                        delPel.deletepelanggangagal();
                    } else {
                        try{
                        model.deletePelanggan(model.searchPelanggan(delPel.getNo_identitas()));
                        delPel.setNo_identitas("");
                        delPel.deletepelangganberhasil();
                        }catch (Exception e) {
                    }}}catch(Exception e){} 
                
                  
            }
            
        }else if (currentView.equals("14")){
            if (source.equals(EPel.getCari())){
                tmpString = EPel.getNo_identitas();
                EPel.setNo_identitas("");
                tmpPel = model.searchPelanggan(tmpString);
                if (model.searchPelanggan(tmpString) != null){
                    currentView = "15";
                    EPel2.setNama(model.searchPelanggan(tmpString).getNama());
                    EPel2.setNo_identitas(model.searchPelanggan(tmpString).getNoIdentitas());
                    EPel2.setAlamat(model.searchPelanggan(tmpString).getAlamat());
                    EPel2.setNo_hp(model.searchPelanggan(tmpString).getNoHp());
                    mMenu.getCardLayout().show(mainpanel, currentView);
                }
                else{
                    EPel.searchPelgagal();}
            }
        }else if (currentView.equals("15")){              
            if (source.equals(EPel2.getKonfirmasi())) {
                try{
                if (EPel2.getNama().equals("") || (EPel2.getNo_identitas().equals("")) || (EPel2.getAlamat().equals("")) || (EPel2.getNo_hp().equals(""))) {
                    EPel2.editPelgagal();
                } else {
                    model.EditPelanggan(tmpPel, EPel2.getNama(), EPel2.getNo_identitas(), EPel2.getAlamat(), EPel2.getNo_hp());
                    EPel2.setNama("");
                    EPel2.setAlamat("");
                    EPel2.setNo_hp("");
                    EPel2.setNo_identitas("");
                    EPel2.editPelberhasil();
                }
            }catch(Exception e){
                
            }

        }else if (currentView.equals("16")){
            String nmKolom [] = {"Nama Tempat","Lokasi"};
            tabelModel = new javax.swing.table.DefaultTableModel(null,nmKolom);
            for (TempatWisata x : model.getDaftarTempatWisata()){
                String nama = x.getNamaTempat();
                String lokasi = x.getLokasi();
                tabelModel.addRow(new String[]{nama,lokasi});
            }
            ipaketTW.getDaftarTempat().setModel(tabelModel);
            
            if(source.equals(ipaketTW.getAdd())){
                TempatWisata tw = model.searchTempatWisata(ipaketTW.getNama(), ipaketTW.getLokasi());
                try{
                if (tw != null){
                    tmptWisArray[tmpintWis]=tw;
                    tmpintWis =tmpintWis+1;
                }else{
                    ipaketTW.insertPW1gagal();
                }}catch(Exception E){
                    
                }
                ipaketTW.setNama("");
                ipaketTW.setLokasi("");
                DefaultTableModel tabelModel2 = new javax.swing.table.DefaultTableModel(null,nmKolom);
                for (int i = 0;i<tmptWisArray.length;i++){
                if (tmptWisArray[i] != null){
                    String nama = tmptWisArray[i].getNamaTempat();
                    String lokasi = tmptWisArray[i].getLokasi();
                    tabelModel2.addRow(new String[]{nama,lokasi});
                }
            }
            ipaketTW.getTempatDipilih().setModel(tabelModel2);
                
            }
            if(source.equals(ipaketTW.getSelesai())){
                tmpPktWis.setDaftarTempatWisata(tmptWisArray);
                model.addPaketWisata(tmpPktWis);
                DPwis.setListPaketWisata(model.getListPaketWisata());
                currentView ="7";
                mMenu.getCardLayout().show(mainpanel,currentView);
                ipaketTW.insertPW1sukses();
            }
        }else if (currentView.equals("17")){
            if (source.equals(IJp2.getAdd())){
                String identitas =IJp2.getNo_identitas();
                try{
                if (model.searchPelanggan(identitas)!=null){
                    Pelanggan pel = model.searchPelanggan(identitas);
                    tmpPerjalanan.addPelanggan(pel);                
                    String noIdentitas = pel.getNoIdentitas();
                    String nama = pel.getNama();
                    tabelModel2.addRow(new String[]{noIdentitas,nama});
                    IJp2.getDaftarDipilih().setModel(tabelModel2);
                    IJp2.setNoIdentitas("");
                }else{
                    IJp2.insertJadwalgagal();
                }}catch(Exception E){
                    
                }   
            }else if (source.equals(IJp2.getSelesai())){
                model.addPerjalanan(tmpPerjalanan);
                tmpPerjalanan=null;
                currentView="1";
                mMenu.getCardLayout().show(mainpanel,currentView);
                IJp2.insertJadwalBerhasil();
            }
        }
    }}
    
    @Override
    public void mousePressed(MouseEvent e) {
        if (currentView.equals("7")) {
            String namaPkt = DPwis.getListPaketWisata();
            if (namaPkt != null) {
                PaketWisata pkt = model.searchPaketWisata(namaPkt);
               
                String harga = Double.toString(pkt.getHarga());
                String lamahari = Integer.toString(pkt.getHari());
                String jum = Integer.toString(pkt.getMinimalKeberangkatan());
                DPwis.setHarga(harga);
                DPwis.setLamahari(lamahari);
                DPwis.setNamapaket(pkt.getNamaPaket());
                DPwis.setMinimalorang(jum);
                
                String nmKolom [] = {"Nama Tempat","Lokasi"};
                DefaultTableModel tabelModel = new javax.swing.table.DefaultTableModel(null,nmKolom);
                
                for (TempatWisata x : pkt.getTempatWisatas()){
                    if(x != null){
                    String nama =x.getNamaTempat(); //pkt.getTempatWisata(i).getNamaTempat();
                    String lokasi =x.getLokasi(); //pkt.getTempatWisata(i).getLokasi();
                    tabelModel.addRow(new String[]{nama,lokasi});
                    }
                }
                DPwis.getDaftarTabel().setModel(tabelModel);  
            }
        }if (currentView.equals("2")){
            String nomer = dperjalanan.getListPaketWisata();
            if  (nomer != null){
                 Perjalanan p = model.searchPerjalanan(nomer);
                 String harga = Double.toString(p.hitungHarga());
                 dperjalanan.setNamaPaket(p.getPaketWisata().getNamaPaket());
                 dperjalanan.setHarga(harga);
                 dperjalanan.setTglPaket(p.getTanggal());
                 
                 String nmKolom [] = {"Nama","No Identitas","No Hp","Alamat"};
                 tabelModel = new javax.swing.table.DefaultTableModel(null,nmKolom);
                
                 for (int i = 0;i<p.getJumlah();i++){
                    String nama = p.getPelanggan(i).getNama();
                    String lokasi = p.getPelanggan(i).getNoIdentitas();
                    String no_hp = p.getPelanggan(i).getNoHp();
                    String alamat = p.getPelanggan(i).getAlamat();
                    tabelModel.addRow(new String[]{nama,lokasi,no_hp,alamat});
                 }
                 dperjalanan.getDaftarPelanggan().setModel(tabelModel);  
            }
                 
            }
        }
}

    
