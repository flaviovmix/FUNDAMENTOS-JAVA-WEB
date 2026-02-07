package br.projeto.tarefa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/tarefas/editar")
public class TarefaEditarServlet extends HttpServlet {

    @Override
    protected void doPost(
        HttpServletRequest request, 
        HttpServletResponse response
    ) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id_tarefa"));
        String titulo = request.getParameter("titulo");
        String prioridade = request.getParameter("prioridade");
        String responsavel = request.getParameter("responsavel");
        String descricao = request.getParameter("descricao");
        int status = Integer.parseInt(request.getParameter("status"));

        TarefaBean tarefa = new TarefaBean();
        tarefa.setId_tarefa(id);
        tarefa.setTitulo(titulo.trim());
        tarefa.setPrioridade(prioridade);
        tarefa.setResponsavel(responsavel.trim());
        tarefa.setStatus(status);
        tarefa.setDescricao(descricao);

        // --- salva ---
        try {
            TarefaDAO dao = new TarefaDAO();
            dao.editarTarefa(tarefa);
        } catch (SQLException e) {
            log("Erro", e);
        }
        //PRG - POST REDIRECT GET
        response.sendRedirect(request.getContextPath() + "/tarefas/listar");
    }
}