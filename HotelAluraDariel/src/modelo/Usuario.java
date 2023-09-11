package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.conexionbase;

public class Usuario {
	
	private String nombre;
	private String contrasenha;
	
	public Usuario(String nombre, String contrasenha) {
		this.nombre = nombre;
		this.contrasenha = contrasenha;
	}

	public String getnombre() {
		return nombre;
	}

	public void setnombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenha() {
		return contrasenha;
	}

	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}
	
	public static boolean validarUsuario(String nombre, String contrasenha) {
		conexionbase con = new conexionbase();
		Connection connec = null;
		PreparedStatement state = null;
		ResultSet result = null;
		try {
			connec = con.conectarbase();
			state = connec.prepareStatement("SELECT * FROM usuarios WHERE nombre=? AND contraseña=?");
			state.setString(1, nombre);
			state.setString(2, contrasenha);
			result = state.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(result != null);
					result.close();
				if (state != null);
					state.close();
				if (connec != null);
					connec.close();
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
	}
}
