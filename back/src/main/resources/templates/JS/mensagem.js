document.getElementById("contactForm").addEventListener("submit", function (event) {
    event.preventDefault();

    const nome = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const assunto = document.getElementById("subject").value;
    const mensagem = document.getElementById("message").value;

    if (nome == "" || email == "" || assunto == "" || mensagem == "") {
        alert("Preencha todos os campos!");
        return;
    }

    const emailValido = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailValido.test(email)) {
        alert("Digite um e-mail válido!");
        return;
    }

    if (mensagem.trim().length < 5) {
        alert("A mensagem deve ter pelo menos 5 caracteres!");
        return;
    }

    const cadastroData = {
        nome: nome,
        email: email,
        assunto: assunto,
        mensagem: mensagem
    };

    fetch("http://localhost:8080/faleconosco/cadastrar", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(cadastroData)
    })
        .then(response => {
            if (!response.ok) {
                return response.text().then(msg => {
                    throw new Error(msg);
                });
            }
            return response.text();
        })
        .then(msg => {
            console.log("Mensagem enviada:", msg);
            alert("Mensagem enviada com sucesso! :)");
            document.getElementById("contactForm").reset(); // Limpa o formulário
        })
        .catch(error => {
            console.error("Erro:", error.message);
            alert("Erro: " + error.message);
        });
});
