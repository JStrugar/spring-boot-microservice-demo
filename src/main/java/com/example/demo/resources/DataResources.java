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
    public String postLeft(@PathVariable("id") final int id, @RequestBody String data) {
        dataService.saveDataLeft(id, data);
        return "ok";
    }

    @PostMapping("/{id}/right")
    public String postRight(@PathVariable("id") final int id, @RequestBody String data) {
        dataService.saveDataRight(id, data);
        return "ok";
    }
}
