package listmap;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Piotr Frankiewicz on 18.06.2017.
 */
public class KeyObject<K, V> {

    @Setter
    @Getter
    private K key;

    @Getter
    @Setter
    private V value;

    public KeyObject(K key, V value){

        this.key = key;
        this.value = value;
    }

}
