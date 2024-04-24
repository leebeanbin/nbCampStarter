package weekOne.cooking;

import java.util.*;

public class CollectionSelector {
    protected static final List<String> list = new ArrayList<>();
    protected static final Set<String> set = new HashSet<>();;
    protected static final Map<String, Integer> map = new HashMap<>();
    protected String type = "";

    public void add(Object element) {
        // Logic to decide where to add element
        // Example logic could be based on instance type, value, etc.
        if (type.equals("List")) {
            list.add((String) element);
        }
        else{
            set.add((String)element);
        }
    }

    public void addToMap(Object key, Object value) {
        map.put((String) key, (Integer)value);
    }

    public List<String> getList() {
        return list;
    }

    public Set<String> getSet() {
        return set;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
