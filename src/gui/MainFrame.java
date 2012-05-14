//**********************************************************
// DESARROLLO DE SOFTWARE II
// TALLER: PATRON-DAO
//
// ARCHIVO: MainFrame.java
//
// FECHA:12/03/30
//
// AUTORES:
// Gustavo Adolfo Rodriguez    0932979-3743
// gustalibreros@hotmail.com
//
// José Antonio Nobile Rendón  0747102-2711
// jose.nobile@gmail.com
//
// Roberto Ceballos            0441812-3743
// robertrock2000@gmail.com
//
// ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION
// UNIVERSIDAD DEL VALLE
//*********************************************************
package GUI;

import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends javax.swing.JFrame {



    public MainFrame() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jButtonEstudiantes = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelLogo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuAyuda = new javax.swing.JMenu();
        jMIAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PATRON-DAO");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(5, 116, 160, 10);

        jButtonEstudiantes.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        jButtonEstudiantes.setText("Estudiantes");
        jButtonEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstudiantesActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEstudiantes);
        jButtonEstudiantes.setBounds(5, 130, 160, 35);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(5, 166, 160, 10);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(166, 0, 10, 500);

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/UNIVALLE.jpg"))); // NOI18N
        jPanel1.add(jLabelLogo);
        jLabelLogo.setBounds(50, 10, 72, 100);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 180, 500);

        jMenuArchivo.setText("Archivo");

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItem1);

        jMenuBar1.add(jMenuArchivo);

        jMenuAyuda.setText("Ayuda");

        jMIAcercaDe.setText("Acerca de");
        jMIAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAcercaDeActionPerformed(evt);
            }
        });
        jMenuAyuda.add(jMIAcercaDe);

        jMenuBar1.add(jMenuAyuda);

        setJMenuBar(jMenuBar1);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-810)/2, (screenSize.height-530)/2, 810, 530);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstudiantesActionPerformed

    }//GEN-LAST:event_jButtonEstudiantesActionPerformed

    private void jMIAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAcercaDeActionPerformed
        //<editor-fold defaultstate="collapsed" desc="jMIAcercaDeActionPerformed()">
        String acercaDe = "DESARROLLO DE SOFTWARE II\n"
//                + "TALLER PATRON-DAO\n\n"
//                + "AUTORES:\n\n"
//                + "Gustavo Adolfo Rodriguez    0932979-3743\n"
//                + "gustalibreros@hotmail.com\n\n"
//                + "José Antonio Nobile Rendón  0747102-2711\n"
//                + "jose.nobile@gmail.com\n\n"
//                + "Roberto Ceballos            0441812-3743\n"
//                + "robertrock2000@gmail.com\n\n"
//                + "Abril 2012\n\n"
                + "ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION\n"
                + "UNIVERSIDAD DEL VALLE\n";
        
        JOptionPane.showMessageDialog(this, acercaDe, "Acerda de", JOptionPane.INFORMATION_MESSAGE);
        //</editor-fold>
    }//GEN-LAST:event_jMIAcercaDeActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc="main()">
        try {
            try {
                javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            } catch (InstantiationException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            } catch (UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
        //</editor-fold>
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEstudiantes;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JMenuItem jMIAcercaDe;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
