package com.amenix.springboottemplate.controller;


import com.amenix.springboottemplate.model.MyTemplateExampleMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.amenix.springboottemplate.repository.MyTemplateExampleMessageRepository;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MyTemplateExampleMessageController {

    private final MyTemplateExampleMessageRepository msgRepo;


    public MyTemplateExampleMessageController(MyTemplateExampleMessageRepository msgRepo) {
        this.msgRepo = msgRepo;
    }


    @GetMapping
    public List<MyTemplateExampleMessage> findAll() {
        return msgRepo.findAll();
    }
    @GetMapping("/{id}")
    public MyTemplateExampleMessage findById(@PathVariable String id) {
        return msgRepo.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public MyTemplateExampleMessage create(@RequestBody MyTemplateExampleMessage toCreate) {
        return msgRepo.create(toCreate);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody MyTemplateExampleMessage toUpdate, @PathVariable String id) {
        msgRepo.update(toUpdate, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        msgRepo.delete(id);
    }
}
