package dl.algorithm.c16dp;

import java.util.Arrays;

public class EraseArray {
    public int[] eraseArray(int[] input) {
        int module = (int) Math.pow(10, 9) + 7;
        int[] help = new int[10];
        int len = input.length;
        help[input[len - 1] % 10 ] = 1;
        if(len==1) return help;
        for (int i = len - 2; i >= 0; i--) {
            int[] newArr = new int[10];
            int i2 = input[i] % 10;
            for (int i1 = 0; i1 < help.length; i1++) {
                if (help[i1] == 0) continue;
                int multiIndex = ( i1 * i2)  % 10 ;
                newArr[multiIndex] += help[i1];
                int addIndex = (i1 + i2) % 10;
                newArr[addIndex] += help[i1];
                if(newArr[addIndex] > module){
                    newArr[addIndex] -= module;
                }
            }
            help = newArr;
        }
        return help;
    }

    public static void main(String[] args) {
        int[] input = {1, 3, 1, 4};
        System.out.println(Arrays.toString(new EraseArray().eraseArray(input)));
    }
}
