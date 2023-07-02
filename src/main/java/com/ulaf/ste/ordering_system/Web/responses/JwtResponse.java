package com.ulaf.ste.ordering_system.Web.responses;

import com.ulaf.ste.ordering_system.Model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class JwtResponse {

    private String token;
    private String username;
    private Role role;
}