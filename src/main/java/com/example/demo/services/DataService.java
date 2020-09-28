package com.example.demo.services;

public interface DataService {
    void saveDataLeft(int id, String data);
    void saveDataRight(int id, String data);
    boolean getDiff(int id);
}
