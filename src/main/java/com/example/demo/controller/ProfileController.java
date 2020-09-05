package com.example.demo.controller;

import java.util.HashMap;
import org.json.JSONObject;

import com.example.demo.model.UserPrincipal;
import lombok.val;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile/")
public class ProfileController {

    @GetMapping("email")
    public String email() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        return principal.getEmail();
    }

    @GetMapping("firstname")
    public String name() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        return principal.getFirstName();
    }

    @GetMapping("userdetails")
    public String userdetails() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        HashMap<String,String> map = new HashMap<>();
        map.put("firstname", principal.getFirstName());
        map.put("lastname", principal.getLastName());
        map.put("email", principal.getEmail());
        map.put("gender", principal.getGender());
        map.put("birthday", principal.getBirthday());
        return new JSONObject(map).toString();
    }

    @GetMapping("id")
    public String userid() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        return principal.getId();
    }
}
