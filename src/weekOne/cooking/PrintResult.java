package weekOne.cooking;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PrintResult extends CollectionSelector{
    CollectionSelector cs = new CollectionSelector();

    public void get(String dataType) {
        int order = 1;
        if ("List".equals(dataType)) {
            List<String> list = cs.getList();
            for (String s : list) {
                System.out.println(order+ ". " + s);
                order++;
            }
        } else if ("Set".equals(dataType)) {
            Iterator<String> set = cs.getSet().iterator();
            while (set.hasNext()) {
                System.out.println( order + ". " + set.next());
                order ++;
            }
        } else {
            Map<String, Integer> map = cs.getMap();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ". "  + entry.getValue());
            }
        }
    }
}
