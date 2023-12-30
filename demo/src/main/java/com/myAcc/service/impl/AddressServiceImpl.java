package com.myAcc.service.impl;


import com.myAcc.entities.Address;
import com.myAcc.entities.User;
import com.myAcc.payload.AddressDto;
import com.myAcc.repository.AddressRepository;
import com.myAcc.repository.UserRepository;
import com.myAcc.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
@Autowired
private AddressRepository addressRepository;
@Autowired
private UserRepository userRepository;

    @Override
    public AddressDto saveAddress(AddressDto addressDto) {

        /// dto to entity
        Address address=new Address();
        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address=addressRepository.save(address);

        // dto to entity
        User user=new User();
        user.setAddress(address);
        address.setUser(user);  // address ke under jo foregin key hai usme id num set hoga user id ke according

        userRepository.save(user);

//        //  entity To Dto
//        UserDto userDto=new UserDto();
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());

        // entity to dto
   AddressDto dto=new AddressDto();
   dto.setId(address.getId());
   dto.setStreet(address.getStreet());
   dto.setCity(address.getCity());

        return dto;
    }
}

