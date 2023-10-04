import java.lang.annotation.Documented;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    @SuppressWarnings("all")
    private String name;

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {

        /**1. Reflection nədir və nə üçündür?*/
        // Reflection class, methode, field və annotationa aid ad, parametr kimi
        // məlumatları almaq, nəzarət etmək və idarə etmək üçün istifadə olunur

        /**2. Class tipinin hansı methodlarını tanıyırsız? Nümunə göstərin*/
        // Burada əsaən .get() - lərdən istifadə olunur.
        Class<Main> mainClass = Main.class;
        // exp: .getMethods() - methodalrı
        Method method = mainClass.getMethod("main", String[].class);
        // exp: .Fields() - Filedalrı
        Field field = mainClass.getDeclaredField("name");
        // exp: .getAnnotations() - Annotasiyaları
        SuppressWarnings deprecated = field.getAnnotation(SuppressWarnings.class);
        // exp: .getConstructors() - Constructorları və s.
        Constructor<Main> constructor = mainClass.getDeclaredConstructor();


        /**3. getMethods'la- getDelcarativeMethods arasındakı fərq nədir?*/

        // .getMethods() - üst classlar daxil bütün methodeları qaytarır
        // .getDeclaredMethods() - sadəcə həmin classdakı methodeları qaytarır

        /**4. getFields'lə - getDelcarativeFields arasındakı fərq nədir?*/

        // .getDeclaredMethodela eyni məntiqdir.

        /** 5. Annotation nədir, nə üçün istifadə olunur?*/

        // Javda koda meta-data əlavə etmək etmək üçün istifadə edilən xüsusi bir işarələmə strukturudur

        /**6. @target nə işə yarayır?*/

        // @Target = biz bu annotationu harda istafdə edəcəyimzi bildirmək üçündür
        //exp - ElementType.FİELD və s.

        /**7. @retention nə işə yarayır?*/

        // @Retention - annotasiyanin nə zaman çalışacağını bildirir.
        // exp - Runtime zamanı, compile zamanı və s.


        /**8. RetentionPolicy daxilində olan Runtime, source və class arasındakı fərqlər nələrdir?*/
        // RUNTİME - həmin annotasiyanin runtime zamanı çalışacağını bildirir
        // SOURCE - bir başa compile zamanı işləyəcəyini bildirir
        // class - isə compile olunduqdan sonra içlıyıcıyini bildirir

        /***9. Hansı annotationları tanıyırsız və bunlar nə işə yarayır, 3 nümunə göstərin.*/
         // @Override - methodun üst classdan gəlib gəlmədiyini yoxlayır
         // @Functionalİnterface - interfacein functional interface olub olmadığını yoxlayır
         // @Deprecated - istifadə olunması tövsiyə olunmadığını bildirir

        /**10. Bir classın daxilində olan annotationları hansı necə əldə edə bilərik? */

        //Əvvəlcə hrda yazıldığəna diqqət edirik daha sonra o classın .getAnnotations() methodundan istifadə edərək
        // həmin annotationları əldə edirik.
        // exp - Methode -a yazılıbsa class.getMethods.getAnnotation() və s.


    }
}