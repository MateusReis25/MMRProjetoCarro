<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<link href="style.css" rel="stylesheet">
<title>Carro</title>
</head>
<body>
	 <div class="menu">
        <div class="col-2">
            <h3>Mateus Cars</h3>
        </div>
       <h6>Carros</h6> 
    </div>
    
    <div class="lista">
        <strong>Lista de Carros</strong>
    </div><hr>
    <div class="btnUsuario">
        <a href="form.jsp"><button type="button" class="btn btn-primary">Cadastrar Carros</button></a>
    </div>
    <td><c:out value="${ipva.anoIpva}"/></td>
    <div class="tabela">
        <table class=" table table table-bordered">
			<thead>
				<tr>
					<th>Cod. Veiculo</th>
					<th>Modelo</th>
					<th>Ano</th>
					<th>IPVA</th>
					<th>A??es</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="carro" items="${listUser}">
					<tr>
						<form action="ServletCarro" method="post"> 
							<td>
								<c:out value="${carro.cod_veiculo}"/>
								<input type="hidden" name="cod_veiculo" value="${carro.cod_veiculo}"/>
							</td>
							<td><c:out value="${carro.modelo}"/></td>
							<td><c:out value="${carro.ano}"/></td>
							<td><c:out value="${ipva.anoIpva}"/></td>
							
							<td class="btnAcoes">
								<button type="submit" name="option" value="delete">Deletar</button>
								<button type="submit" name="option" value="updateForm">Atualizar</button>
							</td>
						</form>	
					</tr>
				</c:forEach>
			</tbody>
		</table>
    </div>
</body>
</html>