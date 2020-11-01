
package javaapplication69;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JavaApplication69 {

    
    public static void main(String[] args) {
        //1
        ArrayList<MatHang> list=new ArrayList<>();
        Scanner s=null;
        try {
            s=new Scanner(new File("MH.INP"));
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
        while(s.hasNextLine()){
            int count=0;
            try {
                MatHang mh=new MatHang();
                count++;
                mh.setMaHang(Integer.parseInt(s.nextLine()));
                count++;
                mh.setTen(s.nextLine());
                count++;
                mh.setNhom(s.nextLine());
                count++;
                mh.setGiaBan(Double.parseDouble(s.nextLine()));
                list.add(mh);
            } catch (maHangException ex) {
                System.out.println(ex);
            } catch (tenException ex) {
                System.out.println(ex);
            } catch (nhomException ex) {
                System.out.println(ex);
            } catch (giaBanException ex) {
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
        Collections.sort(list, new Comparator<MatHang>(){
            @Override
            public int compare(MatHang o1, MatHang o2) {
                if(o1.getGiaBan()<o2.getGiaBan()) return 1;
                else if(o1.getGiaBan()== o2.getGiaBan()) return 0;
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
        Collections.sort(list, new Comparator<MatHang>(){
            @Override
            public int compare(MatHang o1, MatHang o2) {
                return o1.getTen().compareTo(o2.getTen());
            }
            
        });
        
        try {
            PrintStream ps=new PrintStream(new File("NHOM.OUT"));
            ps.println("NHOM HANG TIEU DUNG: ");
            for(int i=0;i<list.size();i++){
                if(list.get(i).getNhom().equals("hàng tiêu dùng")){
                    ps.println(list.get(i));
                }
            }
            
            ps.println("------------------------------");
            ps.println("NHOM HANG THOI TRANG: ");
            for(int i=0;i<list.size();i++){
                if(list.get(i).getNhom().equals("hàng thời trang")){
                    ps.println(list.get(i));
                }
            }
            
            ps.println("------------------------------");
            ps.println("NHOM HANG DIEN TU - DIEN LANH: ");
            for(int i=0;i<list.size();i++){
                if(list.get(i).getNhom().equals("điện tử - điện lạnh")){
                    ps.println(list.get(i));
                }
            }
            
            
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
    
}
