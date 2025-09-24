import { Candidato, Empresa, Vagas, candidatos, empresas } from './data/index';
import { criarFormularioCandidato } from './views/candidatoView';
import { criarFormularioEmpresa } from './views/empresaView';
let pagina_selecionada;
function renderizarTela(tela) {
    const container = document.getElementById('container-principal');
    if (!container) {
        console.error("Contêiner principal não encontrado.");
        return;
    }
    container.innerHTML = '';
    switch (tela) {
        case 'cadastro-candidato':
            container.innerHTML = criarFormularioCandidato();
            const formularioCandidato = document.getElementById('formulario-candidato');
            if (formularioCandidato) {
                formularioCandidato.addEventListener('submit', (e) => {
                    e.preventDefault();
                    const nome = document.getElementById('nome').value;
                    const email = document.getElementById('email').value;
                    const cpf = document.getElementById('cpf').value;
                    const idade = parseInt(document.getElementById('idade').value);
                    const cep = document.getElementById('cep').value;
                    const estado = document.getElementById('estado').value;
                    const endereco = document.getElementById('endereco').value;
                    const descricao = document.getElementById('descricao').value;
                    const skillsSelecionadas = [];
                    document.querySelectorAll('input[name="skills"]:checked').forEach(input => {
                        skillsSelecionadas.push(input.value);
                    });
                    const skillsString = skillsSelecionadas.join(', ');
                    const novoCandidato = new Candidato(nome, email, cpf, idade, cep, estado, endereco, skillsString, descricao);
                    candidatos.push(novoCandidato);
                    console.log('Candidato cadastrado!', candidatos);
                    formularioCandidato.reset();
                });
            }
            break;
        case 'cadastro-empresa':
            container.innerHTML = criarFormularioEmpresa();
            const formularioEmpresa = document.getElementById('formulario-empresa');
            if (formularioEmpresa) {
                formularioEmpresa.addEventListener('submit', (e) => {
                    e.preventDefault();
                    const nome = document.getElementById('nome').value;
                    const email = document.getElementById('email').value;
                    const cnpj = document.getElementById('cnpj').value;
                    const cep = document.getElementById('cep').value;
                    const estado = document.getElementById('estado').value;
                    const endereco = document.getElementById('endereco').value;
                    const descricao = document.getElementById('descricao').value;
                    const vagasString = document.getElementById('vagas').value;
                    const vagasArray = vagasString.split(',').map(item => new Vagas(item.trim(), []));
                    const novaEmpresa = new Empresa(nome, email, cnpj, cep, estado, endereco, vagasArray, descricao);
                    empresas.push(novaEmpresa);
                    console.log('Empresa cadastrada!', empresas);
                    formularioEmpresa.reset();
                });
            }
            break;
        case 'perfil-candidato':
            container.innerHTML = '<h1>Perfil do Candidato (Em breve)</h1>';
            break;
        case 'perfil-empresa':
            container.innerHTML = '<h1>Perfil da Empresa (Em breve)</h1>';
            break;
    }
}
document.addEventListener('DOMContentLoaded', () => {
    pagina_selecionada = document.getElementById('container-principal');
    const conectarBotao = (idBotao, tela) => {
        const botao = document.getElementById(idBotao);
        if (botao) {
            botao.addEventListener('click', (e) => {
                e.preventDefault();
                renderizarTela(tela);
            });
        }
        else {
            console.error(`Botão de navegação não encontrado: #${idBotao}`);
        }
    };
    conectarBotao('nav-candidato-cadastro', 'cadastro-candidato');
    conectarBotao('nav-empresa-cadastro', 'cadastro-empresa');
    conectarBotao('nav-perfil-candidato', 'perfil-candidato');
    conectarBotao('nav-perfil-empresa', 'perfil-empresa');
    renderizarTela('cadastro-candidato');
});
//# sourceMappingURL=app.js.map