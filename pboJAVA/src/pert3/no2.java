package pert3;
import java.util.Scanner;
public class no2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int iterasi = 0;
        int angka = 5;

        for(int i = 1; i <= angka ; i++){
            System.out.println( "iterasi ke" +i+ "adalah" +i );
            iterasi ++;
        }
            System.out.println( "total iterasi" + iterasi  );
        
    }
}
