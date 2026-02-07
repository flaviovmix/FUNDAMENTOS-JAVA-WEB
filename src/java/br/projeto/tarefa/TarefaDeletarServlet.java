package br.projeto.tarefa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/tarefas/deletar")
public class TarefaDeletarServlet extends HttpServlet {

    @Override
    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id_tarefa"));
            TarefaDAO dao = new TarefaDAO();
            dao.excluirTarefa(id);

        } catch (SQLException e) {
            log("Erro ao excluir tarefa", e);
        }

        response.sendRedirect(request.getContextPath() + "/tarefas/listar");
    }
}
