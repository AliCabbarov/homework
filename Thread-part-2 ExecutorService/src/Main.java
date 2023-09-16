import java.util.Random;
import java.util.concurrent.*;

public class Main {
    static StringBuffer stringBuffer = new StringBuffer();
    public static void main(String[] args) throws InterruptedException {
        //1. Callable aid nümune yazın. Runnabledan fərqi nədir kodda göstərin.
        /**  Callable demək olar ki Runnable ilə eynidir. əsas fərqi burada artıq .run() methodu yox
         * .call() methodundan istifadə olunur fərqi isə bu methodun geriyə dəyər qaytarmasıdır
         * qaytarılan dəyər isə Future tipindədir.
         * 2 ci bir fərq isə Callable və Future sayəsində Exceptionları rahaqtlıqla idarə etmək olur.
         */
        try {
            ExecutorService threadPool = Executors.newFixedThreadPool(8);
            Future<Boolean> submit = threadPool.submit(new CallableExample());
            threadPool.shutdown();
            if(submit.get()){
                System.out.println("Welcome!!!");
            }else {
                System.out.println("Access denied!!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        //Threadlərdə ele bir situasiya yaradınki  aşagıdakı classlardan istifadə tam optimal olsun
        //2)FixedThreadPool()
        /** FixedThreadPool() ilə əvvəlcədən thread hovuzunda nə qədər thread yaradacağını təyin edirik.
         * Və Həmin yerdə yaradılan threadlər işləməyə başlayır.
         */

        CountDownLatch count = new CountDownLatch(1);
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        fixedThreadPool.execute(new FixedThreadPool());
        count.await(1,TimeUnit.SECONDS);
        System.out.println("count: " + FixedThreadPool.count);
        fixedThreadPool.shutdown();


        //3)	   CachedThreadPool()\
        /*** CachedThreadPool() ilə artıq thread hovuzunda əvvəlcədən thread sayını təyin etmirik.
         * Çünki burada proses zamanı thread lazım olunan qədər yaradılır. Bu Thread növü əsasən
         * resource çox olduğu zaman istifadə olunur. Çünki  Çox thread yaranıb sistemi yavaşlamasına gətirib çıxara bilər
         * */
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(new ExampleExecutorService());
        cachedThreadPool.shutdown();


        //4)	   SingleThreadPool()
        /*** Yalnız bir thread yaranır. Bütün işləri növbə ilə bir thread yerinə yetirir.*/
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(new ExampleExecutorService());
        singleThreadExecutor.shutdown();
        //5)	   ScheduledThreadPool()
        /*** FixedThreadPool() ilə eynidir sadəcə burada artıq interval fırqi var.
         * Buarda .fixedDelay() , .fixedRate() anlayışlarından istifadə olunur.
         * .fixedRate() -> İlk threadın başladığı andan nə qədər sonra ikinci threadın işə düşəcəyini demək bildirmək üçündür
         * .fixedDelay() -> İşləyən thread bitidkdən nə qədər sonra digər threadın işə düşəcəyini bildirir.
         */

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.execute(new ExampleExecutorService());

        scheduledExecutorService.scheduleWithFixedDelay(new ExampleExecutorService(),1,5,TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new ExampleExecutorService(),1,5,TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();

        //8)StringBuilder aid kod numunesi yazın
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            stringBuilder.append(random.nextInt(9));
        }
        System.out.println(stringBuilder);
        //9)	StringBufferdən istifade üçün bir stuasiya yaradın, burada Builder istifadə etmək daha təhlukəli olsun
        Thread thread = new Thread(new BufferExampleExecutor());
        Thread thread1 = new Thread(new BufferExample());
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(stringBuffer);

        /*** Semaphore -> hər hansı bir hissədə nə qədər thread işlədə bilcəyimizi təmin edir.
        //CountDownLatch və CycleBarrier -> isə Executor Servicdə .join() məntiqini tətbiq etməyə yarayır
        */

    }

     static class BufferExample implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                stringBuffer.append("A");
            }
        }
    }
     static class BufferExampleExecutor implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                stringBuffer.append("B");
            }
        }
    }

}