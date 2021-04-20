function ValidaFormulario () {
    var nome = document.getElementById("nome");
    var email = document.getElementById("email");
    
    if (nome.value == "") {
      nome.focus();
      return;
    }
    if (email.value == ""){
      email.focus();
      return;
    }
    alert ("Cadastro Realizado com Sucesso!"); 
  }