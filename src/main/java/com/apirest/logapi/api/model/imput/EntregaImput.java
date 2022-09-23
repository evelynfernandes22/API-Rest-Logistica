package com.apirest.logapi.api.model.imput;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EntregaImput {

    @Valid
    @NotNull
    private ClienteIdImput cliente;
    @Valid
    @NotNull
    private DestinatarioImput destinatario;

    @NotNull
    private BigDecimal taxa;

}
