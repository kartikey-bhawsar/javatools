package com.kartik.bhavsar.util;
public interface KTList<T>
{
public void add(T data);
public void add(int index, T data);
public void insert(int index, T data);
public void removeAll();
public void clear();
public int size();
public T get(int index);
public void update(int index, T data);
public T removeAt(int index);
public void copyTo(KTList<T> other);
public void copyFrom(KTList<T> other);
public void appendTo(KTList<T> other);
public void appendFrom(KTList<T> other);
public KTIterator<T> Iterator();
public void forEach(KTListItemAcceptor<T> a);
}