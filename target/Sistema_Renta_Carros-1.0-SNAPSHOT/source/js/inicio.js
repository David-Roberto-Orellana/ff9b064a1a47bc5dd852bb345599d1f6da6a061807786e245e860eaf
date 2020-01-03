let limpiar = function (x) {
    for(let q = 0;q < tg("input").length; q++){
        tg("input")[q].value = "";
    }
}
let modales = function (x) {
    limpiar();
    id("menu").style.opacity = "1";
    if(x === 1){
        id("root").className = "ocultar";
        id("slider1").className = "ocultado";
    }else if(x === 2){
        id("cliente").className = "ocultar";
        id("slider2").className = "ocultado";
    }else if(x === 3){
        id("registrar").className = "ocultar";
        id("slider3").className = "ocultado";
    }
}
let modales2 = function (x) {
    id("menu").style.opacity = "0";
    if(x === 1){
        id("root").className = "mostrar";
        id("slider1").className = "mostrado";
    }else if(x === 2){
        id("cliente").className = "mostrar";
        id("slider2").className = "mostrado";
    }else if(x === 3){
        id("registrar").className = "mostrar";
        id("slider3").className = "mostrado";
    }
}
id("sct1").addEventListener("click", function(){
    modales2(1);
});
id("sct2").addEventListener("click", function(){
    modales2(2);
});
id("sct3").addEventListener("click", function(){
    modales2(3);
});
(function(){
    crearCampos();
})();