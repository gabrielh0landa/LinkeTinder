package controller

import model.*
import service.*

import java.util.ArrayList
import java.util.Scanner

class PerfilController {

    void exibirMenu(Scanner sc, ArrayList<Candidato> candidatos, ArrayList<Empresa> empresas) {

        def opcao
        def indice
        def servico = new PerfilService()

        do {
            println "Menu:"
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
                    candidatos.add(servico.criarNovoCandidato(sc))
                    println candidatos.toString()
                    break

                case 2:
                    if(candidatos.isEmpty()){
                        println "Não tem candidatos..."
                        break
                    }
                    println candidatos.toString()
                    println "Qual indice deseja atualizar? (0-" + (candidatos.size() - 1) + ")"
                    indice = sc.nextInt()
                    sc.nextLine()

                    if(indice >= 0 && indice < candidatos.size()){
                        candidatos.set(indice, servico.atualizarPerfilCandidato(candidatos.get(indice), sc))
                    } else {
                        println "Índice inválido"
                    }
                    println candidatos.toString()
                    break

                case 3:
                    empresas.add(servico.criarNovaEmpresa(sc))
                    println empresas.toString()
                    break

                case 4:
                    if(empresas.isEmpty()){
                        println "Não tem empresas..."
                        break
                    }
                    println empresas.toString()
                    println "Qual indice deseja atualizar? (0-" + (empresas.size() - 1) + ")"
                    indice = sc.nextInt()
                    sc.nextLine()


                    if(indice >= 0 && indice < empresas.size()){
                        empresas.set(indice, servico.atualizarPerfilEmpresa(empresas.get(indice), sc))
                    } else {
                        println "Índice inválido"
                    }
                    println empresas.toString()
                    break

                case 5:
                    if(candidatos.isEmpty()){
                        println "Nenhum candidato cadastrado."
                    } else {
                        println "--- Lista de Candidatos ---"
                        candidatos.each { candidato ->
                            candidato.exibirPerfil()
                        }
                    }
                    break

                case 6:
                    if(empresas.isEmpty()){
                        println "Nenhuma empresa cadastrada."
                    } else {
                        println "--- Lista de Empresas ---"
                        empresas.each { empresa ->
                            empresa.exibirPerfil()
                        }
                    }
                    break

                default:
                    println "Opção inválida"
            }
        } while (opcao != 0)
    }
}