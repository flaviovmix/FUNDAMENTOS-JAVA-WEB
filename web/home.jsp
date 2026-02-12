<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="br.projeto.tarefa.TarefaBean"%>
<%@page import="br.projeto.tarefa.TarefaDAO"%>
<%@page import="br.root.config.ConnectionPool"%>
<%@page import="java.sql.*" %>

<%! 
  private String js(String s) {
    if (s == null) return "";
    return s
      .replace("\\", "\\\\")
      .replace("'", "\\'")
      .replace("\"", "\\\"")
      .replace("\r", "")
      .replace("\n", "\\n");
  }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Lista de Tarefas</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/base.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/layout.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/buttons.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/flash.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/tabs.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/table.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/paginacao.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/modal-tarefa.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/checkbox.css">

    </head>

    <body data-context="${pageContext.request.contextPath}">

        <header>
            <div class="header-inner">
                <div class="btn-header">
                    <button class="btn-add" onclick="novaTarefa()">
                        <i class="fa-solid fa-plus"></i>
                        Nova Tarefa
                    </button>
                    <a class="btn-reset" href="${pageContext.request.contextPath}/tarefas/reset">
                        <i class="fa-solid fa-rotate-left"></i>
                        Resetar Tabela
                    </a>
                    <a class="btn-apagar" href="${pageContext.request.contextPath}/tarefas/apagar">
                        <i class="fa-solid fa-trash"></i>
                        Apagar todos os registros
                    </a>
                </div>
                    <h2>FUNDAMENTOS JAVA 25</h2>    
            </div>
        </header>

        <main>

            <div class="page-header">

                <h1>LISTA DE TAREFAS</h1>

                <div class="legenda-prioridade">
                    <span class="legenda-label">níveis de prioridade</span>

                    <div class="legenda-badges">
                        <span class="badge baixa">baixa</span>
                        <span class="badge media">média</span>
                        <span class="badge alta">alta</span>
                    </div>
                </div>

            </div>
            
            <!-- GUIAS / FILTRO DE TAREFAS -->
            <div class="task-tabs">
              <!-- Para começar: deixa "Todos" ativo -->
                <a href="#" class="task-tab active" data-tab="todos">
                  <i class="fa-solid fa-list"></i>
                  Todos
                </a>

                <a href="#" class="task-tab" data-tab="ativas">
                  <i class="fa-solid fa-circle-check"></i>
                  Ativas
                </a>

                <a href="#" class="task-tab" data-tab="inativas">
                  <i class="fa-solid fa-circle-pause"></i>
                  Inativas
                </a>

                <a href="#" class="task-tab" data-tab="pendentes">
                  <i class="fa-solid fa-hourglass-half"></i>
                  Pendentes
                </a>

                <a href="#" class="task-tab" data-tab="rascunho">
                  <i class="fa-solid fa-file-pen"></i>
                  Rascunho
                </a>

                <a href="#" class="task-tab" data-tab="excluidas">
                  <i class="fa-solid fa-trash"></i>
                  Excluídas
                </a>

            </div>
            <!-- FIM GUIAS -->


            <table class="task-table">

                <thead>
                    <tr>
                        <th></th>
                        <th>ID</th>
                        <th>Título</th>
                        <th>Prioridade</th>
                        <th>Responsável</th>
                        <th>Status</th>
                        <th>Quant. Tarefas</th>
                        <th>Editar</th>
                        <th>Excluir</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                     
                    <%
                        
                    try {
                        List<TarefaBean> tarefas = (List<TarefaBean>) request.getAttribute("tarefas");
                        if(tarefas.isEmpty()) {%>
                            <tr>
                                <td class="info" colspan="10">
                                    Nenhuma tarefa encontrada.
                                </td>
                            </tr>
                        <% }
                        for (TarefaBean tarefa : tarefas) { %>
                        <tr class="row-link">
                            <td class="prioridade <%= tarefa.getPrioridade() %>">
                                <a href="${pageContext.request.contextPath}/form.html" class="row-anchor"></a>
                            </td>
                            <td><%= tarefa.getId_tarefa() %></td>
                            <td><%= tarefa.getTitulo() %></td>
                            <td><%= tarefa.getPrioridade() %></td>
                            <td><%= tarefa.getResponsavel() %></td>
                            <td><%= tarefa.getStatusText()%></td>
                            <td class="text-center" > <%= (int)(Math.random() * 11) %></td>
                            
                            <td class="btn-action edit">
                              <a href="${pageContext.request.contextPath}/tarefas/confirmar-edicao?id=<%= tarefa.getId_tarefa() %>">
                                <i class="fa-solid fa-pen"></i>
                              </a>
                            </td>

                            <td class="btn-action delete">
                              <a href="${pageContext.request.contextPath}/tarefas/confirmar-exclusao?id=<%= tarefa.getId_tarefa() %>">
                                <i class="fa-solid fa-trash"></i>
                              </a>
                            </td>
                            
                            <td class="btn-action">
                                <label class="alternador">
                                  <input type="checkbox" 
                                        <%= ((int)(Math.random() * 11)) < 5 ? "checked" : "" %>
                                   >
                                  <span class="alternador-slider"></span>
                                </label>
                            </td>

                         </tr>
                              
                                <% }
                            } catch (Exception e) {
                                 e.printStackTrace(); %>
                                 <tr>
                                     <td class="erro" colspan="8">
                                         Algum erro inesperado aconteceu.
                                     </td>
                                 </tr>
                             <% }
                         %>
                    
                </tbody>
            </table>

                    

            <!-- PAGINAÇÃO (modelo da imagem) -->
            <div class="task-pagination2" id="paginacao">

                <button type="button" class="task2-btn" id="btnPrimeira" aria-label="Primeira página">
                    &lt;&lt;
                </button>

                <button type="button" class="task2-btn" id="btnAnterior" aria-label="Página anterior">
                    &lt;
                </button>

                <div class="task2-center">
                    <select class="task2-select" id="selectPagina" aria-label="Selecionar página">
                        <!-- exemplo estático (você pode substituir via JS/JSP) -->
                        <option value="1">pagina 01 de 15</option>
                        <option value="2">pagina 02 de 15</option>
                        <option value="3">pagina 03 de 15</option>
                    </select>
                </div>

                <button type="button" class="task2-btn" id="btnProxima" aria-label="Próxima página">
                    &gt;
                </button>

                <button type="button" class="task2-btn" id="btnUltima" aria-label="Última página">
                    &gt;&gt;
                </button>

            </div>
            <!-- FIM PAGINAÇÃO -->
                    
            <!--MODAL-->
            <div class='overlay-custom' id='modalTarefas' style='display:none;'>
                <div class='box-modal-custom' id='bgModal'>

                    <button type="button" class="btn-close-custom" onclick="closeModalTarefas()">×</button>
                    <h2 id="tituloModal">Nova Tarefa</h2>

                    <form action="" method="post" class="form-tarefa-custom">

                        <!-- ✅ ÚNICA COISA NOVA PRA EDITAR FUNCIONAR -->
                        <input type="hidden" id="id_tarefa" name="id_tarefa" value="">

                        <div class="group-custom">
                            <label class="label-custom" for="titulo">Título</label>
                            <input type="text" id="titulo" name="titulo" required>
                        </div>

                        <div class="columns-2-custom">

                            <div class="group-custom">
                                <label class="label-custom">Prioridade</label>

                                <div class="radio-custom">

                                    <label class="label-custom">
                                        <input type="radio" name="prioridade" value="alta" required>
                                        Alta
                                    </label>

                                    <label class="label-custom">
                                        <input type="radio" name="prioridade" value="media">
                                        Média
                                    </label>

                                    <label class="label-custom">
                                        <input type="radio" name="prioridade" value="baixa">
                                        Baixa
                                    </label>

                                </div>
                            </div>

                            <div class="group-custom">
                                <label class="label-custom" for="responsavel">Responsável</label>
                                <input type="text" id="responsavel" name="responsavel" required>
                            </div>

                        </div>

                        <div class="columns-2-custom">

                            <div class="group-custom">
                                <label class="label-custom" for="data_criacao">Data de Criação</label>
                                <input type="date" id="data_criacao" name="data_criacao" value="2025-01-01" required>
                            </div>

                            <div class="group-custom">
                                <label class="label-custom" for="status">Status</label>
                                <select id="status" name="status" required>
                                    <option value="">Selecione</option>
                                    <option value="0">ativo</option>
                                    <option value="1">inativo</option>
                                </select>
                            </div>

                        </div>

                        <div class="group-custom">
                            <label class="label-custom" for="descricao">Descrição</label>
                            <textarea id="descricao" name="descricao" rows="4"></textarea>
                        </div>

                        <button type="submit" id="botaoConfirmacao" class="btn-save-custom">Salvar Tarefa</button>

                    </form>

                </div>
            </div>
            <!--FIM DO MODAL-->

            <script src="${pageContext.request.contextPath}/assets/js/modalTarefas.js"></script>
            
<%
  TarefaBean tarefaExcluir = (TarefaBean) request.getAttribute("tarefaExcluir");
  if (tarefaExcluir != null) {
%>
    <script>
      excluirTarefa(
        <%= tarefaExcluir.getId_tarefa() %>,
        '<%= js(tarefaExcluir.getTitulo()) %>',
        '<%= js(tarefaExcluir.getPrioridade()) %>',
        '<%= js(tarefaExcluir.getResponsavel()) %>',
        '<%= tarefaExcluir.getStatus() %>',
        '<%= js(tarefaExcluir.getDescricao()) %>'
      );
    </script> 
<%
  }
%>

<%
  TarefaBean tarefaEdicao = (TarefaBean) request.getAttribute("tarefaEdicao");
  if (tarefaEdicao != null) {
%>
    <script>
      editarTarefa(
        <%= tarefaEdicao.getId_tarefa() %>,
        '<%= js(tarefaEdicao.getTitulo()) %>',
        '<%= js(tarefaEdicao.getPrioridade()) %>',
        '<%= js(tarefaEdicao.getResponsavel()) %>',
        '<%= tarefaEdicao.getStatus() %>',
        '<%= js(tarefaEdicao.getDescricao()) %>'
      );
    </script> 
<%
  }
%>
    </body>
</html>