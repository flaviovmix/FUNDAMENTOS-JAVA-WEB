package br.projeto.testes;

import java.sql.SQLException;

public class TarefaExtruturaTabela {

    public static String html(String tarefa) throws SQLException {

        StringBuilder aux = new StringBuilder();
        
        aux.append("""
                   
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
            """.formatted(tarefa)
        );
        
        return aux.toString();
    }
}
