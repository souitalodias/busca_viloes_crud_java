package com.busca_viloes.controller;

import com.busca_viloes.dao.VilaoDAO;
import com.busca_viloes.model.Vilao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/controller")
public class VilaoController extends HttpServlet {
    private VilaoDAO dao;

    @Override
    public void init() {
        dao = new VilaoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao == null) {
            acao = "listar";
        }

        try {
            switch (acao) {
                case "novo":
                    request.getRequestDispatcher("cadastro.jsp").forward(request, response);
                    break;
                case "editar":
                    Long idEditar = Long.parseLong(request.getParameter("id"));
                    Vilao vilaoExistente = dao.buscarPorId(idEditar);
                    request.setAttribute("vilao", vilaoExistente);
                    request.getRequestDispatcher("cadastro.jsp").forward(request, response);
                    break;
                case "excluir":
                    Long idExcluir = Long.parseLong(request.getParameter("id"));
                    dao.excluir(idExcluir);
                    response.sendRedirect("controller?acao=listar");
                    break;
                case "listar":
                default:
                    List<Vilao> listaViloes = dao.listar();
                    request.setAttribute("viloes", listaViloes);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException("Erro no processamento da requisição GET", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");

        try {
            Vilao vilao = new Vilao();
            vilao.setNome(request.getParameter("nome"));
            vilao.setCodinome(request.getParameter("codinome"));
            vilao.setNivelAmeaca(request.getParameter("nivelAmeaca"));
            vilao.setPrecoDiaria(Double.parseDouble(request.getParameter("precoDiaria")));
            vilao.setDisponivel(Boolean.parseBoolean(request.getParameter("disponivel")));

            if ("salvar".equals(acao)) {
                dao.cadastrar(vilao);
            } else if ("atualizar".equals(acao)) {
                vilao.setId(Long.parseLong(request.getParameter("id")));
                dao.alterar(vilao);
            }
            // Após salvar ou atualizar, redireciona de volta para a listagem
            response.sendRedirect("controller?acao=listar");
        } catch (Exception e) {
            throw new ServletException("Erro no processamento da requisição POST", e);
        }
    }
}