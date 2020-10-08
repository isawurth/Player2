package model;

import java.sql.ResultSet;

import java.sql.SQLException;

import database.DBQuery;

public class Usuario {
	
	private int    idusuario;
	private String nome;
	private	String usuario;
	private	String senha;
	private String email;
	
	private String	tableName = "player2.usuarios";
	private String	fieldsName =  "idusuario, nome, usuario, senha, email";
	private String	keyField = "idusuario";

	//private String	where = "";
	private DBQuery	dbQuery = null;
	
	public Usuario() {
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);	
	}
	
	public Usuario(int idusuario, String nome, String usuario, String senha, String email){
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
	
		this.setIdusuario( idusuario);
		this.setNome( nome);
		this.setUsuario( usuario);
		this.setSenha( senha);
		this.setEmail( email);
	}
	
	public Usuario(String idusuario, String nome, String usuario, String senha, String email){
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
	
		this.setIdusuario(((idusuario==null)?0:Integer.valueOf(idusuario)));
		this.setNome( nome);
		this.setUsuario( usuario);
		this.setSenha( senha);
		this.setEmail( email);
	}
	
	public String[] toArray(){
		return (
			new String[] { 
				""+this.getIdusuario(),
				""+this.getNome(),
				""+this.getUsuario(),
				""+this.getSenha(),
				""+this.getEmail()
			}
		);
	 }
	
	public void save() {
		  if ((this.getIdusuario() == 0 )){
		       this.dbQuery.insert(this.toArray());
        }else{
		      this.dbQuery.update(this.toArray());
        }
      }
	
      public void delete() {
          if (this.getIdusuario() > 0 ){
              this.dbQuery.delete( this.toArray() );
          }
      }
	
      public String listAll() {
	      ResultSet rs =  this.dbQuery.select("");
          String saida = "<br>";
	       saida += "<table border=1>";
		
		   try {
		      while (rs.next()) {
			     saida += "<tr>";
				 saida += "<td>" + rs.getString("idusuario" ) +  "</td>";
				 saida += "<td>" + rs.getString("nome" ) +  "</td>";
				 saida += "<td>" + rs.getString("usuario" ) +  "</td>";
				 saida += "<td>" + rs.getString("senha" ) +  "</td>";
				 saida += "<td>" + rs.getString("email" ) +  "</td>";
			     saida += "</tr> <br>";
		      }
		   } catch (SQLException e) {
			 e.printStackTrace();
		   }
		   saida += "</table>";
		   return (saida);
	   }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
