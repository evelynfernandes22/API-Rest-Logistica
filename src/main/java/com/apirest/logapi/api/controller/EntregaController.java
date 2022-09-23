package com.apirest.logapi.api.controller;

import com.apirest.logapi.api.Assembler.EntregaAssembler;
import com.apirest.logapi.api.model.DestinatarioModel;
import com.apirest.logapi.api.model.EntregaRepresentModel;
import com.apirest.logapi.api.model.imput.EntregaImput;
import com.apirest.logapi.domain.model.Entrega;
import com.apirest.logapi.domain.repository.EntregaRepository;
import com.apirest.logapi.domain.service.FinalizacaoEntregaService;
import com.apirest.logapi.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private SolicitacaoEntregaService solicitacaoEntregaService;
    private EntregaRepository entregaRepository;
    private EntregaAssembler entregaAssembler;
    private FinalizacaoEntregaService finalizacaoEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaRepresentModel solicitar(@Valid @RequestBody EntregaImput entregaImput) {
        Entrega novaEntrega = entregaAssembler.toEntity(entregaImput);

        Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
        return entregaAssembler.toModel(entregaSolicitada);
    }

    @GetMapping
    public List<EntregaRepresentModel> listar() {
        return entregaAssembler.toCollectionModel(entregaRepository.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaRepresentModel> buscar(@PathVariable Long entregaId) {
        return entregaRepository.findById(entregaId)
                .map(entrega -> {
                    EntregaRepresentModel entregaRepresentModel = entregaAssembler.toModel(entrega);

//                    EntregaRepresentModel entregaRepresentModel = new EntregaRepresentModel();
//                    entregaRepresentModel.setId(entrega.getId());
//                    entregaRepresentModel.setNomeCliente(entrega.getCliente().getNome());
//                    entregaRepresentModel.setDestinatario(new DestinatarioModel());
//                    entregaRepresentModel.getDestinatario().setNome(entrega.getDestinatario().getNome());
//                    entregaRepresentModel.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
//                    entregaRepresentModel.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
//                    entregaRepresentModel.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
//                    entregaRepresentModel.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
//                    entregaRepresentModel.getDestinatario().setCidade(entrega.getDestinatario().getCidade());
//                    entregaRepresentModel.setTaxa(entrega.getTaxa());
//                    entregaRepresentModel.setStatus(entrega.getStatus());
//                    entregaRepresentModel.setDataPedido(entrega.getDataPedido());
//                    entregaRepresentModel.setDataFinalizacao(entrega.getDataFinalizacao());
                    return ResponseEntity.ok(entregaRepresentModel);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{entregaId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long entregaId) {

        finalizacaoEntregaService.finalizar(entregaId);
    }
}
