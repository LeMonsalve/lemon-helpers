package com.lemonsalve.generation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * A utility class for generating objects of a given type.
 * <p>
 * This class uses a {@link java.util.function.Supplier} to generate instances of a specified type {@code T}. It provides methods to generate a single instance or multiple instances of {@code T}.
 * </p>
 *
 * Usage example:
 * <pre>
 * {@code
 * Generator<String> stringGenerator = new SimpleGenerator<>(() -> "example");
 * String singleString = stringGenerator.generate();
 * List<String> strings = stringGenerator.generateMany(5);
 * }
 * </pre>
 *
 * @param <T> the type of objects this generator produces
 *
 * @see Generator
 * @author lemonsalve
 */
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
