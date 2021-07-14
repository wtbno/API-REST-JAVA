package com.onedigitalinnovation.personapi.mapper;

import com.onedigitalinnovation.personapi.dto.request.PersonDTO;
import com.onedigitalinnovation.personapi.entity.Person;
import com.onedigitalinnovation.personapi.entity.Person.PersonBuilder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-14T10:47:00-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person toModel(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        PersonBuilder person = Person.builder();

        if ( personDTO.birthDate != null ) {
            person.birthDate( LocalDate.parse( personDTO.birthDate, DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }

        return person.build();
    }

    @Override
    public PersonDTO toDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        if ( person.getBirthDate() != null ) {
            personDTO.birthDate = DateTimeFormatter.ISO_LOCAL_DATE.format( person.getBirthDate() );
        }

        return personDTO;
    }
}
