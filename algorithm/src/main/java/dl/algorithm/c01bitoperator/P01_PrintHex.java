package dl.algorithm.c01bitoperator;

/**
 *  实现一个函数,打印整数的32位
 **/
public class P01_PrintHex {

    // 1左移n位跟num上的第n位 与运算
    public static void print(Integer num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print( (num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print(3);
    }
}
