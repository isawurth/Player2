<%@page import="com.mysql.fabric.Response"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Usuarios</title>
</head>
<body>
<style>

table{
	width: 80%;
	margin-left: 10%;
}
h3{
	height: 35px;
	width: 80%;
	margin-left: 10%;
}

form{
	width: 80%;
	margin-left: 10%;
	text-align: justify;
}
</style>
	<%
	
	String idUsuario 	= request.getParameter("idusuario");
	String nome 		= request.getParameter("nome");
	String usuario 		= request.getParameter("usuario");
	String senha 		= request.getParameter("senha");
	String email 		= request.getParameter("email");	
	
	String acao 		= request.getParameter("acao");
	
	if (( acao != null )&&( idUsuario != null )){
		Usuario usuarios = new Usuario(idUsuario, nome, usuario, senha,email);
		
		if ( Integer.valueOf(acao) == 1){
			usuarios.save();
		} else if ( Integer.valueOf(acao) == 2){
			usuarios.delete();
		}
		
	}
		
		String saida = new Usuario().listAll();
		response.getWriter().write(saida);
	%> 
	
	<form  class="form-horizontal" id='frmUsuarios' action="TesteUsuarios.jsp" method='POST'>
 				<h3>Cadastro de Usuário:</h3>
 				
                <div class='form-group'>
                <input type='hidden' class='form-control' id='idusuario' value='0' placeholder='0' name='idusuario'>
                </div> 
                
                <div class='form-group'>
                <label for='nome'>Nome:</label>
                <input type='text' class='form-control' id='nome' placeholder='Enter nome' name='nome'>
                </div>
                
                <div class='form-group'>
                <label for='usuario'>Usuario:</label>
                <input type='text' class='form-control' id='usuario' placeholder='Enter usuario' name='usuario'>
                </div>
             
                
                <div class='form-group'>
                <label for='senha'>Senha:</label>
                <input type='password' class='form-control' id='senha' placeholder='Enter senha' name='senha'>
                </div>                                
                
                <div class='form-group'>
                <label for='email'>Email:</label>
                <input type='text' class='form-control' id='email' placeholder='Enter email' name='email'>
                </div>
                
                <input type="hidden" name="acao" value="0" >
                <button type="button" id='btnUsuarios' class='btn btn-primary' onclick=" acao.value='1'; this.form.submit(); " > Salvar </button>
               <!-- <button type="button" id='btnUsuarios' class='btn btn-primary' onclick=" acao.value='2'; this.form.submit(); " > Excluir </button>--> </br></br>               
       			<button type="button" value="Alterar" class="btn btn-primary" onClick="location.href='Alterar.jsp'" > Alterar </button>
       			
</form>
</body>
</html>