package views;

import controllers.EmpleadoController;

public class EmpleadoView {

	public static void main(String[] args) {
		//String empleado = new EmpleadoController().createEmpleado("Cruz Domínguez","Juan Antonio","32","Masculino",2150.50);
		//String empleado = new EmpleadoController().deleteEmpleado(2);
		//String empleado = new EmpleadoController().updateEmpleado(3, "Cruz Domingo", "José Anthon", "25", "Masculino", 3000.0);
		String empleado = new EmpleadoController().getEmpleado(3);
		System.out.println(empleado);
	}

}
