
function executaGet(url,dados){

    let request = new XMLHttpRequest();
    request.open('GET', url, false);
    request.send();
  
    return request.responseText;
    
}
function executaPost(url,dados){

    let obterListaLogin = executaGet('http://localhost:9090/usuario/obterTodos',dados);


    let request = new XMLHttpRequest();
   request.open('POST', url, true);
   request.setRequestHeader("Content-Type","application/json");
   request.send(JSON.stringify(dados));
  
   request.onload = function(){  
    var data=request.responseText;
    var jsonResponse = JSON.parse(data);
    console.log(jsonResponse["Data"]);
        alert("Usuario "+jsonResponse["nome"]+" cadastrado!")
        limparformulario();   
               
       
        sessionStorage.setItem("usuarioLogado", "usuarioLogado");
   } 

    return request.responseText;
}
function limparformulario(){
    document.getElementById('nome_cad').value = "";
    document.getElementById('cpf_cad').value = "";
    document.getElementById('cartao_cad').value = "";
    document.getElementById('email_cad').value = "";
    document.getElementById('emailConfirmacao_cad').value = "";
    document.getElementById('senha_cad').value = "";
    document.getElementById('senhaConfirmacao_cad').value = "";
    document.getElementById('rg_cad').value = "";
    document.getElementById('endereco_cad').value = "";
    document.getElementById('nascimento_cad').value = "";
    document.getElementById('nomemae_cad').value = "";
    document.getElementById('telefone_cad').value = "";
    document.getElementById('genero').selectedIndex = 0; 
    document.getElementById('tipo').selectedIndex = 0; 

}

function entrar(){
    event.preventDefault();
    let email = document.getElementById('email_login').value;
    let senha = document.getElementById('senha_login').value;
    dados = {      
        "email": email,
        "senha":senha
    }; 

    let response = executaGet('http://localhost:9090/usuario/obterTodos',dados);

    let jsonResponse = JSON.parse(response); 
    
    let usuarioLogado = false;

    jsonResponse.forEach(element => {  
        if(element.email == dados.email && element.senha == dados.senha){
            usuarioLogado = true;
        }
    });
   
    if(usuarioLogado){
        window.location.href = '/index.html'; //relative to domain
    }else{
        alert("Usuario ou Senha nao cadastrado!")
    }
}
 
function cadastrarLogin(){
    event.preventDefault(); 
    let tipo = document.getElementById('tipo').value;

    let nome = document.getElementById('nome_cad').value;
    let cpf = document.getElementById('cpf_cad').value;
    let rg = document.getElementById('rg_cad').value;
    let numerosus = document.getElementById('cartao_cad').value;
    let endereco = document.getElementById('endereco_cad').value;
    let datanascimento = document.getElementById('nascimento_cad').value;
    let nomemae = document.getElementById('nomemae_cad').value;
    let email = document.getElementById('email_cad').value;
    let telefone = document.getElementById('telefone_cad').value;
    let emailConfirmacao = document.getElementById('emailConfirmacao_cad').value;
    let genero = document.getElementById('genero').value;    
    let senha = document.getElementById('senha_cad').value;
    let senhaConfirmacao = document.getElementById('senhaConfirmacao_cad').value;
   
    if(email != emailConfirmacao){
        alert("E-mail não confere com o E-mail de confirmação");
        return;
    }

    if(senha != senhaConfirmacao){
        alert("Senha não confere com a Senha de confirmação");
        return;
    }

    login =  {      
        "email": email,
        "cpf":cpf
    }; 
    let obterListaLogin = executaGet('http://localhost:9090/usuario/obterTodos',login);


    let retorno = JSON.parse(obterListaLogin); 
   
    let existeUsuario = false;

    let par = "";
 
    retorno.forEach(element => {  
        if(element.cpf == login.cpf){
            existeUsuario = true;
            par = "Cpf";
        }
        else if(element.email == login.email && element.cpf == login.cpf){
            existeUsuario = true;
            par =" E-mail";
        }
    });
   
    if(existeUsuario){
       alert("Usuario com "+par+" cadastrado no sistema!")
    }else{

        dados = {       
            "nome":nome,
            "cpf":cpf,
            "rg":rg, 
            "numerosus": numerosus,
            "endereco":endereco,
            "genero": genero,
            "datanascimento":datanascimento,
            "nomemae": nomemae,
            "telefone":telefone,
            "email":email,
            "tipo": tipo,
            "senha":senha
        };    
    
        executaPost('http://localhost:9090/usuario/inserir',dados);    
    }
}
function somenteNumeros(e) {
    var charCode = e.charCode ? e.charCode : e.keyCode;
    // charCode 8 = backspace   
    // charCode 9 = tab
    if (charCode != 8 && charCode != 9) {
        // charCode 48 equivale a 0   
        // charCode 57 equivale a 9
        if (charCode < 48 || charCode > 57) {
            return false;
        }
    }
}

 