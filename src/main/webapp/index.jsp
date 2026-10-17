<%@ page import="java.util.List" %>
<%@ page import="com.busca_viloes.model.Vilao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Busca Vilões - Catálogo</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: center; }
        th { background-color: #333; color: white; }
        .btn { padding: 8px 12px; text-decoration: none; color: white; background-color: #d9534f; border-radius: 4px; }
        .btn-novo { background-color: #5cb85c; }
        .btn-editar { background-color: #f0ad4e; }
    </style>
</head>
<body>
    <h1>Catálogo de Vilões</h1>

    <a href="controller?acao=novo" class="btn btn-novo">Cadastrar Novo Vilão</a>

    <table>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Codinome</th>
            <th>Ameaça</th>
            <th>Diária (R$)</th>
            <th>Disponível</th>
            <th>Ações</th>
        </tr>
        <%
            List<Vilao> viloes = (List<Vilao>) request.getAttribute("viloes");
            if (viloes != null && !viloes.isEmpty()) {
                for (Vilao v : viloes) {
        %>
        <tr>
            <td><%= v.getId() %></td>
            <td><%= v.getNome() %></td>
            <td><%= v.getCodinome() %></td>
            <td><%= v.getNivelAmeaca() %></td>
            <td><%= v.getPrecoDiaria() %></td>
            <td><%= v.getDisponivel() ? "Sim" : "Não" %></td>
            <td>
                <a href="controller?acao=editar&id=<%= v.getId() %>" class="btn btn-editar">Editar</a>
                <a href="controller?acao=excluir&id=<%= v.getId() %>" class="btn" onclick="return confirm('Tem certeza que deseja excluir?');">Excluir</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="7">Nenhum vilão cadastrado ainda.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>