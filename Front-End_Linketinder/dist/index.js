class Candidato {
    nome;
    email;
    cpf;
    idade;
    cep;
    estado;
    endereco;
    skills;
    descricao;
    constructor(nome, email, cpf, idade, cep, estado, endereco, skills, descricao) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.idade = idade;
        this.cep = cep;
        this.estado = estado;
        this.endereco = endereco;
        this.skills = skills;
        this.descricao = descricao;
    }
}
class Empresa {
    nome;
    email;
    cnpj;
    cep;
    estado;
    endereco;
    vagas;
    descricao;
    constructor(nome, email, cnpj, cep, estado, endereco, vagas = [], descricao) {
        this.nome = nome;
        this.email = email;
        this.cnpj = cnpj;
        this.cep = cep;
        this.estado = estado;
        this.endereco = endereco;
        this.vagas = vagas;
        this.descricao = descricao;
    }
}
class Vagas {
    nome;
    skills;
    constructor(nome, skills) {
        this.nome = nome;
        this.skills = skills;
    }
}
const candidatos = [];
const empresas = [];
const skillsDisponiveis = ['HTML', 'CSS', 'JavaScript', 'TypeScript', 'Python', 'Java'];
let pagina_selecionada;
function renderizarTela(tela) {
    if (!pagina_selecionada) {
        console.error("Contêiner principal não encontrado.");
        return;
    }
    pagina_selecionada.innerHTML = '';
    switch (tela) {
        case 'cadastro-candidato':
            pagina_selecionada.innerHTML = criarFormularioCandidato();
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
            pagina_selecionada.innerHTML = criarFormularioEmpresa();
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
            pagina_selecionada.innerHTML = '<h1>Perfil do Candidato (Em breve)</h1>';
            break;
        case 'perfil-empresa':
            pagina_selecionada.innerHTML = criarListaCandidatos(candidatos);
            break;
    }
}
function criarFormularioCandidato() {
    const skillsHtml = skillsDisponiveis.map(skill => `
    <div>
      <input type="checkbox" id="${skill.toLowerCase()}-skill" name="skills" value="${skill}">
      <label for="${skill.toLowerCase()}-skill">${skill}</label>
    </div>
  `).join('');
    return `
    <form id="formulario-candidato">
      <h2>Cadastro de Candidato</h2>
      <div>
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>
      </div>
      <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
      </div>
      <div>
        <label for="cpf">Cpf:</label>
        <input type="text" id="cpf" name="cpf" required>
      </div>
      <div>
        <label for="idade">Idade:</label>
        <input type="text" id="idade" name="idade" required>
      </div>
      <div>
        <label for="cep">Cep:</label>
        <input type="text" id="cep" name="cep" required>
      </div>
      <div>
        <label for="estado">Estado:</label>
        <input type="text" id="estado" name="estado" required>
      </div>
      <div>
        <label for="endereco">Endereco:</label>
        <input type="text" id="endereco" name="endereco" required>
      </div>
      <h3>Skills:</h3>
      <div id="skills-container">${skillsHtml}</div>
      <div>
        <label for="descricao">Descrição:</label>
        <input type="text" id="descricao" name="descricao">
      </div>
      <button type="submit">Cadastrar Candidato</button>
    </form>
  `;
}
function criarFormularioEmpresa() {
    return `
    <form id="formulario-empresa">
      <h2>Cadastro de Empresa</h2>
      <div>
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>
      </div>
      <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
      </div>
      <div>
        <label for="cnpj">Cnpj:</label>
        <input type="text" id="cnpj" name="cnpj" required>
      </div>
      <div>
        <label for="cep">Cep:</label>
        <input type="text" id="cep" name="cep" required>
      </div>
      <div>
        <label for="estado">Estado:</label>
        <input type="text" id="estado" name="estado" required>
      </div>
      <div>
        <label for="endereco">Endereco:</label>
        <input type="text" id="endereco" name="endereco" required>
      </div>
      <div>
        <label for="vagas">Vagas (separadas por vírgula):</label>
        <input type="text" id="vagas" name="vagas" required>
      </div>
      <div>
        <label for="descricao">Descricao:</label>
        <input type="text" id="descricao" name="descricao">
      </div>
      <button type="submit">Cadastrar Empresa</button>
    </form>
  `;
}
function criarListaCandidatos(candidatos) {
    if (candidatos.length === 0) {
        return '<h2>Nenhum candidato cadastrado.</h2>';
    }
    let listaHtml = `
        <h2>Candidatos Disponíveis</h2>
        <p>Apenas skills e formação são visíveis para empresas.</p>
        <ul>
    `;
    candidatos.forEach(candidato => {
        listaHtml += `
            <li>
                <strong>Skills:</strong> ${candidato.skills} <br>
                <strong>Formação:</strong> ${candidato.descricao}
            </li>
        `;
    });
    listaHtml += '</ul>';
    return listaHtml;
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
export {};
//# sourceMappingURL=index.js.map