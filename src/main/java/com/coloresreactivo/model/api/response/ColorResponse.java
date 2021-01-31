package com.coloresreactivo.model.api.response;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColorResponse implements Serializable {

    private static final long serialVersionUID = UUID.randomUUID().hashCode();

    private int id;
    private String name;
    private String color;
    private String pantone;
    private int year;
}
