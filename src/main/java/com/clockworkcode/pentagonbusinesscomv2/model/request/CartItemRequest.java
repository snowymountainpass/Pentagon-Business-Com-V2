package com.clockworkcode.pentagonbusinesscomv2.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CartItemRequest {

    private final String userToken;
    private final String productID;
    private final String quantity;

}
