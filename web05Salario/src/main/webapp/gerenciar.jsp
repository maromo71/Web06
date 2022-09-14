<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Novo Cálculo de Salário</title>
</head>
<body>
<h1>
    Calculando Salário
</h1>

<form action="calcular.jsp" method="post">
    <label for="nome">Nome do funcionário</label>
    <input type="text" name="nome" id="nome">
    <br>
    <label for="idade">Idade do funcionário</label>
    <input type="text" name="idade" id="idade">
    <br>
    <label for="salario">Salário do funcionário</label>
    <input type="text" name="salario" id="salario">
    <br>
    <label for="sexo">Sexo da pessoa:</label>
    <select name="sexo" id="sexo">
        <optgroup>
            <option value="masculino">Masculino</option>
            <option value="feminino">Feminino</option>
            <option value="naodizer">Prefiro não dizer</option>
        </optgroup>
    </select>
    <br>
    <input type="submit" value="Enviar">
    <input type="reset" value="Limpar">
</form>
</body>
</html>
