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

import datos.AkariGame;
import datos.GeneradorIngenuo;
import java.awt.Color;
import java.awt.Label;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MainFrame extends javax.swing.JFrame {

    AkariGame akariGame;
    GeneradorIngenuo ingenuo;
    private Label[][] Labels;

    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelSubtitulo = new javax.swing.JLabel();
        jLabelSubtitulo1 = new javax.swing.JLabel();
        jLabelTextView = new javax.swing.JLabel();
        jLabelgraphicalview = new javax.swing.JLabel();
        jScrollPaneTextView = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jScrollPanelGraphView = new javax.swing.JScrollPane();
        jPanelGraphiclView = new javax.swing.JPanel();
        jButtonSiguiente = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMICargarTablero = new javax.swing.JMenuItem();
        jMISalir = new javax.swing.JMenuItem();
        jMenuAyuda = new javax.swing.JMenu();
        jMIAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MINIPROYECTO 1 - FADA");
        getContentPane().setLayout(null);

        jPanelPrincipal.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanelPrincipal.setLayout(null);

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/UNIVALLE.jpg"))); // NOI18N
        jPanelPrincipal.add(jLabelLogo);
        jLabelLogo.setBounds(20, 5, 72, 100);
        jPanelPrincipal.add(jSeparator1);
        jSeparator1.setBounds(0, 110, 800, 5);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanelPrincipal.add(jSeparator2);
        jSeparator2.setBounds(400, 115, 5, 480);

        jLabelTitulo.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("FUNDAMENTOS DE ANÁLISIS Y DISEÑO DE ALGORITMOS");
        jPanelPrincipal.add(jLabelTitulo);
        jLabelTitulo.setBounds(92, 10, 708, 30);

        jLabelSubtitulo.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabelSubtitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSubtitulo.setText("MINIPROYECTO 1");
        jPanelPrincipal.add(jLabelSubtitulo);
        jLabelSubtitulo.setBounds(92, 40, 708, 30);

        jLabelSubtitulo1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabelSubtitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSubtitulo1.setText("SOLUCIÓN PARA UN JUEGO DE LÓGICA: AKARI");
        jPanelPrincipal.add(jLabelSubtitulo1);
        jLabelSubtitulo1.setBounds(92, 70, 708, 30);

        jLabelTextView.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabelTextView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTextView.setText("TEXT VIEW");
        jPanelPrincipal.add(jLabelTextView);
        jLabelTextView.setBounds(0, 120, 400, 30);

        jLabelgraphicalview.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabelgraphicalview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelgraphicalview.setText("GRAPHICAL VIEW");
        jPanelPrincipal.add(jLabelgraphicalview);
        jLabelgraphicalview.setBounds(610, 120, 190, 30);

        jTextArea.setColumns(20);
        jTextArea.setEditable(false);
        jTextArea.setRows(5);
        jScrollPaneTextView.setViewportView(jTextArea);

        jPanelPrincipal.add(jScrollPaneTextView);
        jScrollPaneTextView.setBounds(10, 160, 380, 380);

        jScrollPanelGraphView.setBackground(new java.awt.Color(242, 240, 240));
        jScrollPanelGraphView.setViewportView(jPanelGraphiclView);

        jPanelPrincipal.add(jScrollPanelGraphView);
        jScrollPanelGraphView.setBounds(415, 160, 380, 380);

        jButtonSiguiente.setText("Siguiente");
        jButtonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(jButtonSiguiente);
        jButtonSiguiente.setBounds(530, 120, 100, 30);

        jButtonBorrar.setText("Borrar");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(jButtonBorrar);
        jButtonBorrar.setBounds(420, 120, 100, 30);

        getContentPane().add(jPanelPrincipal);
        jPanelPrincipal.setBounds(0, 0, 800, 600);

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

        jMenuBar.add(jMenuArchivo);

        jMenuAyuda.setText("Ayuda");

        jMIAcercaDe.setText("Acerca de");
        jMIAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAcercaDeActionPerformed(evt);
            }
        });
        jMenuAyuda.add(jMIAcercaDe);

        jMenuBar.add(jMenuAyuda);

        setJMenuBar(jMenuBar);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-810)/2, (screenSize.height-580)/2, 810, 580);
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

        JFileChooser selectorArchivo = new JFileChooser("./tests/");
        
        selectorArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int resultado = selectorArchivo.showOpenDialog(this);
       
        if (resultado != JFileChooser.CANCEL_OPTION) {
            akariGame = new AkariGame();
            File selectedFile = selectorArchivo.getSelectedFile();
            akariGame.loadFromFile(selectedFile);
            jTextArea.setText(akariGame.getFileContents());
            ingenuo = new GeneradorIngenuo(akariGame);
            Graficar();
        }
        
    }//GEN-LAST:event_jMICargarTableroActionPerformed

    private void jButtonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteActionPerformed

        if (ingenuo.solucionIngenua())
            Iluminar();
        else
            JOptionPane.showMessageDialog(rootPane, "NO se pudo hallar soluciòn");
    }//GEN-LAST:event_jButtonSiguienteActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
      
      akariGame.inicializarMatriz();
      jPanelGraphiclView.removeAll();
      Graficar();
//      Iluminar();
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    public void pasarPrueba() {
        AkariGame ak = new AkariGame();
        int a[][] = {{0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 1, 1, 0, 0, 1, 1},};


        int B[][] = {
            {1, 0, 1, 1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1},};
//        ak.validation(a);


    }

    private void Graficar() {
        byte[][] MTablero = akariGame.getTablero();
        byte[][] MBombillos = akariGame.getBombillos();
        byte[][] MIluminacion = akariGame.getIluminacion();
        int[][] MRestricciones = akariGame.getRestricciones();
        Labels = new Label[akariGame.getNumeroFilas()][akariGame.getNumeroColumnas()];

        int x = 0;
        int anchoTablero = akariGame.getNumeroColumnas() * (20 + 1);
        int y = 0;
        int altoTablero = akariGame.getNumeroFilas() * (20 + 1);

        if (anchoTablero < jPanelGraphiclView.getWidth()) {
            x = (jPanelGraphiclView.getWidth() - anchoTablero) / 2;
        }

        if (altoTablero < jPanelGraphiclView.getHeight()) {
            y = (jPanelGraphiclView.getHeight() - altoTablero) / 2;
        }
        //IMPORTANTE: las j y las i estan trocadas por el orden en que pinta java los componentes en el contenedor
        for (int i = 0; i < akariGame.getNumeroFilas(); i++) {//for para las filas
            for (int j = 0; j < akariGame.getNumeroColumnas(); j++) {//for para las columas
                Labels[j][i] = new Label();
                //TABLERO CASILLAS BLANCAS Y NEGRAS
                if (MTablero[j][i] == 0)//cuando el valor es 0 la casilla es blanca vacia
                {
                    Labels[j][i].setBackground(Color.white);
                }
                if (MTablero[j][i] == 1) { //cuando el valor es 1 la casilla es negra
                    Labels[j][i].setBackground(Color.black);
                    Labels[j][i].setForeground(Color.white);
                }
                //TABLERO DE RESTRICCIONES
                if (MRestricciones[j][i] == 0)//la casilla tiene el numero 0
                {
                    Labels[j][i].setText("   0");
                }
                if (MRestricciones[j][i] == 1)//la casilla tiene el numero 1
                {
                    Labels[j][i].setText("   1");
                }
                if (MRestricciones[j][i] == 2)//la casilla tiene el numero 2
                {
                    Labels[j][i].setText("   2");
                }
                if (MRestricciones[j][i] == 3)//la casilla tiene el numero 3                {
                {
                    Labels[j][i].setText("   3");
                }
                if (MRestricciones[j][i] == 4)//la casilla tiene el numero 4                
                {
                    Labels[j][i].setText("   4");
                }

                //TABLERO BOMBILLOS
                if (MBombillos[j][i] == 1) {//cuando el valor es 1 la casilla tiene bombillo
                    Labels[j][i].setBackground(Color.YELLOW);
                    Labels[j][i].setForeground(Color.BLACK);
                    Labels[j][i].setText("  B");
                }
                // if (MBombillos[j][i] == 0) //cuando el valor es 0 la casilla no tiene bombillos
                //   Labels[j][i].setBackground(Color.WHITE);
                //TABLERO ILUMINACION    
                if (MIluminacion[j][i] == 1) //cuando el valor es 1 la casilla se ilumina
                {
                    Labels[j][i].setBackground(Color.YELLOW);
                }
                //if (MIluminacion[j][i] == 0) //cuando el valor es 0 la casilla no se ilumina
                //  Labels[j][i].setBackground(Color.WHITE);
                Labels[j][i].setBounds(x + (21 * i), y + (21 * j), 20, 20);//ubica los labels en forma de cuadricula
                
                jPanelGraphiclView.add(Labels[j][i]);//adiciona los labels al contenedor
                
            }
        }

    }
    
    public void Iluminar(){
        byte[][] MIluminacion = akariGame.getIluminacion();        
         byte[][] MBombillos = akariGame.getBombillos(); 
        for (int i = 0; i < Labels.length; i++) {
            for (int j = 0; j < Labels[i].length; j++) {
                if(MIluminacion[i][j]==1)
                    Labels[i][j].setBackground(Color.yellow);
                if(MBombillos[i][j]==1){
                    Labels[i][j].setText("  B");  
                }
            }
        }
    }
     
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
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonSiguiente;
    private javax.swing.JLabel jLabelLogo;
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
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPanel jPanelGraphiclView;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JScrollPane jScrollPaneTextView;
    private javax.swing.JScrollPane jScrollPanelGraphView;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea;
    // End of variables declaration//GEN-END:variables
}
