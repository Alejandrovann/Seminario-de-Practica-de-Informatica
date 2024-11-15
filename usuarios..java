package OperacionesDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import ConexionDB.BaseDatosOrtiz;
import GestionStock.PanolExcepcion;


public class usuarios{
	protected int legajo;
    protected String nombre;
    protected int nroPanol;
    protected String tipoUsuario;
    protected String apellido;

public usuarios(int legajo, int nroPanol, String tipoUsuario, String nombre, String apellido) {
	this.legajo = legajo;
    this.nroPanol=nroPanol;
    this.tipoUsuario=tipoUsuario;
    this.nombre=nombre;
    this.apellido=apellido;
	}

// Agrega un usuario siempre que el mismo no existe en la tabla
public static void AgregarUsuarios(int legajo, int nroPanol, String tipoUsuario, String nombre, String apellido) throws PanolExcepcion {
        Date dt = new Date(System.currentTimeMillis());
		try{
		Connection enlacedb = BaseDatosOrtiz.getConnection();
		System.out.println("Connected"); 
		Statement s = enlacedb.createStatement();
//		Statement i = enlacedb.createStatement();
		ResultSet rs = s.executeQuery("select * from usuarios where legajo="+legajo);
		if (!rs.next()) {
				s.executeUpdate("insert into usuarios (legajo, tipo_usuario, nro_panol, nombre, apellido, fecha_alta) values ("+legajo+", '"+tipoUsuario+"', "+nroPanol+", '"+nombre+"', '"+apellido+"', '"+dt+"');");
				System.out.println("El usuario ha sido agregado");}
					else {
				System.out.println("El usuario no se puede agregar porque ya existe");
				}
		s.close();
		enlacedb.close();}
		catch(Exception e){System.out.println(e);
		}  
	}

// Elimina un usuario siempre que el mismo exista en la tabla y nro pde pañol seleccionado
	public static void EliminarUsuarios(int legajo, int nroPanol) throws PanolExcepcion {
	try{
	Connection enlacedb = BaseDatosOrtiz.getConnection();
	Statement s = enlacedb.createStatement();
	//Statement i = enlacedb.createStatement();
	ResultSet rs = s.executeQuery("select * from usuarios where legajo="+legajo+" and nro_panol="+nroPanol+";");
	if (rs.next()) {
			s.executeUpdate("delete from usuarios where legajo="+legajo+" and nro_panol="+nroPanol+";");
			System.out.println("El usuario ha sido eliminado");}
				else {
			System.out.println("El usuario no se puede eliminar porque no existe");
			}
	s.close();
	enlacedb.close();}
	catch(Exception e){System.out.println(e);
	}  
}

	//Actualiza los datos del usuario, siempre que el mismo exista para el nro de pañol ingresado en la base
	public static void ModificarUsuarios(int legajo, int nroPanol, String tipoUsuario, String nombre, String apellido) throws PanolExcepcion{
    	try {
		Connection enlacedb = BaseDatosOrtiz.getConnection();
		Statement s = enlacedb.createStatement();
		//Statement i = enlacedb.createStatement();
		ResultSet rs = s.executeQuery("select * from usuarios where legajo="+legajo+" and nro_panol="+nroPanol+";");
		if (rs.next()) {
				s.executeUpdate("update usuarios set legajo="+legajo+", tipo_usuario='"+tipoUsuario+"', nro_panol="+nroPanol+", nombre='"+nombre+"', apellido='"+apellido+"' where legajo="+legajo+" and nro_panol="+nroPanol+";");	
				System.out.println("El usuario ha sido modificado");}
					else {
				System.out.println("El usuario no se puede modificar porque no existe");
				}
		s.close();
		enlacedb.close();}
		catch(Exception e){System.out.println(e);
		}  
	}
}
