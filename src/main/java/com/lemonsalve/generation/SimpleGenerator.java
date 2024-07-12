package lib.generation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SimpleGenerator<T> implements Generator<T> {
    private final Supplier<T> supplier;

    public SimpleGenerator(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    @Override
    public T generate() {
        return supplier.get();
    }

    @Override
    public List<T> generateMany(final int amount) {
        final List<T> items = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            T item = generate();
            items.add(item);
        }

        return items;
    }
}
