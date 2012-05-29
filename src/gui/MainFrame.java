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
import datos.GeneradorNoTanIngenuo;
import java.awt.Color;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class MainFrame extends javax.swing.JFrame {

    AkariGame akariGame;
    GeneradorIngenuo generadorIngenuo;
    GeneradorNoTanIngenuo generadorNoTanIngenuo;
    private JLabel[][] jLabelTablero;
    int widthLabel;
    int heightLabel;
    int xInicial;
    int anchoTablero;
    int yInicial;
    int altoTablero;
    boolean tableroCargado;

    public MainFrame() {
        tableroCargado = false;
        widthLabel = 30;
        heightLabel = 30;
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
        jSlider1 = new javax.swing.JSlider();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMICargarTablero = new javax.swing.JMenuItem();
        jMISalir = new javax.swing.JMenuItem();
        jMenuAyuda = new javax.swing.JMenu();
        jMIAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MINIPROYECTO 1 - FADA");
        setResizable(false);
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
        jSeparator2.setBounds(320, 115, 5, 480);

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
        jLabelTextView.setBounds(0, 120, 320, 30);

        jLabelgraphicalview.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabelgraphicalview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelgraphicalview.setText("GRAPHICAL VIEW");
        jPanelPrincipal.add(jLabelgraphicalview);
        jLabelgraphicalview.setBounds(320, 120, 480, 30);

        jTextArea.setColumns(20);
        jTextArea.setEditable(false);
        jTextArea.setRows(5);
        jScrollPaneTextView.setViewportView(jTextArea);

        jPanelPrincipal.add(jScrollPaneTextView);
        jScrollPaneTextView.setBounds(10, 160, 300, 380);

        jScrollPanelGraphView.setBackground(new java.awt.Color(242, 240, 240));

        jPanelGraphiclView.setLayout(null);
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
        jButtonSiguiente.setBounds(330, 210, 80, 30);

        jButtonBorrar.setText("Borrar");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(jButtonBorrar);
        jButtonBorrar.setBounds(330, 170, 80, 30);

        jSlider1.setMaximum(50);
        jSlider1.setMinimum(10);
        jSlider1.setOrientation(javax.swing.JSlider.VERTICAL);
        jSlider1.setValue(30);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jPanelPrincipal.add(jSlider1);
        jSlider1.setBounds(340, 250, 50, 260);

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


            File selectedFile = selectorArchivo.getSelectedFile();
            akariGame = new AkariGame();

            if (akariGame.loadFromFile(selectedFile)) {
                limpiarTodo();
                jTextArea.setText(akariGame.getTextoEnArchivo());
                generadorNoTanIngenuo = new GeneradorNoTanIngenuo(akariGame);
//                generadorIngenuo = new GeneradorIngenuo(akariGame);
                Graficar();
            } else {
                JOptionPane.showMessageDialog(this, "El archivo no pudo ser procesado", "Formato no Valido", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jMICargarTableroActionPerformed

    private void jButtonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteActionPerformed

        if (generadorNoTanIngenuo.solucionNoTanIngenua()) {
            Iluminar();
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se pudo hallar solución", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSiguienteActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed

        akariGame.inicializarMatriz();
        jPanelGraphiclView.removeAll();
        jPanelGraphiclView.repaint();
        Graficar();

    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged

        if (tableroCargado) {
            widthLabel = jSlider1.getValue();
            heightLabel = jSlider1.getValue();

            anchoTablero = akariGame.getNumeroColumnas() * (widthLabel + 1);
            altoTablero = akariGame.getNumeroFilas() * (heightLabel + 1);

            if (anchoTablero < jPanelGraphiclView.getWidth()) {
                xInicial = (jPanelGraphiclView.getWidth() - anchoTablero) / 2;
            }

            if (altoTablero < jPanelGraphiclView.getHeight()) {
                yInicial = (jPanelGraphiclView.getHeight() - altoTablero) / 2;
            }

            for (int i = 0; i < akariGame.getNumeroFilas(); i++) {
                for (int j = 0; j < akariGame.getNumeroColumnas(); j++) {
                    jLabelTablero[i][j].setBounds(
                            xInicial + ((widthLabel + 1) * j),
                            yInicial + ((heightLabel + 1) * i),
                            widthLabel,
                            heightLabel);
                }
            }
        }

    }//GEN-LAST:event_jSlider1StateChanged

    private void jLabelTableroMouseClicked(java.awt.event.MouseEvent evt) {
        String name = ((JLabel) evt.getSource()).getName();
        int i = Integer.parseInt(name.split(",")[0]);
        int j = Integer.parseInt(name.split(",")[1]);

        if (akariGame.ponerBombillo(i, j)) {
            Iluminar();
        } else if (akariGame.quitarBombillo(i, j)) {
            Iluminar();
        }
        if (akariGame.validation()) {
            JOptionPane.showMessageDialog(this, "FELICITACIONES GANASTE!!", "Juego Terminado", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void Graficar() {

        byte[][] tableroCasillasNegras = akariGame.getTableroCasillasNegras();
        byte[][] tableroBombillos = akariGame.getTableroBombillos();
        byte[][] tableroIluminacion = akariGame.getTableroIluminacion();
        int[][] tableroRestricciones = akariGame.getTalberoRestricciones();

        jLabelTablero = new JLabel[akariGame.getNumeroFilas()][akariGame.getNumeroColumnas()];

        // Ajuste de dimensiones para centrar tablero

        xInicial = 0;
        yInicial = 0;

        anchoTablero = akariGame.getNumeroColumnas() * (widthLabel + 1);
        altoTablero = akariGame.getNumeroFilas() * (heightLabel + 1);

        if (anchoTablero < jPanelGraphiclView.getWidth()) {
            xInicial = (jPanelGraphiclView.getWidth() - anchoTablero) / 2;
        }

        if (altoTablero < jPanelGraphiclView.getHeight()) {
            yInicial = (jPanelGraphiclView.getHeight() - altoTablero) / 2;
        }

        //IMPORTANTE: El error que habia aqui antes se arreglo
        Border border = LineBorder.createGrayLineBorder();

        for (int i = 0; i < akariGame.getNumeroFilas(); i++) {
            for (int j = 0; j < akariGame.getNumeroColumnas(); j++) {

                jLabelTablero[i][j] = new JLabel();
                jLabelTablero[i][j].setOpaque(true);
                jLabelTablero[i][j].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabelTablero[i][j].setBorder(border);
                jLabelTablero[i][j].setName(i + "," + j);
                jLabelTablero[i][j].addMouseListener(new java.awt.event.MouseAdapter() {

                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jLabelTableroMouseClicked(evt);
                    }
                });

                //TABLERO CASILLAS BLANCAS Y NEGRAS
                if (tableroCasillasNegras[i][j] == 0) //cuando el valor es 0 la casilla es blanca
                {
                    jLabelTablero[i][j].setBackground(Color.white);
                }
                if (tableroCasillasNegras[i][j] == 1) { //cuando el valor es 1 la casilla es negra
                    jLabelTablero[i][j].setBackground(Color.black);
                    jLabelTablero[i][j].setForeground(Color.white);
                }

                //TABLERO DE RESTRICCIONES
                if (tableroRestricciones[i][j] == 0)//la casilla tiene el numero 0
                {
                    jLabelTablero[i][j].setText("0");
                }
                if (tableroRestricciones[i][j] == 1)//la casilla tiene el numero 1
                {
                    jLabelTablero[i][j].setText("1");
                }
                if (tableroRestricciones[i][j] == 2)//la casilla tiene el numero 2
                {
                    jLabelTablero[i][j].setText("2");
                }
                if (tableroRestricciones[i][j] == 3)//la casilla tiene el numero 3                {
                {
                    jLabelTablero[i][j].setText("3");
                }
                if (tableroRestricciones[i][j] == 4)//la casilla tiene el numero 4                
                {
                    jLabelTablero[i][j].setText("4");
                }

                //TABLERO BOMBILLOS
                if (tableroBombillos[i][j] == 1) {//cuando el valor es 1 la casilla tiene bombillo
                    jLabelTablero[i][j].setText(null);
                    jLabelTablero[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/bombilla.jpg")));
                }

                //TABLERO ILUMINACION    
                if (tableroIluminacion[i][j] == 1) //cuando el valor es 1 la casilla se ilumina
                {
                    jLabelTablero[i][j].setBackground(Color.YELLOW);
                }

                jPanelGraphiclView.add(jLabelTablero[i][j]);//adiciona los labels al contenedor
                jLabelTablero[i][j].setBounds(
                        xInicial + ((widthLabel + 1) * j),
                        yInicial + ((heightLabel + 1) * i),
                        widthLabel,
                        heightLabel);//ubica los labels en forma de cuadricula. Anteriormente habia un error aqui!!
            }
        }
        tableroCargado = true;
    }

    public void Iluminar() {

        byte[][] tableroIluminacion = akariGame.getTableroIluminacion();
        byte[][] tableroBombillos = akariGame.getTableroBombillos();
        byte[][] tableroCasillasNegras = akariGame.getTableroCasillasNegras();

        for (int i = 0; i < jLabelTablero.length; i++) {
            for (int j = 0; j < jLabelTablero[i].length; j++) {

                if (tableroCasillasNegras[i][j] != 1) {
                    jLabelTablero[i][j].setIcon(null);
                    jLabelTablero[i][j].setBackground(Color.white);
                }
                if (tableroIluminacion[i][j] == 1) {
                    jLabelTablero[i][j].setBackground(Color.yellow);
                }
                if (tableroBombillos[i][j] == 1) {
                    jLabelTablero[i][j].setText(null);
                    jLabelTablero[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/bombilla.jpg")));
                }
            }
        }
    }

    public void limpiarTodo() {
        jTextArea.setText(null);
        jPanelGraphiclView.removeAll();
        jPanelGraphiclView.repaint();
        tableroCargado = false;
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
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextArea jTextArea;
    // End of variables declaration//GEN-END:variables
}
