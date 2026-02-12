package br.projeto.testes;

public class Modal {

    public static String toHtml() {

        StringBuilder aux = new StringBuilder();
        
        aux.append("""
            <div class='overlay-custom' id='modalTarefas' style='display:none;'>
                <div class='box-modal-custom' id='bgModal'>

                    <button type="button" class="btn-close-custom" onclick="closeModalTarefas()">×</button>
                    <h2 id="tituloModal">Nova Tarefa</h2>

                    <form action="" method="post" class="form-tarefa-custom">

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
        """);
        
        return aux.toString();
    }
}