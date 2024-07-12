package com.lemonsalve.mangement;

public interface Manager<E> extends Finder<E>, Adder<E>, Remover<E> {}
