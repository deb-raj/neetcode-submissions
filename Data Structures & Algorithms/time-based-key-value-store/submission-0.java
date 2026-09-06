class TimeMap {
    HashMap<String, List<TimeValue>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new TimeValue(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<TimeValue> list = map.get(key);

        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid).timestamp <= timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right == -1) {
            return "";
        }

        return list.get(right).value;
    }
    class TimeValue {
        int timestamp;
        String value;

        TimeValue(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
