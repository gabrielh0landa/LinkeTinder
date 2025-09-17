package test

import model.Empresa
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.*

class EmpresaTest {

    @Test
    void "construtorComAtributos"() {

        String nome = "Inova Software"
        String email = "contato@inovasoftware.com"
        String descricao = "Desenvolvedora de aplicativos mobile inovadores"
        String cep = "55.666-777"
        String estado = "Minas Gerais"
        String pais = "Brasil"
        List<String> competencias = ["Swift", "Kotlin"]
        String cnpj = "55.666.777/0001-88"

        Empresa empresa = new Empresa(nome, email, descricao, cep, estado, pais, competencias, cnpj)

        assertNotNull(empresa)
        assertEquals(nome, empresa.nome)
        assertEquals(email, empresa.email)
        assertEquals(descricao, empresa.descricao)
        assertEquals(cep, empresa.cep)
        assertEquals(estado, empresa.estado)
        assertEquals(pais, empresa.pais)
        assertEquals(competencias, empresa.competencias)
        assertEquals(cnpj, empresa.cnpj)
    }

    @Test
    void "construtorVazio"() {

        Empresa empresa = new Empresa()


        assertNotNull(empresa)
        assertNull(empresa.nome)
    }
}
