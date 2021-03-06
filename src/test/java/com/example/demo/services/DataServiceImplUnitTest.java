package com.example.demo.services;

import com.example.demo.DemoApplication;
import com.example.demo.models.DataPojo;
import com.example.demo.repositories.DataRepository;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
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
    @Tag("UnitTest")
    public void AddLeftData() {
        int id = 1;
        byte[] left = Base64.getEncoder().encode("Levo!".getBytes());;
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
    @Tag("UnitTest")
    public void AddRightData() {
        int id = 1;
        byte[] right = Base64.getEncoder().encode("Desno!".getBytes());;
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
