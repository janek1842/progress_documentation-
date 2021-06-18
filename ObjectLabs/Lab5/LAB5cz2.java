import java.util.HashMap;
import java.util.Map;

public class LAB5cz2 {
    // Zadania wordCount-firstSwap

    public Map<String, Integer> wordCount(String[] strings) {

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < strings.length; i++) {

            String tmp = strings[i];

            if (map.containsKey(tmp)) {
                int count = map.get(tmp);
                map.put(tmp, count + 1);
            } else {
                map.put(tmp, 1);
            }

        }
        return map;
    }

    public Map<String, String> firstChar(String[] strings) {

        Map<String, String> map = new HashMap<String, String>();

        for (int i = 0; i < strings.length; i++) {

            String key = String.valueOf(strings[i].charAt(0));

            if (map.containsKey(key)) {
                String val = map.get(key) + strings[i];
                map.put(key, val);
            } else {
                map.put(key, strings[i]);
            }

        }
        return map;
    }

    public String wordAppend(String[] strings) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int tmp = 0;
        String finalo = new String();
        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i])) {
                tmp = map.get(strings[i]);
                tmp++;
                map.put(strings[i], tmp);
                if (map.get(strings[i]) % 2 == 0) {
                    finalo = finalo + strings[i];
                }
            } else {
                map.put(strings[i], 1);
            }
        }
        return (finalo);
    }

    public Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        String tmp = new String();

        for (int i = 0; i < strings.length; i++) {
            tmp = strings[i];
            if (map.containsKey(tmp)) {
                int count = map.get(tmp);
                map.put(tmp, count + 1);
            } else {
                map.put(tmp, 1);
            }
        }

        Map<String, Boolean> mapas = new HashMap<String, Boolean>();

        for (int i = 0; i < strings.length; i++) {
            if (map.get(strings[i]) >= 2)
                mapas.put(strings[i], true);
            else
                mapas.put(strings[i], false);

        }


        return (mapas);
    }

    public String[] allSwap(String[] strings) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        String tmp = new String();

        for (int i = 0; i < strings.length; i++) {
            map.put(i, 0);
        }

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                if (strings[i].substring(0, 1).equals(strings[j].substring(0, 1)) && map.get(i) == 0 && map.get(j) == 0 && i != j) {
                    tmp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = tmp;
                    map.put(i, 1);
                    map.put(j, 1);
                }
            }
        }
        return strings;
    }

    public String[] firstSwap(String[] strings) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Map<String, Integer> map1 = new HashMap<String, Integer>();

        String tmp = new String();

        for (int i = 0; i < strings.length; i++) {
            map.put(i, 0);
            map1.put(strings[i].substring(0, 1), 0);
        }

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                if (strings[i].substring(0, 1).equals(strings[j].substring(0, 1)) && map.get(i) == 0 && map.get(j) == 0 && i != j && map1.get(strings[i].substring(0, 1)) == 0) {
                    tmp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = tmp;
                    map.put(i, 1);
                    map.put(i, 1);
                    map1.put(strings[i].substring(0, 1), 1);
                }
            }
        }
        return strings;
    }
        public static void main (String[]args){
        new LAB5cz2().firstSwap(new String[]{"ab", "ac"});
    }
}