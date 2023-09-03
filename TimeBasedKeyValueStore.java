// https://leetcode.com/problems/time-based-key-value-store/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeBasedKeyValueStore {
    HashMap<String, List<Pair>> map;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> currentList = this.map.getOrDefault(key, new ArrayList<>());
        currentList.add(new Pair(value, timestamp));
        this.map.put(key, currentList);
    }
    
    public String get(String key, int timestamp) {
        if(this.map.containsKey(key))
        {
            int index = BSLowerTimestamp(this.map.get(key), timestamp);

            if(index >= 0)
            return this.map.get(key).get(index).value;
        }

        return "";
    }

    public int BSLowerTimestamp(List<Pair> values, int targetTimestamp)
    {
        int start = 0, end = values.size() - 1;

        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            Pair currentValue = values.get(mid);

            if(currentValue.timestamp == targetTimestamp)
            return mid;

            else if(currentValue.timestamp > targetTimestamp)
            end = mid - 1;

            else
            start = mid + 1;
        }

        return end;
    }

    public class Pair {
        private String value;
        private int timestamp;

        public Pair(String value, int timestamp)
        {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
