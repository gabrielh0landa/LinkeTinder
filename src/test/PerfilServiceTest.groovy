package test

import model.Candidato
import model.Empresa
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import service.PerfilService

import static org.junit.jupiter.api.Assertions.*

class PerfilServiceTest {

    private PerfilService perfilService

    @BeforeEach
    void setUp() {
        perfilService = new PerfilService()
    }

    @Test
    void "criarCandidatoTeste"() {

        String nome = "Carlos Silva"
        String cpf = "123.456.789-00"
        int idade = 30
        String email = "carlos.silva@example.com"
        String descricao = "Engenheiro de Software"
        String cep = "12345-678"
        String estado = "São Paulo"
        String pais = "Brasil"
        List<String> competencias = ["Java", "Spring Boot"]

        Candidato candidato = perfilService.criarNovoCandidato(nome, cpf, idade, email, descricao, cep, estado, pais, competencias)

        assertNotNull(candidato)
        assertEquals(nome, candidato.nome)
        assertEquals(cpf, candidato.cpf)
    }

    @Test
    void "atualizarCandidatoTeste"() {

        Candidato candidato = new Candidato("Ana Antiga", "ana@antiga.com", "Dev Jr", "11111-111", "RJ", "BR", ["HTML"], "111.111.111-11", 22)

        String novoNome = "Ana Clara Nova"
        String novoCpf = "222.222.222-22"
        Integer novaIdade = 25
        String novoEmail = "ana.nova@email.com"
        String novaDescricao = "Desenvolvedora Pleno"
        String novoCep = "22222-222"
        String novoEstado = "SP"
        String novoPais = "Portugal"
        List<String> novasCompetencias = ["CSS", "JavaScript"]

        perfilService.atualizarPerfilCandidato(candidato, novoNome, novoCpf, novaIdade, novoEmail, novaDescricao, novoCep, novoEstado, novoPais, novasCompetencias)

        assertEquals(novoNome, candidato.nome)
        assertEquals(novoCpf, candidato.cpf)
        assertEquals(novaIdade, candidato.idade)
        assertEquals(novoEmail, candidato.email)
        assertEquals(novaDescricao, candidato.descricao)
        assertEquals(novoCep, candidato.cep)
        assertEquals(novoEstado, candidato.estado)
        assertEquals(novoPais, candidato.pais)
        assertTrue(candidato.competencias.containsAll(["HTML", "CSS", "JavaScript"]), "A lista de competências deve conter tanto as antigas quanto as novas")
    }

    @Test
    void "criarEmpresaTeste"() {

        String nome = "Tech Solutions Ltda"
        String cnpj = "12.345.678/0001-99"
        String email = "contato@techsolutions.com"
        String descricao = "Soluções em nuvem"
        String cep = "87654-321"
        String estado = "Santa Catarina"
        String pais = "Brasil"
        List<String> competencias = ["AWS", "Azure"]

        Empresa empresa = perfilService.criarNovaEmpresa(nome, cnpj, email, descricao, cep, estado, pais, competencias)

        assertNotNull(empresa)
        assertEquals(nome, empresa.nome)
        assertEquals(cnpj, empresa.cnpj)
    }

    @Test
    void "atualizarEmpresaTeste"() {

        Empresa empresa = new Empresa("Firma Velha", "contato@velha.com", "Vendas", "99999-999", "BA", "BR", ["Vendas"], "99.999.999/0001-99")

        String novoNome = "Firma Nova & Cia"
        String novoCnpj = "88.888.888/0001-88"
        String novoEmail = "contato@firmanova.com"
        String novaDescricao = "Marketing Digital e Vendas Globais"
        String novoCep = "88888-888"
        String novoEstado = "SC"
        String novoPais = "Canadá"
        List<String> novasCompetencias = ["Marketing", "SEO"]

        perfilService.atualizarPerfilEmpresa(empresa, novoNome, novoCnpj, novoEmail, novaDescricao, novoCep, novoEstado, novoPais, novasCompetencias)

        assertEquals(novoNome, empresa.nome)
        assertEquals(novoCnpj, empresa.cnpj)
        assertEquals(novoEmail, empresa.email)
        assertEquals(novaDescricao, empresa.descricao)
        assertEquals(novoCep, empresa.cep)
        assertEquals(novoEstado, empresa.estado)
        assertEquals(novoPais, empresa.pais)
        assertTrue(empresa.competencias.containsAll(["Vendas", "Marketing", "SEO"]), "A lista de competências deve conter tanto as antigas quanto as novas")
    }
}