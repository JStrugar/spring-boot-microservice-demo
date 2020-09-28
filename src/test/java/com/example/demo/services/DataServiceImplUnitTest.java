package com.example.demo.services;

import com.example.demo.DemoApplication;
import com.example.demo.models.DataPojo;
import com.example.demo.repositories.DataRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;

@SpringBootTest(classes = DemoApplication.class)
@ExtendWith(MockitoExtension.class)
public class DataServiceImplUnitTest {

    @Mock
    private DataRepository dataRepository;
    @InjectMocks
    private DataServiceImpl dataService;

    @Test
    public void AddLeftData() {
        int id = 1;
        String left = "TGV2byE=";
        DataPojo expected = new DataPojo(1, Base64.getDecoder().decode(left), null);
        dataService.saveDataLeft(id, left);
        Mockito.verify(dataRepository, Mockito.atLeastOnce()).findById(1);
        Mockito.verify(dataRepository, Mockito.atLeastOnce()).save(Mockito.any(DataPojo.class));
    }

}
