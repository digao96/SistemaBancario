package br.com.banco;

public interface Iterator<T> {
    boolean hasNext();
    T next();
}