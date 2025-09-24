export class Candidato {
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
export class Empresa {
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
export class Vagas {
    nome;
    skills;
    constructor(nome, skills) {
        this.nome = nome;
        this.skills = skills;
    }
}
export const candidatos = [];
export const empresas = [];
export const skillsDisponiveis = ['HTML', 'CSS', 'JavaScript', 'TypeScript', 'Python', 'Java'];
//# sourceMappingURL=index.js.map