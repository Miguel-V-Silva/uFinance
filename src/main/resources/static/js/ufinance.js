const inputPrice = document.getElementById("price");

inputPrice.addEventListener("input", () => {
    // Remove tudo que não for número
    let valor = inputPrice.value.replace(/\D/g, "");

    // Converte para centavos se necessário
    valor = (Number(valor) / 100).toFixed(2);

    // Troca ponto por vírgula
    valor = valor.replace(".", ",");

    // Adiciona separador de milhar
    valor = valor.replace(/\B(?=(\d{3})+(?!\d))/g, ".");

    // Atualiza valor no input
    inputPrice.value = valor;
});

function submitForm() {
    const inputDay = document.getElementById("day");
    const inputPrice = document.getElementById("price");

    const day = Number(inputDay.value);
    const price = inputPrice.value;

    // Valida preço
    if (price === "00,00" || price === "0,00") {
        alert("O preço precisa ser acima de 1");
        return false;
    }

    // Pega o mês atual e o ano atual
    const dataAtual = new Date();
    const mesAtual = dataAtual.getMonth() + 1; // getMonth é 0 a 11
    const anoAtual = dataAtual.getFullYear();

    // Função para descobrir os dias do mês atual
    function diasNoMes(mes, ano) {
        return new Date(ano, mes, 0).getDate();
    }

    const maxDias = diasNoMes(mesAtual, anoAtual);

    // Valida dia
    if (day < 1 || day > maxDias) {
        alert(`O dia precisa estar entre 1 e ${maxDias} para o mês atual.`);
        return false;
    }

    // Se passou por tudo, envia
    alert("Formulário enviado com sucesso!");
    return true; // permite o envio do formulário
}

const despesas = document.querySelectorAll(".model-despesa");
const hiddenCategoria = document.getElementById("categoria");

// define ALIMENTACAO como default no carregamento
hiddenCategoria.value = "ALIMENTACAO";

despesas.forEach((item) => {
    item.addEventListener("click", () => {
        // remove .selected de todas
        despesas.forEach((el) => el.classList.remove("selected"));

        // adiciona no clicado
        item.classList.add("selected");

        // pega o id e seta no hidden, convertendo pra maiúsculo e tratando
        let categoria = item.id.toUpperCase();
        if (categoria === "CONTA-FIXA") categoria = "CONTA_FIXA";
        else categoria = categoria.replace("-", "_");

        hiddenCategoria.value = categoria;

        // opcional: mudar a cor primária no :root
        const root = document.documentElement;
        const color = getComputedStyle(item).color;
        root.style.setProperty('--primary-color', color);
        root.style.setProperty('--primary-color-hover', color);
    });
});

