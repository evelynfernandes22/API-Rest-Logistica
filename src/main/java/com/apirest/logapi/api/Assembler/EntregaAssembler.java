package com.apirest.logapi.api.Assembler;

import com.apirest.logapi.api.model.EntregaRepresentModel;
import com.apirest.logapi.api.model.imput.EntregaImput;
import com.apirest.logapi.domain.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EntregaAssembler {

    private ModelMapper modelMapper;

    public EntregaRepresentModel toModel(Entrega entrega){
        return modelMapper.map(entrega,EntregaRepresentModel.class);
    }

    public List<EntregaRepresentModel> toCollectionModel(List<Entrega> entregas){
        return entregas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());

    }

    public Entrega toEntity(EntregaImput entregaImput){
        return modelMapper.map(entregaImput, Entrega.class);
    }
}
