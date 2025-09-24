export declare class Candidato {
    nome: string;
    email: string;
    cpf: string;
    idade: number;
    cep: string;
    estado: string;
    endereco: string;
    skills: string;
    descricao: string;
    constructor(nome: string, email: string, cpf: string, idade: number, cep: string, estado: string, endereco: string, skills: string, descricao: string);
}
export declare class Empresa {
    nome: string;
    email: string;
    cnpj: string;
    cep: string;
    estado: string;
    endereco: string;
    vagas: Vagas[];
    descricao: string;
    constructor(nome: string, email: string, cnpj: string, cep: string, estado: string, endereco: string, vagas: Vagas[] | undefined, descricao: string);
}
export declare class Vagas {
    nome: string;
    skills: string[];
    constructor(nome: string, skills: string[]);
}
export declare const candidatos: Candidato[];
export declare const empresas: Empresa[];
export declare const skillsDisponiveis: string[];
//# sourceMappingURL=index.d.ts.map