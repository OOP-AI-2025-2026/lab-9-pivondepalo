package ua.opnu;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Task {

    public static void removeShorterStrings(List<String> list) {
        if (list == null) {
            return;
        }
        int i = 0;
        while (i < list.size() - 1) {
            String first = list.get(i);
            String second = list.get(i + 1);
            if (first.length() <= second.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
            i++;
        }
    }

    public static void stutter(List<String> list) {
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size(); i += 2) {
            String value = list.get(i);
            list.add(i, value);
        }
    }

    public static void switchPairs(List<String> list) {
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size() - 1; i += 2) {
            String first = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, first);
        }
    }

    public static void removeDuplicates(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        String previous = list.get(0);
        int i = 1;
        while (i < list.size()) {
            String current = list.get(i);
            if (previous.equals(current)) {
                list.remove(i);
            } else {
                previous = current;
                i++;
            }
        }
    }

    public static void markLength4(List<String> list) {
        if (list == null) {
            return;
        }
        int i = 0;
        while (i < list.size()) {
            String s = list.get(i);
            if (s != null && s.length() == 4) {
                list.add(i, "****");
                i += 2;
            } else {
                i++;
            }
        }
    }

    public static boolean isPalindrome(Queue<Integer> q) {
        if (q == null) {
            throw new IllegalArgumentException("Queue must not be null");
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int size = q.size();

        for (int i = 0; i < size; i++) {
            Integer value = q.remove();
            q.add(value);
            stack.push(value);
        }

        boolean palindrome = true;

        for (int i = 0; i < size; i++) {
            Integer value = q.remove();
            Integer fromStack = stack.pop();
            if (!value.equals(fromStack)) {
                palindrome = false;
            }
            q.add(value);
        }

        return palindrome;
    }

    public static void reorder(Queue<Integer> q) {
        if (q == null || q.isEmpty()) {
            return;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int size = q.size();
        int negativeCount = 0;

        for (int i = 0; i < size; i++) {
            int value = q.remove();
            if (value < 0) {
                stack.push(value);
                negativeCount++;
            } else {
                q.add(value);
            }
        }

        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        int positiveCount = size - negativeCount;
        for (int i = 0; i < positiveCount; i++) {
            q.add(q.remove());
        }
    }

    public static void rearrange(Queue<Integer> q) {
        if (q == null || q.isEmpty()) {
            return;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int size = q.size();
        int oddCount = 0;

        for (int i = 0; i < size; i++) {
            int value = q.remove();
            if (value % 2 != 0) {
                stack.push(value);
                oddCount++;
            } else {
                q.add(value);
            }
        }

        int evenCount = size - oddCount;

        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        for (int i = 0; i < evenCount; i++) {
            q.add(q.remove());
        }

        for (int i = 0; i < oddCount; i++) {
            stack.push(q.remove());
        }

        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
    }

    public static int maxLength(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return 0;
        }
        int max = 0;
        for (String s : set) {
            if (s != null && s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    public static void removeEvenLength(Set<String> set) {
        if (set == null) {
            return;
        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s != null && s.length() % 2 == 0) {
                it.remove();
            }
        }
    }

    public static int numInCommon(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list2 == null) {
            return 0;
        }
        Set<Integer> s1 = new HashSet<>(list1);
        Set<Integer> s2 = new HashSet<>(list2);
        s1.retainAll(s2);
        return s1.size();
    }

    public static boolean isUnique(Map<String, String> map) {
        if (map == null) {
            return true;
        }
        Set<String> seen = new HashSet<>();
        for (String value : map.values()) {
            if (!seen.add(value)) {
                return false;
            }
        }
        return true;
    }

    public static Map<String, Integer> intersect(Map<String, Integer> m1, Map<String, Integer> m2) {
        Map<String, Integer> result = new HashMap<>();
        if (m1 == null || m2 == null) {
            return result;
        }
        for (Map.Entry<String, Integer> entry : m1.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (m2.containsKey(key)) {
                Integer otherValue = m2.get(key);
                if (value == null ? otherValue == null : value.equals(otherValue)) {
                    result.put(key, value);
                }
            }
        }
        return result;
    }

    public static Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();
        if (map == null) {
            return result;
        }
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            result.put(value, key);
        }
        return result;
    }

    public static int rarest(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("Map must not be null or empty");
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer value : map.values()) {
            if (value == null) {
                continue;
            }
            counts.put(value, counts.getOrDefault(value, 0) + 1);
        }

        int bestValue = 0;
        int bestCount = Integer.MAX_VALUE;
        boolean first = true;

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();
            if (first || count < bestCount || (count == bestCount && value < bestValue)) {
                bestValue = value;
                bestCount = count;
                first = false;
            }
        }

        if (first) {
            throw new IllegalArgumentException("Map contains no non-null values");
        }

        return bestValue;
    }

    public static int maxOccurrences(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer value : list) {
            if (value == null) {
                continue;
            }
            counts.put(value, counts.getOrDefault(value, 0) + 1);
        }

        int max = 0;
        for (int count : counts.values()) {
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}

