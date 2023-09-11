package controladores;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

import modelo.Usuario;
import views.Login;
import views.MenuUsuario;

public class usuariocontrolador implements ActionListener {

	private Login vista;
	
	public usuariocontrolador(Login vista) {
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nombre = vista.getNombre1();
		String contraseña = vista.getContraseña();
		
		if(Usuario.validarUsuario(nombre, contraseña)) {
			MenuUsuario menu = new MenuUsuario();
			menu.setVisible(true);
			vista.dispose();
		}else {
			JOptionPane.showMessageDialog(vista, "Usuario o contraseña no validos");
		}
	}
	
}
