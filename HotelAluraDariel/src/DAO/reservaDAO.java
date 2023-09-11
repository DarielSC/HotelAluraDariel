package DAO;

import java.beans.Statement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.reserva;

public class reservaDAO {

	private Connection con;
	
	public reservaDAO(Connection con) {
		super();
		this.con = con;
	}
	
	
	public void guardar(reserva reversa1) {
		try {
			String sql = "INSERT INTO reservas (fecha_entrada, fecha_salida, valor, forma_de_pago) VALUES (?,?,?,?)";
			try(PreparedStatement pstm = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)){
				pstm.setObject(1, reversa1.getDataE());
				pstm.setObject(2, reversa1.getDataS());
				pstm.setString(3, reversa1.getValor());
				pstm.setString(4, reversa1.getFormadePago());
				pstm.executeUpdate();
				
				try(ResultSet rst = pstm.getGeneratedKeys()){
					while(rst.next()) {
						reversa1.setId(rst.getInt(1));
					}
				}
				
			}
		} catch (SQLException e) {
			throw new RuntimeException("animal" + e.getMessage(),e);
		}		
	}
	
	public List<reserva> mostrar(){
		List<reserva> reservas = new ArrayList<reserva>();
		try {
			String sql = "SELECT id, fecha_entrada, fecha_salida, valor, forma_de_pago FROM reservas";
			try(PreparedStatement pstm = con.prepareStatement(sql)){
				pstm.execute();
				
				transformarResultado(reservas,pstm);
				
			}
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<reserva> buscarId(String id){
		List<reserva> reservas = new ArrayList<reserva>();
		try {
			String sql = "SELECT id,fecha_entrada, fecha_salida,valor, forma_de_pago FROM reservas WHERE id= ?";
			try(PreparedStatement pstm = con.prepareStatement(sql)){
				pstm.setString(1, id);
				pstm.execute();
				
				transformarResultado(reservas,pstm);
				
			}
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public void Eliminar(Integer id) {
	    try {
	        java.sql.Statement state = con.createStatement();
	        state.execute("SET FOREIGN_KEY_CHECKS=0");
	        PreparedStatement stm = con.prepareStatement("DELETE FROM reservas WHERE id = ?");
	        stm.setInt(1, id);
	        stm.execute();
	        state.execute("SET FOREIGN_KEY_CHECKS=1"); 
	    } catch (SQLException e) {
	        throw new RuntimeException("Error: " + e.getMessage(), e);
	    }
	}

	
	
	
	
	public void Actualizar(LocalDate dataE, LocalDate dataS, String valor, String formadePago, Integer id) {
	    try (PreparedStatement stm = con.prepareStatement("UPDATE reservas SET "
	            + "fecha_entrada=?, fecha_salida=?, valor=?, forma_de_pago=? WHERE id=?")) {
	        stm.setObject(1, java.sql.Date.valueOf(dataE));
	        stm.setObject(2, java.sql.Date.valueOf(dataS));
	        stm.setString(3, valor);
	        stm.setString(4, formadePago);
	        stm.setInt(5, id);
	        stm.executeUpdate();
	        System.out.println("Entro a la base de datos");
	    } catch (SQLException e) {
	        throw new RuntimeException("Error al actualizar reserva: " + e.getMessage(), e);
	    }
	}

	
	
	
	
	
	private void transformarResultado(List<reserva> reservas, PreparedStatement pstm) throws SQLException {
		try(ResultSet rst = pstm.getResultSet()){
			while(rst.next()) {
				int id = rst.getInt("id");
				LocalDate fechaE = rst.getDate("fecha_entrada").toLocalDate().plusDays(1);
				LocalDate fechaS = rst.getDate("fecha_salida").toLocalDate().plusDays(1);
				String valor = rst.getString("valor");
				String formaPago = rst.getString("forma_de_pago");
				reserva producto = new reserva(id,fechaE,fechaS,valor,formaPago);
				reservas.add(producto);
			}
		}
	}
	
	
}
