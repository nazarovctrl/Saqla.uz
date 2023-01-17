package com.example.thymleaf.dto.auth;

import com.example.thymleaf.enums.ProfileRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDTO {

    private String name;
    private String surname;
    private ProfileRole role;
    private String token;

}
