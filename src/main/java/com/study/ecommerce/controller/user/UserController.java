package com.study.ecommerce.controller.user;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/create")
    @PreAuthorize("hasPermission('USER', 'CREATE')")
    public ResponseEntity<String> create(){
        return ResponseEntity.ok("User create action");
    }

    @GetMapping("/list")
    @PreAuthorize("hasPermission('USER', 'LIST')")
    public ResponseEntity<String> list(){
        return ResponseEntity.ok("User list action");
    }

    @PutMapping("/update")
    @PreAuthorize("hasPermission('USER', 'UPDATE')")
    public ResponseEntity<String> update(){
        return ResponseEntity.ok("User update action");
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasPermission('USER', 'DELETE')")
    public ResponseEntity<String> delete(){
        return ResponseEntity.ok("User delete action");
    }
}
