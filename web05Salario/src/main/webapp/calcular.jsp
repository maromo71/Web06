<%@ page import="com.example.web05salario.model.Funcionario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Novo Salário</title>
</head>
<body>
<%
    Funcionario funcionario = new Funcionario();
    funcionario.setNome(request.getParameter("nome"));
    funcionario.setIdade(Integer.parseInt(request.getParameter("idade")));
    funcionario.setSalario(Double.parseDouble(request.getParameter("salario")));
    funcionario.setSexo(request.getParameter("sexo"));
    funcionario.calcularSalario();
%>
<h1>
    Novo salário
</h1>
<h2>
    Empregado(a): <%=funcionario.getNome()%>
</h2>
<p>
    Com base nas suas informações o
    salário novo calculado é <%=funcionario.getSalario()%>
</p>
<a href="index.jsp">Retornar Página Principal</a>
</body>
</html>
