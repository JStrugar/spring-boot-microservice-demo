package com.example.demo.services;

import com.example.demo.DemoApplication;
import com.example.demo.models.DataPojo;
import com.example.demo.repositories.DataRepository;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
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
        final ArgumentCaptor<Integer> idCaptor = ArgumentCaptor.forClass(Integer.class);
        final ArgumentCaptor<DataPojo> dataCaptor = ArgumentCaptor.forClass(DataPojo.class);
        Mockito.verify(dataRepository, Mockito.atLeastOnce()).findById(idCaptor.capture());
        Mockito.verify(dataRepository, Mockito.atLeastOnce()).save(dataCaptor.capture());

        Assertions.assertEquals(1, idCaptor.getValue());
        Assertions.assertEquals(1, dataCaptor.getValue().getId());
        Assertions.assertArrayEquals(Base64.getDecoder().decode("TGV2byE="), dataCaptor.getValue().getLeftData());
        Assertions.assertNull(dataCaptor.getValue().getRightData());
    }


    @Test
    public void AddRightData() {
        int id = 1;
        String right = "RGVzbm8h";
        DataPojo expected = new DataPojo(1, Base64.getDecoder().decode(right), null);
        dataService.saveDataRight(id, right);
        final ArgumentCaptor<Integer> idCaptor = ArgumentCaptor.forClass(Integer.class);
        final ArgumentCaptor<DataPojo> dataCaptor = ArgumentCaptor.forClass(DataPojo.class);
        Mockito.verify(dataRepository, Mockito.atLeastOnce()).findById(idCaptor.capture());
        Mockito.verify(dataRepository, Mockito.atLeastOnce()).save(dataCaptor.capture());

        Assertions.assertEquals(1, idCaptor.getValue());
        Assertions.assertEquals(1, dataCaptor.getValue().getId());
        Assertions.assertArrayEquals(Base64.getDecoder().decode("RGVzbm8h"), dataCaptor.getValue().getRightData());
        Assertions.assertNull(dataCaptor.getValue().getLeftData());
    }
}
