package com.clockworkcode.pentagonbusinesscomv2.model.logout;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class LogoutRequest {
    private final String loginToken;
}
