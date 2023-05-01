package com.skkgroup.shoes.shoemodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shoe")
@CrossOrigin

public class ShoeController {
    @Autowired
    private Shoeservice shoeservice;
    @PostMapping("/create")
    Shoe CreateShoe(@RequestBody  Shoe shoe){
        return shoeservice.CreateShoe(shoe);
    }

    @GetMapping("/list")
    List<Shoe> getAllShoe(){
        return shoeservice.getAllShoe();
    }
    @GetMapping("/{id}")
 Shoe one(@PathVariable Long id) throws Exception {

        return shoeservice.one(id);
    }


}
