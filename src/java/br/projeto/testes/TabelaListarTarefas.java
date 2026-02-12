package br.projeto.testes;

import br.projeto.tarefa.TarefaBean;
import br.projeto.tarefa.TarefaDAO;
import java.sql.SQLException;
import java.util.List;

public class TabelaListarTarefas {
    public static String toHtml() throws SQLException {
    
        StringBuilder aux = new StringBuilder();        
        TarefaDAO dao = new TarefaDAO();
        List<TarefaBean> tarefas = dao.listarTarefas();
        
        boolean checked = Math.random() < 0.5;
        for (TarefaBean tarefa : tarefas) {
            
            aux.append("""
            <tr class="row-link">

                <td class="prioridade %s cell-link">
                    <a href="detalhe.html?id=%d" class="row-anchor">Abrir</a>
                </td>

                <td class="cell-link">%d</td>
                <td class="cell-link">%s</td>
                <td class="cell-link">%s</td>
                <td class="cell-link">%s</td>
                <td class="cell-link">%s</td>

                <td class="btn-action edit text-center">
                    <a href="#"><i class="fa-solid fa-pen"></i></a>
                </td>

                <td class="btn-action delete text-center">
                    <a href="#"><i class="fa-solid fa-trash"></i></a>
                </td>

                <td class="btn-action">
                    <label class="alternador">
                        <input type="checkbox" %s>
                        <span class="alternador-slider"></span>
                    </label>
                </td>

            </tr>
            """.formatted(
                    tarefa.getPrioridade(),
                    tarefa.getId_tarefa(),
                    tarefa.getId_tarefa(),
                    tarefa.getTitulo(),
                    tarefa.getPrioridade(),
                    tarefa.getResponsavel(),
                    tarefa.getStatusText(),
                    checked ? "checked" : ""
            ));
        }
        
        return aux.toString();
    }
}
