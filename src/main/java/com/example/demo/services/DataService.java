package com.example.demo.services;

public interface DataService {
    void saveDataLeft(int id, byte[] data);
    void saveDataRight(int id, byte[] data);
    boolean getDiff(int id);
}
