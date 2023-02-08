package vop;

public class CaesarCipher extends AbstractCipher {
    private int rotFactor;

    public CaesarCipher(int rotFactor) {
        if (rotFactor > -1 && rotFactor < ALPHABETH.length) {
            this.rotFactor = rotFactor;
        }
    }

    @Override
    public String encrypt(String original) {
        char[] chars = original.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int charIndex = findCharIndex(chars[i]);
            if (charIndex != -1) {
                chars[i] = ALPHABETH[(charIndex + rotFactor) % ALPHABETH.length];
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c:
             chars) {
            result.append(c);
        }
        return result.toString();
    }

    @Override
    public String decrypt(String encrypted) {
        char[] chars = encrypted.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int charIndex = findCharIndex(chars[i]);
            if (charIndex != -1) {
                chars[i] = ALPHABETH[(charIndex + ALPHABETH.length - rotFactor) % ALPHABETH.length];
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c:
                chars) {
            result.append(c);
        }
        return result.toString();
    }
}
