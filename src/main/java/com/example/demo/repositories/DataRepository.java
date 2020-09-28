package com.example.demo.repositories;
import com.example.demo.models.DataPojo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DataRepository extends CrudRepository<DataPojo, Integer>{
}
