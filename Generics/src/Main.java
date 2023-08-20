import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //1.Generics nədir, nə üçün istifadə olunur?
        /*Bəzən bir məlumatı təyin edərkən tipini müəəyən etmək olmur yəni bu
        müxtəlif tiplərdə ola bilər, Və biz hər dəfə hər bir məlumat üçün yeni
        class yaradıb yeni tip təyin etmıyıyk deyə Genericslərdən istifadə edirik.
        Generics təkcə tip təyin edərkən deyil geriyə nəyisə return edərkən də istifadə edirik
        Qısacası generics nə isə təyin etmək üçün lakın tipini bilmədiyimiz üçün istifadə edirik.
        */


        //2.Genericsi class səviyəsində təyin edərək nümunə göstərin.
        Response<User> response = new Response<>("Success", 200, new User(1, "Ali", "Cabbarov", LocalDate.now()));


        //3.Genericsi method səviyəsində təyin edərək nümunə göstərin.
        User user = foo(new User(1, "Ali", "Cabbarov", LocalDate.now()));

        //4.Wildcard nədir? <? extends Number> və <? super Number> fərqləri nədir?
        //extends alt siniflərə icazə verir üst siniflərə icazə vermir.
        /**
         * extends istifadə olunması:
         public static <T extends NUmber> T exp(T t) {
         return t;
         }
         */
        //super üst siniflərə icazə verir lakin alt sinif ondan törədiyi üçün alt sinifin bu sinifdə olan özəlliklərini də icazə verilir
        /***
         * super istifadə olunması
         * Response<? super User> response = new Response<>("Success", 200, new User(1, "Ali", "Cabbarov", LocalDate.now()));
         */
        //5.Bir generics class düzəldin. İki tip qəbul etsin, Key Value. Daha sonra həmin həmin
        // key və value fieldlərinə istənilən tipdə dəyər göndərib onları çap edə bilək.
        Generics<String,Integer> generics = new Generics<>();
        generics.setKeyValue("Cabbarov",123);
        System.out.println(generics.getValue("Cabbarov"));

    }

    public static <T> T foo(T t) {
        return t;
    }


}