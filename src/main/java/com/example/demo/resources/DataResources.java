package com.example.demo.resources;

import com.example.demo.services.DataService;
import com.example.demo.services.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("v1/diff")
public class DataResources {

    @Autowired
    private DataService dataService;

    @PostMapping("/{id}/left")
    public void postLeft(@PathVariable("id") final int id, @RequestBody DataResource data) {
        dataService.saveDataLeft(id, data.getData().getBytes());
    }

    @PostMapping("/{id}/right")
    public void postRight(@PathVariable("id") final int id, @RequestBody DataResource data) {
        dataService.saveDataRight(id, data.getData().getBytes());
    }
}
