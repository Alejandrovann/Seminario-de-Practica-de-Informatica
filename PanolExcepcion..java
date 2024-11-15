package GestionStock;

public class PanolExcepcion extends Exception {
	private static final long serialVersionUID = 1L;

	public PanolExcepcion (String mensaje) {
        super(mensaje);
    }
}
