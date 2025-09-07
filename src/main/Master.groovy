package main

import controller.PerfilController
import model.Candidato
import model.Empresa

class Master {
    static void main(String[] args) {
        def scanner = new Scanner(System.in)

        def candidatos = []

        candidatos << new Candidato("Fernanda Costa", "fernanda@email.com", "Analista de sistemas com foco em back-end e banco de dados.", "65432-109", "Distrito Federal", "Brasil", ["Python", "SQL"] as ArrayList,  "889988776", 28)
        candidatos << new Candidato("Guilherme Viana", "guilherme@email.com", "Desenvolvedor mobile para plataformas iOS e Android.", "76543-210", "Ceará", "Brasil", ["Swift", "Kotlin"] as ArrayList,  "778877665", 30)
        candidatos << new Candidato("Helena Souza", "helena@email.com", "Especialista em segurança da informação e testes de penetração.", "87654-321", "Pernambuco", "Brasil", ["C++", "Cybersecurity"] as ArrayList,  "667766554", 25)
        candidatos << new Candidato("Igor Nogueira", "igor@email.com", "Engenheiro de software e arquiteto de microserviços.", "98765-432", "Amazonas", "Brasil", ["Go", "Docker"] as ArrayList,  "556655443", 35)
        candidatos << new Candidato("Juliana Dias", "juliana@email.com", "Arquiteta de cloud computing certificada em AWS e Azure.", "09876-543", "Rio Grande do Sul", "Brasil", ["AWS", "Azure"] as ArrayList,  "445544332", 27)

        def empresas = []

        empresas << new Empresa("Cloud Services", "vagas@cloudservices.com", "Empresa focada em soluções de computação em nuvem.", "33.444.555/0001-66", "São Paulo", "Brasil", ["Cloud", "DevOps"] as ArrayList,  "88.999.000/0001-11")
        empresas << new Empresa("Alpha Consultoria", "rh@alphaconsultoria.com", "Consultoria de TI especializada em otimização de processos.", "44.555.666/0001-77", "Rio de Janeiro", "Brasil", ["C#", "SQL Server"] as ArrayList,  "99.000.111/0001-22")
        empresas << new Empresa("Inova Software", "contato@inovasoftware.com", "Desenvolvedora de aplicativos mobile inovadores.", "55.666.777/0001-88", "Minas Gerais", "Brasil", ["Swift", "Kotlin"] as ArrayList,  "11.222.333/0001-33")
        empresas << new Empresa("Data Analytics Co.", "trabalheconosco@dataco.com", "Líder em análise de dados e business intelligence.", "66.777.888/0001-99", "Paraná", "Brasil", ["Python", "R"] as ArrayList,  "22.333.444/0001-44")
        empresas << new Empresa("Connect Solutions", "oportunidades@connect.com", "Fornecedora de soluções de conectividade e IoT.", "77.888.999/0001-00", "Bahia", "Brasil", ["C++", "IoT"] as ArrayList,  "33.444.555/0001-55")

        def perfilController = new PerfilController()
        perfilController.exibirMenu(scanner, candidatos, empresas)

        scanner.close()
    }
}