package service;

import model.MenuItem;

import java.util.Scanner;

public interface IMenuService {
    void create(MenuItem item);
    void update(String id,MenuItem updateItem);
    void delete(String id);
    void displayAll();
}
