package br.projeto.tarefa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/tarefas/confirmar-exclusao")
public class TarefaConfirmarExclusaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            TarefaDAO dao = new TarefaDAO();
            TarefaBean tarefa = dao.buscarPorId(id);
            request.setAttribute("tarefaExcluir", tarefa);

            List<TarefaBean> tarefas = dao.listarTarefas();
            request.setAttribute("tarefas", tarefas);

            request.getRequestDispatcher("/home.jsp").forward(request, response);

        } catch (SQLException e) {
            log("Erro ao buscar tarefa", e);
            response.sendRedirect(request.getContextPath() + "/tarefas/listar");
        }
    }
}
