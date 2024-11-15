package OperacionesDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import ConexionDB.BaseDatosOrtiz;
import GestionStock.Panol;
import GestionStock.PanolExcepcion;

public abstract class Insumos extends Panol{
protected int codigo;
protected String descripcion;
protected int nroPanol;
protected String fabricante;
protected int stock;
protected int stock_min;
public String estado;


public Insumos(int codigo2, String descripcion2, int nroPanol2, String fabricante2, int stock2, int stock_min2, String estado2) {
	// TODO Auto-generated constructor stub
}

//Da de alta un nuevo insumo, verificando previamente si existe dentro del nro de pañol indicado en la base
public static void CrearInsumos(int codigo, String descripcion, int nroPanol, String fabricante, int stock, int stock_min, String estado) throws PanolExcepcion {
	try{ 
	Connection enlacedb = BaseDatosOrtiz.getConnection();
    Statement s = enlacedb.createStatement();
	ResultSet rs = s.executeQuery("select * from insumos where codigo="+codigo+" and nro_panol="+nroPanol+";");
	if (!rs.next()) {
			System.out.println("insert into insumos (codigo, descripcion, nro_panol, fabricante, stock, stock_min, estado) values ("+codigo+", '"+descripcion+"', "+nroPanol+", '"+fabricante+"', "+stock+", "+stock_min+", '"+estado+"');");
			System.out.println("El nuevo insumo ha sido agregado");}
				else {
			System.out.println("El insumo no se puede agregar porque ya existe");
			}
	s.close();
	rs.close();
	enlacedb.close();}
	catch(Exception e){System.out.println(e);
	}  
}

//Elimina un insumo, verificando previamente si el insumo existe en el nro de pañol indicado en la base
public static void EliminarInsumos(int codigo, int nroPanol) throws PanolExcepcion {
	try{
	Connection enlacedb = BaseDatosOrtiz.getConnection();
	Statement s = enlacedb.createStatement();
	//Statement ins = enlacedb.createStatement();
	ResultSet rs = s.executeQuery("select * from insumos where codigo="+codigo+" and nro_panol="+nroPanol+";");
	if (!rs.next()) {
		System.out.println("El insumo no se puede borrar porque no existe");}
	 else {
     		ResultSet rm = s.executeQuery("select * from movimientos where codigo="+codigo+";");
     		if (!rm.next()) {
     				s.executeUpdate("delete from insumos where codigo="+codigo+" and nro_panol="+nroPanol+";");
					System.out.println("El insumo ha sido borrado");
								}
					else {
						System.out.println("El insumo que se quiere eliminar, no puede ser borrado porque tiene movimientos");
					}
				}
	s.close();
	rs.close();
	enlacedb.close();}
	catch(Exception e){System.out.println(e);
	}  
}

//Actualiza los atributos del insumo ingresado, siempre que este exista en el pañol indicado en la base
public static void ModificarInsumos(int codigo, String descripcion, int nroPanol, String fabricante, int stock, int stock_min, String estado) throws PanolExcepcion{
	try{ 
	Connection enlacedb = BaseDatosOrtiz.getConnection();
	Statement s = enlacedb.createStatement();
	//Statement ins = enlacedb.createStatement();
	ResultSet rs = s.executeQuery("select * from insumos where codigo="+codigo+" and nro_panol="+nroPanol+";");
	if (rs.next()) {
		s.executeUpdate("update insumos set codigo="+codigo+", descripcion='"+descripcion+"', nro_panol="+nroPanol+", fabricante='"+fabricante+"', stock="+stock+", stock_min="+stock_min+", estado='"+estado+"' where codigo="+codigo+" and nro_panol="+nroPanol+";");
			System.out.println("El insumo ha sido modificado exitsamente");}
				else {
			System.out.println("El insumo no se puede modificar porque no existe");
			}
	s.close();
	rs.close();
	enlacedb.close();}
	catch(Exception e){System.out.println(e);
	}  
 }

}
