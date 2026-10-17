<%@ page import="com.busca_viloes.model.Vilao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Vilao vilao = (Vilao) request.getAttribute("vilao");
    boolean isEdicao = (vilao != null && vilao.getId() != null);
%>
<html>
<head>
    <title><%= isEdicao ? "Editar Vilão" : "Cadastrar Vilão" %></title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        .form-container { max-width: 400px; margin: auto; padding: 20px; border: 1px solid #ccc; border-radius: 8px; }
        input, select { width: 100%; padding: 8px; margin: 8px 0; box-sizing: border-box; }
        .btn { width: 100%; padding: 10px; background-color: #5cb85c; color: white; border: none; border-radius: 4px; cursor: pointer; }
    </style>
</head>
<body>
    <div class="form-container">
        <h2><%= isEdicao ? "Editar Vilão" : "Cadastrar Novo Vilão" %></h2>

        <form action="controller" method="post">
            <input type="hidden" name="acao" value="<%= isEdicao ? "atualizar" : "salvar" %>">
            <% if (isEdicao) { %>
                <input type="hidden" name="id" value="<%= vilao.getId() %>">
            <% } %>

            <label>Nome:</label>
            <input type="text" name="nome" value="<%= isEdicao ? vilao.getNome() : "" %>" required>

            <label>Codinome:</label>
            <input type="text" name="codinome" value="<%= isEdicao ? vilao.getCodinome() : "" %>" required>

            <label>Nível de Ameaça:</label>
            <select name="nivelAmeaca">
                <option value="BAIXO" <%= isEdicao && "BAIXO".equals(vilao.getNivelAmeaca()) ? "selected" : "" %>>Baixo</option>
                <option value="MEDIO" <%= isEdicao && "MEDIO".equals(vilao.getNivelAmeaca()) ? "selected" : "" %>>Médio</option>
                <option value="ALTO" <%= isEdicao && "ALTO".equals(vilao.getNivelAmeaca()) ? "selected" : "" %>>Alto</option>
                <option value="CRITICO" <%= isEdicao && "CRITICO".equals(vilao.getNivelAmeaca()) ? "selected" : "" %>>Crítico</option>
            </select>

            <label>Preço da Diária (R$):</label>
            <input type="number" step="0.01" name="precoDiaria" value="<%= isEdicao ? vilao.getPrecoDiaria() : "" %>" required>

            <label>Disponível:</label>
            <select name="disponivel">
                <option value="true" <%= isEdicao && vilao.getDisponivel() ? "selected" : "" %>>Sim</option>
                <option value="false" <%= isEdicao && !vilao.getDisponivel() ? "selected" : "" %>>Não</option>
            </select>

            <button type="submit" class="btn"><%= isEdicao ? "Atualizar" : "Cadastrar" %></button>
            <br><br>
            <a href="controller?acao=listar" style="display:block; text-align:center; color:#d9534f;">Cancelar e Voltar</a>
        </form>
    </div>
</body>
</html>