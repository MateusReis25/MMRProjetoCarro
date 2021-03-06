<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<link href="style.css" rel="stylesheet">
<title>Formulário</title>
</head>
<body>
	<div class="menu">
        <div class="col-2">
            <h3>Lista de Carros</h3>
        </div>
       <h6>Formulário</h6> 
    </div>
    <div class="formLogin">
        <h3>Cadastrar Carro</h3>
        <form action="ServletCarro" method="post">
			<c:choose>
				<c:when test="${carro == null}">
					<div class="inputs">
						<label>Modelo:</label><br>
						<input type="text" name="modelo" required/> <br>
						<label>Ano:</label><br>
						<input type="text" name="ano"/><br><br>
						
									
						<button type="submit" name="option" value="insert"><strong>Salvar</strong></button>
					</div>	
				</c:when>
				<c:otherwise>
					<div class="inputs">
						<input type="hidden" name="cod_veiculo" value="${carro.cod_veiculo}"/>
						<label>Modelo:</label><input type="text" name="modelo" value="${carro.modelo}" required/>
						<label>Ano:</label><input type="text" name="ano" value="${carro.ano}"/>
					
						<button type="submit" name="option" value="update">Atualizar</button>
					</div>
				</c:otherwise>
			</c:choose>
		</form>
    </div>
</body>
</html>