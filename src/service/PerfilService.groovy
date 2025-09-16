package service

import model.Candidato
import model.Empresa

class PerfilService {

    Candidato criarNovoCandidato(String nome, String cpf, int idade, String email, String descricao, String cep, String estado, String pais, List<String> competencias) {
        new Candidato(nome, email, descricao, cep, estado, pais, competencias, cpf, idade)
    }

    void atualizarPerfilCandidato(Candidato c, String novoNome, String novoCpf, Integer novaIdade, String novoEmail, String novaDescricao, String novoCep, String novoEstado, String novoPais, List<String> novasCompetencias) {
        if (novoNome) c.nome = novoNome
        if (novoCpf) c.cpf = novoCpf
        if (novaIdade != null) c.idade = novaIdade
        if (novoEmail) c.email = novoEmail
        if (novaDescricao) c.descricao = novoDescricao
        if (novoCep) c.cep = novoCep
        if (novoEstado) c.estado = novoEstado
        if (novoPais) c.pais = novoPais
        if (novasCompetencias) c.competencias.addAll(novasCompetencias)
    }

    Empresa criarNovaEmpresa(String nome, String cnpj, String email, String descricao, String cep, String estado, String pais, List<String> competencias) {
        new Empresa(nome, email, descricao, cep, estado, pais, competencias, cnpj)
    }

    void atualizarPerfilEmpresa(Empresa e, String novoNome, String novoCnpj, String novoEmail, String novaDescricao, String novoCep, String novoEstado, String novoPais, List<String> novasCompetencias) {
        if (novoNome) e.nome = novoNome
        if (novoCnpj) e.cnpj = novoCnpj
        if (novoEmail) e.email = novoEmail
        if (novaDescricao) e.descricao = novaDescricao
        if (novoCep) e.cep = novoCep
        if (novoEstado) e.estado = novoEstado
        if (novoPais) e.pais = novoPais
        if (novasCompetencias) e.competencias.addAll(novasCompetencias)
    }
}
