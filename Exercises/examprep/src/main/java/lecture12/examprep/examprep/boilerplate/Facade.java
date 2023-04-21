package lecture12.examprep.examprep.boilerplate;

import java.util.Arrays;
import java.util.Random;

public class Facade {
    private int[] intArray;
    Random random;

    public Facade() {
        random = new Random();
    }

    public int[] fillArray(int size, int max) {
        intArray = new int[size];
        intArray = Arrays.stream(intArray).map(x -> random.nextInt(max)).toArray();
        return intArray;
    }

    public int[] fillUniqueArray(int size, int max) {
        if (size > max) throw new ArrayStoreException();

        intArray = new int[size];
        for (int i = 0; i < intArray.length; i++) {
            int randomNumber = random.nextInt(max);
            while (numberExists(randomNumber)) {
                randomNumber = random.nextInt(max);
            }
            intArray[i] = randomNumber;
        }

        return intArray;
    }

    public int sumOfDivisors(int divisor) {
        return Arrays.stream(intArray).filter(x -> x % divisor == 0).sum();
    }

    public int[] getIntArray() {
        return intArray;
    }

    private boolean numberExists(int randomNumber) {
        return Arrays.stream(intArray).anyMatch(x -> x == randomNumber);
    }
}
