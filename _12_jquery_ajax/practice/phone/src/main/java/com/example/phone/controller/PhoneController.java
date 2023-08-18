package com.example.phone.controller;

import com.example.phone.model.Phone;
import com.example.phone.service.ServicePhone;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/smartphones")
@AllArgsConstructor
public class PhoneController {
    private final ServicePhone smartPhoneService;
    @GetMapping
    public ResponseEntity<Iterable<Phone>> findAll() {
        return new ResponseEntity<>(smartPhoneService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Phone> save(@RequestBody Phone smartphone) {
        return new ResponseEntity<>(smartPhoneService.save(smartphone), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Phone> delete(@PathVariable Long id){
        Optional<Phone> smartphoneOptional = smartPhoneService.findById(id);
        if (smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        smartPhoneService.remove(id);

        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.OK);
    }
}
