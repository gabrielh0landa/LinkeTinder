package main

import controller.PerfilController
import repository.Repository

class Master {

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in)
        def repo = new Repository()
        def controller = new PerfilController(repo)
        controller.exibirMenu(sc)
    }
}
