package com.user.service.impl;

import com.user.entities.Address;
import com.user.entities.User;
import com.user.payload.AddressDto;
import com.user.repository.AddressRepository;
import com.user.repository.UserRepository;
import com.user.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private XyzRepository xyzRepository;

    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        // dto to entity
        Address address = new Address();
        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
         address = addressRepository.save(address);

        // user and address ko exchange kar rahe ahi
        User user = new User();
        user.setAddress(address); // user me address ka value insert kar rahe hai (inside user id insert automatio)
        address.setUser(user);  //  address me user ka value insert ka rahe ahi(inside Address Foreing key inset hoga)
        userRepository.save(user);

        // Xyz & address ko exchange kar rahe hai
        Xyz xyz=new Xyz();
        xyz.setAddress(address);
        address.setXyz(xyz);
        xyzRepository.save(xyz);
        //
        // entity to dto
        AddressDto dto = new AddressDto();
        dto.setId(address.getId());
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        return dto;
    }
}


