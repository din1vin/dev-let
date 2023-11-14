package dl.tazi;


import org.junit.Test;

public class ReorderAlphas {

    public void reorderAlphas(int k) {
        String mod = "qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm";
        int len = (int) Math.ceil(26.0 / k) * 2 * k;
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (ans.length() < len) {
            ans.append(mod, i, i + k);
            ans.append(mod, i, i + k);
            i += k;
        }
        System.out.println(ans);
    }

    @Test
    public void test() {
        reorderAlphas(6);
    }
}
