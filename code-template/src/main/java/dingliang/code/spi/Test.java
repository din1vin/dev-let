package dingliang.code.spi;

import java.util.ServiceLoader;

public class Test {

    public static void main(String[] args) {
        ServiceLoader<Search> s = ServiceLoader.load(Search.class);
        s.iterator().forEachRemaining(x->x.searchDoc("hello"));
    }
}
