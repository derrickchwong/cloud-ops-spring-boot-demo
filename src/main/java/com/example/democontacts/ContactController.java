package com.example.democontacts;

import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Observed(name = "contactController")

public class ContactController {

  @Autowired
  private ContactService contactService;

  @PostMapping("/contacts")
  public Contact addContact(@RequestBody Contact contact){
    log.info("new contact {}", contact);
    return contactService.addContact(contact);
  }

  @GetMapping("/contacts/{id}")
  public Contact getContactById(@PathVariable Long id){
    return contactService.getContactById(id);
  }

}
