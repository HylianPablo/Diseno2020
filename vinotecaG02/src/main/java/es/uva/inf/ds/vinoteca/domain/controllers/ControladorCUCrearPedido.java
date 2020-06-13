package es.uva.inf.ds.vinoteca.domain.controllers;

import es.uva.inf.ds.vinoteca.common.AbonadoNotExistsException;
import es.uva.inf.ds.vinoteca.common.FacturaVencidaException;
import es.uva.inf.ds.vinoteca.domain.models.Abonado;
import es.uva.inf.ds.vinoteca.domain.models.Pedido;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controlador del caso de uso "Crear pedido de Abonado".
 * @author pamarti
 * @author alerome
 * @author ivagonz
 */
public class ControladorCUCrearPedido {
    
    /**
     * Factoría de controladores del caso de uso.
     * @return Nueva instancia del controlador del caso de uso "Crear pedido de Abonado".
     */
    
    private Abonado b;
    private Pedido newPedido;
    
    public static ControladorCUCrearPedido getController(){
        return new ControladorCUCrearPedido();
    }

    /**
     * Comprueba que el abonado existe en el sistema.
     * @param idAbonado Número entero que representa el identificador del abonado.
     */
    public void comprobarAbonado(int idAbonado) {
        try{
            b = Abonado.getAbonado(idAbonado);
        }catch(AbonadoNotExistsException ex){
            Logger.getLogger(ControladorCURegistrarRecepcionCompra.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    /**
     * Comprueba si el abonado tiene pedidos vencidos antes de crear el nuevo pedido.
     * @return {@code True} en caso de que el abonado no tenga pedidos vencidos y {@code false} en caso contrario.
     * @throws {@code FacturaVencidaException} si el abonado tiene pedidos vencidos. 
     */
    public boolean comprobarPlazosVencidos() throws FacturaVencidaException{ //Necesario idAbonado?? comprobar
        ArrayList<Pedido> pedidos = b.getPedidos();
        boolean bandera = true;
        for(int i=0;i<pedidos.size();i++){
            if(pedidos.get(i).comprobarNoVencido()){
                bandera=false;
                throw new FacturaVencidaException("Existen facturas vencidas.");
            }
        }
        if(bandera){
            newPedido = new Pedido(-1,1,null,"notaEntrega",0.0,null,null,0,0);
        }
        return bandera;
    }
}
