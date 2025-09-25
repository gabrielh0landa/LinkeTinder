import { Candidato } from '../data/index.js';

declare var Chart: any;

export function gerarGraficoSkills(candidatos: Candidato[]) {
  console.log('--- Iniciando Depuração do Gráfico ---');
  console.log('1. Função gerarGraficoSkills foi chamada com', candidatos.length, 'candidatos.');

  const canvasElement = document.getElementById('grafico-skills') as HTMLCanvasElement;
  console.log('2. Elemento canvas encontrado no HTML:', canvasElement);

  if (!canvasElement || candidatos.length === 0) {
    console.log('3. CONDIÇÃO DE SAÍDA: Canvas ou candidatos não encontrados. Função interrompida.');
    return;
  }

  const contagemSkills: { [key: string]: number } = {};
  for (const candidato of candidatos) {
    for (const skill of candidato.skills) {
      contagemSkills[skill] = (contagemSkills[skill] || 0) + 1;
    }
  }

  const labels = Object.keys(contagemSkills);
  const data = Object.values(contagemSkills);

  console.log('4. Dados processados para o gráfico:', { labels, data });

  new Chart(canvasElement, {
    type: 'bar',
    data: {
      labels: labels,
      datasets: [{
        label: '# de Candidatos por Skill',
        data: data,
        backgroundColor: 'rgba(54, 162, 235, 0.6)',
        borderColor: 'rgba(54, 162, 235, 1)',
        borderWidth: 1
      }]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true,
          ticks: {
            stepSize: 1
          }
        }
      }
    }
  });

  console.log('5. Comando para criar o gráfico foi executado com sucesso!');
  console.log('--- Fim da Depuração ---');
}
