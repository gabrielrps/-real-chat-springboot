package br.com.gabrielrps.realchat.realchat.controllers;

import br.com.gabrielrps.realchat.realchat.payload.LoginRequest;
import br.com.gabrielrps.realchat.realchat.payload.LoginResponse;
import br.com.gabrielrps.realchat.realchat.payload.UserRequest;
import br.com.gabrielrps.realchat.realchat.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> getLogin(@RequestBody LoginRequest loginRequest){

        return new ResponseEntity<LoginResponse>(userService.login(loginRequest),HttpStatus.OK);

    }

    @PostMapping("/createUser")
    public ResponseEntity<LoginResponse> createUser(@RequestBody UserRequest userRequest){
        return new ResponseEntity<LoginResponse>(userService.save(userRequest),HttpStatus.OK);

    }

    @DeleteMapping("/deleteOnline/{username}")
    public ResponseEntity<Boolean> deleteOnline(@PathVariable("username") String username){
        return new ResponseEntity<Boolean>(userService.deleteOnline(username),HttpStatus.OK);

    }



}
