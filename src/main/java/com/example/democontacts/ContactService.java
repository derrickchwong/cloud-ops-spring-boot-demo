package com.example.democontacts;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Observed(name = "contactService")
public class ContactService {
  private final MeterRegistry meterRegistry;
  private ContactRepository contactRepository;

  public ContactService(MeterRegistry meterRegistry, ContactRepository contactRepository) {
    this.meterRegistry = meterRegistry;
    this.contactRepository = contactRepository;
  }

  public Contact addContact(Contact contact){
    log.info("new contact {}", contact);
    this.meterRegistry.counter("numberOfContacts").increment();
    return contactRepository.save(contact);
  }

  public Contact getContactById(Long id){
    return contactRepository.getReferenceById(id);
  }


}
