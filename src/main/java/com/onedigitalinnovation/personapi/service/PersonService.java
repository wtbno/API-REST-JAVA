package com.onedigitalinnovation.personapi.service;

import com.onedigitalinnovation.personapi.dto.MessageResponseDTO;
import com.onedigitalinnovation.personapi.dto.request.PersonDTO;
import com.onedigitalinnovation.personapi.entity.Person;
import com.onedigitalinnovation.personapi.exception.PersonNotFoundException;
import com.onedigitalinnovation.personapi.mapper.PersonMapper;
import com.onedigitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private static PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;


    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public static void delete(Long id) throws PersonNotFoundException {
        verifyIfNotExists(id);

    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Create person with ID " + savedPerson.getId())
                .build();

    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople =  personRepository.findAll();

        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }
    public PersonDTO findById( Long Id ) throws PersonNotFoundException {
        Person person = verifyIfNotExists(Id);

        return personMapper.toDTO(person);
    }

    public void deleteById( Long id) throws PersonNotFoundException {
        verifyIfNotExists(id);

        personRepository.deleteById( id );
    }

    private static Person verifyIfNotExists(Long Id) throws PersonNotFoundException {
        return personRepository.findById(Id)
                .orElseThrow(() -> new PersonNotFoundException(Id));
    }

}


