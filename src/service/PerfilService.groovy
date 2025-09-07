package service

import model.Candidato
import model.Empresa
import java.util.Scanner

class PerfilService {

    def criarNovoCandidato(Scanner sc) {
        def c = new Candidato()

        println "--- Criando novo perfil de Candidato ---"
        println "Qual seu nome completo?"
        c.nome = sc.nextLine()

        println "Qual seu CPF?"
        c.cpf = sc.nextLine()

        println "Qual sua idade?"
        // Correção do bug do Scanner
        c.idade = sc.nextInt()
        sc.nextLine()

        println "Qual seu e-mail?"
        c.email = sc.nextLine()

        println "Fale sobre você (descrição pessoal):"
        c.descricao = sc.nextLine()

        println "Qual seu CEP?"
        c.cep = sc.nextLine()

        println "Em qual estado você mora?"
        c.estado = sc.nextLine()

        println "Em qual país você mora?"
        c.pais = sc.nextLine()

        println "\nAdicione suas competências"
        println "(Digite 'fim' para terminar)"
        def competencia

        while (true) {
            competencia = sc.nextLine()
            if (competencia.equalsIgnoreCase("fim")) {
                break
            }
            c.adicionarCompetencia(competencia) // Corrigido para o método que adiciona
        }
        println "\nPerfil de candidato criado com sucesso!"
        return c
    }

    def atualizarPerfilCandidato(Candidato c, Scanner sc) {
        if (!c) { // Forma concisa de checar por null ou vazio
            println "Candidato não encontrado para atualização."
            return null
        }

        println "--- Atualizando Perfil de Candidato ---"
        println "Pressione 'Enter' para manter o valor atual."

        println "Nome atual: ${c.nome}" // Interpolação de String
        print "Digite o novo nome: "
        def buffer = sc.nextLine()
        if (buffer) {
            c.nome = buffer
        }

        println "CPF atual: ${c.cpf}"
        print "Digite o novo CPF: "
        buffer = sc.nextLine()
        if (buffer) {
            c.cpf = buffer
        }

        println "Idade atual: ${c.idade}"
        print "Digite sua Idade: "
        buffer = sc.nextLine()
        if (buffer) {
            c.idade = buffer.toInteger() // Conversão simples
        }

        println "E-mail atual: ${c.email}"
        print "Digite o novo e-mail: "
        buffer = sc.nextLine()
        if (buffer) {
            c.email = buffer
        }

        println "Descrição pessoal atual: ${c.descricao}"
        print "Digite a nova descrição pessoal: "
        buffer = sc.nextLine()
        if (buffer) {
            c.descricao = buffer
        }

        println "CEP atual: ${c.cep}"
        print "Digite o novo CEP: "
        buffer = sc.nextLine()
        if (buffer) {
            c.cep = buffer
        }

        println "Estado atual: ${c.estado}"
        print "Digite o novo estado: "
        buffer = sc.nextLine()
        if (buffer) {
            c.estado = buffer
        }

        println "País atual: ${c.pais}"
        print "Digite o novo país: "
        buffer = sc.nextLine()
        if (buffer) {
            c.pais = buffer
        }

        println "Competências atuais: ${c.competencias}"
        println "Adicione novas competências (digite 'fim' para terminar):"

        while (true) {
            buffer = sc.nextLine()
            if (buffer.equalsIgnoreCase("fim")) {
                break
            }
            if (buffer) {
                c.adicionarCompetencia(buffer)
            }
        }
        println "\nPerfil de Candidato atualizado com sucesso!"
        return c
    }

    def criarNovaEmpresa(Scanner sc) {
        def e = new Empresa()

        println "Qual o nome da empresa?"
        e.nome = sc.nextLine()

        println "Qual o CNPJ?"
        e.cnpj = sc.nextLine()

        println "Qual o e-mail corporativo?"
        e.email = sc.nextLine()

        println "Fale sobre a empresa (descrição):"
        e.descricao = sc.nextLine()

        println "Qual o CEP?"
        e.cep = sc.nextLine()

        println "Em qual estado a empresa se localiza?"
        e.estado = sc.nextLine()

        println "Em qual país a empresa se localiza?"
        e.pais = sc.nextLine()

        println "\nAdicione as competências esperadas"
        println "(Digite 'fim' para terminar)"
        def competencia

        while (true) {
            competencia = sc.nextLine()
            if (competencia.equalsIgnoreCase("fim")) {
                break
            }
            e.adicionarCompetencia(competencia) // Corrigido
        }
        println "\nPerfil de empresa criado com sucesso!"
        return e
    }

    def atualizarPerfilEmpresa(Empresa e, Scanner sc) {
        if (!e) {
            println "Empresa não encontrada para atualização."
            return null
        }

        println "Pressione 'Enter' para manter o valor atual."

        println "Nome atual: ${e.nome}"
        print "Digite o novo nome: "
        def buffer = sc.nextLine()
        if (buffer) {
            e.nome = buffer
        }

        println "CNPJ atual: ${e.cnpj}"
        print "Digite o novo CNPJ: "
        buffer = sc.nextLine()
        if (buffer) {
            e.cnpj = buffer
        }

        println "E-mail atual: ${e.email}"
        print "Digite o novo e-mail: "
        buffer = sc.nextLine()
        if (buffer) {
            e.email = buffer
        }

        println "Descrição da empresa atual: ${e.descricao}"
        print "Digite a nova descrição: "
        buffer = sc.nextLine()
        if (buffer) {
            e.descricao = buffer
        }

        println "CEP atual: ${e.cep}"
        print "Digite o novo CEP: "
        buffer = sc.nextLine()
        if (buffer) {
            e.cep = buffer
        }

        println "Estado atual: ${e.estado}"
        print "Digite o novo estado: "
        buffer = sc.nextLine()
        if (buffer) {
            e.estado = buffer
        }

        println "País atual: ${e.pais}"
        print "Digite o novo país: "
        buffer = sc.nextLine()
        if (buffer) {
            e.pais = buffer
        }

        println "Competências atuais: ${e.competencias}"
        println "Adicione novas competências (digite 'fim' para terminar):"

        while (true) {
            buffer = sc.nextLine()
            if (buffer.equalsIgnoreCase("fim")) {
                break
            }
            if (buffer) {
                e.adicionarCompetencia(buffer)
            }
        }

        println "\nPerfil de Empresa atualizado com sucesso!"
        return e
    }
}