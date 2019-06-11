package group144.tetin;

import org.junit.Test;
import java.util.function.Supplier;
import static org.junit.Assert.*;

public class LazyFactorTest {

    @Test
    public void createNonSynchronizedLazyCommonTest() {
        SupplierWithCounter<Integer> supplier = new SupplierWithCounter<>(1);
        Lazy<Integer> lazy = LazyFactor.createOneThreadLazy(supplier);

        assertEquals(Integer.valueOf(1), lazy.get());

        lazy.get();
        lazy.get();
        lazy.get();
        assertEquals(1, supplier.numberOfCalls);

        assertEquals(Integer.valueOf(1), lazy.get());
    }

    @Test
    public void createNonSynchronizedLazyNullTest() {
        SupplierWithCounter<Integer> supplier = new SupplierWithCounter<>(null);
        Lazy<Integer> lazy = LazyFactor.createOneThreadLazy(supplier);

        assertEquals(null, lazy.get());

        lazy.get();
        lazy.get();
        assertEquals(1, supplier.numberOfCalls);

        assertEquals(null, lazy.get());
    }

    @Test
    public void createSynchronizedLazyCommonTest() {
        SupplierWithCounter<String> supplier = new SupplierWithCounter<>("ABC");
        Lazy<String> lazy = LazyFactor.createMultiThreadLazy(supplier);

        assertEquals("ABC", lazy.get());

        lazy.get();
        lazy.get();
        assertEquals(1, supplier.numberOfCalls);

        assertEquals("ABC", lazy.get());
    }

    @Test
    public void createSynchronizedLazyNullTest() {
        SupplierWithCounter<Integer> supplier = new SupplierWithCounter<>(null);
        Lazy<Integer> lazy = LazyFactor.createMultiThreadLazy(supplier);

        assertEquals(null, lazy.get());

        lazy.get();
        lazy.get();
        assertEquals(1, supplier.numberOfCalls);

        assertEquals(null, lazy.get());
    }

    @Test
    public void synchronizedRaceCaseTest() {
        SupplierWithCounter<String> supplier = new SupplierWithCounter<>("Race");
        Lazy<String> lazy = LazyFactor.createMultiThreadLazy(supplier);

        int NUMBER_OF_THREADS = 1000;
        Thread[] threads = new Thread[NUMBER_OF_THREADS];
        for (int i = 0; i < NUMBER_OF_THREADS; i++) { // initializing all threads
            threads[i] = new Thread(() -> assertEquals("Race", lazy.get()));
        }

        for (int i = 0; i < NUMBER_OF_THREADS; i++) { // starting all threads
            threads[i].start();
        }

        for (int i = 0; i < NUMBER_OF_THREADS; i++) { // joining all threads
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        assertEquals(1, supplier.numberOfCalls);
        assertEquals("Race", lazy.get());
    }

    private class SupplierWithCounter<T> implements Supplier<T> {
        private int numberOfCalls = 0;
        private T value;

        private SupplierWithCounter(T value) {
            this.value = value;
        }

        @Override
        public T get() {
            numberOfCalls++;
            return value;
        }
    }
}