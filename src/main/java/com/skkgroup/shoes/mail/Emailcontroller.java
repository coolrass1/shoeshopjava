package com.skkgroup.shoes.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/v1/mail")
public class Emailcontroller {
    @Autowired
    EmailServiceImpl emailService;
    @PostMapping("/send")
    public String Sendm(){

        try {
            emailService.sendSimpleMessage("rassoul76@yahoo.fr","testing", "hoc vv");
            return "email sent";
        }catch (Exception e) {
            System.out.println("Something went wrong.");
            return "error";
        }




    }
}
