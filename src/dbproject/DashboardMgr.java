/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dbproject;

/**
 *
 * @author abc
 */
public class DashboardMgr extends javax.swing.JFrame {

    int emp;
    boolean isMgr;

    public DashboardMgr(int emp) {
        initComponents();
        this.emp = emp;
        this.isMgr = true;
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
        TaskAssign = new javax.swing.JButton();
        Subordinates = new javax.swing.JButton();
        Attendance = new javax.swing.JButton();
        Salrep = new javax.swing.JButton();
        ViewProfile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jButton7 = new javax.swing.JButton();
        generateSalary = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(52, 45, 71));
        jPanel1.setPreferredSize(new java.awt.Dimension(730, 425));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Manager");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 10, 220, 40);

        jLabel2.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DASHBOARD ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 40, 220, 40);

        TaskAssign.setBackground(new java.awt.Color(105, 103, 115));
        TaskAssign.setFont(new java.awt.Font("Rockwell", 1, 15)); // NOI18N
        TaskAssign.setForeground(new java.awt.Color(255, 255, 255));
        TaskAssign.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/TaskManager.png"))); // NOI18N
        TaskAssign.setText("Task Assignment");
        TaskAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaskAssignActionPerformed(evt);
            }
        });
        jPanel1.add(TaskAssign);
        TaskAssign.setBounds(510, 120, 230, 100);

        Subordinates.setBackground(new java.awt.Color(105, 103, 115));
        Subordinates.setFont(new java.awt.Font("Rockwell", 1, 15)); // NOI18N
        Subordinates.setForeground(new java.awt.Color(255, 255, 255));
        Subordinates.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/Subordinates.png"))); // NOI18N
        Subordinates.setText("Subordinates");
        Subordinates.setFocusPainted(false);
        Subordinates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubordinatesActionPerformed(evt);
            }
        });
        jPanel1.add(Subordinates);
        Subordinates.setBounds(510, 260, 230, 100);

        Attendance.setBackground(new java.awt.Color(105, 103, 115));
        Attendance.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        Attendance.setForeground(new java.awt.Color(255, 255, 255));
        Attendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/ComplaintPortal.png"))); // NOI18N
        Attendance.setText("Attendance Report");
        Attendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttendanceActionPerformed(evt);
            }
        });
        jPanel1.add(Attendance);
        Attendance.setBounds(270, 120, 230, 100);

        Salrep.setBackground(new java.awt.Color(105, 103, 115));
        Salrep.setFont(new java.awt.Font("Rockwell", 1, 15)); // NOI18N
        Salrep.setForeground(new java.awt.Color(255, 255, 255));
        Salrep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/SalaryReport.png"))); // NOI18N
        Salrep.setText("Salary Report");
        Salrep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalrepActionPerformed(evt);
            }
        });
        jPanel1.add(Salrep);
        Salrep.setBounds(30, 260, 230, 100);

        ViewProfile.setBackground(new java.awt.Color(105, 103, 115));
        ViewProfile.setFont(new java.awt.Font("Rockwell", 1, 15)); // NOI18N
        ViewProfile.setForeground(new java.awt.Color(255, 255, 255));
        ViewProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/ViewProfile.png"))); // NOI18N
        ViewProfile.setText("View Profile");
        ViewProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewProfileActionPerformed(evt);
            }
        });
        jPanel1.add(ViewProfile);
        ViewProfile.setBounds(30, 120, 230, 100);
        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(630, 320, 2, 2);

        jButton7.setText("Sign out");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(660, 30, 73, 23);

        generateSalary.setBackground(new java.awt.Color(105, 103, 115));
        generateSalary.setFont(new java.awt.Font("Rockwell", 1, 15)); // NOI18N
        generateSalary.setForeground(new java.awt.Color(255, 255, 255));
        generateSalary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/PayGrade.png"))); // NOI18N
        generateSalary.setText("Generate Salary");
        generateSalary.setFocusPainted(false);
        generateSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateSalaryActionPerformed(evt);
            }
        });
        jPanel1.add(generateSalary);
        generateSalary.setBounds(270, 260, 230, 100);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TaskAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaskAssignActionPerformed
        new CreateTask(emp).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_TaskAssignActionPerformed

    private void SubordinatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubordinatesActionPerformed
        new Subordinates(emp).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_SubordinatesActionPerformed

    private void AttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttendanceActionPerformed
        new Emp_AttendanceView(emp, isMgr).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AttendanceActionPerformed

    private void SalrepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalrepActionPerformed
        new Employee_Salary(emp, isMgr).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_SalrepActionPerformed

    private void ViewProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewProfileActionPerformed
        new View_profile(emp, isMgr).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ViewProfileActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.setVisible(false);
        new MainPage().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void generateSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateSalaryActionPerformed
        new Generate_Salary(emp, isMgr).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_generateSalaryActionPerformed

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
            java.util.logging.Logger.getLogger(DashboardMgr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardMgr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardMgr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardMgr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardMgr(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Attendance;
    private javax.swing.JButton Salrep;
    private javax.swing.JButton Subordinates;
    private javax.swing.JButton TaskAssign;
    private javax.swing.JButton ViewProfile;
    private javax.swing.JButton generateSalary;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
