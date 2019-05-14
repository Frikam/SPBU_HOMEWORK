package group144.tetin;

import java.util.function.Supplier;

public class LazyFactor {

    public static <T> Lazy<T> createOneThreadLazy(Supplier<T> supplier) {
        return new Lazy<T>() {
            private boolean wasCalculated = false;
            private T value;

            @Override
            public T get() {
                if (!wasCalculated) {
                    value = supplier.get();
                    wasCalculated = true;
                }
                return value;
            }
        };
    }

    public static <T> Lazy<T> createMultiThreadLazy(Supplier<T> supplier) {
        return new Lazy<T>() {
            private volatile boolean wasCalculated = false;
            private volatile T value;

            @Override
            public T get() {
                if (!wasCalculated) {
                    synchronized (this) {
                        value = supplier.get();
                        wasCalculated = true;
                    }
                }
                return value;
            }
        };
    }
}
