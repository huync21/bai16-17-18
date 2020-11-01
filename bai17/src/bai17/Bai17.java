
package bai17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bai17 {

    
    public static void main(String[] args) {
        ArrayList<Sach> list=new ArrayList<>();
        Scanner s=null;
        try {
             s=new Scanner(new File("SACH.INP"));
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
          }
        
        while(s.hasNextLine()){
            int count=0;
            try {
                Sach sach=new Sach();
                count++;
                sach.setMaSach(Integer.parseInt(s.nextLine()));
                count++;
                sach.setTenSach(s.nextLine());
                count++;
                sach.setChuyenNganh(s.nextLine());
                count++;
                sach.setGiaBan(Double.parseDouble(s.nextLine()));
                list.add(sach);
            } catch (maSachExeption ex) {
                System.out.println(ex);
            } catch (tenSachExeption ex) {
                System.out.println(ex);
            } catch (chuyenNganhExeption ex) {
                System.out.println(ex);
            } catch (giaBanExeption ex) {
                System.out.println(ex);
            }
            catch(Exception ex){
                System.out.println(ex);
            }
            
            if(count<4){
                for(int i=1;i<=4-count;i++){
                    if(s.hasNextLine())
                        s.nextLine();
                }
            }
        }
        
        //2 
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        
        //3 
        Collections.sort(list,new Comparator<Sach>(){
            @Override
            public int compare(Sach o1, Sach o2) {
                if(o1.getGiaBan()<o2.getGiaBan()) return 1;
                else if(o1.getGiaBan()==o2.getGiaBan()) return 0;
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
        
        //4
        Collections.sort(list, new Comparator<Sach>(){
            @Override
            public int compare(Sach o1, Sach o2) {
               return o1.getTenSach().compareTo(o2.getTenSach());
            }
            
        });
        
        try {
            PrintStream ps=new PrintStream(new File("CN.OUT"));
            ps.println("-------------------------------------");
            ps.println("Giáo khoa");
            for(int i=0;i<list.size();i++){
                if(list.get(i).getChuyenNganh().equals("Giáo khoa")){
                    ps.println(list.get(i));
                }
            }
            
             ps.println("-------------------------------------");
            ps.println("Văn học");
            for(int i=0;i<list.size();i++){
                if(list.get(i).getChuyenNganh().equals("Văn học")){
                    ps.println(list.get(i));
                }
            }
            
             ps.println("-------------------------------------");
            ps.println("Kỹ thuật");
            for(int i=0;i<list.size();i++){
                if(list.get(i).getChuyenNganh().equals("Kỹ thuật")){
                    ps.println(list.get(i));
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
       
    }
    
}
