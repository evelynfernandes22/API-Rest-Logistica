package com.apirest.logapi.api.controller;

import com.apirest.logapi.api.Assembler.OcorrenciaAssembler;
import com.apirest.logapi.api.model.OcorrenciaRepresentModel;
import com.apirest.logapi.api.model.imput.OcorrenciaImput;
import com.apirest.logapi.domain.model.Entrega;
import com.apirest.logapi.domain.model.Ocorrencia;
import com.apirest.logapi.domain.service.BuscaEntregaService;
import com.apirest.logapi.domain.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaAssembler ocorrenciaAssembler;
    private BuscaEntregaService buscaEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaRepresentModel registrar(@PathVariable Long entregaId,
                                             @Valid @RequestBody OcorrenciaImput ocorrenciaImput){
        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId, ocorrenciaImput.getDescricao());

        return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
    }
    @GetMapping
    public List<OcorrenciaRepresentModel> listar(@PathVariable Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
    }
}
