public class Generics <K,V>{
    private K key;
    private V value;

    public void setKeyValue(K key,V value){
        this.key = key;
        this.value =value;
    }
    public V getValue(K k){
        if(k == this.key) {
            return value;
        }
        return null;
    }


}
