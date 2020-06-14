package es.uva.inf.ds.vinoteca.userinterface;

import es.uva.inf.ds.vinoteca.common.CompletadaException;
import es.uva.inf.ds.vinoteca.common.ReferenciaNoValidaException;
import es.uva.inf.ds.vinoteca.domain.models.Bodega;
import es.uva.inf.ds.vinoteca.domain.models.LineaCompra;
import es.uva.inf.ds.vinoteca.domain.models.Referencia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo
 */
public class VistaAlmacen extends javax.swing.JFrame {

    private final ControladorVistaAlmacen controller;
    private ArrayList<Integer> lcs; 
    private DefaultTableModel model;
    private DefaultTableModel model2;
    /**
     * Creates new form VistaContabilidad
     */
    public VistaAlmacen() {
        initComponents();
        setResizable(false);
        errorMsg.setText("");
        controller = new ControladorVistaAlmacen(this);
        lcs =  new ArrayList<>();
        setLocationRelativeTo(null);
        
    }
    
    public void mostrarMensajeUsuario(ArrayList<Integer> lcnr) {
        model2 = (DefaultTableModel) table2.getModel();
        model2.setRowCount(lcnr.size());
            for(int i = 0; i<lcnr.size(); i++){
            model2.setValueAt(lcnr.get(i), i, 0);
            model2.setValueAt("No Recibida", i, 1);
        }
    }
    
    public void setMensajeError(String message){
        errorMsg.setText(message);
        searchButton.setEnabled(false);
        finalizarButton.setEnabled(false); 
        searchBar.setEnabled(false);
    }
    

    
    public void actualizarVista(String nombreB, ArrayList<Integer> codigosLineaCompra, ArrayList<Integer> unidadesLineaCompra,
            ArrayList<Integer> codigosReferencia) {
        //String [] col = {"selected", "nombreBodega", "idLineaCompra", "idReferencia", "unidades"};
        String [][] data = new String [codigosLineaCompra.size()][4];
        lcs = codigosLineaCompra;
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(codigosLineaCompra.size());
        for(int i = 0; i<codigosLineaCompra.size(); i++){
            int j = 1;
            String unidades = Integer.toString(unidadesLineaCompra.get(i));
            String codigoLinea = Integer.toString(codigosLineaCompra.get(i));
            String codigoRef = Integer.toString(codigosReferencia.get(i));
            model.setValueAt(nombreB, i, j);
            model.setValueAt(false, i, 0);
            j++;
            model.setValueAt(codigoLinea, i, j);
            j++;
            model.setValueAt(codigoRef, i, j);
            j++;
            model.setValueAt(unidades, i, j);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        searchBar = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        errorMsg = new javax.swing.JLabel();
        finalizarButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "selected", "nombreBodega", "idLineaCompra", "idReferencia", "unidades"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        searchBar.setText("Introducir identificador compra");
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });

        searchButton.setText("Buscar");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Salir");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        errorMsg.setText("Mensaje de error");

        finalizarButton.setText("Finalizar");
        finalizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarButtonActionPerformed(evt);
            }
        });

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idLineaCompra", "descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(searchBar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(finalizarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorMsg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitButton)
                    .addComponent(finalizarButton)
                    .addComponent(errorMsg)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        int idCompra = Integer.parseInt(searchBar.getText());
        try {
            controller.procesaDatosIntroducirIdCompra(idCompra);
        } catch (ReferenciaNoValidaException | CompletadaException ex) {
            Logger.getLogger(VistaAlmacen.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_searchButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void finalizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarButtonActionPerformed
        ArrayList <Integer> codigosCompras = new ArrayList<>();
        ArrayList <Integer> codigosComprasNoMarcadas = new ArrayList<>();
        
        for (int r = 0 ; r < lcs.size(); r++){
            boolean bandera = (boolean) model.getValueAt(r, 0);
            String codigoAux;
            int codigo;
            if(bandera){
                codigoAux = (String) model.getValueAt(r, 2);
                codigo = Integer.parseInt(codigoAux);
                codigosCompras.add(codigo);
                
            }else{
                codigoAux = (String) model.getValueAt(r, 2);
                codigo = Integer.parseInt(codigoAux);
                codigosComprasNoMarcadas.add(codigo);
            }
        }   
        try {
            controller.procesaDatosSeleccionaLineas(codigosCompras);
        } catch (SQLException ex) {
            Logger.getLogger(VistaAlmacen.class.getName()).log(Level.SEVERE, null, ex);
        }
        controller.procesaDatosFinalizar();
        finalizarButton.setEnabled(false);
        searchButton.setEnabled(false);
    }//GEN-LAST:event_finalizarButtonActionPerformed

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorMsg;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton finalizarButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton searchButton;
    private javax.swing.JTable table;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables

}
