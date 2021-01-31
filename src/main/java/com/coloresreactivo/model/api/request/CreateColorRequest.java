package com.coloresreactivo.model.api.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@ToString
public class CreateColorRequest implements Serializable {

    private static final long serialVersionUID = UUID.randomUUID().hashCode();

    private String color;
    private String pantone;
    private int year;
    private String name;

}
