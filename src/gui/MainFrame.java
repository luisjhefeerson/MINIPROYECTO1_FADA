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

import datos.AkariFile;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MainFrame extends javax.swing.JFrame {

    AkariFile archivoEntrada;
    
    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelSubtitulo = new javax.swing.JLabel();
        jLabelSubtitulo1 = new javax.swing.JLabel();
        jLabelTextView = new javax.swing.JLabel();
        jLabelgraphicalview = new javax.swing.JLabel();
        jScrollPaneTextView = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMICargarTablero = new javax.swing.JMenuItem();
        jMISalir = new javax.swing.JMenuItem();
        jMenuAyuda = new javax.swing.JMenu();
        jMIAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MINIPROYECTO 1 - FADA");
        getContentPane().setLayout(null);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/UNIVALLE.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 5, 72, 100);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(0, 110, 800, 5);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(400, 115, 5, 480);

        jLabelTitulo.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("FUNDAMENTOS DE ANÁLISIS Y DISEÑO DE ALGORITMOS");
        jPanel1.add(jLabelTitulo);
        jLabelTitulo.setBounds(92, 10, 708, 30);

        jLabelSubtitulo.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabelSubtitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSubtitulo.setText("MINIPROYECTO 1");
        jPanel1.add(jLabelSubtitulo);
        jLabelSubtitulo.setBounds(92, 40, 708, 30);

        jLabelSubtitulo1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabelSubtitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSubtitulo1.setText("SOLUCIÓN PARA UN JUEGO DE LÓGICA: AKARI");
        jPanel1.add(jLabelSubtitulo1);
        jLabelSubtitulo1.setBounds(92, 70, 708, 30);

        jLabelTextView.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabelTextView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTextView.setText("TEXT VIEW");
        jPanel1.add(jLabelTextView);
        jLabelTextView.setBounds(0, 120, 400, 30);

        jLabelgraphicalview.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabelgraphicalview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelgraphicalview.setText("GRAPHICAL VIEW");
        jPanel1.add(jLabelgraphicalview);
        jLabelgraphicalview.setBounds(400, 120, 400, 30);

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jScrollPaneTextView.setViewportView(jTextArea);

        jPanel1.add(jScrollPaneTextView);
        jScrollPaneTextView.setBounds(10, 160, 380, 400);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 600);

        jMenuArchivo.setText("Archivo");

        jMICargarTablero.setText("Cargar Tablero");
        jMICargarTablero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICargarTableroActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMICargarTablero);

        jMISalir.setText("Salir");
        jMISalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISalirActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMISalir);

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
        setBounds((screenSize.width-810)/2, (screenSize.height-630)/2, 810, 630);
    }// </editor-fold>//GEN-END:initComponents

    private void jMISalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMISalirActionPerformed

    private void jMIAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAcercaDeActionPerformed
        //<editor-fold defaultstate="collapsed" desc="jMIAcercaDeActionPerformed()">
        String acercaDe = "FUNDAMENTOS DE ANÁLISIS Y DISEÑO DE ALGORITMOS\n"
                + "MINIPROYECTO 1: SOLUCIÓN PARA UN JUEGO DE LÓGICA: AKARI\n"
                + "\n"
                + "ARCHIVO: MainFrame.java\n"
                + "\n"
                + "FECHA:\n"
                + "\n"
                + "AUTORES:\n"
                + "    Marx Arturo Arias - 0840247-3743\n"
                + "    marxarturoariasescobar@gmail.com\n"
                + "\n"
                + "    Luis Jeferson Gallardo - \n"
                + "    luisjhefeerson@gmail.com\n"
                + "\n"
                + "    Fidel Herney Palacios - 0832691-3743\n"
                + "    herney400@gmail.com\n"
                + "\n"
                + "    James Andrés Payan - 0957150-2711\n"
                + "    jamespayan@gmail.com\n"
                + "\n"
                + "    Gustavo Adolfo Rodriguez - 0932979-3743\n"
                + "    gustalibreros@gmail.com\n"
                + "\n"
                + "ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION\n"
                + "UNIVERSIDAD DEL VALLE";


        JOptionPane.showMessageDialog(this, acercaDe, "Acerda de", JOptionPane.INFORMATION_MESSAGE);
        //</editor-fold>
    }//GEN-LAST:event_jMIAcercaDeActionPerformed

    private void jMICargarTableroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICargarTableroActionPerformed

        JFileChooser selectorArchivo = new JFileChooser();//escogedor de archivo
        selectorArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int resultado = selectorArchivo.showOpenDialog(this);
      
        
        if (resultado != JFileChooser.CANCEL_OPTION) {
            archivoEntrada = new AkariFile();
            File selectedFile = selectorArchivo.getSelectedFile();
            archivoEntrada.loadFromFile(selectedFile);
            jTextArea.setText(archivoEntrada.getFileContents());
        }

    }//GEN-LAST:event_jMICargarTableroActionPerformed

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelSubtitulo;
    private javax.swing.JLabel jLabelSubtitulo1;
    private javax.swing.JLabel jLabelTextView;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelgraphicalview;
    private javax.swing.JMenuItem jMIAcercaDe;
    private javax.swing.JMenuItem jMICargarTablero;
    private javax.swing.JMenuItem jMISalir;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPaneTextView;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea;
    // End of variables declaration//GEN-END:variables
}