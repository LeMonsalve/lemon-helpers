package lib.managment.implementations;

import lib.managment.interfaces.Adder;

import java.util.List;

public class AdderManager<T> implements Adder<T> {
    private final List<T> items;

    public AdderManager(List<T> items) {
        this.items = items;
    }

    @Override
    public void add(T item) {
        items.add(item);
    }

    @Override
    public void addAll(List<T> items) {
        if (items != null) {
            this.items.addAll(items);
        }
    }
}