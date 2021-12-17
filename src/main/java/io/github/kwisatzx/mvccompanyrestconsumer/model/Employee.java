package io.github.kwisatzx.mvccompanyrestconsumer.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

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
