package com.clockworkcode.pentagonbusinesscomv2.model.login;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class LoginRequest {
    private final String email;
    private final String password;

}
