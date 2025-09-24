import { skillsDisponiveis } from '../data/index';

export function criarFormularioCandidato(): string {
  const skillsHtml = skillsDisponiveis.map(skill => 
  `
  <div>
    <input type="checkbox" id="${skill.toLowerCase()}-skill" name="skills" value="${skill}">
    <label for="${skill.toLowerCase()}-skill">${skill}</label>
  </div>
  `).join(''); 
  
  const formulario = 
  `
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
    <div id="skills-container">
      ${skillsHtml}
    </div>
            
    <div>
      <label for="descricao">Descricao:</label>
      <input type="text" id="descricao" name="descricao">
    </div>
            
    <button type="submit">Cadastrar Candidato</button>
  </form>
  `;
  return formulario;
}
