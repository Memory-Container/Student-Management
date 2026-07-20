package Controller;

import Entity.Student;

import java.util.ArrayList;

public interface Controller<T, E> {
    public ArrayList<T> getAll();
    public T getAtIndex(int index);
    public ArrayList<T> filterBy(E property, String searchTerm);
    public boolean add(T newEntity);
    public boolean remove(T oldEntity);
}
