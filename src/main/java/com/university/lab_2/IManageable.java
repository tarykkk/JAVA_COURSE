package com.university.lab_2;

import java.util.List;

public interface IManageable {
    void addItem(Item item);
    void removeItem(Item item);
    List<Item> listAvailable();
    List<Item> listBorrowed();
}
