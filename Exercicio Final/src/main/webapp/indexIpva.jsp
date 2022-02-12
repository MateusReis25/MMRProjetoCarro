<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<link href="style.css" rel="stylesheet">
<title>IPVA</title>
</head>
<body>
	 <div class="menu">
        <div class="col-2">
            <h3>IPVA</h3>
        </div>
    </div>
    
    <div class="lista">
        <strong>Tabela IPVA</strong>
    </div><hr>
    <div class="btnUsuario">
        <a href="formIpva.jsp"><button type="button" class="btn btn-primary">Cadastrar IPVA</button></a>
    </div>
    
    <div class="tabela">
        <table class=" table table table-bordered">
			<thead>
				<tr>
					<th>Cod. IPVA</th>
					<th>Ano</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ipva" items="${listIpva}">
					<tr>
						<form action="ServletIPVA" method="post"> 
							<td>
								<c:out value="${ipva.cod_ipva}"/>
								<input type="hidden" name="cod_ipva" value="${ipva.cod_ipva}"/>
							</td>
							<td><c:out value="${ipva.anoIpva}"/></td>
							
							
							<td class="btnAcoes">
								<button type="submit" name="optionIpva" value="deleteIpva">Deletar</button>
								<button type="submit" name="optionIpva" value="updateFormIpva">Atualizar</button>
							</td>
						</form>	

					</tr>
				</c:forEach>
			</tbody>
		</table>
    </div>
</body>
</html>