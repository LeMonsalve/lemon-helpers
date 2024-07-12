package com.lemonsalve.mangement;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Manager<E> implements Finder<E>, Adder<E>, Remover<E> {
    private final Finder<E> finder;
    private final Adder<E> adder;
    private final Remover<E> remover;

    public Manager(final Finder<E> finder, final Adder<E> adder, final Remover<E> remover) {
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