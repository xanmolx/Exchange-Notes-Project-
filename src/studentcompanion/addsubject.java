/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentcompanion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author anmol singh sethi
 */

public class addsubject extends javax.swing.JFrame {

    /**
     * Creates new form addsubject
     */
    
    public addsubject() {
        initComponents();
        setSize(800, 800);
        setVisible(true);
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Driver Loading done");

            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student_companion", "root", "system");
//            System.out.println("Connection Created");

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
//            System.out.println("Statement Created");

            ResultSet rs = stmt.executeQuery("select * from departments");
            while (rs.next()) {

                cbdeptlist.addItem(rs.getString("department"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        jLabel4 = new javax.swing.JLabel();
        cbdeptlist = new javax.swing.JComboBox<>();
        cbcourselist = new javax.swing.JComboBox<>();
        tfsubcode = new javax.swing.JTextField();
        tfsubname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cbsem = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Select Department");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(37, 26, 160, 50);

        jLabel2.setText("Select Course");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 100, 130, 50);

        jLabel3.setText("Select Subjct Code");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 200, 150, 70);

        jLabel4.setText("Subject Name");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 290, 130, 40);

        cbdeptlist.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbdeptlistItemStateChanged(evt);
            }
        });
        getContentPane().add(cbdeptlist);
        cbdeptlist.setBounds(250, 30, 200, 50);

        cbcourselist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbcourselistActionPerformed(evt);
            }
        });
        getContentPane().add(cbcourselist);
        cbcourselist.setBounds(250, 120, 200, 50);
        getContentPane().add(tfsubcode);
        tfsubcode.setBounds(250, 200, 200, 60);
        getContentPane().add(tfsubname);
        tfsubname.setBounds(250, 290, 200, 60);

        jLabel5.setText("Semester");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 390, 140, 50);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(110, 480, 270, 70);

        cbsem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---select---", "1", "2", "3", "4", "5", "6", "7", "8" }));
        cbsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbsemActionPerformed(evt);
            }
        });
        getContentPane().add(cbsem);
        cbsem.setBounds(250, 380, 200, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbsemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbsemActionPerformed

    private void cbcourselistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcourselistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbcourselistActionPerformed

    private void cbdeptlistItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbdeptlistItemStateChanged
        String s = (String) cbdeptlist.getSelectedItem();
        cbcourselist.removeAllItems();
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Driver Loading done");

            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student_companion", "root", "system");
//            System.out.println("Connection Created");

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
//            System.out.println("Statement Created");

            ResultSet rs = stmt.executeQuery("select * from courses where department='" + s + "'");
            while (rs.next()) {

                cbcourselist.addItem(rs.getString("coursename"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbdeptlistItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String subid = tfsubcode.getText();
        String subname = tfsubname.getText();
        String course = (String) cbcourselist.getSelectedItem();
        int sem = Integer.parseInt((String) cbsem.getSelectedItem());

        try {
            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Driver Loading done");

            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student_companion", "root", "system");
//            System.out.println("Connection Created");

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
//            System.out.println("Statement Created");

            ResultSet rs = stmt.executeQuery("select * from subjects where subjectcode='" + subid + "'");
            if (rs.next()) {
                JOptionPane.showMessageDialog(rootPane, "Subject already exists \nEnter new Subject");
                tfsubcode.setText("");
                tfsubname.setText("");
            } else {
                rs.moveToInsertRow();

                rs.updateString("subjectcode", subid);

                rs.updateString("subjectname", subname);

                rs.updateString("coursename", course);
                rs.updateInt("semester", sem);
                rs.insertRow();
                JOptionPane.showMessageDialog(rootPane, "Subject added successfully");
                dispose();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(addsubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addsubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addsubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addsubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addsubject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbcourselist;
    private javax.swing.JComboBox<String> cbdeptlist;
    private javax.swing.JComboBox<String> cbsem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tfsubcode;
    private javax.swing.JTextField tfsubname;
    // End of variables declaration//GEN-END:variables
}
