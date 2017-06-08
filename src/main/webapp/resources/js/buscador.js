/*
 Buscador de la barra de navegacion de Cursos mediante la API rest
 Busca cursos que coincidan su nombre, minimo 3 letras
 http://localhost:8080/formacion/api/curso/?filtro=a
*/

"use strict"



$(function() {
  console.debug('buscador.js ready');
  
  $( "#buscadorCurso" ).autocomplete({
      source: function( request, response ) {
        $.ajax( {
          url: "/formacion/api/curso/?filtro=" + $("#buscadorCurso").val(),
          dataType: "json",
          success: function( data ) {
        	var aString = [];
            $.each(data, function(index, rec){
            	aString.push({"label":rec.nombre, "value":rec.id});
        	});
            response( aString );
          }
        } );
      },
      minLength: 3,
      select: function( event, ui ) {
        console.debug( "Selected: " + ui.item.value + " id " + ui.item.label );
        var url = "view/"+ ui.item.value;
        window.location.href = url;
      }
    } );
  
});