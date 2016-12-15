/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo: Castro-Santos-Sinchi.
 */
public class logim extends javax.swing.JFrame {

    
    PreparedStatement pstm = null;
    conexion con=new conexion();
    Connection conex=con.conexion();
    ResultSet rs = null;
    /**
     * Creates new form logim
     */
    public logim() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        btaceptar = new javax.swing.JButton();
        btsalir = new javax.swing.JButton();
        txtcontraseña = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/logim1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 62, 124, 110));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("USUARIO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 80, 23));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 255));
        jLabel3.setText("CONTRASEÑA:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 130, 110, 23));

        txtuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuserActionPerformed(evt);
            }
        });
        txtuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtuserKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtuserKeyTyped(evt);
            }
        });
        getContentPane().add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 150, -1));

        btaceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/entrar1.jpg"))); // NOI18N
        btaceptar.setText("ENTRAR");
        btaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btaceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        btsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/salir1.jpg"))); // NOI18N
        btsalir.setText("SALIR");
        btsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsalirActionPerformed(evt);
            }
        });
        getContentPane().add(btsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        txtcontraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontraseñaActionPerformed(evt);
            }
        });
        txtcontraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcontraseñaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcontraseñaKeyTyped(evt);
            }
        });
        getContentPane().add(txtcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 150, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("INGRESO A SISTEMA CLINICO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/fondo login (2).jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -70, 480, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaceptarActionPerformed
        
        String usuario = "";
        String sql = "SELECT * FROM usuario where login=? and clave=?";
        try{
            pstm = conex.prepareStatement(sql);
            pstm.setString(1, txtuser.getText());
            pstm.setString(2, txtcontraseña.getText());
            rs = pstm.executeQuery();
            
            if (rs.next()){
                //tip_usu= rs.getString(1);
                JOptionPane.showMessageDialog(null,"Bienvenido(a) " + txtuser.getText(),"Login \n", JOptionPane.INFORMATION_MESSAGE);
                menu menu1 = new menu();
                menu1.setVisible(true);
                menu1.loginmenu.setText(txtuser.getText());
                this.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null,"Login o Password incorrecto ", "ERROR\n",JOptionPane.ERROR_MESSAGE);
                txtuser.setText(null);
                txtcontraseña.setText(null);
                txtuser.requestDefaultFocus();
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null,"ERROR DE CONEXION ", "Error \n" + ex, JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        }
        
    }//GEN-LAST:event_btaceptarActionPerformed

    private void btsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsalirActionPerformed
        // TODO add your handling code here:
        
        System.exit(0);
    }//GEN-LAST:event_btsalirActionPerformed

    private void txtcontraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontraseñaKeyTyped
               
        //Se asegura de capturar la tecla ENTER y desactivar todas las demas teclas
        char cTeclapresionada=evt.getKeyChar();
        
        //da click al boton de Aceptar al detectar que se presiono la tecla ENTER.
        if(cTeclapresionada==KeyEvent.VK_ENTER){
            //Ejecuta el boton de aceptar (dar click)
            btaceptar.doClick();
        }
        char escTeclapresionada=evt.getKeyChar();
        
        //da click al boton de Aceptar al detectar que se presiono la tecla ENTER.
        if(escTeclapresionada==KeyEvent.VK_ESCAPE){
            //Ejecuta el boton de aceptar (dar click)
            btsalir.doClick();
        }
    }//GEN-LAST:event_txtcontraseñaKeyTyped

    private void txtuserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuserKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((c<'a' || c>'z') && (c<'A')| c>'Z') evt.consume();
        //Se asegura de capturar la tecla ENTER y desactivar todas las demas teclas
        char cTeclapresionada=evt.getKeyChar();
        
        //da click al boton de Aceptar al detectar que se presiono la tecla ENTER.
        if(cTeclapresionada==KeyEvent.VK_ENTER){
            //Ejecuta el boton de aceptar (dar click)
            btaceptar.doClick();
        }
        char escTeclapresionada=evt.getKeyChar();
        
        //da click al boton de Aceptar al detectar que se presiono la tecla ENTER.
        if(escTeclapresionada==KeyEvent.VK_ESCAPE){
            //Ejecuta el boton de aceptar (dar click)
            btsalir.doClick();
        }
    }//GEN-LAST:event_txtuserKeyTyped

    private void txtcontraseñaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontraseñaKeyReleased
        // TODO add your handling code here:
        if (KeyEvent.VK_CAPS_LOCK == evt.getKeyCode()){
            JOptionPane.showMessageDialog(null,"La tecla Mayuscula esta activada");
        }
    }//GEN-LAST:event_txtcontraseñaKeyReleased

    private void txtuserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuserKeyReleased
        // TODO add your handling code here:
        if (KeyEvent.VK_CAPS_LOCK == evt.getKeyCode()){
            JOptionPane.showMessageDialog(null,"La tecla Mayuscula esta activada");
        }
    }//GEN-LAST:event_txtuserKeyReleased

    private void txtuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuserActionPerformed

    private void txtcontraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontraseñaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(logim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(logim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(logim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(logim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new logim().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btaceptar;
    private javax.swing.JButton btsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JPasswordField txtcontraseña;
    public static javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}