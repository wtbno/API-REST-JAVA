package com.onedigitalinnovation.personapi.service;

import com.onedigitalinnovation.personapi.dto.MessageResponseDTO;
import com.onedigitalinnovation.personapi.dto.request.PersonDTO;
import com.onedigitalinnovation.personapi.entity.Person;
import com.onedigitalinnovation.personapi.mapper.PersonMapper;
import com.onedigitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;


    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);


        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Create person with ID " + savedPerson.getId())
                .build();

    }
}
