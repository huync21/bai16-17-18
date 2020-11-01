/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Bai18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<MonHoc> list=new ArrayList<>();
        Scanner s=null;
        try {
             s=new Scanner(new File("MH.INP"));
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
        while(s.hasNextLine()){
            int count=0;
            try {
                MonHoc m=new MonHoc();
                count++;
                m.setMaMon(Integer.parseInt(s.nextLine()));
                count++;
                m.setTenMon(s.nextLine());
                count++;
                m.setNhomMon(s.nextLine());
                count++;
                m.setSoTinchi(Integer.parseInt(s.nextLine()));
                list.add(m);
            } catch (maMonException ex) {
                System.out.println(ex);
            } catch (tenMonException ex) {
                System.out.println(ex);
            } catch (nhomMonException ex) {
                System.out.println(ex);
            } catch (soTinChiException ex) {
                System.out.println(ex);
            }
            catch(Exception e){
                
            }
        }
        
        
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        
        Collections.sort(list, new Comparator<MonHoc>(){
            @Override
            public int compare(MonHoc o1, MonHoc o2) {
               if(o1.getSoTinchi()<o2.getSoTinchi()) return 1;
               else if(o1.getSoTinchi()==o2.getSoTinchi()) return 0;
               else return -1;
            }
            
        });
        
        try {
            PrintStream ps=new PrintStream(new File("SX.OUT"));
            for(int i=0;i<list.size();i++){
            ps.println(list.get(i));
        }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
        Collections.sort(list, new Comparator<>(){
            @Override
            public int compare(MonHoc o1, MonHoc o2) {
               return o1.getTenMon().compareTo(o2.getTenMon());
               
            }
            
        });
        
        try {
            PrintStream ps=new PrintStream(new File("NHOM.OUT"));
            ps.println("----------------------------------");
            ps.println("Co ban:");
            for(int i=0;i<list.size();i++){
                if(list.get(i).getNhomMon().equalsIgnoreCase("Cơ bản"))
                ps.println(list.get(i));
            }
            
             ps.println("----------------------------------");
            ps.println("CO so nganh:");
            for(int i=0;i<list.size();i++){
                if(list.get(i).getNhomMon().equalsIgnoreCase("cơ sở ngành"))
                ps.println(list.get(i));
            }
             ps.println("----------------------------------");
            ps.println("Chuyen nganh:");
            for(int i=0;i<list.size();i++){
                if(list.get(i).getNhomMon().equalsIgnoreCase("chuyên ngành"))
                ps.println(list.get(i));
            }
             ps.println("----------------------------------");
            ps.println("Ky nang mem:");
            for(int i=0;i<list.size();i++){
                if(list.get(i).getNhomMon().equalsIgnoreCase("kỹ năng mềm"))
                ps.println(list.get(i));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
    
}
