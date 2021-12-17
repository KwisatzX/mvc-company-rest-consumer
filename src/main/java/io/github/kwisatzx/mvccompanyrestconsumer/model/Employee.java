package io.github.kwisatzx.mvccompanyrestconsumer.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Getter
@Setter
public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private Character sex;
    private Double salary;
    private Employee superior;
    private Branch branch;

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}
