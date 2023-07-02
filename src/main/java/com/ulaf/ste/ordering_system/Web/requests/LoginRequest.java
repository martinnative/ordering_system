package com.ulaf.ste.ordering_system.Web.requests;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
