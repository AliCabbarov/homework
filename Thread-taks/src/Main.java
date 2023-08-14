public class Main {
    public static void main(String[] args) throws InterruptedException {
        //1. run() ve start() methodlarını ferqi
        //run() methodu bildiyimiz məntiqlə işləyir bir methodu işlətdiyimiz qaydası ilə
        //start() methodu lakin thread məntiqini iləri sürərək paralel işləmə məntiqini işlədir


        //2. Runnable ve Thread in ferqi nedir , Runableden implement ederek bir thread qur
        // Runnable interfacedir, Thread isə ondan törəyən classdır.
        //Runnable da sadəcə run() methodu vardır, Thraad də isə Threadə məxsus funksionallıqlar var və s.
        Thread thread = new Thread(new MyThread());


        //3. volatile nedir ne iş görür  numune kod
        //Volatile bir başa dəyərin özünü oxumağımız üçün istifadə olunur
        VolatileExample volatileExample = new VolatileExample();
        volatileExample.start();
        Thread.sleep(2000);
        VolatileExample.isTrue = true;

        //4. synchronized ne iş görür numune kod
        //Həmin synchronized blokonu müraciəti blocklayır.


        //5. monitor , lock ,deadlock nedir  numune kod yaz (deadlock bas versin)
        // Lock ümumi anlayış olub bir çox kilidləmə növünü təyin edir.
        // Monitor isə Sadəcə synchronized ilə kilidləməyə deyilir
        //Dead lock İki threadın bir birini gözəməsi zamanı baş verir


        //6. join, wait, notify in threads nedir nie istifade olunur example code
        // join() -> bir threadin işi bittikdən sonra digər threadin davam etməsi üçün istifadə olunur
        // wait() -> thredin gözləməsini bildirir ta ki notify() metodu çağrılana qədər;
        // notify() -> üait() metodundan sonra çağrılaraq gözlənilən threadın təkrar işləməsini təmin edir.


        //7. Atomic nedir numune kod




    }
}