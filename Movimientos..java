package OperacionesDB;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.List;
import ConexionDB.BaseDatosOrtiz;
import GestionStock.PanolExcepcion;



public class Movimientos {
	protected int nromovimiento;
	protected int codigo;
	protected int legajo;
	protected String puestoTrabajo;
	protected int cantidad;
    
    public Movimientos(int legajo2, int codigo2, String puestoTrabajo2, int cantidad2) {
		// TODO Auto-generated constructor stub
	}
    
    //Crea un nuevo movimiento en la tabla movimientos de la base
    public static void CrearMovimiento (int legajo, int codigo, String puestoTrabajo, int cantidad) throws PanolExcepcion {
		try{
		Connection enlacedb = BaseDatosOrtiz.getConnection();
		Statement m = enlacedb.createStatement();
		m.executeUpdate("insert into movimientos (legajo, codigo, puesto_trabajo, cantidad) values ("+legajo+", "+codigo+", '"+puestoTrabajo+"', "+cantidad+");");
		m.close();
		enlacedb.close();
		}
		catch(Exception e){System.out.println(e);
		}
    }
    
    //verifica que el legajo ingresado exista
	public static boolean VerificarLegajo(int legajo2) throws PanolExcepcion {
    		try{
    		Connection enlacedb = BaseDatosOrtiz.getConnection();
    		Statement s = enlacedb.createStatement();
    		ResultSet user = s.executeQuery("select * from usuarios where legajo="+legajo2+";");
    		if (user.next()) {
    			s.close();
    			enlacedb.close();
    			return true; 
}
    		else
    			System.out.println("El legajo no existe dentro del metodo");
    		s.close();	
    		enlacedb.close();
    			return false; 
    		}
    		catch(Exception e){System.out.println(e);
    }
			return false;		
}
	
    //verifica que el codigo de insumo ingresado existe para el pañol ingresado
    public static boolean VerificarCodigo(int codigo2, int nro_panol) {
    	try{
   		Connection enlacedb = BaseDatosOrtiz.getConnection();
		Statement s = enlacedb.createStatement();
		ResultSet insm = s.executeQuery("select * from insumos where codigo="+codigo2+" and nro_panol="+nro_panol+";");
		if (insm.next()) {
			ResultSet stock0 = s.executeQuery("select * from insumos where codigo="+codigo2+" and stock > 0;");
			if (stock0.next()) {
				s.close();
				enlacedb.close(); 
				return true;				}
				else
				{
					System.out.println("El código de insumo existe pero no tiene stock");
				}
				s.close();
				enlacedb.close();
				return false; }
			else {
			System.out.println("El codigo de insumo ingresado no existe en el pañol seleccionado");
			
			return false; 
			}
		}
		catch(Exception e){System.out.println(e);
}
		return false;
    }

    //verifica que el legajo exista para el nro de pañol ingresado
    public static boolean VerificarNropanol(int legajo2, int nro_panol) throws PanolExcepcion {
    	try{
    	Connection enlacedb = BaseDatosOrtiz.getConnection();
		Statement s = enlacedb.createStatement();
		ResultSet user = s.executeQuery("select * from usuarios where legajo="+legajo2+" and nro_panol="+nro_panol+";");
		if (!user.next()) {
			System.out.println("El numero de pañol no está habilitado para ese legajo");
			s.close();
			enlacedb.close(); 
			return false;
}
		else
			s.close();
			enlacedb.close();
			return true; 
    	}
		catch(Exception e){System.out.println(e);
}
    	return false;				
	}
    // Actualiza la cantidad de stock del insumo retirado siempre que la cantidad ingresada sea menor al stock del sistema
    
    public static boolean RetirarInsumos(int codigo, int nromovimiento, int legajo, String puestoTrabajo, int cantidad) throws PanolExcepcion{
	    try{
    	Connection enlacedb = BaseDatosOrtiz.getConnection();
		Statement s = enlacedb.createStatement();
		//Statement i = enlacedb.createStatement();
		ResultSet insum = s.executeQuery("select * from insumos where codigo="+codigo+" and stock >"+cantidad+";");
		if (insum.next()) {
			s.executeUpdate("update insumos set stock = stock - "+cantidad+" where codigo = "+codigo+";");
			System.out.println("La operación fue realizada con éxito");
			s.close();
			enlacedb.close();
			return true;}
			
					else {
			System.out.println("La cantidad ingresada es superior al stock, la operación se puede realizarse");
			s.close();
			enlacedb.close();
			return false;
				}
		}
		catch(Exception e){System.out.println(e);
		}
		return false;
	}
    
    // Actualiza la cantidad de stock del insumo ingresado
	public static boolean IntroducirInsumos(int codigo, int legajo, String puestoTrabajo, int cantidad){
	    try{ 
	    Connection enlacedb = BaseDatosOrtiz.getConnection();
    	Statement i = enlacedb.createStatement();
		ResultSet insum = i.executeQuery("select * from insumos where codigo="+codigo+";");
		//System.out.println("select * from insumos where codigo="+codigo+";");
		if (insum.next()) {
			//System.out.println("update insumos set stock = stock + "+cantidad+" where codigo = "+codigo+";");
			i.executeUpdate("update insumos set stock = stock + "+cantidad+" where codigo = "+codigo+";");
			System.out.println("La operación fue realizada con éxito");
			i.close();
			enlacedb.close();
			return true;}
			
					else {
			System.out.println("La operación no pudo realizarse. Comuníquese con el administrador");
			i.close();
			enlacedb.close();
			return false;
				}
		}
		catch(Exception e){System.out.println(e);
		}
		return false;
	}
	
	//Lista todos los movimientos de la tabla, sin filtros
	public static List<String> listarmovimientos() throws PanolExcepcion {
    	try{
    		Connection enlacedb = BaseDatosOrtiz.getConnection();
       		Statement s = enlacedb.createStatement();
    		ResultSet rs = s.executeQuery("select * from movimientos;");
    		ResultSetMetaData rsMetaData = rs.getMetaData();
    		int count = rsMetaData.getColumnCount();
    		for (int i = 1; i <= count; i++) {
    			System.out.print(rsMetaData.getColumnName(i)
                             + "\t");
        }

        System.out.println(
            "\n----------------------------------------------------------------");
        while (rs.next()) {
            System.out.println(rs.getString(1) +"\t\t"
            					+ rs.getString(2) +"\t"
            					+ rs.getString(3)+ "\t" 
            					+ rs.getString(4)+ "\t\t" 
            					+ rs.getString(5)+ "\t\t" 
            					+ rs.getString(6)+ "\t");
        }
        s.close();
        rs.close();
        enlacedb.close();
		}
		catch(Exception e){System.out.println(e);
}
		return null;
}
	
	public static void ExportarMovimientos () {
		String archivo = "/home/diego/Seminario/movimientos.csv";
	        try {
	        		Connection enlacedb = BaseDatosOrtiz.getConnection();
	           		Statement s = enlacedb.createStatement();
	        		ResultSet rs = s.executeQuery("select * from movimientos;");
	        		FileWriter fileWriter = new FileWriter(archivo);
	                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	                // Escribir nombres de las columnas
	                ResultSetMetaData metaData = rs.getMetaData();
	                int numColumns = metaData.getColumnCount();
	                for (int i = 1; i <= numColumns; i++) {
	                        bufferedWriter.write(metaData.getColumnName(i));
	                        if (i < numColumns) {
	                            bufferedWriter.write(",");
	                        }
	                    }
	                    bufferedWriter.newLine();

	                    // Escribir datos de la consulta
	                while (rs.next()) {
	                    for (int i = 1; i <= numColumns; i++) {
	                    bufferedWriter.write(rs.getString(i));
	                    if (i < numColumns) {
	                                bufferedWriter.write(",");
	                            }
	                        }
	                    bufferedWriter.newLine();
	                    }

	                    bufferedWriter.close();
	                    fileWriter.close();
	                    s.close();
	                    enlacedb.close();

	                    System.out.println("Los movimientos fueron exportados correctamente al archivo movimientos.csv.");
	            
	        	} catch (Exception e) {
	            System.err.println("Error: " + e.getMessage());
	        }
	    }
	

}
