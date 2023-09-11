package controladores;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import DAO.reservaDAO;
import factory.conexionbase;
import modelo.reserva;

public class reservacontrolador {
	
	private reservaDAO reservaD;
	
	public reservacontrolador() {
		Connection con = new conexionbase().conectarbase();
		this.reservaD = new reservaDAO(con);
	}
	
	public void guardar(reserva reserva2) {
		this.reservaD.guardar(reserva2);
	}
	
	public List<reserva> mostrar(){
		return this.reservaD.mostrar();
	}

	public List<reserva> buscar(String id){
		return this.reservaD.buscarId(id);
	}
	
	public void actulizarReserva(LocalDate dataE, LocalDate dataS,String valor, String formadePago, Integer id) {
		this.reservaD.Actualizar(dataE, dataS, valor, formadePago, id);
	}
	
	public void Eliminar(Integer id) {
		this.reservaD.Eliminar(id);
	}
	
}
