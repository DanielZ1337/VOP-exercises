package vop;

public class AtbashCipher extends AbstractCipher {

    @Override
    public String encrypt(String original) {
        StringBuilder sb = new StringBuilder();
        
        
        int index;
        for(char c : original.toCharArray()){

            index = findCharIndex(c);
            if(index > -1){
                sb.append(ALPHABETH[ALPHABETH.length - 1 - index]);
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();

    }

    @Override
    public String decrypt(String encrypted) {
        return encrypt(encrypted);
    }


}
