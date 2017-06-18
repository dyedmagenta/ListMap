import listmap.KeyObject;
import listmap.ListMap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Piotr Frankiewicz on 18.06.2017.
 */
public class Example {


    public static void main(String[] args) {
        exampleKeyObject();
    }

    private static void exampleKeyObject(){

        System.out.println("Example - KeyObject");

        //Filling ArrayList with some Objects
        ArrayList<KeyObject<String, Object>> alObject = new ArrayList<>();
        alObject.add(new KeyObject<>("2" ,"12"));
        alObject.add(new KeyObject<>("2" ,"Nope"));
        alObject.add(new KeyObject<>("2" , 244));

        ArrayList<String> alString = new ArrayList<>();
        alString.add("Hello");
        alString.add("56");
        alObject.add(new KeyObject<>("1" ,alString));

        ArrayList<String> alAnotherString = new ArrayList<>();
        alAnotherString.add("Du du");
        alAnotherString.add("Pim pam");

        alObject.add(new KeyObject<>("2" ,alAnotherString));

        Object[] ar = {null, 12, "25"};
        KeyObject ki = new KeyObject<String, Object>("1", ar);
        alObject.add(ki);

        //Converting ArrayList to Map
        Map m = ListMap.listToMapWithKeyObject(alObject);
        Example.printMap(m);
    }

    private static void exampleClassName(){

        System.out.println("Example 2 - It doesn't allow for custom key names because Keys are class names of objects although it doesn't use any additional objects");

        //Filling ArrayList with some Objects
        List<Object> alObject = new LinkedList<>();
        alObject.add("12");
        alObject.add("Nope");
        alObject.add(244);

        ArrayList<String> alString = new ArrayList<>();
        alString.add("Hello");
        alString.add("56");
        alObject.add(alString);

        List<String> alAnotherString = new ArrayList<>();
        alAnotherString.add("Dudu");
        alAnotherString.add("Pimpom");

        alObject.add(alAnotherString);

        Object[] ar = {null, 12, "25"};
        KeyObject ki = new KeyObject<Integer, Object>(1, ar);
        alObject.add(ki);

        //Converting ArrayList to Map
        Map m = ListMap.listToMapWithoutKeys(alObject);
        Example.printMap(m);
    }


    private static <K, V> void printMap(Map<K, List<V>> map) {

        map.forEach((K k, List<V> v) -> {
           System.out.println("    Key: " + k);
           System.out.print("    Value: { ");
           v.forEach(o -> System.out.print(o.toString() + " "));
           System.out.print("}Count: " + v.size());
           System.out.print("\n\n");
        });
    }
}