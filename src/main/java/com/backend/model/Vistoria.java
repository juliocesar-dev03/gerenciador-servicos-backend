package com.backend.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Entity
@Data
@DiscriminatorValue("VISTORIA")
public class Vistoria extends Servico {

    private String escopo;

    private String fonteAlimentacao;
    private String disjuntorEntrada;
    private String secaoCondutorEntrada;
    private String aterramento;

    private Double distanciaDisjuntorEntrada;

    private List<String> tipoInfraestrutura;

    private Double tensaoL1L2;
    private Double tensaoL1L3;
    private Double tensaoL2L3;

    private String observacoes;

    private String acompanhadoPor;

    private String previsaoDuracao;

    @ElementCollection
    private List<String> materiais;
}