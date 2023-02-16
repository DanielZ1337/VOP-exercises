package vop;

public class AtbashCipher extends AbstractCipher {
    @Override
    public String encrypt(String original) {
        char[] chars = original.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int charIndex = findCharIndex(chars[i]);
            if (charIndex != -1) {
                chars[i] = ALPHABETH[51 - charIndex];
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c :
                chars) {
            result.append(c);
        }
        return result.toString();
    }

    @Override
    public String decrypt(String encrypted) {
        return encrypt(encrypted);
    }
}
