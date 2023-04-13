package ArrayManipulation;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ArrayManipulation {
    public static void main(String[] arg) {
        Random generator = new Random(222);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(100);
        }
        System.out.println("Input: " + Arrays.toString(array));

        ArrayManipulation arrMani = new ArrayManipulation();
        int[] result = arrMani.evenOdd(array);
        System.out.println("Output: " + Arrays.toString(result));
    }

    public int[] evenOdd(int[] array) {
        int oddIndex = 0;
        int evenIndex = array.length;
        int[] temp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                temp[evenIndex - 1] = array[i];
                evenIndex--;
            } else {
                temp[oddIndex] = array[i];
                oddIndex++;
            }
        }
        System.out.println("EvenOdd: " + Arrays.toString(temp));
        sort(temp, 5);
        return temp;
    }

    private void sort(int[] array, int splitIndex) {
        Integer[] temp = new Integer[splitIndex];
        Integer[] temp2 = new Integer[array.length - splitIndex];
        if (splitIndex < array.length) {
            for (int i = 0; i < array.length; i++) {

                if (i < splitIndex) {
                    temp[i] = array[i];
                } else {
                    temp2[i - splitIndex] = array[i];
                }

            }
        }
        Arrays.sort(temp);
        Arrays.sort(temp2, Collections.reverseOrder());
        for (int i = 0; i < array.length; i++) {
            if (i < splitIndex) {
                array[i] = temp[i];
            } else {
                array[i] = temp2[i - splitIndex];
            }
        }
    }
}

    
