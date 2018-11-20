/**
 * 
 */

$("#btnNuevo").click(function(){
	
	//alert("hola");
	$.get("http://192.168.8.102:8080/dispositivo/mostrarfrm?id=0",function(data){
		aler("recibiendo");
	})
});