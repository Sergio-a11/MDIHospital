/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Sergio Cruz
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public VentanaPrincipal() {
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

        pndEscritorio = new javax.swing.JDesktopPane();
        LabelDiseño = new javax.swing.JLabel();
        mnBarra = new javax.swing.JMenuBar();
        MainMenuRegistrar = new javax.swing.JMenu();
        opcmRegistrar = new javax.swing.JMenuItem();
        MainMenuConsultar = new javax.swing.JMenu();
        opcmConsultar = new javax.swing.JMenuItem();
        MainMenuSalir = new javax.swing.JMenu();
        opcmSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pndEscritorio.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darcula.selection.color1"));

        LabelDiseño.setText("Diseñado por: Daniel Torres y Sergio Cruz");
        pndEscritorio.add(LabelDiseño);
        LabelDiseño.setBounds(300, 280, 240, 30);

        MainMenuRegistrar.setText("Registrar");

        opcmRegistrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        opcmRegistrar.setText("Registrar");
        MainMenuRegistrar.add(opcmRegistrar);

        mnBarra.add(MainMenuRegistrar);

        MainMenuConsultar.setText("Consultar");

        opcmConsultar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        opcmConsultar.setText("Consultar");
        MainMenuConsultar.add(opcmConsultar);

        mnBarra.add(MainMenuConsultar);

        MainMenuSalir.setText("Salir");

        opcmSalir.setText("Salir");
        MainMenuSalir.add(opcmSalir);

        mnBarra.add(MainMenuSalir);

        setJMenuBar(mnBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pndEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pndEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JLabel getLabelDiseño() {
        return LabelDiseño;
    }

    public void setLabelDiseño(JLabel LabelDiseño) {
        this.LabelDiseño = LabelDiseño;
    }

    public JMenu getMainMenuConsultar() {
        return MainMenuConsultar;
    }

    public void setMainMenuConsultar(JMenu MainMenuConsultar) {
        this.MainMenuConsultar = MainMenuConsultar;
    }

    public JMenu getMainMenuRegistrar() {
        return MainMenuRegistrar;
    }

    public void setMainMenuRegistrar(JMenu MainMenuRegistrar) {
        this.MainMenuRegistrar = MainMenuRegistrar;
    }

    public JMenu getMainMenuSalir() {
        return MainMenuSalir;
    }

    public void setMainMenuSalir(JMenu MainMenuSalir) {
        this.MainMenuSalir = MainMenuSalir;
    }

    public JMenuBar getMnBarra() {
        return mnBarra;
    }

    public void setMnBarra(JMenuBar mnBarra) {
        this.mnBarra = mnBarra;
    }

    public JMenuItem getOpcmConsultar() {
        return opcmConsultar;
    }

    public void setOpcmConsultar(JMenuItem opcmConsultar) {
        this.opcmConsultar = opcmConsultar;
    }

    public JMenuItem getOpcmRegistrar() {
        return opcmRegistrar;
    }

    public void setOpcmRegistrar(JMenuItem opcmRegistrar) {
        this.opcmRegistrar = opcmRegistrar;
    }

    public JMenuItem getOpcmSalir() {
        return opcmSalir;
    }

    public void setOpcmSalir(JMenuItem opcmSalir) {
        this.opcmSalir = opcmSalir;
    }

    public JDesktopPane getPndEscritorio() {
        return pndEscritorio;
    }

    public void setPndEscritorio(JDesktopPane pndEscritorio) {
        this.pndEscritorio = pndEscritorio;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelDiseño;
    private javax.swing.JMenu MainMenuConsultar;
    private javax.swing.JMenu MainMenuRegistrar;
    private javax.swing.JMenu MainMenuSalir;
    private javax.swing.JMenuBar mnBarra;
    private javax.swing.JMenuItem opcmConsultar;
    private javax.swing.JMenuItem opcmRegistrar;
    private javax.swing.JMenuItem opcmSalir;
    private javax.swing.JDesktopPane pndEscritorio;
    // End of variables declaration//GEN-END:variables

}
