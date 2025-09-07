package model
import groovy.transform.ToString

@ToString
class Pessoa {
    String nome
    String email
    String descricao
    String cep
    String estado
    String pais
    def competencias = []

    Pessoa(String nome, String email, String descricao, String cep, String estado, String pais, List<String> competencias) {
        this.nome = nome
        this.email = email
        this.descricao = descricao
        this.cep = cep
        this.estado = estado
        this.pais = pais
        this.competencias = competencias
    }

    Pessoa() {
        this.competencias = []
    }

    void exibirPerfil() {
        println toString()
    }


    void adicionarCompetencia(String competencia) {
        competencias << competencia
    }
}