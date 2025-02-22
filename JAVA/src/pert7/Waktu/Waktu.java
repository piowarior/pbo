package pert7.Waktu;

public class Waktu {
        
        private int menitWaktu;
    
        
        public Waktu(int menitWaktu) {
            this.menitWaktu = menitWaktu;
        }
    
       
        public int getJam() {
            return menitWaktu / 60;
        }
    
        
        public int getMenit() {
            return menitWaktu % 60;
        }
    
        
        public void setJam(int j) {
            menitWaktu = (j * 60) + (menitWaktu % 60);
        }
    
        
        public void setMenit(int m) {
            menitWaktu = ((menitWaktu / 60) * 60) + m;
        }
    
        
        public int getTotalMenit() {
            return menitWaktu;
        }
        
        
        public static void main(String[] args) {
            Waktu waktu = new Waktu(125); 
            
            System.out.println("Jam: " + waktu.getJam()); 
            System.out.println("Menit: " + waktu.getMenit()); 
            waktu.setJam(3); 
            System.out.println("Setelah setJam(3) - Total Menit: " + waktu.getTotalMenit()); 
            waktu.setMenit(30); 
            System.out.println("Setelah setMenit(30) - Total Menit: " + waktu.getTotalMenit());
        }
    }