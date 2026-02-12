package br.projeto.testes;

import java.sql.SQLException;

public class TarefaExtruturaTabela {

    public static String html(String tarefa) throws SQLException {

        StringBuilder aux = new StringBuilder();
        
        aux.append("""
            <table class="task-table">

                <thead>
                    <tr>
                        <th></th>
                        <th>ID</th>
                        <th>Titulo</th>
                        <th>Prioridade</th>
                        <th>Responsável</th>
                        <th>Status</th>
                        <th class="text-center">Editar</th>
                        <th class="text-center">Excluir</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    %s
                </tbody>

            </table>
            """.formatted(tarefa), 
        );
        
        return aux.toString();
    }
}
