package com.apirest.logapi.api.model.imput;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClienteIdImput {

    @NotNull
    private Long Id;
}
