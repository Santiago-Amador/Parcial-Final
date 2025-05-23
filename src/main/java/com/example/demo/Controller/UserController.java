package com.example.demo.Controller;

import com.example.demo.Modules.User;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
     @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
     }
     @GetMapping("/email/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.getByEmail(email));
     }
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user){
        userService.createUser(user);
        return ResponseEntity.ok("User created");
    }
    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email){
        userService.deleteUser(email);
        return ResponseEntity.ok("User deleted");
    }
    @PutMapping("/{email}")
    public ResponseEntity<String> updateUser(@PathVariable String email, @RequestBody User user){
        userService.updateUser(email, user);
        return ResponseEntity.ok("User updated");
    }

}
