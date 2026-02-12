package br.projeto.testes;

public class Paginacao {

    public static String toHtml() {
        
        StringBuilder aux = new StringBuilder();  
        
        aux.append("""
            <div class="task-pagination2" id="paginacao">

                <button type="button" class="task2-btn" id="btnPrimeira" aria-label="Primeira página">
                    &lt;&lt;
                </button>

                <button type="button" class="task2-btn" id="btnAnterior" aria-label="Página anterior">
                    &lt;
                </button>

                <div class="task2-center">
                    <select class="task2-select" id="selectPagina" aria-label="Selecionar página">
                        <!-- exemplo estático (você pode substituir via JS/JSP) -->
                        <option value="1">pagina 01 de 15</option>
                        <option value="2">pagina 02 de 15</option>
                        <option value="3">pagina 03 de 15</option>
                    </select>
                </div>

                <button type="button" class="task2-btn" id="btnProxima" aria-label="Próxima página">
                    &gt;
                </button>

                <button type="button" class="task2-btn" id="btnUltima" aria-label="Última página">
                    &gt;&gt;
                </button>

            </div>       
        """);
        
        return aux.toString();
    }
    
}