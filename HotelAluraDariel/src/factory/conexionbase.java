package factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class conexionbase {

	public DataSource dataSou;
	
	public conexionbase() {
		ComboPooledDataSource comboPool = new ComboPooledDataSource();
		comboPool.setJdbcUrl("jdbc:mysql://localhost:3306/hotel_alura_mx?serverTimezone=UTC");
		comboPool.setUser("root");
		comboPool.setPassword("root1234");
		
		this.dataSou = comboPool;
	}
	
	public Connection conectarbase() {
		try {
			return this.dataSou.getConnection();
		} catch (SQLException e) {
			System.out.println("Hubo un error");
			throw new RuntimeException(e);
		}
	}
}
