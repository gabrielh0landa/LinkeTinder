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
    case 'perfil-candidato':
      pagina_selecionada.innerHTML = '<h1>Perfil de Candidato AQUI!</h1>';
      break;
    case 'perfil-empresa':
      pagina_selecionada.innerHTML = '<h1>Perfil de Empresa AQUI!</h1>';
      break;
  }
}


document.addEventListener(
  
  'DOMContentLoaded', () => {
  function conectarBotao(idBotao: string, tela: nome_pagina) {

      const botao = document.getElementById(idBotao);

      if (botao) {

          botao.addEventListener(
    
            'click', function(e) {

              e.preventDefault(); // Impede o link <a> de ir para '#'
              renderizarTela(tela);
              
            }
          );
      } else {
          console.error('Botão de navegação não encontrado: #' + idBotao);
          
      }

  }

      conectarBotao('nav-candidato-cadastro', 'cadastro-candidato');
      conectarBotao('nav-empresa-cadastro', 'cadastro-empresa');
      conectarBotao('nav-perfil-candidato', 'perfil-candidato');
      conectarBotao('nav-perfil-empresa', 'perfil-empresa');

      renderizarTela('cadastro-candidato');
  }
);

(window as any).renderizarTela = renderizarTela;
export{}


