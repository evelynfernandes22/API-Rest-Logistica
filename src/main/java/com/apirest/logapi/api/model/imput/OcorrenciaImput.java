package com.apirest.logapi.api.model.imput;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OcorrenciaImput {

    @NotBlank
    private String descricao;
}
