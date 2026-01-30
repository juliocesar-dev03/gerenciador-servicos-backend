package com.backend.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Entity
@Data
@DiscriminatorValue("INSTALACAO")
public class Instalacao extends Servico {

    private String equipamento;

    private String atividade;

    private String fonteAlimentacao;
    private String disjuntorEntrada;
    private String aterramento;

    private Double distanciaDisjuntorCarregador;

    @ElementCollection
    private List<String> tipoInfraestrutura;

    @ElementCollection
    private List<String> protecoes;

    private String condutores;

    private Double tensaoL1L2;
    private Double tensaoL1T;
    private Double tensaoL2T;

    private Double correnteR;
    private Double correnteS;

    private String observacoes;

    private String acompanhadoPor;
}
