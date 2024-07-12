package lib.managment.interfaces;

import java.util.List;

public interface Adder<E>{
    void add(E item);
    void addAll(List<E> items);
}
