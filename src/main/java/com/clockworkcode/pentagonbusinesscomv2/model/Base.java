package com.clockworkcode.pentagonbusinesscomv2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Base {

    private Timestamp createdAt;
    private Timestamp modifiedAt;
    private Timestamp deletedAt;

}
