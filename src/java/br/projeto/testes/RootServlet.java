package br.projeto.testes;

import jakarta.servlet.http.HttpServlet;

public abstract class RootServlet extends HttpServlet{
    
    public abstract void obriga(String a);
   
    protected void inicio() {
    
        //abre o banco
        //autentica usuario
        
    }
    
    protected void fim() {
    
        //fecha o banco
        //trata erro
        
    }
    
}
