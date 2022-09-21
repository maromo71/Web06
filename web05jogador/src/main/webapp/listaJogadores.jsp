<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         import="java.util.*,
                 br.santalucia.web05jogador.dao.*,
                 br.santalucia.web05jogador.model.Jogador"
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Lista de Jogadores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<p class="display-4 text-center mt-8">Jogadores</p>
<div class="container">


    <table class="table table-striped">
        <tr class="table-dark">
            <td>Nome do Jogador</td>
            <td>Apelido</td>
            <td>Posição</td>
            <td>Idade</td>
        </tr>
        <tr>
            <%
                JogadorDao dao = new JogadorDao();
                List<Jogador> lista = dao.listarJogadores();
                for (Jogador j : lista) {
            %>
            <td><%=j.getNome()%>
            </td>
            <td><%=j.getApelido()%>
            </td>
            <td><%=j.getPosicao()%>
            </td>
            <td><%=j.getIdade()%>
            </td>
        </tr>
        <% } %>
    </table>
</div>
</body>
</html>