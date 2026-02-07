package br.projeto.tarefa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/tarefas/cadastrar")
public class TarefaCadastrarServlet extends HttpServlet {

      @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response
    ) throws ServletException, IOException {
        
          try {
              String titulo = request.getParameter("titulo");
              String prioridade = request.getParameter("prioridade");
              String responsavel = request.getParameter("responsavel");
              String descricao = request.getParameter("descricao");
              String statusStr = request.getParameter("status");
              int status = Integer.parseInt(statusStr != null ? statusStr.trim() : "2");
              
              TarefaBean tarefa = new TarefaBean();
              tarefa.setTitulo(titulo.trim());
              tarefa.setPrioridade(prioridade);
              tarefa.setResponsavel(responsavel);
              tarefa.setStatus(status);
              tarefa.setDescricao(descricao);
              
              TarefaDAO dao = new TarefaDAO();
              dao.adicionarTarefa(tarefa);
              
              //PRG - POST REDIRECT GET
              response.sendRedirect(request.getContextPath() + "/tarefas/listar");
          } catch (SQLException e) {
              log("Erro", e);
          }
    }
}
