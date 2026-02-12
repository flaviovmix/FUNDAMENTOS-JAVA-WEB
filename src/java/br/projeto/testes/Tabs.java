package br.projeto.testes;


public class Tabs {

    public static String toHtml() {

        StringBuilder aux = new StringBuilder();
        
        aux.append("""
            <div class="task-tabs">

                <!-- INDICADOR DESLIZANTE -->
                <div class="tab-indicator"></div>

                <!-- TAB 1 -->
                <a href="#" class="task-tab active" data-tab="todos">
                    <i class="fa-solid fa-list"></i>
                    Todos
                </a>

                <!-- TAB 2 -->
                <a href="#" class="task-tab" data-tab="ativas">
                    <i class="fa-solid fa-circle-check"></i>
                    Ativas
                </a>

                <!-- TAB 3 -->
                <a href="#" class="task-tab" data-tab="inativas">
                    <i class="fa-solid fa-circle-pause"></i>
                    Inativas
                </a>

                <!-- TAB 4 -->
                <a href="#" class="task-tab" data-tab="pendentes">
                    <i class="fa-solid fa-hourglass-half"></i>
                    Pendentes
                </a>

                <!-- TAB 5 -->
                <a href="#" class="task-tab" data-tab="rascunho">
                    <i class="fa-solid fa-file-pen"></i>
                    Rascunho
                </a>

                <!-- TAB 6 -->
                <a href="#" class="task-tab" data-tab="excluidas">
                    <i class="fa-solid fa-trash"></i>
                    Excluídas
                </a>

            </div>
        """);
        
        return aux.toString();
    }
    
}