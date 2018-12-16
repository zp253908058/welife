package com.swpu.welife.web.controller;

import com.swpu.welife.web.model.EmptyEntity;
import com.swpu.welife.web.model.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sign/")
public class SignController {

    @PostMapping("in")
    public String signIn(@RequestParam String username) {
        return "success";
    }

    @GetMapping("register")
    public ResponseEntity<EmptyEntity> register() {
        return new ResponseEntity<>();
    }
}
