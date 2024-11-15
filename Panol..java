package GestionStock;

public abstract class Panol {
    protected int nropanol;
	protected String descripcion;
	protected String estado;
	protected String ubicacion;
    
    public void CrearPanol(int nropanol, String descripcion, String ubicacion, String estado) {
        this.nropanol=nropanol;
        this.descripcion=descripcion;
        this.ubicacion=ubicacion;
        this.estado=estado;
    	}
}
