package br.projeto.testes;

public class LayoutCSS {

    public static String toHtml(String contextPath) {

        StringBuilder aux = new StringBuilder();
        
        aux.append("""
            <!DOCTYPE html>
            <html lang="pt-br">
            <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Home</title>

            <link rel="stylesheet" href="%1$s/assets/css/base.css">
            <link rel="stylesheet" href="%1$s/assets/css/layout.css">
            <link rel="stylesheet" href="%1$s/assets/css/components/buttons.css">
            <link rel="stylesheet" href="%1$s/assets/css/components/table.css">
            <link rel="stylesheet" href="%1$s/assets/css/components/checkbox.css">
            <link rel="stylesheet" href="%1$s/assets/css/components/paginacao.css">
            <link rel="stylesheet" href="%1$s/assets/css/components/tabs.css">
            <link rel="stylesheet" href="%1$s/assets/css/components/modal-tarefa.css">

            <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

            </head>
            <body>

            <header>
                <div class="header-inner">

                    <div class="btn-header">

                        <button class="btn-add" onclick="novaTarefa()">
                            <i class="fa-solid fa-plus"></i>
                            Nova Tarefa
                        </button>

                        <a class="btn-reset" href="%1$s/tarefas/reset">
                            <i class="fa-solid fa-rotate-left"></i>
                            Resetar Tabela
                        </a>

                        <a class="btn-apagar" href="%1$s/tarefas/apagar">
                            <i class="fa-solid fa-trash"></i>
                            Apagar todos os registros
                        </a>

                    </div>

                    <h2>FUNDAMENTOS JAVA 25</h2>

                </div>
            </header>

            <main>

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
            """.formatted(contextPath));
        
        return aux.toString();
    }

}
