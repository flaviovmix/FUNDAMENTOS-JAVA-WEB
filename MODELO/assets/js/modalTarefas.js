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

function setCamposHabilitados(habilitar) {
    document.getElementById("titulo").disabled = !habilitar;
    document.getElementById("responsavel").disabled = !habilitar;
    document.getElementById("descricao").disabled = !habilitar;
    document.getElementById("data_criacao").disabled = !habilitar; 
    document.getElementById("status").disabled = !habilitar;

    document.querySelectorAll('input[name="prioridade"]').forEach(r => {
        r.disabled = !habilitar;
    });
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

function removeEstilo() {
    // classes remover estilo do bg
    document.getElementById("bgModal").classList.remove("bg-nova");
    document.getElementById("bgModal").classList.remove("bg-editar");
    document.getElementById("bgModal").classList.remove("bg-excluir");
    
    // classes remover estilo do botão
    document.getElementById("botaoConfirmacao").classList.remove("btn-excluirTarefa");
    document.getElementById("botaoConfirmacao").classList.remove("btn-novaTarefa");
    document.getElementById("botaoConfirmacao").classList.remove("btn-editarTarefa");
}

function novaTarefa() {
    setCamposHabilitados(true);
    const ctx = document.body.dataset.context;
    document.getElementById("tituloModal").innerText = "Nova Tarefa";
    document.getElementById("botaoConfirmacao").innerText = "Salvar Registro";
    removeEstilo();
    document.getElementById("bgModal").classList.add("bg-nova");
    openModalTarefas('#nova-tarefa');
    document.getElementById("titulo").focus();
    document.querySelector(".form-tarefa-custom").action = ctx + "/tarefas/cadastrar";
}

function editarTarefa(id, titulo, prioridade, responsavel, status, descricao) {
    setCamposHabilitados(true);
    const ctx = document.body.dataset.context;
    document.getElementById("tituloModal").innerText = "Editar Tarefa";
    document.getElementById("botaoConfirmacao").innerText = "Editar Registro";
    removeEstilo();
    document.getElementById("bgModal").classList.add("bg-editar");
    document.getElementById("botaoConfirmacao").classList.add("btn-editarTarefa");
    openModalTarefas("#editar-tarefa");
    
    document.getElementById("id_tarefa").value = id;
    document.getElementById("titulo").value = titulo;
    document.getElementById("responsavel").value = responsavel;
    document.getElementById("descricao").value = descricao;
    document.getElementById("status").value = status;
    
    // prioridade (radio)
    document.querySelectorAll('input[name="prioridade"]').forEach(r => {
        r.checked = (r.value === prioridade);
    });
    
    document.getElementById("titulo").focus();
    document.querySelector(".form-tarefa-custom").action = ctx + "/tarefas/editar";
}

function excluirTarefa(id, titulo, prioridade, responsavel, status, descricao) {
    setCamposHabilitados(false);
    
    const ctx = document.body.dataset.context;
    document.getElementById("tituloModal").innerText = "Excluir Tarefa";
    document.getElementById("botaoConfirmacao").innerText = "Confirmar Exclusão";
    removeEstilo();
    document.getElementById("bgModal").classList.add("bg-excluir");
    document.getElementById("botaoConfirmacao").classList.add("btn-excluirTarefa");
    openModalTarefas("#excluir-tarefa");
    
    document.getElementById("id_tarefa").value = id;
    document.getElementById("titulo").value = titulo;
    document.getElementById("responsavel").value = responsavel;
    document.getElementById("descricao").value = descricao;
    document.getElementById("status").value = status;
    
    // prioridade (radio)
    document.querySelectorAll('input[name="prioridade"]').forEach(r => {
        r.checked = (r.value === prioridade);
    });
    
    document.querySelector(".form-tarefa-custom").action = ctx + "/tarefas/deletar";
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
  if (location.hash === '#nova-tarefa') novaTarefa();
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

