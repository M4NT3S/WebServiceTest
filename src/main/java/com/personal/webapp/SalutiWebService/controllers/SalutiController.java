package com.personal.webapp.SalutiWebService.controllers;

import com.personal.webapp.SalutiWebService.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/saluti")
@CrossOrigin("http://localhost:4200")
public class SalutiController {

    @GetMapping(path = "/test")
    public String retrieveSaluti(){
        return "\"Hello there, just starting from point 0 once again :)\"";
    }

    @GetMapping(path = "/{username}")
    public String retrieveSalutiDinamically(@PathVariable String username){return "Hello there, "+username +", just starting from point 0 once again :)";}

    @GetMapping(path = "/{name}/{surname}")
    public ResponseEntity<User> createUserDinamically(@PathVariable String name, @PathVariable String surname){
        //The user it's created and inserted in the DB
        User user = new User(name, surname);
        return ResponseEntity.ok().body(user);
    }


}
