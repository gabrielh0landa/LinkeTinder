type nome_pagina = 'cadastro-candidato' | 'cadastro-empresa' | 'perfil-candidato' | 'perfil-empresa';

function renderizarTela(tela: nome_pagina): void {
  const pagina_selecionada = document.getElementById('container-principal');

  if (!pagina_selecionada) {
    throw new Error("Contêiner principal não encontrado.");
  }

  pagina_selecionada.innerHTML = '';

  switch (tela) {
    case 'cadastro-candidato':
      pagina_selecionada.innerHTML = '<h1>Formulário de Cadastro de Candidato AQUI!</h1>';
      break;
    case 'cadastro-empresa':
      pagina_selecionada.innerHTML = '<h1>Formulário de Cadastro de Empresa AQUI!</h1>';
      break;
  }
}

