package cleanCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class cleanCode {
    public static void main(String[] args) {
        /**1 ) KISS – Clean code prinsipinin anlamı  nədir ?
        // bu pirinsipi pozacaq bir  kod nümunə yazın
        // sonrada həmin prinsipdən istifadə edərək probləmi həll edin .*/

        // KISS - Keep it simple, stupid -> kodunu qısa tut axmaq olma
        /*
            kodunzu mürəkkəb yazmayın, mümkün olduqca kodu qısa tutun.
            Qarmaşıq və ya lazımsız qarmaşıqlıq yerinə ən qısa həlli yolunu tapmağa çalışın
            qısa və aydın kod baxımı rahatlaşdırır
        */
        // TODO: KISS code write here
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }
        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }
        /**-------------------------------------**/

        Stream.iterate(0,i -> i + 1)
                .forEach(System.out::println);

        /**2 ) DRY - Clean code prinsipinin anlamı  nədir ?
                bu pirinsipi pozacaq bir  kod nümunə yazın/
                sonrada həmin prinsipdən istifadə edərək probləmi həll edin .*/

        /*
         DRY - Don't Repeat Yourself -> təkrar etmə. eyni kodu birdən çox bir yerdəə yazma.
         təkrar olunacaq hissəni bir dəfə yaz metoda çıxar və və lazım olduqca istifadə et.
        */
        List<String> strings = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        strings.add(scanner.nextLine());
        for (String string : strings) {
            System.out.println(string);
        }


        Scanner sc = new Scanner(System.in);
        strings.add(sc.nextLine());
        for (String string : strings) {
            System.out.println(string);
        }
        /**------------------------------------**/
        addAndShow(strings);

        /**3 ) Yagni - Clean code prinsipinin anlamı  nədir ?
          bu pirinsipi pozacaq bir  kod nümunə yazın/
          sonrada həmin prinsipdən istifadə edərək probləmi həll edin .
          */
        /*
           YAGNI - You Aren't Gonna Need It -> lazım deyil deyilsə yazma.
           Gləcəkətktəki hər hansısa problemi nəzərə alaraq kodu uzadıb qarmaşıqlaşdırma
           sadəcə indiki problemləri həll et.
           Gələcəktə problem yarnanda kodunu ona uyğun genişlət.
         */


    }
    public static void addAndShow(List<String> strings){
        Scanner sc = new Scanner(System.in);
        strings.add(sc.nextLine());
        for (String string : strings) {
            System.out.println(string);
        }
    }

}
