package com.lemonsalve.mangement;

import java.util.List;

public interface Remover<E>{
    void remove(E item);
    void removeAll(List<E> items);
}
