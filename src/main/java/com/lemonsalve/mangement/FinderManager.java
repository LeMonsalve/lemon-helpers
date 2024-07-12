package lib.managment.implementations;

import lib.managment.interfaces.Finder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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

    private Optional<T> findOptionalByIndex(final int index) {
        boolean isIndexValid = index >= 0 && index < items.size();

        if (isIndexValid) {
            return Optional.of(items.get(index));
        } else {
            return Optional.empty();
        }
    }
}