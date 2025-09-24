export class Candidato {
  constructor(
    public nome: string,
    public email: string,
    public cpf: string,
    public idade: number,
    public cep: string,
    public estado: string,
    public endereco: string,
    public skills: string,
    public descricao: string
  ) {}
}

export class Empresa {
  constructor(
    public nome: string,
    public email: string,
    public cnpj: string,
    public cep: string,
    public estado: string,
    public endereco: string,
    public vagas: Vagas[] = [],
    public descricao: string
  ) {}
}

export class Vagas {
  constructor(
    public nome: string,
    public skills: string[]
  ) {}
}

export const candidatos: Candidato[] = [];
export const empresas: Empresa[] = [];

export const skillsDisponiveis = ['HTML', 'CSS', 'JavaScript', 'TypeScript', 'Python', 'Java'];