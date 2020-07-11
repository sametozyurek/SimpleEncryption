/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleencryption;
import java.util.Scanner;

/**
 *
 * @author samet
 */

public class SimpleEncryption {
    
    interface Isle{
    
        public void ayir();
    }
    
    interface Donustur{
        
        public void donusturAsci();
    }
    
    interface SifrelemeIslemi{
    
        public void sifrelemeBaslat();
    }
    
    interface SifrelemeCoz{
    
        public void sifrelemeCozBaslat();
    }
    
    class Sifrele implements Isle,Donustur,SifrelemeIslemi,SifrelemeCoz{
        
        String girdi="";
        
        public int kullaniciGirdisi(){
        
            Scanner input=new Scanner(System.in);
            this.girdi=input.nextLine();
            return girdi.length();
        }
        
        int girdiUzunluk=kullaniciGirdisi();
        
        char[] harfleme=new char[girdiUzunluk];
        int[] harflemeAsci=new int[girdiUzunluk];
        int[] sifrelenmisHarflerAsci=new int[girdiUzunluk];
        char[] sifrelenmisCumle=new char[girdiUzunluk];
        int[] bolum=new int[girdiUzunluk];
        
        @Override
        public void ayir(){
            
            for (int i = 0; i < girdiUzunluk; i++) {
                
                harfleme[i]=girdi.charAt(i);
            } 
        }
        
        @Override
        public void donusturAsci(){
            
            for (int i = 0; i < girdiUzunluk; i++) {
                
                harflemeAsci[i]=harfleme[i];
            }
        }
        
        @Override
        public void sifrelemeBaslat(){
            
            String sifrelenenCumle="";
            
            for (int i = 0; i < girdiUzunluk; i++) {
                
                sifrelenmisHarflerAsci[i]=(harflemeAsci[i]%26)+48;
                bolum[i]=harflemeAsci[i]/26;
                sifrelenmisCumle[i]=(char) sifrelenmisHarflerAsci[i];
                sifrelenenCumle+=sifrelenmisCumle[i];
            }
            
            System.out.println("Cümlenin şifrelenmiş hali : "+sifrelenenCumle);
            System.out.println("");
        }
        
        @Override
        public void sifrelemeCozBaslat(){
            
            String cumle="";
            int[] sifrelenmedenOncekiAsci=new int[girdiUzunluk];
            char[] sifrelenmedenOncekiCumle=new char[girdiUzunluk];
            int[] a=new int[girdiUzunluk];
            
            for (int i = 0; i < girdiUzunluk; i++) {
                
                a[i]=sifrelenmisHarflerAsci[i]-48;
                sifrelenmedenOncekiAsci[i]=(bolum[i]*26)+a[i];
                sifrelenmedenOncekiCumle[i]=(char) sifrelenmedenOncekiAsci[i];
                cumle+=sifrelenmedenOncekiCumle[i];
            }
            System.out.println("Şifrelenmeden önceki cümle : "+cumle);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        SimpleEncryption.Sifrele sifrelemeSinifi=new SimpleEncryption().new Sifrele();
       
        sifrelemeSinifi.ayir();
        sifrelemeSinifi.donusturAsci();
        sifrelemeSinifi.sifrelemeBaslat();
        sifrelemeSinifi.sifrelemeCozBaslat();
    }  
}
