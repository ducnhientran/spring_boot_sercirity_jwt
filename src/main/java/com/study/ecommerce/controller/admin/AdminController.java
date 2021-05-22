package com.study.ecommerce.controller.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/create")
    @PreAuthorize("hasPermission('ADMIN', 'CREATE')")
    public ResponseEntity<String> create(){
        return ResponseEntity.ok("Admin create action");
    }

    @GetMapping("/list")
    @PreAuthorize("hasPermission('ADMIN', 'LIST')")
    public ResponseEntity<String> list(){
        return ResponseEntity.ok("Admin list action");
    }

    @PutMapping("/update")
    @PreAuthorize("hasPermission('ADMIN', 'UPDATE')")
    public ResponseEntity<String> update(){
        return ResponseEntity.ok("Admin update action");
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasPermission('ADMIN', 'DELETE')")
    public ResponseEntity<String> delete(){
        return ResponseEntity.ok("Admin delete action");
    }
}
