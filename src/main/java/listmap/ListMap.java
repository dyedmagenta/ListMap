package listmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Piotr Frankiewicz on 18.06.2017.
 */
public class ListMap {


    /**
     * Converts list to HashMap using custom object with Key and Value
     *
     * @param list <KeyObject<K,V>> - list to be converted to HashMap
     * KeyObject<K,V> - custom object that has Key and Value
     * @return HashMap <K, V>
     * K - Key is key from KeyObject in list
     * V - Value is list of values from KeyObject with the same keys
     */
    public static <K, V> HashMap<K, List<Object>> listToMapWithKeyObject(List<KeyObject<K,V>> list) {

        HashMap<K, List<Object> > hashMap = new HashMap<>();
        for (KeyObject<K,V> o: list) {

            K key = o.getKey();
            if(hashMap.containsKey(key)) {
                hashMap.get(key).add(o.getValue());
            } else {
                hashMap.put(key, new ArrayList<>());
                hashMap.get(key).add(o.getValue());
            }
        }

        return hashMap;
    }


    /**
     * Converts list to HashMap using Class names as keys
     *
     * @param list - list to be converted to HashMap
     * @return HashMap K,V
     * K - Key is class name of object in list
     * V - Value is list of objects with class name K
     */
     public static <T> HashMap<String, List<Object>> listToMapWithoutKeys(List<T> list){

        HashMap< String, List<Object> > hashMap = new HashMap<>();
        for (Object o: list) {


            String key = o.getClass().getName();
            if(hashMap.containsKey(key)) {
                hashMap.get(key).add(o);
            } else {
                hashMap.put(key, new ArrayList<Object>());
                hashMap.get(key).add(o);
            }
        }

        return hashMap;
    }
}
