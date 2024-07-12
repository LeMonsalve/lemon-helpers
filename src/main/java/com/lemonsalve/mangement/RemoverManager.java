package com.lemonsalve.mangement;

import com.lemonsalve.generation.Generator;

import java.util.List;

/**
 * Manages the removal of elements from a collection.
 * <p>
 * This class provides functionality to remove single or multiple elements from a collection. It is designed to work with any type of elements, making it versatile for various use cases.
 * </p>
 *
 * Usage example:
 * <pre>
 * {@code
 * List<String> items = new ArrayList<>("example1", "example2", "example3");
 * Remover<String> remover = new RemoverManager<>(items);
 * remover.remove("example1");
 * remover.removeAll(List.of("example2", "example3"));
 * }
 * </pre>
 *
 * @param <T> the type of elements this manager handles
 *
 * @see Remover
 * @author lemonsalve
 */
public class RemoverManager<T> implements Remover<T> {
    private final List<T> items;

    public RemoverManager(List<T> items) {
        this.items = items;
    }

    @Override
    public void remove(T item) {
        items.remove(item);
    }

    @Override
    public void removeAll(List<T> items) {
        if (items != null) {
            this.items.removeAll(items);
        }
    }
}