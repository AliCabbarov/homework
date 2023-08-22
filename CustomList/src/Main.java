import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        //1.List nədir, necə işləyir?
        /**
          The List interface in Java provides a way to store the ordered collection.
          It is a child interface of Collection.
          It is an ordered collection of objects in which duplicate values can be stored.
          Since List preserves the insertion order, it allows positional access and insertion of elements
         */
        //2.ArrayList və LinkedList in ferqleri nelerdir hansı nə zaman istifadə olunmalıdır ?
        /**
         LinkedList bir - birlərinə referansla bağlı olduğundan burada əlavə etmək və ya silmək daha sürətlidir
         Əgər əlavə və silmə daha çox olacaqsa, LinkedList istifadəsi daha uyöundur.
         ArrayList Dinamik massivdir və axtarışı binarySearch lə etdiyindən bu tip proseslərdə
         ArrayListlər  daha uyğundur.
         * */
        //3.ArrayList və LinkedListi custom olaraq yaradın və istifadə edin
        //custom yaradacagınız classlar içərsində add() , size() , get() , remove()  methodları yer almalıdır
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(5);
        System.out.println(arrayList.size());
        System.out.println(arrayList.get(0));
        arrayList.remove(0);

        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("hello");
        System.out.println(linkedList.size());
        System.out.println(linkedList.get(0));
        linkedList.remove(0);

        //4.Listin ArrayListinden  ve Vectordan istifade ederek  hefdenin günlərini listə daxil edin
        //look: Question4Answer class



        //5. Stack Vector və  list fərqəri nələrdir ?
        //Vector və Stack Listdən törəyən Collection tipləridir
        //Vector sinxorn işləyir
        //Stack isə LİFO prinsipi ilə işləyir

        //      6. Stack yaradın və steke elementler daxil edin silin ,
        //      get() methodundan istifade ederek indexe  gore	 elemenet cap edin ,
        //      pop()  və və peek()  methodlarından istifadə edin və fərqlərini qeyd edin


        Stack<String> stack =  new Stack<>();
        stack.add("hello");
        stack.add("hello");
        stack.add("hello");
        stack.get(0);
        stack.pop();
        //dəyəri silir və qaytarır
        stack.peek();
        //dəyəri saxlayaraq qaytarır








    }
}