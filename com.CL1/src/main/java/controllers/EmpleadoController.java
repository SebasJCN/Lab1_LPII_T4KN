package controllers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Empleado;

public class EmpleadoController {
	public String createEmpleado(String apellidos, String nombres, String edad, String sexo, Double salario){
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
	
		Session session = sessionFactory.openSession();
		
		try {
			Empleado empleado = new Empleado(apellidos,nombres,edad,sexo,salario);
			session.beginTransaction();
			session.save(empleado);
			session.getTransaction().commit();
			
			sessionFactory.close();
			
			return "Empleado creado satisfactoriamente";
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "Error al registrar Empleado";
		
	}
	
	public String deleteEmpleado(int Id) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {	
			
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, Id);
			session.delete(empleado);
			session.getTransaction().commit();
			
			sessionFactory.close();
			
			return "Empleado eliminado satisfactoriamente";
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "Error al eliminar Empleado";
	}
	
	public String updateEmpleado(int idempleado, String apellidos, String nombres, String edad, String sexo, double salario) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, idempleado);
			empleado.setApellidos(apellidos);
			empleado.setNombres(nombres);
			empleado.setEdad(edad);
			empleado.setSexo(sexo);
			empleado.setSalario(salario);
			session.update(empleado);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Empleado actualizado satisfactoriamente";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error al actualizar empleado";
	}
	
	public String getEmpleado(int idempleado) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, idempleado);
			
			
			sessionFactory.close();
			
			return empleado.toString();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Usuario no encontrado";
	}
}
