import java.util.HashMap;
import java.util.Map;

public class Lab5 {

    public Map<String, Integer> wordLen(String[] strings) {
        Map<String, Integer> map = new HashMap();

        for (String str:strings) {
            map.put(str, str.length());
        }

        return map;
    }

    public Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap();

        for (String str:strings) {
            map.put(str.substring(0,1), str.substring(str.length()-1));
        }

        return map;
    }


    public static void main(String[] args) {
        new Lab5().pairs(new String[]{"man","moon","main"});
    }

}
