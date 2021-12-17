package io.github.kwisatzx.mvccompanyrestconsumer.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

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
