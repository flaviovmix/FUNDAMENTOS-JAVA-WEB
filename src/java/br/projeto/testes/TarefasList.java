package br.projeto.testes;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.SQLException;

@WebServlet("/home")
public class TarefasList extends RootServlet {

    public void inicio() {
    
    }
    
    @Override
    protected void doGet(
        
        HttpServletRequest request, 
        HttpServletResponse response
    )   throws ServletException, IOException {
            
        this.inicio();
        super.inicio();
        
        try {
            PrintWriter resposta = response.getWriter();
            String caminhoAplicacao = request.getContextPath();
            
            resposta.print(LayoutCSS.toHtml(caminhoAplicacao));
            resposta.print(Tabs.toHtml());
            
            String vazio = ("""
                <tr>
                    <td class="info" colspan="10">
                        Nenhuma tarefa encontrada.
                    </td>
                </tr>                
            """);
            
            String tarefa;
            if (true) {
                tarefa = TabelaListarTarefas.toHtml();    
            } else {
                tarefa = vazio;    
            }
            
            resposta.print(TarefaExtruturaTabela.html(tarefa));
            
            resposta.print(Paginacao.toHtml());
            resposta.print("</main>");
            resposta.print(Modal.toHtml());
            resposta.print(Js.toHtml(caminhoAplicacao));
            resposta.print("</body></html>");
        } catch (SQLException e) {
            log("erro", e);
        }
        
        super.fim();
        
    } 

    @Override
    public void obriga(String a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
