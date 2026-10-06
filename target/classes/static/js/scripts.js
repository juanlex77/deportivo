// ============================================
// Sistema Deportivo - Scripts generales
// ============================================

document.addEventListener('DOMContentLoaded', function () {
    console.log('✅ Sistema Deportivo cargado correctamente');

    // Confirmación global para todos los botones con clase .btn-eliminar
    document.querySelectorAll('.btn-eliminar').forEach(function (boton) {
        boton.addEventListener('click', function (e) {
            const nombre = this.getAttribute('data-nombre') || 'este registro';
            if (!confirm('¿Está seguro de eliminar ' + nombre + '?')) {
                e.preventDefault();
            }
        });
    });

    // Contador de jugadores seleccionados (formulario Club)
    const selectJugadores = document.getElementById('jugadores');
    const contador = document.getElementById('contadorJugadores');

    if (selectJugadores && contador) {
        const actualizarContador = function () {
            const total = Array.from(selectJugadores.selectedOptions).length;
            contador.textContent = '👥 ' + total + ' jugador(es) seleccionado(s)';
        };
        selectJugadores.addEventListener('change', actualizarContador);
        actualizarContador();
    }
});