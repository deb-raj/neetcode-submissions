class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> tMap = new HashMap<>();

        if (s.length() < t.length()) {
            return "";
        }

        // Required frequency
        for (int i = 0; i < t.length(); i++) {
            tMap.put(
                t.charAt(i),
                tMap.getOrDefault(t.charAt(i), 0) + 1
            );
        }

        int have = 0;
        int need = tMap.size();

        int left = 0;

        int min = Integer.MAX_VALUE;
        String value = "";

        HashMap<Character, Integer> windowMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            // Add right character
            windowMap.put(
                c,
                windowMap.getOrDefault(c, 0) + 1
            );

            // Requirement completely satisfied
            if (tMap.containsKey(c)
                    && windowMap.get(c).equals(tMap.get(c))) {
                have++;
            }

            // Window is valid
            while (have == need) {

                // Check current valid window
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    value = s.substring(left, right + 1);
                }

                // Remove left character
                char leftChar = s.charAt(left);

                windowMap.put(
                    leftChar,
                    windowMap.get(leftChar) - 1
                );

                // Requirement broken
                if (tMap.containsKey(leftChar)
                        && windowMap.get(leftChar) < tMap.get(leftChar)) {
                    have--;
                }

                left++;
            }
        }

        return value;
    }
}