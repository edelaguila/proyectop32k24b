/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import controlador.Boletas2;
import java.awt.BorderLayout;
import java.awt.Dimension;
import modelo.Boletas2DAO;
import controlador.CursosAsignados;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import modelo.CursosAsignadosDAO;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ProcesoAsignacionCursosMaestros extends javax.swing.JInternalFrame {
     int codigoAplicacion = 3456;
    public class AsignacionCursos extends JFrame {
    private JTable tablaCursoAsignar;
    private JTable tablaCursoAsignada;
    private JButton botonPasarDerecha;
    private JButton botonPasarIzquierda;
    private JButton botonGenerar;
    private JButton botonIngresar;
    private DefaultTableModel modeloAsignar;
    private DefaultTableModel modeloAsignada;
    
      private void mostrarReporte(String reporte) {
        JTextArea textArea = new JTextArea(reporte);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        JOptionPane.showMessageDialog(this, scrollPane, "Reporte de Cursos", JOptionPane.INFORMATION_MESSAGE);
    }

       public AsignacionCursos() {
        setTitle("Gestión de Cursos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        modeloAsignar = new DefaultTableModel(new Object[]{"Cursos"}, 0);
        modeloAsignada = new DefaultTableModel(new Object[]{"Cursos"}, 0);

     
        modeloAsignar.addRow(new Object[]{"Programación III"});
        modeloAsignar.addRow(new Object[]{"Metódos Númericos"});
        modeloAsignar.addRow(new Object[]{"Electrónica Analógica"});
        modeloAsignar.addRow(new Object[]{"Emprendedores de Negocios"});
        modeloAsignar.addRow(new Object[]{"Estadísticas II"});
        modeloAsignar.addRow(new Object[]{"Física I"});
        modeloAsignar.addRow(new Object[]{"Física II"});
        modeloAsignar.addRow(new Object[]{"Lógica en Sistemas"});
        modeloAsignar.addRow(new Object[]{"Programación I"});
        modeloAsignar.addRow(new Object[]{"Programación II"});
     
        tablaCursoAsignar = new JTable(modeloAsignar);
        tablaCursoAsignada = new JTable(modeloAsignada);

        botonPasarDerecha = new JButton("🡪");
        botonPasarIzquierda = new JButton("🡨");
        botonGenerar = new JButton("Generar Reporte");
        botonIngresar = new JButton("Ingresar a DB");

        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.add(botonPasarDerecha);
        panelBotones.add(botonPasarIzquierda);
        panelBotones.add(botonGenerar);
        panelBotones.add(botonIngresar);

      
        add(new JScrollPane(tablaCursoAsignar), BorderLayout.WEST);
        add(panelBotones, BorderLayout.CENTER);
        add(new JScrollPane(tablaCursoAsignada), BorderLayout.EAST);

        // Acción del botón de pasar a la derecha
        botonPasarDerecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tablaCursoAsignar.getSelectedRow();
                if (selectedRow != -1) {
                    Object curso = modeloAsignar.getValueAt(selectedRow, 0);
                    modeloAsignar.removeRow(selectedRow);
                    modeloAsignada.addRow(new Object[]{curso});
                }
            }
        });

   
        botonPasarIzquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tablaCursoAsignada.getSelectedRow();
                if (selectedRow != -1) {
                    Object curso = modeloAsignada.getValueAt(selectedRow, 0);
                    modeloAsignada.removeRow(selectedRow);
                    modeloAsignar.addRow(new Object[]{curso});
                }
            }
        });
   botonGenerar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
       Connection conn = null;        
        Map p = new HashMap();
        JasperReport report;
        JasperPrint print;

        try {
            conn = Conexion.getConnection();
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/main/java/reportes/rptReporteCursosAsignadosMaestros.jrxml");
	    print = JasperFillManager.fillReport(report, p, conn);
            JasperViewer view = new JasperViewer(print, false);
	    view.setTitle("Reporte Prueba");
            view.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
});

   botonIngresar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
     
        int rowCount = modeloAsignada.getRowCount();
        String primerCurso = "";
        String segundoCurso = "";
        String tercerCurso = "";
        String cuartoCurso = "";
        String quintoCurso = "";

        if (rowCount > 0) primerCurso = (String) modeloAsignada.getValueAt(0, 0);
        if (rowCount > 1) segundoCurso = (String) modeloAsignada.getValueAt(1, 0);
        if (rowCount > 2) tercerCurso = (String) modeloAsignada.getValueAt(2, 0);
        if (rowCount > 3) cuartoCurso = (String) modeloAsignada.getValueAt(3, 0);
        if (rowCount > 4) quintoCurso = (String) modeloAsignada.getValueAt(4, 0);

       
        CursosAsignados cursoAsignado = new CursosAsignados(primerCurso, segundoCurso, tercerCurso, cuartoCurso, quintoCurso);

       
        CursosAsignadosDAO cursoAsignadoDAO = new CursosAsignadosDAO();
        int rowsInserted = cursoAsignadoDAO.insert(cursoAsignado);

        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(null, "Cursos ingresados exitosamente a la base de datos.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al ingresar los cursos a la base de datos.");
        }
    }
});



    }

    
}
    public ProcesoAsignacionCursosMaestros() {
        initComponents();
    }
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoBoleta = new javax.swing.JTextField();
        txtCodigoMaestro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtJornada = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbAño = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSeccion = new javax.swing.JTextField();
        cmbSemestre = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        btnRegistrar.setText("Ingresar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel1.setText("ID del boleta:");

        jLabel2.setText("Código del Maestro:");

        jLabel4.setText("Semestre");

        jLabel5.setText("Jornada");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Asinacion de Cursos a Maestros");

        cmbAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "2024", "2025", "2026", "2027" }));

        jLabel6.setText("Año");

        jLabel7.setText("Seccion");

        cmbSemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto", "Séptimo", "Octavo", " " }));
        cmbSemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSemestreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cmbSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCodigoMaestro))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCodigoBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnRegistrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(47, 47, 47)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbAño, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))))
                                .addGap(23, 23, 23)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigoBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoMaestro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
      String CodigoMaestro = txtCodigoMaestro.getText();
      String Semestre = cmbSemestre.getSelectedItem().toString();
      String Jornada = txtJornada.getText();
      String Seccion = txtSeccion.getText();
      String Año = cmbAño.getSelectedItem().toString();
      String IDBoleta = txtCodigoBoleta.getText();
      
      if(IDBoleta.isEmpty() || Semestre.isEmpty() || Semestre.equals("Seleccionar")
   || Jornada.isEmpty() || Seccion.isEmpty() || Año.equals("Seleccionar")) {
     JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}
     JTextField codigoBoletaField = new JTextField();
Object[] message = {
    "Ingrese el número de la boleta:", codigoBoletaField
};
int option = JOptionPane.showConfirmDialog(this, message, "Número de Boleta", JOptionPane.OK_CANCEL_OPTION);
if (option == JOptionPane.OK_OPTION) {
    String codigoBoleta = codigoBoletaField.getText();
    if (codigoBoleta.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe ingresar el número de la boleta.", "Error", JOptionPane.ERROR_MESSAGE);
        return; 
    }

    if (codigoBoleta.equals(IDBoleta)) {
        JOptionPane.showMessageDialog(this, "Boleta Verificada exitosamente. Código de boleta: " + codigoBoleta, "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        Boletas2 boleta = new Boletas2(IDBoleta, CodigoMaestro, Jornada, Seccion, Semestre, Año);
        
        Boletas2DAO boletaDAO = new Boletas2DAO();
        int rowsInserted = boletaDAO.insert(boleta);
        
        new AsignacionCursos().setVisible(true);
        
    }
    } else {
        JOptionPane.showMessageDialog(this, "Error al Verificar la boleta. Profesor insolvente.", "Error", JOptionPane.ERROR_MESSAGE);
    }     
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void cmbSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSemestreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSemestreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbAño;
    private javax.swing.JComboBox<String> cmbSemestre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtCodigoBoleta;
    private javax.swing.JTextField txtCodigoMaestro;
    private javax.swing.JTextField txtJornada;
    private javax.swing.JTextField txtSeccion;
    // End of variables declaration//GEN-END:variables
}
