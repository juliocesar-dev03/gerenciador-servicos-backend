        package com.backend.model;

        import com.fasterxml.jackson.annotation.JsonSubTypes;
        import com.fasterxml.jackson.annotation.JsonTypeInfo;
        import jakarta.persistence.*;
        import lombok.Data;

        import java.time.LocalDate;
        import java.time.LocalTime;

        @Entity
        @Data
        @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
        @DiscriminatorColumn(name = "tipo_servico")
        @JsonTypeInfo(
                use = JsonTypeInfo.Id.NAME,
                include = JsonTypeInfo.As.PROPERTY,
                property = "tipo"
        )
        @JsonSubTypes({
                @JsonSubTypes.Type(value = Instalacao.class, name = "INSTALACAO"),
                @JsonSubTypes.Type(value = Manutencao.class, name = "MANUTENCAO"),
                @JsonSubTypes.Type(value = Vistoria.class, name = "VISTORIA"),
                @JsonSubTypes.Type(value = Diagnostico.class, name = "DIAGNOSTICO"),
                @JsonSubTypes.Type(value = ServicoBasico.class, name = "SERVICO_BASICO"),
        })
        public abstract class Servico {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;

            private LocalDate data;

            private LocalTime horario;

            private String cliente;

            private String local;

            private Boolean concluido = false;
        }
