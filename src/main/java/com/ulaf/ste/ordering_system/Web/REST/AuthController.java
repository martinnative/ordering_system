package com.ulaf.ste.ordering_system.Web.REST;

import com.ulaf.ste.ordering_system.Config.JwtUtil;
import com.ulaf.ste.ordering_system.Model.User;
import com.ulaf.ste.ordering_system.Service.UserService;
import com.ulaf.ste.ordering_system.Web.requests.LoginRequest;
import com.ulaf.ste.ordering_system.Web.responses.JwtResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AuthController {
    private final UserService userService;

    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        // Validate user credentials
        User user = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {
            // Generate JWT token
            String token = jwtUtil.generateToken(user);
            // Return the token to the client
            return ResponseEntity.ok(new JwtResponse(token,user.getUsername(),user.getRole()));
        } else {
            // Invalid credentials
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
