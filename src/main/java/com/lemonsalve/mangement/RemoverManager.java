package lib.managment.implementations;

import lib.managment.interfaces.Remover;

import java.util.List;

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