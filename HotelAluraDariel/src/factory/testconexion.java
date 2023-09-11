package factory;

import java.sql.Connection;
import java.sql.SQLException;

public class testconexion {

	public static void main(String[] args) throws SQLException{
		conexionbase con = new conexionbase();
		Connection cone = con.conectarbase();
		
		System.out.println("conectó bien");
		cone.close();
		
		System.out.println("cerró bien");
	}
}
