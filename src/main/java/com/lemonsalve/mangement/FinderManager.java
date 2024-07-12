package com.lemonsalve.mangement;

import com.lemonsalve.generation.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Manages the finding of elements in a collection.
 * <p>
 * This class provides functionality to find elements in a collection based on various criteria. It supports finding the first, last, and any element that matches a given predicate.
 * </p>
 *
 * Usage example:
 * <pre>
 * {@code
 * List<String> items = new ArrayList<>("example1", "example2", "example3");
 * Finder<String> finder = new FinderManager<>(items);
 * List<String> all = finder.findAll();
 * Optional<String> first = finder.findFirst();
 * Optional<String> last = finder.findLast();
 * Optional<String> anyMatch = finder.findBy(s -> s.contains("2"));
 * List<String> allBy = finder.findAllBy(s -> s.contains("3"));
 * }
 * </pre>
 *
 * @param <T> the type of elements this manager handles
 *
 * @see Finder
 * @author lemonsalve
 */
public class FinderManager<T> implements Finder<T> {
    private final List<T> items;

    public FinderManager(List<T> items) {
        this.items = items;
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(items);
    }

    @Override
    public Optional<T> findFirst() {
        return findOptionalByIndex(0);
    }

    @Override
    public Optional<T> findLast() {
        final int lastIndex = items.size() - 1;
        return findOptionalByIndex(lastIndex);
    }

    @Override
    public Optional<T> findBy(final Predicate<T> filter) {
        return items.stream().filter(filter).findFirst();
    }

    @Override
    public List<T> findAllBy(Predicate<T> filter) {
        return items.stream().filter(filter).toList();
    }

    private Optional<T> findOptionalByIndex(final int index) {
        boolean isIndexValid = index >= 0 && index < items.size();

        if (isIndexValid) {
            return Optional.of(items.get(index));
        } else {
            return Optional.empty();
        }
    }
}