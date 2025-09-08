# LinkeTinder_Groovy

Este é o projeto LinkeTinder, desenvolvido como parte da trilha de groovy do aceleraZG.

### Autor
* **Gabriel Holanda De Freitas**

### Sobre o Projeto

O projeto "LinkeTinder" é uma aplicação de console desenvolvida em Groovy, que simula um sistema de gestão de perfis para candidatos e empresas.
A aplicação permite:
* Criar perfis de candidatos com informações pessoais e competências.
* Criar perfis de empresas com dados corporativos e competências requeridas.
* Atualizar perfis existentes.
* Listar todos os candidatos e empresas cadastrados.

A aplicação segue o padrão de Orientação a Objetos, utilizando herança (`Pessoa` é a classe-pai de `Candidato` e `Empresa`) e separação de responsabilidades (classes `Controller`, `Service` e `Model`).

### Como Executar o Projeto

Para executar este projeto, você precisará ter o Groovy instalado em sua máquina e uma IDE como o IntelliJ IDEA.

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/gabrielh0landa/LinkeTinder_Groovy.git](https://github.com/gabrielh0landa/LinkeTinder_Groovy.git)
    ```

2.  **Abra o projeto na IDE:**
    * No IntelliJ IDEA, vá em `File` -> `Open` e selecione a pasta do projeto clonado.
    * O IntelliJ deve reconhecer a estrutura do projeto Groovy automaticamente.

3.  **Adicione a dependência do Groovy:**
    * Clique com o botão direito na pasta do projeto.
    * Vá em `Open Module Settings` (F4).
    * Vá em `Libraries` e adicione a biblioteca do Groovy.

4.  **Execute o programa:**
    * Abra a classe `Master.groovy` (`src/main/main/Master.groovy`).
    * Clique com o botão direito no arquivo e selecione `Run 'Master.main()'`.
    * O programa será iniciado no console da IDE.

### Estrutura do Projeto

* `/src`: Contém todo o código-fonte do projeto.
    * `/controller`: Classes responsáveis por controlar o fluxo da aplicação.
    * `/main`: Classe principal (`Master`) onde o programa inicia.
    * `/model`: Classes de modelo que representam as entidades (Pessoa, Candidato, Empresa).
    * `/repository`: (Não utilizado neste projeto)
    * `/service`: Classes de serviço com a lógica de negócio da aplicação.
* `/lib`: Armazena as bibliotecas externas, como o Groovy.
* `/out`: Diretório de saída da compilação.
* `.gitignore`: Ignora arquivos gerados pela IDE e de compilação.
