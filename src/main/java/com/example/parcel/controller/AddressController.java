package com.example.parcel.controller;

import com.example.parcel.Messages.SysMessage;
import com.example.parcel.model.Address;
import com.example.parcel.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/address/")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Address address){
        addressService.add(address);
        return ResponseEntity.ok(SysMessage.ADDRESS_CREATED);
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(addressService.getAll());
    }


    @DeleteMapping("deleteaddress/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        addressService.deleteById(id);
        return ResponseEntity.ok(SysMessage.ADDRESS_DELETED);
    }

    @GetMapping("getAddressByUserId/{userId}")
    public ResponseEntity<?> getAddressByUserId(@PathVariable int userId) {
        return ResponseEntity.ok(addressService.getAddressByUserId(userId));
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return ResponseEntity.ok(addressService.getById(id));
    }
}
