function openModalTarefas(hash) {
    const overlay = document.getElementById('modalTarefas');
    const modal  = document.getElementById('bgModal');

    // limpa resíduos de animação
    modal.classList.remove('shake-modal');
    modal.classList.remove('saindo');

    overlay.style.display = 'flex';

    if (hash) {
        history.pushState({ modal: true }, '', hash);
    }
}

function closeModalTarefas() {
    const overlay = document.getElementById('modalTarefas');
    const modal  = document.getElementById('bgModal');

    // anima saída
    modal.classList.add('saindo');

    setTimeout(() => {
        overlay.style.display = 'none';
        modal.classList.remove('saindo');

        if (location.hash) {
            history.back();
        }
    }, 200);
}

function removeEstudo() {
    const modal = document.getElementById("bgModal");
    modal.classList.remove("bg-nova");
    modal.classList.remove("bg-editar");
    modal.classList.remove("bg-excluir");
}

function novaTarefa() {
    document.getElementById("tituloModal").innerText = "Nova Tarefa";
    removeEstudo();
    document.getElementById("bgModal").classList.add("bg-nova");
    openModalTarefas('#nova-tarefa');
    document.getElementById("titulo").focus();
}

function editarTarefa() {
    document.getElementById("tituloModal").innerText = "Editar Tarefa";
    removeEstudo();
    document.getElementById("bgModal").classList.add("bg-editar");
    openModalTarefas("#editar-tarefa");
    document.getElementById("titulo").focus();
}

function excluirTarefa() {
    document.getElementById("tituloModal").innerText = "Excluir Tarefa";
    removeEstudo();
    document.getElementById("bgModal").classList.add("bg-excluir");
    openModalTarefas("#excluir-tarefa");
    document.getElementById("titulo").focus();
}

/* ==========================================================
   HASH / HISTÓRICO
   ========================================================== */
window.onpopstate = function () {
    if (!location.hash) {
        document.getElementById('modalTarefas').style.display = 'none';
    }
};

window.onload = function () {
    if (location.hash === '#nova-tarefa')   novaTarefa();
    if (location.hash === '#editar-tarefa') editarTarefa();
    if (location.hash === '#excluir-tarefa') excluirTarefa();
};

/* ==========================================================
   SHAKE AO CLICAR FORA
   ========================================================== */
document
  .getElementById('modalTarefas')
  .addEventListener('click', function (e) {

    // clicou no overlay
    if (e.target.id === 'modalTarefas') {

      const modal = document.getElementById('bgModal');

      // reinicia animação
      modal.classList.remove('shake-modal');
      void modal.offsetWidth;
      modal.classList.add('shake-modal');

      document.getElementById("titulo").focus();
    }
  });
