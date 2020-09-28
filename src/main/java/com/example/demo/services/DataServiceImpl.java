package com.example.demo.services;

import com.example.demo.models.DataPojo;
import com.example.demo.repositories.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
public class DataServiceImpl implements DataService{

    @Autowired
    public DataServiceImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    private DataRepository dataRepository;
    public void saveDataLeft(int id, byte[] data) {
        Optional<DataPojo> dataPojoOptional = dataRepository.findById(id);
        byte[] byteData = Base64.getDecoder().decode(data);
        DataPojo dataPojo = null;
        if(dataPojoOptional.isPresent()) {
            dataPojo = dataPojoOptional.get();
            dataPojo.setLeftData(byteData);
        } else {
            dataPojo = new DataPojo(id, byteData, null);
        }
        dataRepository.save(dataPojo);
    }

    public void saveDataRight(int id, byte[] data) {
        Optional<DataPojo> dataPojoOptional = dataRepository.findById(id);
        byte[] byteData = Base64.getDecoder().decode(data);
        DataPojo dataPojo = null;
        if(dataPojoOptional.isPresent()) {
            dataPojo = dataPojoOptional.get();
            dataPojo.setRightData(byteData);
        } else {
            dataPojo = new DataPojo(id, null, byteData);
        }
        dataRepository.save(dataPojo);
    }

    @Override
    public boolean getDiff(int id) {
        DataPojo dataPojo;
        Optional<DataPojo> dataPojoOptional = dataRepository.findById(id);
        if(!dataPojoOptional.isPresent()) {
            return false;
        }

        dataPojo = dataPojoOptional.get();
        String left = new String(dataPojo.getLeftData());
        String right = new String((dataPojo.getRightData()));

        if(left.length() == right.length()) {
            return true;
        }

        return false;
    }
}
