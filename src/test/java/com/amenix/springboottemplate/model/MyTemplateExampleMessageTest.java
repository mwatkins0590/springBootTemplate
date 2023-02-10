package com.amenix.springboottemplate.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



public class MyTemplateExampleMessageTest {

    @Test
    void create_new_my_template_example_message() {
        MyTemplateExampleMessage msg = new MyTemplateExampleMessage();
        msg.setId(UUID.randomUUID().toString());
        msg.setAuthor("MockAuthor");
        msg.setMessage("This is a test message!");
        msg.setCreateDate(LocalDateTime.now(ZoneOffset.UTC));
        msg.setId(UUID.randomUUID().toString());
        assertNotNull(msg);
        assertEquals("MockAuthor", msg.getAuthor(), "author didnt match!");
    }
}
