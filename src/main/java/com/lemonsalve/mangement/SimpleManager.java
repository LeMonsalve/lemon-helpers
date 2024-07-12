package com.lemonsalve.mangement;

import com.lemonsalve.generation.Generator;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Manages the addition, removal, and finding of elements in a collection.
 * <p>
 * This class acts as a facade for three separate interfaces: {@link Finder}, {@link Adder}, and {@link Remover}. It provides a unified interface to add, remove, and find elements based on various criteria. The actual operations are delegated to the implementations of these interfaces provided at construction time.
 * </p>
 *
 * Usage example:
 * <pre>
 * {@code
 * Manager<String> manager = new SimpleManager<>(new StringFinder(), new StringAdder(), new StringRemover());
 * manager.add("example");
 * Optional<String> found = manager.findFirst();
 * manager.remove("example");
 * }
 * </pre>
 *
 * @param <E> the type of elements managed by this class
 *
 * @see Manager
 * @author lemonsalve
 */
public class SimpleManager<E> implements Manager<E> {
    private final Finder<E> finder;
    private final Adder<E> adder;
    private final Remover<E> remover;

    /**
     * Creates a new instance of this class with the specified finder, adder, and remover.
     *
     * @param finder  the finder to use
     * @param adder   the adder to use
     * @param remover the remover to use
     */
    public SimpleManager(final Finder<E> finder, final Adder<E> adder, final Remover<E> remover) {
        this.finder = finder;
        this.adder = adder;
        this.remover = remover;
    }

    @Override
    public List<E> findAll() {
        return finder.findAll();
    }

    @Override
    public Optional<E> findFirst() {
        return finder.findFirst();
    }

    @Override
    public Optional<E> findLast() {
        return finder.findLast();
    }

    @Override
    public Optional<E> findBy(final Predicate<E> filter) {
        return finder.findBy(filter);
    }

    @Override
    public List<E> findAllBy(Predicate<E> filter) {
        return finder.findAllBy(filter);
    }

    @Override
    public void add(final E item) {
        adder.add(item);
    }

    @Override
    public void addAll(final List<E> items) {
        adder.addAll(items);
    }

    @Override
    public void remove(final E item) {
        remover.remove(item);
    }

    @Override
    public void removeAll(final List<E> items) {
        remover.removeAll(items);
    }
}