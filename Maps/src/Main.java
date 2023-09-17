import enums.Enums;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1)	Map nədir ?
        //Map key və value dan ibarət texniki olaraq collectiondir.
        //Burada əsas qayda keylərin unique olmasldır.
        //setlər özü də maplarda implements edir.
        //Mapin Setin valuesini mapin keyi hesab etmək olar



        //2)	Map hierarchy  ın structurunu qur (əsas class və interfacelər) .
        //Map hierarchy na Hashtable, HashMap, LinkedHashMap, TreeMap aiddir(ən çox istifadə olunan)
        //buradakı məntiq setlərlə eyni məntiqdir
        //hashtable çox köhnə texnologiyadır - Hashtable key və value olaraq heç bir halda null qəbul etmir
        //TreeMap key olaraq null qəbul etmir çünki sorted prinsipini pozur.

        //3)	HashMap, LinkedHashMap , TreeMap,HashTable , Properties ferqləri nələrdir (hansılarda key value null qebul edir) ?
        //LinkedHashMap və HashMap null key qəbul edir
        //Properties  HashMaplarla eynidir fərqləri burada dəyərlər object tipində saxlanılır və ThreadSafedir.

        


        //5)	EnumSet və EnumMap nə üçün istifadə olunur kod nümunəsi  yazın .
        //EnumSet içində Sadəcə enum saxlayan set tipidir
        //EnumMap isə içində key olaraq enum saxlayan map tipidir.
        EnumMap<Enums,String> enums = new EnumMap<>(Enums.class);
        enums.put(Enums.MONDAY,"bazar ertesi");
        enums.put(Enums.WEDNESDAY,"cersenbe axsami");


        EnumSet<Enums> enumSet = EnumSet.of(Enums.MONDAY);
        enumSet.add(Enums.TUESDAY);
    }
}