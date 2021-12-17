package io.github.kwisatzx.mvccompanyrestconsumer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client {

    private Long id;
    private String name;
    private Branch branch;
}
