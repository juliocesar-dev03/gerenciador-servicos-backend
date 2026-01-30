package com.backend.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Entity
@Data
@DiscriminatorValue("MANUTENCAO")
public class Manutencao extends Servico {

    private String equipamento;

    private String tipoManutencao;

    private String descricaoAtividades;

    @ElementCollection
    private List<String> problemasIdentificados;

    @ElementCollection
    private List<String> pecasSubstituidas;

    private Double tensaoL1L2;
    private Double tensaoL1T;
    private Double tensaoL2T;

    private Double correnteR;
    private Double correnteS;

    private String observacoes;

    private String acompanhadoPor;
}
