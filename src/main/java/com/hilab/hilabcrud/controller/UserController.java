package com.hilab.hilabcrud.controller;

import com.hilab.hilabcrud.dto.UserInputDTO;
import com.hilab.hilabcrud.dto.UserOutputDTO;
import com.hilab.hilabcrud.model.User;
import com.hilab.hilabcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController() {
    }

    @GetMapping
    public ResponseEntity<List<UserOutputDTO>> getUser(@RequestParam Map<String, String> params){
        try {
            List<User> users = userService.findUser(params);
            List<UserOutputDTO> outputUsers = users
                    .stream()
                    .map(user -> new UserOutputDTO().FromModel(user))
                    .collect(Collectors.toList());

            return new ResponseEntity(outputUsers, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public void create(@Valid @RequestBody UserInputDTO userInputDto) throws Exception {
        this.userService.save(userInputDto.toModel());
    }

    @PutMapping
    public void update(@Valid @RequestBody UserInputDTO userInputDTO) throws Exception {
        this.userService.update(userInputDTO.toModel());
    }
}

