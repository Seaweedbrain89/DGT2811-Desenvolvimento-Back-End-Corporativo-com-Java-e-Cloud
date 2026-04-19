package cadastroee.servlets;

import cadastroee.controller.ProdutoFacadeLocal;
import cadastroee.model.Produto;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletProdutoFC", urlPatterns = {"/ServletProdutoFC"})
public class ServletProdutoFC extends HttpServlet {

    @EJB
    ProdutoFacadeLocal facade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        String destino;

        if ("formIncluir".equals(acao) || "formAlterar".equals(acao)) {
            destino = "ProdutoDados.jsp";
        } else {
            destino = "ProdutoLista.jsp";
        }

        if ("listar".equals(acao)) {
            request.setAttribute("produtos", facade.findAll());
        } else if ("formAlterar".equals(acao)) {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("produto", facade.find(id));
        } else if ("excluir".equals(acao)) {
            int id = Integer.parseInt(request.getParameter("id"));
            facade.remove(facade.find(id));
            request.setAttribute("produtos", facade.findAll());
        } else if ("alterar".equals(acao)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Produto p = facade.find(id);
            p.setNome(request.getParameter("nome"));
            p.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
            p.setPrecoVenda(Double.parseDouble(request.getParameter("precoVenda")));
            facade.edit(p);
            request.setAttribute("produtos", facade.findAll());
        } else if ("incluir".equals(acao)) {
            Produto p = new Produto();
            p.setNome(request.getParameter("nome"));
            p.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
            p.setPrecoVenda(Double.parseDouble(request.getParameter("precoVenda")));
            facade.create(p);
            request.setAttribute("produtos", facade.findAll());
        }

        request.getRequestDispatcher(destino).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}