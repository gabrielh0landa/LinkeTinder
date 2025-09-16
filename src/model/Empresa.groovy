package model

import groovy.transform.ToString

@ToString(includeSuper = true, includeNames = true)
class Empresa extends Pessoa {

    String cnpj

    Empresa(String nome, String email, String descricao, String cep, String estado, String pais, List<String> competencias = [], String cnpj) {
        super(nome, email, descricao, cep, estado, pais, competencias)
        this.cnpj = cnpj
    }

    Empresa() {}
}
