
const categoryColors = {
    'ALIMENTACAO' : '#D3B01B',
    'TRANSPORTE' : '#004853',
    'SAUDE' : '#177F0E',
    'EDUCACAO' : '#8F5C8D',
    'LAZER' : '#867258',
    'MORADIA' : '#DF9B8D',
    'CONTA_FIXA' : '#1B0DBF',
    'OUTRO' : '#F95A39'
}

fetch("/api/despesa")
    .then(response => response.json())
    .then(data => {
        const labels = Object.keys(data);
        const values = Object.values(data);
        const colors = labels.map(category => categoryColors[category] || '#CCCCCC');

        const ctx = document.getElementById('graph-despesa-total')

        new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: labels,
                datasets: [{
                    label: 'Gasto',
                    data: values,
                    backgroundColor: colors,
                    hoverOffset: 4,
                    borderWidth: 0,
                }]
            },
            options: {
                plugins: {
                    legend: {
                        labels: {
                            // This more specific font property overrides the global property
                            font: {
                                size: 14,
                                family: "'Inter', sans-serif"
                            }
                        }
                    }
                }
            }
        })
        Chart.defaults.color = '#000';
    })
fetch("/api/receita")
    .then(response => response.json())
    .then(data => {
        const labels = Object.keys(data);
        const values = Object.values(data);
        const colors = ['#58CA5E', '#FF4726'];

        const ctx = document.getElementById('graph-receita-total')

        new Chart(ctx, {
            type: 'bar',
            data: {
                labels: labels,
                datasets: [{
                    label: 'R$',
                    data: values,
                    backgroundColor: colors,
                    hoverOffset: 4,
                    borderWidth: 0
                }]
            },
            options: {
                plugins: {
                    legend: {
                        labels: {
                            // This more specific font property overrides the global property
                            font: {
                                size: 14,
                                family: "'Inter', sans-serif"
                            }
                        }
                    }
                }
            }
        })
    })