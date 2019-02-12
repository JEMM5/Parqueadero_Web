function reloj(){
    var fecha = new Date();
    var hora = fecha.getHours();
    var min = fecha.getMinutes();
    var seg = fecha.getSeconds();
    var actualizar = setTimeout('reloj()',500); 
        
    var idRecibido = document.getElementById('idDef').value;
    
    if(idRecibido == "" || idRecibido == null){
        document.getElementById('hE').value = hora + ":" + min + ":" + seg;        
    }else{
        document.getElementById('hS').value = hora + ":" + min + ":" + seg;
    }

}


