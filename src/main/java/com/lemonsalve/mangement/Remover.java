package lib.managment.interfaces;

import java.util.List;

public interface Remover<E>{
    void remove(E item);
    void removeAll(List<E> items);
}
