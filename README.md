# Sistema de Gerenciamento de Serviços Técnicos - Backend

Backend de um sistema para gerenciamento de serviços técnicos de uma empresa de eletrotécnica, desenvolvido em **Java com Spring Boot**, com foco em **modelagem de domínio realista**, **arquitetura REST** e **polimorfismo com JPA e Jackson**.

O sistema permite o cadastro, consulta, atualização, conclusão e exclusão de diferentes tipos de serviços técnicos, cada um com características próprias.

## Tipos de Serviço Suportados

O sistema foi modelado para trabalhar com múltiplos tipos de serviço utilizando **herança**:

- Instalação
- Manutenção
- Diagnóstico
- Vistoria
- Serviço Básico

Cada tipo possui seus próprios campos e regras, mantendo uma estrutura unificada no backend.

## Arquitetura e Conceitos Utilizados

- **Spring Boot**
- **Spring Data JPA**
- **Arquitetura REST**
- **Camadas bem definidas**:
  - Controller (API)
  - Service (regras de negócio)
  - Repository (persistência)
- **Herança JPA (SINGLE_TABLE)**
- **Polimorfismo com Jackson**
  - Uso de `@JsonTypeInfo` e `@JsonSubTypes`
- **Banco H2** (ambiente de desenvolvimento)
- **Lombok** para redução de boilerplate

## 🔄 Polimorfismo com JPA + Jackson

O backend utiliza herança com `@Inheritance(strategy = InheritanceType.SINGLE_TABLE)` e discriminação por tipo de serviço.

O tipo do serviço é definido no JSON através do campo `tipo`, permitindo que o backend identifique automaticamente qual subclasse deve ser instanciada e persistida.

### Exemplo de JSON (Instalação)

```json
{
  "tipo": "INSTALACAO",
  "data": "2026-01-30",
  "horario": "14:00",
  "cliente": "Empresa XYZ",
  "local": "Rio de Janeiro",
  "equipamento": "Carregador Veicular",
  "atividade": "Instalação de carregador",
  "fonteAlimentacao": "Rede Trifásica",
  "concluido": false
}
```

## Endpoints REST

- **Listar serviços**
  - `GET /api/servicos`
  - `GET /api/servicos?concluido=true`

- **Buscar serviço por ID**
  - `GET /api/servicos/{id}`

- **Criar serviço**
  - `POST /api/servicos`

- **Atualizar serviço**
  - `PUT /api/servicos/{id}`

- **Concluir serviço**
  - `PATCH /api/servicos/{id}/concluir`

- **Deletar serviço**
  - `DELETE /api/servicos/{id}`

## Testes

Os endpoints foram testados utilizando Postman, validando:

- Criação de serviços
- Listagem e filtros
- Atualização
- Conclusão de serviços
- Exclusão

## Frontend do Projeto

Este sistema possui um frontend desenvolvido em Angular, responsável pela interface de gerenciamento dos serviços técnicos.

Repositório do frontend:
https://github.com/juliocesar-dev03/gerenciador-servicos-frontend

## Autor

Desenvolvido por **Júlio César**