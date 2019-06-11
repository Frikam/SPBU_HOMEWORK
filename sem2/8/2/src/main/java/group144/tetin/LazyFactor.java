package group144.tetin;

import java.util.function.Supplier;

public class LazyFactor {

    /**
     * A method that create thread lazy calculation
     */
    public static <T> Lazy<T> createOneThreadLazy(Supplier<T> supplier) {
        return new OneThreadLazy<>(supplier);
    }

    /**
     * A method that create multi threads lazy calculation
     */
    public static <T> Lazy<T> createMultiThreadLazy(Supplier<T> supplier) {
        return new MultiThreadLazy<>(supplier);
    }

    /**
     * A class that represent one thread lazy calculation
     */
    private static class OneThreadLazy<T> implements Lazy<T> {
        private T value;
        private Supplier<T> supplier;

        @Override
        public T get() {
            if (supplier != null) {
                value = supplier.get();
                supplier = null;
            }
            return value;
        }

        OneThreadLazy(Supplier<T> supplier) {
            this.supplier = supplier;
        }
    }

    /**
     * A class that represent multi threads lazy calculation
     */
    private static class MultiThreadLazy<T> implements Lazy<T> {
        private T value;
        private volatile Supplier<T> supplier;

        @Override
        public T get() {
            if (supplier != null) {
                synchronized (this) {
                    value = supplier.get();
                    supplier = null;
                }
            }
            return value;
        }

        public MultiThreadLazy(Supplier<T> supplier) {
            this.supplier = supplier;
        }
    }
}
