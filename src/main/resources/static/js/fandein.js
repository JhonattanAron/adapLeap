  document.addEventListener("DOMContentLoaded" , ()=>{
    var elementos = document.querySelectorAll('.container-c');

  function esVisible(elemento) {
    var elementoRect = elemento.getBoundingClientRect();
    var alturaVentana = window.innerHeight;
    var offset = 50; // Espacio adicional para que el elemento se muestre completamente antes de ser considerado visible
    return (
      elementoRect.right >= 0 &&
      elementoRect.left <= (window.innerWidth || document.documentElement.clientWidth) &&
      elementoRect.bottom >= 0 - offset &&
      elementoRect.top <= alturaVentana + offset
    );
  }

  function actualizarVisibilidad() {
    elementos.forEach(function (elemento) {
      if (esVisible(elemento)) {
        elemento.classList.add('visible');
      } else {
        elemento.classList.remove('visible');
      }
    });
  }

  window.addEventListener('scroll', actualizarVisibilidad);
  window.addEventListener('resize', actualizarVisibilidad); // Asegurarse de actualizar la visibilidad en caso de cambios de tamaño de la ventana

  actualizarVisibilidad();


  })