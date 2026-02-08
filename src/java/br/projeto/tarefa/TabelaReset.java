package br.projeto.tarefa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/tarefas/reset")
public class TabelaReset extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            TarefaDAO dao = new TarefaDAO();
            dao.resetarTabela();

            List<TarefaBean> tarefas = dao.listarTarefas();
            request.setAttribute("tarefas", tarefas);

            request.getRequestDispatcher("/home.jsp").forward(request, response);

        } catch (SQLException e) {
            log("Erro ao buscar tarefa", e);
            response.sendRedirect(request.getContextPath() + "/tarefas/listar");
        }
    }
}