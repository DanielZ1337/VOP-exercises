package vop;

public abstract class AbstractCipher implements CipherInterface {
    protected int findCharIndex(char ch) {
        for (int i = 0; i < ALPHABETH.length; i++) {
            if (ALPHABETH[i] == ch) {
                return i;
            }
        }
        return -1;
    }
}
