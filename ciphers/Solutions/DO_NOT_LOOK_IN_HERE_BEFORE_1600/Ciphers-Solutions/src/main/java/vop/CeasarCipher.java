package vop;

public class CeasarCipher extends AbstractCipher {

    private int rotFactor;

    public CeasarCipher(int rotFactor) {
        if (rotFactor > 0 && rotFactor < ALPHABETH.length) {
            this.rotFactor = rotFactor;
        } else {
            System.out.println("Fejl i rotFactor!");
        }
    }

    @Override
    public String encrypt(String original) {
        StringBuilder result = new StringBuilder();
        for (char c : original.toCharArray()) {
            int index = findCharIndex(c);
            if (index >= 0) {
                index = (index + rotFactor) % ALPHABETH.length;
                result.append(ALPHABETH[index]);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    @Override
    public String decrypt(String encrypted) {
        StringBuilder result = new StringBuilder();
        for (char c : encrypted.toCharArray()) {
            int index = findCharIndex(c);
            if (index >= 0) {
                index = (index + ALPHABETH.length - rotFactor) % ALPHABETH.length;
                result.append(ALPHABETH[index]);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
