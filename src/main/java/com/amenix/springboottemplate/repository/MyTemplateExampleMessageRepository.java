package com.amenix.springboottemplate.repository;

import com.amenix.springboottemplate.model.MyTemplateExampleMessage;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class MyTemplateExampleMessageRepository {
    static final MyTemplateExampleMessage dummyMsgPrototype;
    public static ArrayList<MyTemplateExampleMessage> prepackedMessages;
    static final int numPrepackedMessages = 10;

    static {
        dummyMsgPrototype = new MyTemplateExampleMessage();
        dummyMsgPrototype.setAuthor("Dummy Dude");
        dummyMsgPrototype.setMessage("Hey I'm not dumb!");
        dummyMsgPrototype.setCreateDate(LocalDateTime.now(ZoneOffset.UTC));
        dummyMsgPrototype.setId(UUID.randomUUID().toString());

        prepackedMessages = new ArrayList<>();
        prepackedMessages.add(dummyMsgPrototype);
        for (int i=0; i<numPrepackedMessages-1; i++){
            prepackedMessages.add(dummyMsgPrototype.clone());
        }
    }

    public MyTemplateExampleMessageRepository(){
    }

    public List<MyTemplateExampleMessage> findAll(){
        return prepackedMessages;
    }

    public MyTemplateExampleMessage findById(String id) {
        return prepackedMessages.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }

    public MyTemplateExampleMessage create(MyTemplateExampleMessage toMake) {
        prepackedMessages.add(toMake);
        return toMake;
    }

    public void update(MyTemplateExampleMessage updatedMessage, String id) {
        MyTemplateExampleMessage toUpdate = prepackedMessages.stream().filter(msg -> msg.getId().equals(id))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Message not found"));
        int i = prepackedMessages.indexOf(toUpdate);
        prepackedMessages.set(i, updatedMessage);
    }

    public void delete(String id){
        prepackedMessages.removeIf(m -> m.getId().equals(id));
    }
}
