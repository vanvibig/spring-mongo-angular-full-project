package com.kv.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/test")
public class TestResource {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/address")
    public List<Address> addresses() {
        return addressRepository.findAll();
    }

    @GetMapping("/student")
    public List<Student> students() {
        return studentRepository.findAll();
    }

    @PostMapping("/address")
    public Address createAddress(@RequestBody Address address) {
        return addressRepository.save(address);
    }

    @DeleteMapping("/address/{id}")
    public void deleteAddress(@PathVariable String id) {
        this.addressRepository.deleteById(id);
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable String id) {
        this.studentRepository.deleteById(id);
    }

}
