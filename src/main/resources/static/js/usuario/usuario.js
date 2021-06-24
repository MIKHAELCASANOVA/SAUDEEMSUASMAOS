function testeGet(url,dados){

    let request = new XMLHttpRequest();
    request.open('GET', url, false);
    request.send();
  
    let jsonResponse = JSON.parse(request.responseText); 
    
    let usuarioLogado = false;

    jsonResponse.forEach(element => {
        console.log(element);
        if(element.email == dados.email && element.senha == dados.senha){
            usuarioLogado = true;
        }
    });
   
    if(usuarioLogado){
        window.location.href = '/index.html'; //relative to domain
    }else{
        alert("Usuario ou Senha incorreto!")
    }

}
function testePost(url,dados){
    let request = new XMLHttpRequest();
   request.open('POST', url, true);
   request.setRequestHeader("Content-Type","application/json");
   request.send(JSON.stringify(dados));

   request.onload = function(){
        console.log( this.responseText)
                
        alert("Usuario Cadastrado com Sucesso!")
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

    testeGet('http://localhost:9090/login/obterTodos',dados);
}


function teste2(){
    var retorno = teste('http://localhost:9090/login');
    var login = JSON.parse(retorno);
    console.log(login);
}
// function cadastrar(){
//     var nome = document.getElementById('nome_cad').value;
//     var cpf = document.getElementById('cpf_cad').value;
//     var cartao = document.getElementById('cartao_cad').value;
//     var email = document.getElementById('email_cad').value;
//     var emailConfirmacao = document.getElementById('emailConfirmacao_cad').value;
//     var senha = document.getElementById('senha_cad').value;
//     var senhaConfirmacao = document.getElementById('senhaConfirmacao_cad').value;
   
//     dados = {
//         "nome": nome,
//         "email": email,
//         "cpf":cpf
//     };
  
//     testePost('http://localhost:9090/login/inserir',dados);
//     console.log("chamou!!!");
// }

function cadastrarLogin(){
    event.preventDefault();
    var teste = document.getElementById('formLogin');
    var form = new FormData();
    console.log(form);

    console.log("chamou!!!");

    var nome = document.getElementById('nome_cad').value;
    var cpf = document.getElementById('cpf_cad').value;
    var numerosus = document.getElementById('cartao_cad').value;
    var email = document.getElementById('email_cad').value;
    var emailConfirmacao = document.getElementById('emailConfirmacao_cad').value;
    var senha = document.getElementById('senha_cad').value;
    var senhaConfirmacao = document.getElementById('senhaConfirmacao_cad').value;
   
    dados = {       
        "nome": nome,
        "email": email,
        "cpf":cpf,
        "numerosus": numerosus,
        "senha": senha
    };
  
    testePost('http://localhost:9090/login/inserir',dados);
    
}

function closeAlert(){
    document.getElementById(".alert").alert('close')
}