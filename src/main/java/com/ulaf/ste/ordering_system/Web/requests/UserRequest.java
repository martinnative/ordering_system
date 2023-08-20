package com.ulaf.ste.ordering_system.Web.requests;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {
    String username;
    String password;
}
