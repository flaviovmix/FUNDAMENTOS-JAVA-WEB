package br.projeto.testes;

public class Dashboard {

    public static String toHtml() {

        StringBuilder aux = new StringBuilder();
        
        aux.append("""
            <div class="dashboard-container">

            <div class="dashboard-grid">
                <div class="dashboard-card">
                    <div class="dashboard-icon" style="background-color:#2ecc71;">
                        <i class="fa-solid fa-list"></i>
                    </div>
                    <h5 class="card-title">Tarefas</h5>
                    <p class="card-text">Organize aqui suas atividades.</p>
                    <a href="#" class="dashboard-btn"
                       style="border:2px solid #2ecc71; color:#2ecc71; background:transparent; transition:0.3s;"
                       onmouseover="this.style.background = '#2ecc71'; this.style.color = '#fff';"
                       onmouseout="this.style.background = 'transparent'; this.style.color = '#2ecc71';"
                       onclick="clearInput();ajaxURL('db05abc2cd78d92b6136740811d416fe.jsap', 1, 1, 1);">Acessar</a>
                </div>
                <div class="dashboard-card">
                    <div class="dashboard-icon" style="background-color:#2ecc71;">
                        <i class="fa-solid fa-list"></i>
                    </div>
                    <h5 class="card-title">Tarefas</h5>
                    <p class="card-text">Organize aqui suas atividades.</p>
                    <a href="#" class="dashboard-btn"
                       style="border:2px solid #2ecc71; color:#2ecc71; background:transparent; transition:0.3s;"
                       onmouseover="this.style.background = '#2ecc71'; this.style.color = '#fff';"
                       onmouseout="this.style.background = 'transparent'; this.style.color = '#2ecc71';"
                       onclick="clearInput();ajaxURL('db05abc2cd78d92b6136740811d416fe.jsap', 1, 1, 1);">Acessar</a>
                </div>
                <div class="dashboard-card">
                    <div class="dashboard-icon" style="background-color:#2ecc71;">
                        <i class="fa-solid fa-list"></i>
                    </div>
                    <h5 class="card-title">Tarefas</h5>
                    <p class="card-text">Organize aqui suas atividades.</p>
                    <a href="#" class="dashboard-btn"
                       style="border:2px solid #2ecc71; color:#2ecc71; background:transparent; transition:0.3s;"
                       onmouseover="this.style.background = '#2ecc71'; this.style.color = '#fff';"
                       onmouseout="this.style.background = 'transparent'; this.style.color = '#2ecc71';"
                       onclick="clearInput();
                  ajaxURL('db05abc2cd78d92b6136740811d416fe.jsap', 1, 1, 1);">Acessar</a>
                </div>
            </div>

        </div>         
    """);
        
        return aux.toString();
    }
}