//TODO
//1. 가입 -> POST /users 가입 정보 (DTO) => email이 unique key!
//2. 목록, 상세 보고 => ADMIN!
//3. 사용자 정보 갱신 -> PUT/PATCH /users/{id} => 정보 갱신 (DTO) -> 이름만!
//4. 탈퇴 -> DELETE
package com.codesoom.assignment.controllers;

import com.codesoom.assignment.application.UserService;
import com.codesoom.assignment.domain.User;
import com.codesoom.assignment.dto.UserResultData;
import com.codesoom.assignment.dto.UserRegisterationData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UserResultData create(@RequestBody @Valid UserRegisterationData registerationData) {
        User user = userService.registerUser(registerationData);

        return UserResultData.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .build();
    }

    @PatchMapping("{id}")
    UserResultData update() {
        return null;
    }
}
