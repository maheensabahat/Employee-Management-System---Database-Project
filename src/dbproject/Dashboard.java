/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dbproject;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abc
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Task = new javax.swing.JButton();
        Dept = new javax.swing.JButton();
        Emp = new javax.swing.JButton();
        Salary = new javax.swing.JButton();
        Attendance = new javax.swing.JButton();
        MA = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(52, 45, 71));
        jPanel1.setPreferredSize(new java.awt.Dimension(730, 425));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrator");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 10, 220, 40);

        jLabel2.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DASHBOARD ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 40, 220, 40);

        Task.setBackground(new java.awt.Color(105, 103, 115));
        Task.setFont(new java.awt.Font("Rockwell", 1, 15)); // NOI18N
        Task.setForeground(new java.awt.Color(255, 255, 255));
        Task.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/TaskManager.png"))); // NOI18N
        Task.setText("Tasks Report ");
        Task.setFocusPainted(false);
        Task.setFocusable(false);
        Task.setRequestFocusEnabled(false);
        Task.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaskActionPerformed(evt);
            }
        });
        jPanel1.add(Task);
        Task.setBounds(510, 120, 230, 100);

        Dept.setBackground(new java.awt.Color(105, 103, 115));
        Dept.setFont(new java.awt.Font("Rockwell", 1, 15)); // NOI18N
        Dept.setForeground(new java.awt.Color(255, 255, 255));
        Dept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/Department.png"))); // NOI18N
        Dept.setText("Department Info");
        Dept.setFocusPainted(false);
        Dept.setFocusable(false);
        Dept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeptActionPerformed(evt);
            }
        });
        jPanel1.add(Dept);
        Dept.setBounds(30, 120, 230, 100);

        Emp.setBackground(new java.awt.Color(105, 103, 115));
        Emp.setFont(new java.awt.Font("Rockwell", 1, 15)); // NOI18N
        Emp.setForeground(new java.awt.Color(255, 255, 255));
        Emp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/Employee.png"))); // NOI18N
        Emp.setText("Employee Data");
        Emp.setFocusPainted(false);
        Emp.setFocusable(false);
        Emp.setRequestFocusEnabled(false);
        Emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpActionPerformed(evt);
            }
        });
        jPanel1.add(Emp);
        Emp.setBounds(270, 120, 230, 100);

        Salary.setBackground(new java.awt.Color(105, 103, 115));
        Salary.setFont(new java.awt.Font("Rockwell", 1, 15)); // NOI18N
        Salary.setForeground(new java.awt.Color(255, 255, 255));
        Salary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/Salary.png"))); // NOI18N
        Salary.setText("Salary");
        Salary.setFocusPainted(false);
        Salary.setFocusable(false);
        Salary.setRequestFocusEnabled(false);
        Salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalaryActionPerformed(evt);
            }
        });
        jPanel1.add(Salary);
        Salary.setBounds(30, 260, 230, 100);

        Attendance.setBackground(new java.awt.Color(105, 103, 115));
        Attendance.setFont(new java.awt.Font("Rockwell", 1, 15)); // NOI18N
        Attendance.setForeground(new java.awt.Color(255, 255, 255));
        Attendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/Attendancee.png"))); // NOI18N
        Attendance.setText("Attendance");
        Attendance.setFocusPainted(false);
        Attendance.setFocusable(false);
        Attendance.setRequestFocusEnabled(false);
        Attendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttendanceActionPerformed(evt);
            }
        });
        jPanel1.add(Attendance);
        Attendance.setBounds(270, 260, 230, 100);

        MA.setBackground(new java.awt.Color(105, 103, 115));
        MA.setFont(new java.awt.Font("Rockwell", 1, 15)); // NOI18N
        MA.setForeground(new java.awt.Color(255, 255, 255));
        MA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/PerformanceAnalysis(2).png"))); // NOI18N
        MA.setText("Monthly Analysis");
        MA.setFocusPainted(false);
        MA.setFocusable(false);
        MA.setRequestFocusEnabled(false);
        MA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MAActionPerformed(evt);
            }
        });
        jPanel1.add(MA);
        MA.setBounds(510, 260, 230, 100);

        jButton1.setBackground(new java.awt.Color(105, 103, 115));
        jButton1.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Sign out");
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setRequestFocusEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(641, 25, 90, 25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaskActionPerformed
        new Admin_Tasks().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_TaskActionPerformed

    private void DeptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeptActionPerformed
        new Admin_Dept().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_DeptActionPerformed

    private void EmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpActionPerformed
        try {
            new Admin_Employee().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }//GEN-LAST:event_EmpActionPerformed

    private void SalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalaryActionPerformed
        new Ad_Salaryy().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_SalaryActionPerformed

    private void AttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttendanceActionPerformed
        new Mark_Attendance2().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AttendanceActionPerformed

    private void MAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAActionPerformed
        new PerformanceAnalysis().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MAActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        new MainPage().setVisible(true);
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Attendance;
    private javax.swing.JButton Dept;
    private javax.swing.JButton Emp;
    private javax.swing.JButton MA;
    private javax.swing.JButton Salary;
    private javax.swing.JButton Task;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
