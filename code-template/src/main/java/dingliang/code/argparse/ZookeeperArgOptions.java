package dingliang.code.argparse;

import java.util.*;

/**
 * 该参数解析类只适用于 -option1 value -option-other value类型的参数
 * 参数解析类 via : Zookeeper
 **/
public class ZookeeperArgOptions {
    private final Map<String, String> options = new HashMap<>();
    private final List<String> commandArgs = new ArrayList<>();

    // 可以将缺省参数在初始化的时候放入
    public ZookeeperArgOptions() {
        options.put("server", "localhost:2181");
        options.put("timeout", "30000");
    }

    public void parseArgs(String[] args) {
        List<String> argList = Arrays.asList(args);
        Iterator<String> it = argList.iterator();
        while (it.hasNext()) {
            String opt = it.next();
            if (opt.equals("-server")) {
                options.put("server", it.next());
            } else if (opt.equals("-timeout")) {
                options.put("timeout", it.next());
            } else if (opt.equals("-r")) {
                options.put("readonly", "true");
            } else if (opt.equals("-client-configuration")) {
                options.put("client-configuration", it.next());
            } else if (opt.equals("-waitforconnection")) {
                options.put("waitforconnection", "true");
            }
        }


    }
}
