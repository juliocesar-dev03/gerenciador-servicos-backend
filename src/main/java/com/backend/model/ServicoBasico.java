package com.backend.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Entity
@Data
@DiscriminatorValue("SERVICO_BASICO")
public class ServicoBasico extends Servico {

    private String tipoServicoBasico;

    private String descricaoServico;

    @ElementCollection
    private List<String> equipamentosEnvolvidos;

    @ElementCollection
    private List<String> ferramentasUtilizadas;

    @ElementCollection
    private List<String> materiaisUtilizados;

    private String resultadoFinal;

    private String observacoes;

    private String acompanhadoPor;
}
