package com.example.demo.services;

import com.example.demo.DemoApplication;
import com.example.demo.repositories.DataRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;

@SpringBootTest(classes = DemoApplication.class)
class DataServiceImplTest {

    @Autowired
    private DataService dataService;

    @Autowired
    private DataRepository dataRepository;

    @BeforeEach
    public void resetDatabase() {
        dataRepository.deleteAll();
    }

    @Test
    public void AddLeftData(){
        int id = 1;
        byte[] left = Base64.getEncoder().encode("Levo!".getBytes());

        dataService.saveDataLeft(id, left);

        byte[] actual = dataRepository.findById(1).get().getLeftData();
        Assertions.assertEquals(new String(actual), "Levo!");
    }

    @Test
    public void AddRightData(){
        int id = 1;
        byte[] right = Base64.getEncoder().encode("Desno!".getBytes());;

        dataService.saveDataRight(id, right);

        byte[] actual = dataRepository.findById(1).get().getRightData();
        Assertions.assertEquals(new String(actual), "Desno!");
    }

    @Test
    public void AddBothData(){
        int id = 1;
        byte[] left = Base64.getEncoder().encode("Levo!".getBytes());;
        byte[] right = Base64.getEncoder().encode("Desno!".getBytes());;

        dataService.saveDataRight(id, right);
        dataService.saveDataLeft(id, left);


        byte[] actualRight = dataRepository.findById(1).get().getRightData();
        byte[] actualLeft = dataRepository.findById(1).get().getLeftData();

        Assertions.assertEquals(new String(actualRight), "Desno!");
        Assertions.assertEquals(new String(actualLeft), "Levo!");
    }

    @Test
    public void GetDiff() {
        int id = 1;
        byte[] left = Base64.getEncoder().encode("Levo!".getBytes());;
        byte[] right = Base64.getEncoder().encode("Desno!".getBytes());;

        dataService.saveDataRight(id, right);
        dataService.saveDataLeft(id, left);

        dataService.getDiff(1);
    }
}