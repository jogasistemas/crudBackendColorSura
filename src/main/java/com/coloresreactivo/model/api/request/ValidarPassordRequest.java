package com.coloresreactivo.model.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidarPassordRequest {

    private String email;
    private String password;

}
