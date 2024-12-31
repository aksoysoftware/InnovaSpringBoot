package com.hamitmizrak.innova_springboot.security.jwttoken;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

// LOMBOK
@Getter
@Setter
@ToString
public class _1_LoginRequest implements Serializable {

    // Serializable
    public static final Long serialVersionUID = 1L;

    // Field
    private String username;
    private String password;
}
