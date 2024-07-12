package com.lemonsalve.mangement;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Finder<E> {
    List<E> findAll();
    Optional<E> findFirst();
    Optional<E> findLast();
    Optional<E> findBy(Predicate<E> filter);
    List<E> findAllBy(Predicate<E> filter);
}
