package model

class Candidato extends Pessoa {

    String cpf
    int idade

    Candidato(String nome, String email, String descricao, String cep, String estado, String pais, List<String> competencias, String cpf, int idade) {
        super(nome, email, descricao, cep, estado, pais, competencias)
        this.cpf = cpf
        this.idade = idade
    }

    @Override
    String toString() {
        return "Candidato -> Nome: ${nome}, CPF: ${cpf}, Idade: ${idade}, Email: ${email}, Competências: ${competencias.join(', ')}"
    }

    Candidato() {}
}