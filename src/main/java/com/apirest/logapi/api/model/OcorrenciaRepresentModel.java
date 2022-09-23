package com.apirest.logapi.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OcorrenciaRepresentModel {

    private Long id;
    private String descricao;
    private OffsetDateTime dataRegistro;
}
