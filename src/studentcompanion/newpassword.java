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
import javax.swing.JOptionPane;

/**
 *
 * @author anmol singh sethi
 */
public class newpassword extends javax.swing.JFrame {

    /**
     * Creates new form newpassword
     */
    String username;
    public newpassword( String user) {
        initComponents();
         username=user;
        tfuser.setText(user);
        this.setSize(500,500);
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
        tfold = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfnew = new javax.swing.JPasswordField();
        tfconf = new javax.swing.JPasswordField();
        update = new javax.swing.JButton();
        tfuser = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 110, 80, 60);

        jLabel2.setText("Welcome");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 40, 210, 50);

        jLabel3.setText("Old Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 190, 110, 30);

        tfold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfoldActionPerformed(evt);
            }
        });
        getContentPane().add(tfold);
        tfold.setBounds(250, 180, 180, 22);

        jLabel4.setText("New Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(80, 250, 110, 30);

        jLabel5.setText("Confirm Password");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, 310, 120, 40);
        getContentPane().add(tfnew);
        tfnew.setBounds(250, 250, 180, 22);
        getContentPane().add(tfconf);
        tfconf.setBounds(250, 320, 180, 22);

        update.setText("Change");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update);
        update.setBounds(220, 405, 160, 50);

        tfuser.setEditable(false);
        tfuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfuserActionPerformed(evt);
            }
        });
        getContentPane().add(tfuser);
        tfuser.setBounds(250, 130, 170, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        String oldpass = tfold.getText();  
        String newpass = tfnew.getText();  
        String confpass = tfconf.getText();
        if(oldpass.isEmpty()|| newpass.isEmpty() || confpass.isEmpty())
        {
           JOptionPane.showMessageDialog(null, "Enter the fields you moron");
           tfold.setText("");
             tfnew.setText("");
             tfconf.setText("");
        }
        else
        {
             try
             {
              Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Driver Loading done");
            
            Connection conn = DriverManager.getConnection
        ("jdbc:mysql://127.0.0.1:3306/student_companion", "root", "system");
//            System.out.println("Connection Created");
            
            Statement stmt = conn.createStatement
        (ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
//            System.out.println("Statement Created");
            
            ResultSet rs = stmt.executeQuery("select * from admin_login where username='"+username+"' and password='"+oldpass+"'");

            if(!newpass.equals(confpass))
            {
             JOptionPane.showMessageDialog(this,"Passwords don't match");   
             tfold.setText("");
             tfnew.setText("");
             tfconf.setText("");
            }
            else if(oldpass.equals(newpass))
            {
                JOptionPane.showMessageDialog(this,"Passwords cannot be same as before");
                tfold.setText("");
             tfnew.setText("");
             tfconf.setText("");
            }
            else if(rs.next())
                 {
                    // rs.moveToInsertRow();
                     rs.updateString("password", newpass);
                     rs.updateRow();
                     JOptionPane.showMessageDialog(this,"Password Changed Succesfully");
                     dispose();
                     
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(this,"old password not corect");
                     tfold.setText("");
             tfnew.setText("");
             tfconf.setText("");
                 }
                 
                 
             }catch(Exception e)
              {
                 
             }}
// TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed
    
    private void tfoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfoldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfoldActionPerformed

    private void tfuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfuserActionPerformed

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
            java.util.logging.Logger.getLogger(newpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new newpassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField tfconf;
    private javax.swing.JPasswordField tfnew;
    private javax.swing.JPasswordField tfold;
    private javax.swing.JTextField tfuser;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
