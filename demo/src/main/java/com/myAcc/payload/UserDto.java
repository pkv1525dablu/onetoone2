package com.myAcc.payload;

import com.myAcc.entities.Address;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String name;

    private Address address;

}


