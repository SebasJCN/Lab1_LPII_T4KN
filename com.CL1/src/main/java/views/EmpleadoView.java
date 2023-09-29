package views;

import controllers.EmpleadoController;

public class EmpleadoView {

	public static void main(String[] args) {
		//String empleado = new EmpleadoController().createEmpleado("Cruz Domínguez","Juan Antonio","32","Masculino",2150.50);
		String empleado = new EmpleadoController().deleteEmpleado(5);
		//String empleado = new EmpleadoController().updateEmpleado(5, "Palacios Sáenz", "Maria Julia", "25", "Femenino", 3000.0);
		//String empleado = new EmpleadoController().getEmpleado(5);
		System.out.println(empleado);
	}

}
