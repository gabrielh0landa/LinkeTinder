package controller

import service.PerfilService
import repository.Repository

class PerfilController {

    private final PerfilService servico = new PerfilService()
    private final Repository repo

    PerfilController(Repository repo) {
        this.repo = repo
    }

    void exibirMenu(Scanner sc) {
        int opcao
        do {
            println "\nMenu:"
            println "1. Criar Perfil de Candidato"
            println "2. Atualizar Perfil de Candidato"
            println "3. Criar Perfil de Empresa"
            println "4. Atualizar Perfil de Empresa"
            println "5. Listar Candidatos"
            println "6. Listar Empresas"
            println "0. Sair"
            print "Escolha uma opção: "

            opcao = sc.nextInt()
            sc.nextLine()

            switch (opcao) {
                case 0:
                    println "Saindo..."
                    break

                case 1:

                    print "Nome: "
                    def nome = sc.nextLine()
                    print "CPF: "
                    def cpf = sc.nextLine()
                    print "Idade: "
                    def idade = sc.nextInt()
                    sc.nextLine()
                    print "Email: "
                    def email = sc.nextLine()
                    print "Descrição: "
                    def descricao = sc.nextLine()
                    print "CEP: "
                    def cep = sc.nextLine()
                    print "Estado: "
                    def estado = sc.nextLine()
                    print "País: "
                    def pais = sc.nextLine()

                    def competencias = []
                    print "Quantas competências deseja adicionar? "
                    def qtd = sc.nextInt()
                    sc.nextLine()
                    qtd.times {
                        print "Competência ${it + 1}: "
                        competencias << sc.nextLine()
                    }

                    def c = servico.criarNovoCandidato(nome, cpf, idade, email, descricao, cep, estado, pais, competencias)
                    repo.adicionarCandidato(c)
                    println "\nCandidato adicionado com sucesso!"
                    break

                case 2:

                    def listaC = repo.listarCandidatos()
                    if (listaC.empty) {
                        println "Não há candidatos cadastrados."
                        break
                    }

                    listaC.eachWithIndex { cand, i -> println "$i: $cand" }

                    print "Qual índice deseja atualizar? (0-${listaC.size() - 1}): "
                    def indice = sc.nextInt()
                    sc.nextLine()

                    def cAtual = repo.buscarCandidato(indice)
                    if (!cAtual) {
                        println "Índice inválido."
                        break
                    }

                    println "Pressione Enter para manter o valor atual."

                    print "Nome atual (${cAtual.nome}): "
                    def entrada = sc.nextLine()
                    def novoNome = entrada ? entrada : null

                    print "CPF atual (${cAtual.cpf}): "
                    entrada = sc.nextLine()
                    def novoCpf = entrada ? entrada : null

                    print "Idade atual (${cAtual.idade}): "
                    entrada = sc.nextLine()
                    def novaIdade = entrada ? entrada.toInteger() : null

                    print "Email atual (${cAtual.email}): "
                    entrada = sc.nextLine()
                    def novoEmail = entrada ? entrada : null

                    print "Descrição atual (${cAtual.descricao}): "
                    entrada = sc.nextLine()
                    def novaDescricao = entrada ? entrada : null

                    print "CEP atual (${cAtual.cep}): "
                    entrada = sc.nextLine()
                    def novoCep = entrada ? entrada : null

                    print "Estado atual (${cAtual.estado}): "
                    entrada = sc.nextLine()
                    def novoEstado = entrada ? entrada : null

                    print "País atual (${cAtual.pais}): "
                    entrada = sc.nextLine()
                    def novoPais = entrada ? entrada : null

                    def novasCompetencias = []
                    println "Competências atuais: ${cAtual.competencias}"
                    println "Adicione novas competências (digite 'fim' para terminar):"
                    while (true) {
                        entrada = sc.nextLine()
                        if (entrada.equalsIgnoreCase("fim")) break
                        if (entrada) novasCompetencias << entrada
                    }

                    servico.atualizarPerfilCandidato(cAtual, novoNome, novoCpf, novaIdade, novoEmail, novaDescricao, novoCep, novoEstado, novoPais, novasCompetencias)
                    repo.atualizarCandidato(indice, cAtual)
                    println "\nCandidato atualizado com sucesso!"
                    break

                case 3:

                    print "Nome: "
                    def nomeE = sc.nextLine()
                    print "CNPJ: "
                    def cnpj = sc.nextLine()
                    print "Email: "
                    def emailE = sc.nextLine()
                    print "Descrição: "
                    def descricaoE = sc.nextLine()
                    print "CEP: "
                    def cepE = sc.nextLine()
                    print "Estado: "
                    def estadoE = sc.nextLine()
                    print "País: "
                    def paisE = sc.nextLine()

                    def competenciasE = []
                    print "Quantas competências deseja adicionar? "
                    def qtdE = sc.nextInt()
                    sc.nextLine()
                    qtdE.times {
                        print "Competência ${it + 1}: "
                        competenciasE << sc.nextLine()
                    }

                    def eNova = servico.criarNovaEmpresa(nomeE, cnpj, emailE, descricaoE, cepE, estadoE, paisE, competenciasE)
                    repo.adicionarEmpresa(eNova)
                    println "\nEmpresa adicionada com sucesso!"
                    break

                case 4:

                    def listaE = repo.listarEmpresas()
                    if (listaE.empty) {
                        println "Não há empresas cadastradas."
                        break
                    }

                    listaE.eachWithIndex { emp, i -> println "$i: $emp" }

                    print "Qual índice deseja atualizar? (0-${listaE.size() - 1}): "
                    def idxE = sc.nextInt()
                    sc.nextLine()

                    def eAtual = repo.buscarEmpresa(idxE)
                    if (!eAtual) {
                        println "Índice inválido."
                        break
                    }

                    println "Pressione Enter para manter o valor atual."

                    print "Nome atual (${eAtual.nome}): "
                    def entradaE = sc.nextLine()
                    def novoNomeE = entradaE ? entradaE : null

                    print "CNPJ atual (${eAtual.cnpj}): "
                    entradaE = sc.nextLine()
                    def novoCnpj = entradaE ? entradaE : null

                    print "Email atual (${eAtual.email}): "
                    entradaE = sc.nextLine()
                    def novoEmailE = entradaE ? entradaE : null

                    print "Descrição atual (${eAtual.descricao}): "
                    entradaE = sc.nextLine()
                    def novaDescricaoE = entradaE ? entradaE : null

                    print "CEP atual (${eAtual.cep}): "
                    entradaE = sc.nextLine()
                    def novoCepE = entradaE ? entradaE : null

                    print "Estado atual (${eAtual.estado}): "
                    entradaE = sc.nextLine()
                    def novoEstadoE = entradaE ? entradaE : null

                    print "País atual (${eAtual.pais}): "
                    entradaE = sc.nextLine()
                    def novoPaisE = entradaE ? entradaE : null

                    def novasCompetenciasE = []
                    println "Competências atuais: ${eAtual.competencias}"
                    println "Adicione novas competências (digite 'fim' para terminar):"
                    while (true) {
                        entradaE = sc.nextLine()
                        if (entradaE.equalsIgnoreCase("fim")) break
                        if (entradaE) novasCompetenciasE << entradaE
                    }

                    servico.atualizarPerfilEmpresa(eAtual, novoNomeE, novoCnpj, novoEmailE, novaDescricaoE, novoCepE, novoEstadoE, novoPaisE, novasCompetenciasE)
                    repo.atualizarEmpresa(idxE, eAtual)
                    println "\nEmpresa atualizada com sucesso!"
                    break

                case 5:

                    def listaCand = repo.listarCandidatos()
                    if (listaCand.empty) {
                        println "Não há candidatos cadastrados."
                    } else {
                        listaCand.each { println it }
                    }
                    break

                case 6:

                    def listaEmp = repo.listarEmpresas()
                    if (listaEmp.empty) {
                        println "Não há empresas cadastradas."
                    } else {
                        listaEmp.each { println it }
                    }
                    break

                default:
                    println "Opção inválida!"
            }
        } while (opcao != 0)
    }
}
