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
            <h3>Tabela IPVA</h3>
        </div>
       <h6>Formulário</h6> 
    </div>
    <div class="formLogin">
        <h3>Cadastrar IPVA</h3>
        <form action="ServletIPVA" method="post">
			<c:choose>
				<c:when test="${ipva == null}">
					<div class="inputs">
						<label>Ano:</label><br>
						<input type="text" name="anoIpva"/><br><br>
									
						<button type="submit" name="optionIpva" value="insertIpva"><strong>Salvar</strong></button>
					</div>	
				</c:when>
				<c:otherwise>
					<div class="inputs">
						<input type="hidden" name="cod_ipva" value="${ipva.cod_ipva}"/>
						<label>Ano:</label>
						<input type="text" name="anoIpva" value="${ipva.anoIpva}"required/>
					
						<button type="submit" name="optionIpva" value="updateIpva">Atualizar</button>
					</div>
				</c:otherwise>
			</c:choose>
		</form>
    </div>
</body>
</html>