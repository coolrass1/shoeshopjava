package com.skkgroup.shoes.shoemodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Shoeservice {
    @Autowired
    private ShoeJPA shoeJPA;

    Shoe CreateShoe(Shoe shoe){
        return shoeJPA.save(shoe);
    }

    List<Shoe> getAllShoe(){
        return shoeJPA.findAll();
    }
    Shoe one(Long id) throws Exception {

        return shoeJPA.findById(id)
                .orElseThrow(() -> new Exception());
    }
}
