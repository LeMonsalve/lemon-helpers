package com.lemonsalve.mangement;

import java.util.List;

public interface Adder<E>{
    void add(E item);
    void addAll(List<E> items);
}
