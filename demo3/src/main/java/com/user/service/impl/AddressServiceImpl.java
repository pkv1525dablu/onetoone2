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

    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        // dto to entity
        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());


        User user = new User();
        user.setAddress(address);  // addresss
        address.setUser(user);

        userRepository.save(user);
        Address save = addressRepository.save(address);


        // entity to dto
        AddressDto dto = new AddressDto();
        dto.setId(save.getId());
        dto.setCity(save.getCity());
        dto.setStreet(save.getStreet());

        return  dto;
    }

    }

