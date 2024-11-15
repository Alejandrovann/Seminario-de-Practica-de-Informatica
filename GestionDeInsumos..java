package GestionStock;

import java.util.Scanner;
import OperacionesDB.Insumos;
import OperacionesDB.Movimientos;
import OperacionesDB.usuarios;

//Clase principal que presenta el menú al usuario para interactuar con el sistema
public class GestionDeInsumos {
	public static void main(String[] args) throws PanolExcepcion {
		
		
	        try (Scanner scanner = new Scanner(System.in)) {
				boolean ejecutando = true;
				while (ejecutando) {
				    System.out.println("_______________________________");
				    System.out.println("MENU PRINCIPAL - Pañol Ortiz");
				    System.out.println("___________________________");
				    System.out.println("1. Gestión de Usuarios");
				    System.out.println("2. Gestión de Insumos");
				    System.out.println("3. Retirar Insumo");
				    System.out.println("4. Ingresar Insumos");
				    System.out.println("5. Listar Movimientos");
				    System.out.println("6. Exportar Movimientos");
				    System.out.println("7. Consultar Stock de Insumo");
				    System.out.println("8. Déjenos su comentario");
				    System.out.println("9. Lisar Comentarios");
				    System.out.println("0. Salir");
				    System.out.println("_______________________________");
				    System.out.print("Elige una opción: ");
				    

				    int opcion = scanner.nextInt();
				    switch (opcion) {
				    case 1 -> {
				    	
				    	
				    	boolean ejecutando1 = true;
						while (ejecutando1) {
				            System.out.println("_______________________________");
				            System.out.println("MENU Gestion Usuarios");
				            System.out.println("___________________________");
				            System.out.println("1. Agregar Usuario");
				            System.out.println("2. Eliminar Usuario");
				            System.out.println("3. Modificar Usuario");
				            System.out.println("4. Volver");
				            System.out.println("_______________________________");
				            System.out.print("Elige una opción: ");
				    	    int opcion1 = scanner.nextInt();
				            switch (opcion1) {
				            case 1 -> {
				            	System.out.print("legajo: ");
				            	int legajo = scanner.nextInt();
				            	scanner.nextLine();
				            	System.out.print("Número de Pañol: ");
				            	int nroPanol = scanner.nextInt();
				            	scanner.nextLine();
				            	System.out.print("Tipo de Usuario: ");
				            	String tipoUsuario = scanner.nextLine();
				            	System.out.print("Nombre: ");
				            	String nombre = scanner.nextLine();
				            	System.out.print("Apellido: ");
				            	String apellido = scanner.nextLine();
				            	usuarios.AgregarUsuarios(legajo,nroPanol,tipoUsuario,nombre,apellido);}
				            case 2 -> {
				            	System.out.print("legajo: ");
				            	int legajo = scanner.nextInt();
				            	scanner.nextLine();
				            	System.out.print("Número de Pañol: ");
				            	int nroPanol = scanner.nextInt();
				            	scanner.nextLine();
				            	usuarios.EliminarUsuarios(legajo,nroPanol);}
				            case 3 -> {
				            	System.out.print("legajo: ");
				            	int legajo = scanner.nextInt();
				            	scanner.nextLine();
				            	System.out.print("Número de Pañol: ");
				            	int nroPanol = scanner.nextInt();
				            	scanner.nextLine();
				            	System.out.print("Tipo de Usuario: ");
				            	String tipoUsuario = scanner.nextLine();
				            	//scanner.nextLine();
				            	System.out.print("Nombre: ");
				            	String nombre = scanner.nextLine();
				            	System.out.print("Apellido: ");
				            	String apellido = scanner.nextLine();
				            	usuarios.ModificarUsuarios(legajo,nroPanol,tipoUsuario,nombre,apellido);}
				            	case 4 -> {
				                System.out.println("Programa Finalizado");
				                ejecutando1 = false;}
				            }
						}
				    }
				        
				   case 2 -> {
					    boolean ejecutando2 = true;
					    while (ejecutando2) {
				        System.out.println("_______________________________");
				        System.out.println("MENU Gestion Insumos");
				        System.out.println("___________________________");
				        System.out.println("1. Crear Insumo");
				        System.out.println("2. Eliminar Insumo");
				        System.out.println("3. Modificar Insumo");
				        System.out.println("4. Volver");
				        System.out.println("_______________________________");
				        System.out.print("Elige una opción: ");
				   	    int opcion2 = scanner.nextInt();
				        switch (opcion2) {
				           case 1 -> {
				           	System.out.print("Código: ");
				           	int codigo = scanner.nextInt();
				           	scanner.nextLine();
				           	System.out.print("Descripción ");
				           	String descripcion = scanner.nextLine();
				           	System.out.print("Número de Pañol: ");
				           	int nroPanol = scanner.nextInt();
				           	scanner.nextLine();
				           	System.out.print("Fabricante: ");
				           	String fabricante = scanner.nextLine();
				           	//scanner.nextLine();
				           	System.out.print("Stock: ");
				           	int stock = scanner.nextInt();
				           	scanner.nextLine();
				           	System.out.print("Stock Mínimo: ");
				           	int stock_min = scanner.nextInt();
				           	scanner.nextLine();
				           	System.out.print("Estado: ");
				           	String estado = scanner.nextLine();
				           	Insumos.CrearInsumos(codigo,descripcion,nroPanol,fabricante,stock,stock_min,estado);}
				           case 2 -> {
				           	System.out.print("Código: ");
				           	int codigo = scanner.nextInt();
				           	scanner.nextLine();
				           	System.out.print("Número de Pañol: ");
				           	int nroPanol = scanner.nextInt();
				           	scanner.nextLine();
				           	Insumos.EliminarInsumos(codigo,nroPanol);}
				           case 3 -> {
				           	System.out.print("Codigo: ");
				           	int codigo = scanner.nextInt();
				           	scanner.nextLine();
				           	System.out.print("Descripción: ");
				           	String descripcion = scanner.nextLine();
				           	System.out.print("Número de Pañol: ");
				           	int nroPanol = scanner.nextInt();
				           	scanner.nextLine();
				           	System.out.print("fabricante: ");
				           	String fabricante = scanner.nextLine();
				           	//scanner.nextLine();
				           	System.out.print("Stock: ");
				           	int stock = scanner.nextInt();
				           	scanner.nextLine();
				           	System.out.print("Stock Mínimo: ");
				           	int stock_min = scanner.nextInt();
				           	scanner.nextLine();
				           	System.out.print("Estado: ");
				           	String estado = scanner.nextLine();
				           	Insumos.ModificarInsumos(codigo,descripcion,nroPanol,fabricante,stock,stock_min,estado);}
				           	case 4 -> {
				               System.out.println("Programa Finalizado");
				               ejecutando2 = false;}
      
				   }
				}
      }
				   case 3 -> {
				   	
				   	
				    boolean ejecutando3 = true;
					while (ejecutando3) {
						System.out.print("Ingrese su legajo: ");
				       	int legajo = scanner.nextInt();
				       	Movimientos.VerificarLegajo(legajo);
				       	if (Movimientos.VerificarLegajo(legajo)) {
				       		System.out.print("Ingrese el número de Pañol: ");
				           	int nro_panol = scanner.nextInt();
				           	Movimientos.VerificarNropanol(legajo, nro_panol);
				           	if (Movimientos.VerificarNropanol(legajo, nro_panol)) {
				           		System.out.print("Ingrese el codigo de insumo: ");
				           		int codigo = scanner.nextInt();
				           		if (Movimientos.VerificarCodigo(codigo, nro_panol)) {
				           			System.out.print("Ingrese la cantidad a retirar: ");
				               		int cantidad = scanner.nextInt();
				               		scanner.nextLine();
				               		System.out.print("Ingrese el puesto de trabajo de destino: ");
				                   	String puestoTrabajo = scanner.nextLine();
				                   	if (Movimientos.RetirarInsumos(codigo, codigo, legajo, puestoTrabajo, cantidad)) {
				                   	Movimientos.CrearMovimiento(legajo,codigo,puestoTrabajo,cantidad);
				                   	ejecutando3 = false;
				                   	}
				                   	else
				                   	{

				                        ejecutando3 = false;
				           		    }
				           		 }
				           		 else 
				           		 {
				           		 ejecutando3 = false;
				           		 }
				       	  }
				           	else {
				            ejecutando3 = false;
				           	} }
				       	else {
				           	ejecutando3 = false;
				       	}
				   }
				   
				              
        
   }
				   case 4 -> {
				      	
				      	
				       boolean ejecutando4 = true;
						while (ejecutando4) {
							System.out.print("Ingrese su legajo: ");
				          	int legajo = scanner.nextInt();
				          	Movimientos.VerificarLegajo(legajo);
				          	if (Movimientos.VerificarLegajo(legajo)) {
				          		System.out.print("Ingrese el número de Pañol: ");
				              	int nro_panol = scanner.nextInt();
				              	Movimientos.VerificarNropanol(legajo, nro_panol);
				              	if (Movimientos.VerificarNropanol(legajo, nro_panol)) {
				              		System.out.print("Ingrese el codigo de insumo: ");
				              		int codigo = scanner.nextInt();
				              		if (Movimientos.VerificarCodigo(codigo, nro_panol)) {
				              			System.out.print("Ingrese la cantidad que ingresará a pañol: ");
				                  		int cantidad = scanner.nextInt();
				                  		String puestoTrabajo = null;
				                      	if (Movimientos.IntroducirInsumos(codigo, legajo, puestoTrabajo, cantidad)) {
				                        Movimientos.CrearMovimiento(legajo,codigo,puestoTrabajo,cantidad);
				                      	ejecutando4 = false;
				                      	//ejecutando = false;
				                      	}
				                      	else
				                      	{
				                      		System.out.println("Cancelado");
				                      		System.out.println("Programa Finalizado");
				                           ejecutando4 = false;
				              		    }
				              		 }
				              		 else 
				              		 {
				              		 System.out.println("El codigo no existe para este pañol");
				              		 ejecutando4 = false;
				              		 }
				          	  }
				              	else {
				          		System.out.println("El legajo no existe para este pañol fuera del metodo");
				          		System.out.println("Programa Finalizado");
				               ejecutando4 = false;
				              	} }
				              	else {
				              	System.out.println("El legajo no existe fuera del metodo");
				              ejecutando4 = false;
				          	}
				      }
				      
				                 
				 
  	   }
				   case 5 -> {
				     	
				     	
				       boolean ejecutando5 = true;
						while (ejecutando5) {
				          	Movimientos.listarmovimientos();
				          	ejecutando5 = false;
							}
				      
				                 
				 
				   		}
				   case 6 -> {
					   {
					     		
					       boolean ejecutando6 = true;
							while (ejecutando6) {
					          	Movimientos.ExportarMovimientos();
					          	ejecutando6 = false;
								}
					      
					                 
					 
					   		}
				   }
				   case 8 -> {
					   {
					     		
					       boolean ejecutando8 = true;
							while (ejecutando8) {
					          	Comentarios.IngresarComentarios(args);
					          	ejecutando8 = false;
								}
					      
					                 
					 
					   		}
				   
				   }
				   case 9 -> {
					   {
					     		
					       boolean ejecutando9 = true;
							while (ejecutando9) {
					          	Comentarios.ListarComentarios();
					          	ejecutando9 = false;
								}
					      
					                 
					 
					   		}
				   }
				    }
				}
			}   
		}
}
