package com.cvmanager.backend.controllers;

import com.cvmanager.backend.exceptions.UserNotFoundException;
import com.cvmanager.backend.models.ui.User;
import com.cvmanager.backend.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
    @GetMapping(path = "", produces = "application/json")
    public ResponseEntity<List<User>> getUsers(@RequestParam(name = "name", required = false) String name) {
        logger.info("GET /users request received");

        try {
            return StringUtils.isEmpty(name) ?
                    new ResponseEntity<>(userService.getUsers(), HttpStatus.OK) :
                    new ResponseEntity<>(userService.getUserByName(name), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<User> getUsersById(@PathVariable("id") String id) {
        logger.info("GET /users/id request received");
        try {
            return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        logger.info("POST /users request received");
        try {
            User newUser = userService.addUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
    @PutMapping(path = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        logger.info("PUT /users request received");
        try {
            return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
