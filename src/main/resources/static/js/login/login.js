
function executaGet(url,dados){

    let request = new XMLHttpRequest();
    request.open('GET', url, false);
    request.send();
  
    return request.responseText;
    
}
function executaPost(url,dados){

    let obterListaLogin = executaGet('http://localhost:9090/login/obterTodos',dados);


    let request = new XMLHttpRequest();
   request.open('POST', url, true);
   request.setRequestHeader("Content-Type","application/json");
   request.send(JSON.stringify(dados));
  
   request.onload = function(){                 
        alert("Usuario cadastrado!")
        limparformulario();            
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
}

function entrar(){
    event.preventDefault();
    var email = document.getElementById('email_login').value;
    var senha = document.getElementById('senha_login').value;
    dados = {      
        "email": email,
        "senha":senha
    }; 

    let response = executaGet('http://localhost:9090/login/obterTodos',dados);

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
    var nome = document.getElementById('nome_cad').value;
    var cpf = document.getElementById('cpf_cad').value;
    var numerosus = document.getElementById('cartao_cad').value;
    var email = document.getElementById('email_cad').value;
    var emailConfirmacao = document.getElementById('emailConfirmacao_cad').value;
    var senha = document.getElementById('senha_cad').value;
    var senhaConfirmacao = document.getElementById('senhaConfirmacao_cad').value;
   
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
    let obterListaLogin = executaGet('http://localhost:9090/login/obterTodos',login);


    let retorno = JSON.parse(obterListaLogin); 
   
    let existeUsuario = false;
 
    retorno.forEach(element => {  
        if(element.email == login.email && element.cpf == login.cpf){
            existeUsuario = true;
        }
    });
   
    if(existeUsuario){
       alert("Usuario cadastrado no sistema!")
    }else{

        dados = {       
            "nome": nome,
            "email": email,
            "cpf":cpf,
            "numerosus": numerosus,
            "senha": senha
        };    
    
        executaPost('http://localhost:9090/login/inserir',dados);    
    }

    
  
}

 