package vop;

public class CipherDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CipherInterface cipher; 
        
        String message = "Her har vi en Meddelelse, som er hemmelig!" ;
        System.out.println("Original: \n" + message);
        
        cipher = new AtbashCipher();
        String enc = cipher.encrypt(message);
        System.out.println("Atbash: \n" + enc);
        System.out.println(cipher.decrypt(enc));
        
        cipher = new CeasarCipher(13);
        enc = cipher.encrypt(message);
        System.out.println("Ceasar 13: \n" + enc);
        System.out.println(cipher.decrypt(enc));
        
        
        
    }
    
}
