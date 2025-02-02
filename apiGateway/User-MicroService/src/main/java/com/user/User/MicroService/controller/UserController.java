package com.user.User.MicroService.controller;

import com.user.User.MicroService.model.User;
import com.user.User.MicroService.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
//    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    @GetMapping("/{userId}")
//    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//    @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
//    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
//    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        logger.info("Get Single User Handler: UserController");
//        logger.info("Retry count: {}", retryCount);

        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }
    @DeleteMapping
    public ResponseEntity<User>deleteUser(@RequestParam("userId")String userId)
    {
        User user =  userService.deleteUserByUserId(userId);
        return ResponseEntity.ok(user);
    }


    @PutMapping

    public ResponseEntity<User>updateUser(@RequestBody User user)
    {
        User savedUser = userService.getUser(user.getUserId());
        savedUser.setAbout(user.getAbout());
        savedUser.setName(user.getName());
        savedUser.setEmail(user.getEmail());
        userService.saveUser(savedUser);
        return ResponseEntity.ok(savedUser);
    }
}
