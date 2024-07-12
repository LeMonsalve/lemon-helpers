package com.lemonsalve.mangement;

import com.lemonsalve.generation.Generator;

import java.util.List;

/**
 * Manages the addition of elements to a collection.
 * <p>
 * This class provides functionality to add single or multiple elements to a collection. It is designed to work with any type of elements, making it versatile for various use cases.
 * </p>
 *
 * Usage example:
 * <pre>
 * {@code
 * List<String> items = new ArrayList<>();
 * Adder<String> adder = new AdderManager<>(items);
 * adder.add("example");
 * adder.addAll(Arrays.asList("example1", "example2"));
 * }
 * </pre>
 *
 * @param <T> the type of elements this manager handles
 *
 * @see Adder
 * @author lemonsalve
 */
public class AdderManager<T> implements Adder<T> {
    private final List<T> items;

    public AdderManager(List<T> items) {
        this.items = items;
    }

    @Override
    public void add(T item) {
        items.add(item);
    }

    @Override
    public void addAll(List<T> items) {
        if (items != null) {
            this.items.addAll(items);
        }
    }
}