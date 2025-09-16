package repository

import model.Candidato
import model.Empresa

class Repository {

    private final List<Candidato> candidatos = []
    private final List<Empresa> empresas = []

    Repository() {
        inicializarDados()
    }

    private void inicializarDados() {
        candidatos.add(new Candidato("Gabriel", "gabriel@email.com", "Dev Java", "60000-000",
                "CE", "Brasil", ["Java", "SQL"], "123.456.789-00", 21))
        candidatos.add(new Candidato("Maria", "maria@email.com", "Front-end", "60001-000",
                "CE", "Brasil", ["HTML", "CSS", "JavaScript"], "987.654.321-00", 23))
        candidatos.add(new Candidato("João", "joao@email.com", "Full Stack", "60002-000",
                "CE", "Brasil", ["Java", "React", "SQL"], "111.222.333-44", 25))
        candidatos.add(new Candidato("Ana", "ana@email.com", "Mobile Developer", "60003-000",
                "CE", "Brasil", ["Kotlin", "Flutter"], "555.666.777-88", 22))
        candidatos.add(new Candidato("Carlos", "carlos@email.com", "Data Scientist", "60004-000",
                "CE", "Brasil", ["Python", "R", "SQL"], "999.888.777-66", 24))

        empresas.add(new Empresa("TechCorp", "contato@techcorp.com", "Empresa de tecnologia", "60000-001",
                "CE", "Brasil", ["Java", "SQL"], "12.345.678/0001-00"))
        empresas.add(new Empresa("WebSolutions", "contato@websolutions.com", "Desenvolvimento web", "60001-001",
                "CE", "Brasil", ["HTML", "CSS", "JavaScript"], "98.765.432/0001-11"))
        empresas.add(new Empresa("DataLabs", "contato@datalabs.com", "Ciência de dados", "60002-001",
                "CE", "Brasil", ["Python", "R", "SQL"], "11.223.344/0001-22"))
        empresas.add(new Empresa("MobileApps", "contato@mobileapps.com", "Desenvolvimento mobile", "60003-001",
                "CE", "Brasil", ["Kotlin", "Flutter"], "55.667.788/0001-33"))
        empresas.add(new Empresa("AI Solutions", "contato@aisolutions.com", "Inteligência artificial", "60004-001",
                "CE", "Brasil", ["Python", "Machine Learning"], "99.887.766/0001-44"))
    }

    void adicionarCandidato(Candidato c) {
        candidatos << c
    }

    List<Candidato> listarCandidatos() {
        candidatos
    }

    Candidato buscarCandidato(int indice) {
        (indice >= 0 && indice < candidatos.size()) ? candidatos[indice] : null
    }

    void atualizarCandidato(int indice, Candidato c) {
        if (indice >= 0 && indice < candidatos.size()) {
            candidatos[indice] = c
        }
    }

    void adicionarEmpresa(Empresa e) {
        empresas << e
    }

    List<Empresa> listarEmpresas() {
        empresas
    }

    Empresa buscarEmpresa(int indice) {
        (indice >= 0 && indice < empresas.size()) ? empresas[indice] : null
    }

    void atualizarEmpresa(int indice, Empresa e) {
        if (indice >= 0 && indice < empresas.size()) {
            empresas[indice] = e
        }
    }
}
