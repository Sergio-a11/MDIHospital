/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author dadxc
 */
public class VentanaExamenes extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaExamenes
     */
    public VentanaExamenes() {
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

        btnGrupo = new javax.swing.ButtonGroup();
        btnSangre = new javax.swing.JRadioButton();
        btnOrina = new javax.swing.JRadioButton();
        btnCorprologico = new javax.swing.JRadioButton();
        btnOptometria = new javax.swing.JRadioButton();
        btnOdontologia = new javax.swing.JRadioButton();
        btnAgregar = new javax.swing.JButton();
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();

        setClosable(true);

        btnSangre.setText("Sangre");

        btnOrina.setText("Orina");

        btnCorprologico.setText("Coprológico");

        btnOptometria.setText("Optometría");

        btnOdontologia.setText("Odontología");

        btnAgregar.setText("Agregar");

        lblDescripcion.setText("Descripcion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSangre)
                    .addComponent(btnOrina)
                    .addComponent(btnCorprologico)
                    .addComponent(btnOptometria)
                    .addComponent(btnOdontologia)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblDescripcion)
                        .addContainerGap(98, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtDescripcion)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSangre)
                    .addComponent(lblDescripcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOrina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCorprologico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOptometria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOdontologia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregar)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtDescripcion)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JRadioButton getBtnCorprologico() {
        return btnCorprologico;
    }

    public void setBtnCorprologico(JRadioButton btnCorprologico) {
        this.btnCorprologico = btnCorprologico;
    }

    public ButtonGroup getBtnGrupo() {
        return btnGrupo;
    }

    public void setBtnGrupo(ButtonGroup btnGrupo) {
        this.btnGrupo = btnGrupo;
    }

    public JRadioButton getBtnOdontologia() {
        return btnOdontologia;
    }

    public void setBtnOdontologia(JRadioButton btnOdontologia) {
        this.btnOdontologia = btnOdontologia;
    }

    public JRadioButton getBtnOptometria() {
        return btnOptometria;
    }

    public void setBtnOptometria(JRadioButton btnOptometria) {
        this.btnOptometria = btnOptometria;
    }

    public JRadioButton getBtnOrina() {
        return btnOrina;
    }

    public void setBtnOrina(JRadioButton btnOrina) {
        this.btnOrina = btnOrina;
    }

    public JRadioButton getBtnSangre() {
        return btnSangre;
    }

    public void setBtnSangre(JRadioButton btnSangre) {
        this.btnSangre = btnSangre;
    }

    public JLabel getLblDescripcion() {
        return lblDescripcion;
    }

    public void setLblDescripcion(JLabel lblDescripcion) {
        this.lblDescripcion = lblDescripcion;
    }

    public JTextField getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(JTextField txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JRadioButton btnCorprologico;
    private javax.swing.ButtonGroup btnGrupo;
    private javax.swing.JRadioButton btnOdontologia;
    private javax.swing.JRadioButton btnOptometria;
    private javax.swing.JRadioButton btnOrina;
    private javax.swing.JRadioButton btnSangre;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
