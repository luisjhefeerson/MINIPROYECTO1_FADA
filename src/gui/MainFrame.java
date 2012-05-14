//**********************************************************
// FUNDAMENTOS DE ANÁLISIS Y DISEÑO DE ALGORITMOS
// MINIPROYECTO 1: SOLUCIÓN PARA UN JUEGO DE LÓGICA: AKARI
//
// ARCHIVO: MainFrame.java
//
// FECHA:
//
// AUTORES:
//     Marx Arturo Arias - 0840247-3743
//     marxarturoariasescobar@gmail.com
//
//     Luis Jeferson Gallardo - 
//     luisjhefeerson@gmail.com
//
//     Fidel Herney Palacios - 0832691-3743
//     herney400@gmail.com
//
//     James Andrés Payan - 0957150-2711
//     jamespayan@gmail.com
//
//     Gustavo Adolfo Rodriguez - 0932979-3743    
//     gustalibreros@gmail.com
//
// ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION
// UNIVERSIDAD DEL VALLE
//**********************************************************
package gui;

import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends javax.swing.JFrame {



    public MainFrame() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/UNIVALLE.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 0, 90, 120);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 130);

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
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMIAcercaDe;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
