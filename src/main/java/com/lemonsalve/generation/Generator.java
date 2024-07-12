package com.lemonsalve.generation;

import java.util.List;

public interface Generator<T> {
    T generate();
    List<T> generateMany(int amount);
}
