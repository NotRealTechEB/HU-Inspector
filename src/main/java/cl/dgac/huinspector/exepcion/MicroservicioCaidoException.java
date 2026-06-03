package cl.dgac.huinspector.exepcion;

public class MicroservicioCaidoException extends RuntimeException {
    public MicroservicioCaidoException(String mensaje){
        super(mensaje);
    }

}
