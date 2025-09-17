package test

import model.Candidato
import model.Empresa
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import repository.Repository

import static org.junit.jupiter.api.Assertions.*

class RepositoryTest {

    private Repository repository

    @BeforeEach
    void setUp() {
        repository = new Repository()
    }

    @Test
    void "deve inicializar com 5 candidatos"() {

        List<Candidato> candidatos = repository.listarCandidatos()

        assertNotNull(candidatos)
        assertEquals(5, candidatos.size())
        assertEquals("Gabriel", candidatos[0].nome)
    }

    @Test
    void "deve adicionar um novo candidato"() {

        Candidato novoCandidato = new Candidato("Lucas", "lucas@email.com", "DBA", "60005-000", "CE", "Brasil", ["Oracle", "PostgreSQL"], "444.555.666-77", 29)

        repository.adicionarCandidato(novoCandidato)
        List<Candidato> candidatos = repository.listarCandidatos()

        assertEquals(6, candidatos.size()) // 5 iniciais + 1 novo
        assertEquals("Lucas", candidatos.last().nome)
    }

    @Test
    void "deve buscar um candidato por um índice válido e inválido"() {

        Candidato candidato = repository.buscarCandidato(1) // Deve retornar a "Maria"

        assertNotNull(candidato)
        assertEquals("Maria", candidato.nome)

        Candidato candidatoInexistente = repository.buscarCandidato(99)
        Candidato candidatoInexistenteNegativo = repository.buscarCandidato(-1)

        assertNull(candidatoInexistente)
        assertNull(candidatoInexistenteNegativo)
    }

    @Test
    void "deve atualizar um candidato existente"() {
        Candidato candidatoAtualizado = new Candidato("Gabriel Santos", "gabriel.santos@email.com", "Dev Java Sênior", "60000-000", "CE", "Brasil", ["Java", "SQL", "Spring"], "123.456.789-00", 22)
        int indiceParaAtualizar = 0 // Posição do "Gabriel"

        repository.atualizarCandidato(indiceParaAtualizar, candidatoAtualizado)
        Candidato candidatoBuscado = repository.buscarCandidato(indiceParaAtualizar)

        assertNotNull(candidatoBuscado)
        assertEquals("Gabriel Santos", candidatoBuscado.nome)
        assertEquals("Dev Java Sênior", candidatoBuscado.descricao)
        assertEquals(22, candidatoBuscado.idade)
    }

    @Test
    void "deve inicializar com 5 empresas"() {
        List<Empresa> empresas = repository.listarEmpresas()

        assertNotNull(empresas)
        assertEquals(5, empresas.size())
        assertEquals("TechCorp", empresas[0].nome)
    }

    @Test
    void "deve adicionar uma nova empresa"() {
        Empresa novaEmpresa = new Empresa("CloudExperts", "contato@cloudexperts.com", "Consultoria em nuvem", "60005-001", "CE", "Brasil", ["AWS", "GCP"], "10.203.040/0001-50")

        repository.adicionarEmpresa(novaEmpresa)
        List<Empresa> empresas = repository.listarEmpresas()

        assertEquals(6, empresas.size()) // 5 iniciais + 1 nova
        assertEquals("CloudExperts", empresas.last().nome)
    }

    @Test
    void "deve buscar uma empresa por um índice válido e inválido"() {
        Empresa empresa = repository.buscarEmpresa(2) // Deve retornar a "DataLabs"

        assertNotNull(empresa)
        assertEquals("DataLabs", empresa.nome)


        Empresa empresaInexistente = repository.buscarEmpresa(10)

        assertNull(empresaInexistente)
    }

    @Test
    void "deve atualizar uma empresa existente"() {

        Empresa empresaAtualizada = new Empresa("TechCorp Global", "contato@techcorpglobal.com", "Empresa de tecnologia global", "60000-001", "CE", "Brasil", ["Java", "SQL", "Cloud"], "12.345.678/0001-00")
        int indiceParaAtualizar = 0 // Posição da "TechCorp"

        repository.atualizarEmpresa(indiceParaAtualizar, empresaAtualizada)
        Empresa empresaBuscada = repository.buscarEmpresa(indiceParaAtualizar)

        assertNotNull(empresaBuscada)
        assertEquals("TechCorp Global", empresaBuscada.nome)
        assertEquals("Empresa de tecnologia global", empresaBuscada.descricao)
    }
}