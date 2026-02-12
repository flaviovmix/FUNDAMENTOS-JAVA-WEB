package br.projeto.testes;

public class Js {

    public static String toHtml(String contextPath) {

        StringBuilder aux = new StringBuilder();
        
        aux.append("""
            <script src="%1$s/assets/js/modalTarefas.js"></script>
        """.formatted(contextPath));
        
        return aux.toString();
    }
}