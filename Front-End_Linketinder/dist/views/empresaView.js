export function criarFormularioEmpresa() {
    const formulario = `
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
      <input type="text" id="vagas" name="vagas">
    </div>
            
    <div>
      <label for="descricao">Descricao:</label>
      <input type="text" id="descricao" name="descricao">
    </div>
            
    <button type="submit">Cadastrar Empresa</button>
  </form>
  `;
    return formulario;
}
//# sourceMappingURL=empresaView.js.map