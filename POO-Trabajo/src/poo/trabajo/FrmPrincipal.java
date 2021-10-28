/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.trabajo;

//import componenteReporte.ReporteAlumnos;
//import images.DesktopConFondo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Timer;

public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    
    private static FrmPrincipal instancia;
    public static FrmPrincipal getInstancia(){
        if(instancia==null){
            instancia = new FrmPrincipal();
        }
        
        return instancia;
    }

    public FrmPrincipal() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmnRegistroempleado = new javax.swing.JMenuItem();
        jmnRegistroCargo = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jmnPermisoempleado = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jmnProgramarHorario = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jmnMarcarAsistencia = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jbtnReporte = new javax.swing.JMenuItem();
        jmnu = new javax.swing.JMenu();
        jmSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Matricula");
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("REGISTRO Y MARCACIÓN DE ASISTENCIA DE LOS EMPLEADOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jLabel7))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.jpg"))); // NOI18N
        jLabel2.setToolTipText("");

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/RGISTRARmnu.png"))); // NOI18N
        jMenu1.setText("Registro");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jmnRegistroempleado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmnRegistroempleado.setText("Registrar empleado");
        jmnRegistroempleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnRegistroempleadoActionPerformed(evt);
            }
        });
        jMenu1.add(jmnRegistroempleado);

        jmnRegistroCargo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmnRegistroCargo.setText("Registrar Cargo");
        jmnRegistroCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnRegistroCargoActionPerformed(evt);
            }
        });
        jMenu1.add(jmnRegistroCargo);

        jMenuBar1.add(jMenu1);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/prmiso.png"))); // NOI18N
        jMenu6.setText("Permisos");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jmnPermisoempleado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmnPermisoempleado.setText("Permiso empleado");
        jmnPermisoempleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnPermisoempleadoActionPerformed(evt);
            }
        });
        jMenu6.add(jmnPermisoempleado);

        jMenuBar1.add(jMenu6);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reloghorario.png"))); // NOI18N
        jMenu4.setText("Programación de Horario  ");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jmnProgramarHorario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmnProgramarHorario.setText("Programar Horario");
        jmnProgramarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnProgramarHorarioActionPerformed(evt);
            }
        });
        jMenu4.add(jmnProgramarHorario);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/marcarasistncia_mnu.png"))); // NOI18N
        jMenu5.setText("Marcar Asistencia");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jmnMarcarAsistencia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmnMarcarAsistencia.setText("Marcar Asistencia");
        jmnMarcarAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnMarcarAsistenciaActionPerformed(evt);
            }
        });
        jMenu5.add(jmnMarcarAsistencia);

        jMenuBar1.add(jMenu5);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pdf.png"))); // NOI18N
        jMenu2.setText("Reporte          ");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jbtnReporte.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbtnReporte.setText("Reporte empleado");
        jbtnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnReporteActionPerformed(evt);
            }
        });
        jMenu2.add(jbtnReporte);

        jMenuBar1.add(jMenu2);

        jmnu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir_mnu.png"))); // NOI18N
        jmnu.setText("Salir");

        jmSalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmSalir.setText("Salir");
        jmnu.add(jmSalir);

        jMenuBar1.add(jmnu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
   
     //   ((DesktopConFondo) dpnEscritorio).setImagen("/images/ucv.jpg");
    }//GEN-LAST:event_formWindowOpened

    private void jbtnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnReporteActionPerformed
        // TODO add your handling code here:
      
        
    }//GEN-LAST:event_jbtnReporteActionPerformed

    private void jmnProgramarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnProgramarHorarioActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jmnProgramarHorarioActionPerformed

    private void jmnRegistroCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnRegistroCargoActionPerformed
       
 
    }//GEN-LAST:event_jmnRegistroCargoActionPerformed

    private void jmnRegistroempleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnRegistroempleadoActionPerformed
       
        
    }//GEN-LAST:event_jmnRegistroempleadoActionPerformed

    private void jmnMarcarAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnMarcarAsistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmnMarcarAsistenciaActionPerformed

    private void jmnPermisoempleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnPermisoempleadoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jmnPermisoempleadoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    public javax.swing.JMenuItem jbtnReporte;
    public javax.swing.JMenuItem jmSalir;
    public javax.swing.JMenuItem jmnMarcarAsistencia;
    public javax.swing.JMenuItem jmnPermisoempleado;
    public javax.swing.JMenuItem jmnProgramarHorario;
    public javax.swing.JMenuItem jmnRegistroCargo;
    public javax.swing.JMenuItem jmnRegistroempleado;
    public javax.swing.JMenu jmnu;
    // End of variables declaration//GEN-END:variables
}