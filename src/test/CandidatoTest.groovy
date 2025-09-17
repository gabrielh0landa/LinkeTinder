package test

import model.Candidato
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.*

class CandidatoTest {

    @Test
    void "construtorComAtributos"() {

        String nome = "Ana Clara"
        String email = "ana.clara@email.com"
        String descricao = "Desenvolvedora backend com experiência em Java e Groovy"
        String cep = "61800-000"
        String estado = "Ceará"
        String pais = "Brasil"
        List<String> competencias = ["Java", "Groovy", "SQL"]
        String cpf = "111.222.333-44"
        int idade = 28


        Candidato candidato = new Candidato(nome, email, descricao, cep, estado, pais, competencias, cpf, idade)


        assertNotNull(candidato)
        assertEquals(nome, candidato.nome)
        assertEquals(email, candidato.email)
        assertEquals(descricao, candidato.descricao)
        assertEquals(cep, candidato.cep)
        assertEquals(estado, candidato.estado)
        assertEquals(pais, candidato.pais)
        assertEquals(competencias, candidato.competencias)
        assertEquals(cpf, candidato.cpf)
        assertEquals(idade, candidato.idade)
    }

    @Test
    void "construtorVazio"() {

        Candidato candidato = new Candidato()


        assertNotNull(candidato)
        assertNull(candidato.nome)
        assertNull(candidato.cpf)
        assertEquals(0, candidato.idade)
    }
}