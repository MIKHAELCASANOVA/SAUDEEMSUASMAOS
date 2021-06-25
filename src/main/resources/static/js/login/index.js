 
window.onload = function() {
    if(sessionStorage.getItem("usuarioLogado") === "usuarioLogado" ){
        document.getElementById("entrar").innerHTML="Sair";
    } 
};
