package io.github.kwisatzx.mvccompanyrestconsumer.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "name")
@Getter
@Setter
public class Branch {

    private Long id;
    private String name;
    private Employee manager;
    private LocalDate mgrStartDate;
    private Set<Client> clients;
    private Set<Employee> employees;

    public String getClientsDisplayString() {
        return getClients().stream().map(Client::toString).collect(Collectors.joining(", "));
    }

    public String getEmployeesDisplayString() {
        return getEmployees().stream().map(Employee::toString).collect(Collectors.joining(", "));
    }

    @Override
    public String toString() {
        return getName();
    }
}
