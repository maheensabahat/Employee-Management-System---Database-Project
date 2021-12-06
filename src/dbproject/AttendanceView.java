package dbproject;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Hp
 */
public class AttendanceView extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Database db;

    public AttendanceView() {
        initComponents();

        error1.setVisible(false);
        error2.setVisible(false);

        //making connection to database
        db = new Database();
        try {
            db.openConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceView.class.getName()).log(Level.SEVERE, null, ex);
        }

        con = db.con;
        pst = db.pst;
        rs = db.rs;

        tableupdate();

        Employee.getTableHeader().setOpaque(true);
//        Employee.getTableHeader().setBackground(new java.awt.Color(64, 56, 84));
        Employee.getTableHeader().setFont(new java.awt.Font("Rockwell", 1, 10));
        Employee.getTableHeader().setForeground(new java.awt.Color(52, 45, 71));
    }

    private void tableupdate() { //table updated after every change
        int c;
        try {

            pst = con.prepareStatement("SELECT a.Employee_ID, e.first_name, "
                    + "e.last_name, a.date, a.`Attendance`\n"
                    + "FROM Attendance a\n"
                    + "INNER JOIN Employee e using (Employee_ID);");
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) Employee.getModel();
            dft.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("employee_id"));
                    v2.add(rs.getString("first_name"));
                    v2.add(rs.getString("last_name"));
                    v2.add(rs.getString("date"));
                    v2.add(rs.getString("attendance"));
                }

                dft.addRow(v2);

            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Sbdate = new javax.swing.JLabel();
        empid = new javax.swing.JTextField();
        search1 = new javax.swing.JButton();
        empID2 = new javax.swing.JLabel();
        markAtt = new javax.swing.JButton();
        or = new javax.swing.JLabel();
        searchbemp = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Employee = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        Date = new javax.swing.JLabel();
        error1 = new javax.swing.JLabel();
        day = new javax.swing.JTextField();
        month = new javax.swing.JComboBox<>();
        Date1 = new javax.swing.JLabel();
        Date2 = new javax.swing.JLabel();
        year = new javax.swing.JComboBox<>();
        search2 = new javax.swing.JButton();
        error2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(52, 45, 71));
        jPanel1.setPreferredSize(new java.awt.Dimension(744, 490));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 45, 71));
        jLabel1.setText("Attendance ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 20, 230, 43);

        Sbdate.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        Sbdate.setForeground(new java.awt.Color(52, 45, 71));
        Sbdate.setText("Search by Date:");
        jPanel1.add(Sbdate);
        Sbdate.setBounds(30, 230, 120, 20);

        empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empidActionPerformed(evt);
            }
        });
        jPanel1.add(empid);
        empid.setBounds(110, 130, 80, 30);

        search1.setBackground(new java.awt.Color(38, 32, 54));
        search1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        search1.setForeground(new java.awt.Color(255, 255, 255));
        search1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/search_white.png"))); // NOI18N
        search1.setText("Search");
        search1.setFocusPainted(false);
        search1.setFocusable(false);
        search1.setRequestFocusEnabled(false);
        search1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                search1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                search1MouseExited(evt);
            }
        });
        search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search1ActionPerformed(evt);
            }
        });
        jPanel1.add(search1);
        search1.setBounds(110, 170, 83, 25);

        empID2.setFont(new java.awt.Font("Rockwell", 1, 11)); // NOI18N
        empID2.setForeground(new java.awt.Color(52, 45, 71));
        empID2.setText("Employee ID:");
        jPanel1.add(empID2);
        empID2.setBounds(30, 140, 90, 14);

        markAtt.setBackground(new java.awt.Color(38, 32, 54));
        markAtt.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        markAtt.setForeground(new java.awt.Color(255, 255, 255));
        markAtt.setText("Mark Attendance");
        markAtt.setFocusPainted(false);
        markAtt.setFocusable(false);
        markAtt.setRequestFocusEnabled(false);
        markAtt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                markAttMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                markAttMouseExited(evt);
            }
        });
        markAtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markAttActionPerformed(evt);
            }
        });
        jPanel1.add(markAtt);
        markAtt.setBounds(550, 60, 170, 30);

        or.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        or.setForeground(new java.awt.Color(52, 45, 71));
        or.setText("OR");
        jPanel1.add(or);
        or.setBounds(40, 200, 30, 18);

        searchbemp.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        searchbemp.setForeground(new java.awt.Color(52, 45, 71));
        searchbemp.setText("Search by Employee:");
        jPanel1.add(searchbemp);
        searchbemp.setBounds(30, 100, 150, 18);

        Employee.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 12)); // NOI18N
        Employee.setForeground(new java.awt.Color(52, 45, 71));
        Employee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "First Name", "Last Name", "Date", "Attendance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Employee.setFocusable(false);
        Employee.setGridColor(new java.awt.Color(52, 45, 71));
        Employee.setSelectionBackground(new java.awt.Color(130, 120, 158));
        jScrollPane1.setViewportView(Employee);
        Employee.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 12)); // NOI18N

        Employee.setForeground(new java.awt.Color(52, 45, 71));

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(220, 100, 500, 310);

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(52, 45, 71));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/dashboard_32.png"))); // NOI18N
        jLabel2.setText("Dashboard");
        jLabel2.setFocusable(false);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(630, 10, 130, 40);

        reset.setBackground(new java.awt.Color(38, 32, 54));
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("Reset Table");
        reset.setFocusPainted(false);
        reset.setFocusable(false);
        reset.setRequestFocusEnabled(false);
        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resetMouseExited(evt);
            }
        });
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel1.add(reset);
        reset.setBounds(620, 410, 100, 20);

        Date.setFont(new java.awt.Font("Rockwell", 1, 11)); // NOI18N
        Date.setForeground(new java.awt.Color(52, 45, 71));
        Date.setText("Day: ");
        jPanel1.add(Date);
        Date.setBounds(30, 280, 80, 14);

        error1.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error1.setForeground(new java.awt.Color(255, 0, 51));
        error1.setText("enter day to proceed");
        jPanel1.add(error1);
        error1.setBounds(70, 250, 140, 20);

        day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayActionPerformed(evt);
            }
        });
        day.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dayKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dayKeyReleased(evt);
            }
        });
        jPanel1.add(day);
        day.setBounds(80, 270, 110, 30);

        month.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        month.setFocusable(false);
        month.setRequestFocusEnabled(false);
        month.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                monthMouseClicked(evt);
            }
        });
        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthActionPerformed(evt);
            }
        });
        jPanel1.add(month);
        month.setBounds(80, 310, 110, 29);

        Date1.setFont(new java.awt.Font("Rockwell", 1, 11)); // NOI18N
        Date1.setForeground(new java.awt.Color(52, 45, 71));
        Date1.setText("Month:");
        jPanel1.add(Date1);
        Date1.setBounds(30, 320, 80, 14);

        Date2.setFont(new java.awt.Font("Rockwell", 1, 11)); // NOI18N
        Date2.setForeground(new java.awt.Color(52, 45, 71));
        Date2.setText("Year:");
        jPanel1.add(Date2);
        Date2.setBounds(30, 360, 80, 14);

        year.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", " " }));
        year.setFocusable(false);
        year.setRequestFocusEnabled(false);
        year.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yearMouseClicked(evt);
            }
        });
        year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearActionPerformed(evt);
            }
        });
        jPanel1.add(year);
        year.setBounds(80, 350, 110, 29);

        search2.setBackground(new java.awt.Color(38, 32, 54));
        search2.setForeground(new java.awt.Color(255, 255, 255));
        search2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/search_white.png"))); // NOI18N
        search2.setText("Search");
        search2.setFocusPainted(false);
        search2.setFocusable(false);
        search2.setRequestFocusEnabled(false);
        search2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                search2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                search2MouseExited(evt);
            }
        });
        search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search2ActionPerformed(evt);
            }
        });
        jPanel1.add(search2);
        search2.setBounds(90, 390, 90, 30);

        error2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error2.setForeground(new java.awt.Color(255, 0, 51));
        error2.setText("numeric values only");
        jPanel1.add(error2);
        error2.setBounds(70, 250, 140, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empidActionPerformed

    private void markAttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markAttActionPerformed
        new Mark_Attendance2().setVisible(rootPaneCheckingEnabled);
        this.setVisible(false);
    }//GEN-LAST:event_markAttActionPerformed

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
        if (!empid.getText().isEmpty()) {
            try {
                int emp = Integer.parseInt(empid.getText());

                try {
                    pst = con.prepareStatement("SELECT a.Employee_ID, e.first_name, "
                            + "e.last_name, a.date, a.`Attendance`\n"
                            + "FROM Attendance a\n"
                            + "INNER JOIN Employee e using (Employee_ID) where employee_ID = ?");
                    pst.setInt(1, emp);
                    rs = pst.executeQuery();

                    ResultSetMetaData rsd = rs.getMetaData();
                    DefaultTableModel dft = (DefaultTableModel) Employee.getModel();
                    dft.setRowCount(0);

                    while (rs.next()) {
                        Vector v2 = new Vector();
                        v2.add(rs.getString("employee_id"));
                        v2.add(rs.getString("first_name"));
                        v2.add(rs.getString("last_name"));
                        v2.add(rs.getString("date"));
                        v2.add(rs.getString("attendance"));
                        dft.addRow(v2);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Admin_Employee.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (NumberFormatException ex) {
                empid.setText("");
            }
        }
    }//GEN-LAST:event_search1ActionPerformed

    private void search1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search1MouseEntered
        // TODO add your handling code here:
        search1.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_search1MouseEntered

    private void markAttMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_markAttMouseEntered
        // TODO add your handling code here:
        markAtt.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_markAttMouseEntered

    private void search1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search1MouseExited
        // TODO add your handling code here:
        search1.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_search1MouseExited

    private void markAttMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_markAttMouseExited
        // TODO add your handling code here:
        markAtt.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_markAttMouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        Dashboard db = new Dashboard();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void resetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseEntered
        // TODO add your handling code here:
        reset.setBackground(new java.awt.Color(79, 70, 102));
    }//GEN-LAST:event_resetMouseEntered

    private void resetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseExited
        // TODO add your handling code here:
        reset.setBackground(new java.awt.Color(38, 32, 54));
    }//GEN-LAST:event_resetMouseExited

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        tableupdate();
        empid.setText("");
        day.setText("");
        month.setSelectedIndex(0);
        year.setSelectedIndex(0);
    }//GEN-LAST:event_resetActionPerformed

    private void dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayActionPerformed

    private void dayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dayKeyPressed
        error1.setVisible(false);
        error2.setVisible(false);
    }//GEN-LAST:event_dayKeyPressed

    private void dayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dayKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_dayKeyReleased

    private void monthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthMouseClicked

    }//GEN-LAST:event_monthMouseClicked

    private void monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthActionPerformed

    private void yearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yearMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_yearMouseClicked

    private void yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearActionPerformed

    private void search2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search2MouseEntered
        // TODO add your handling code here:
        search2.setBackground(new java.awt.Color(79, 70, 102));
    }//GEN-LAST:event_search2MouseEntered

    private void search2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search2MouseExited
        // TODO add your handling code here:
        search2.setBackground(new java.awt.Color(38, 32, 54));
    }//GEN-LAST:event_search2MouseExited

    private void search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search2ActionPerformed
        int c;
        if (!day.getText().isEmpty()) {
            try {

                String d = day.getText();
                int day = Integer.parseInt(d);

                String m = (String) month.getSelectedItem();
                String Y = (String) year.getSelectedItem();
                String date = Y + "-" + m + "-" + d;

                try {

                    pst = con.prepareStatement("SELECT a.Employee_ID, e.first_name, "
                            + "e.last_name, a.date, a.`Attendance`\n"
                            + "FROM Attendance a\n"
                            + "INNER JOIN Employee e using (Employee_ID)"
                            + "where a.date = str_to_date(?,'%Y-%m-%d')");
                    pst.setString(1, date);
                    rs = pst.executeQuery();

                    ResultSetMetaData rsd = rs.getMetaData();
                    c = rsd.getColumnCount();
                    DefaultTableModel dft = (DefaultTableModel) Employee.getModel();
                    dft.setRowCount(0);

                    while (rs.next()) {
                        Vector v2 = new Vector();
                        for (int i = 1; i <= c; i++) {
                            v2.add(rs.getString("employee_id"));
                            v2.add(rs.getString("first_name"));
                            v2.add(rs.getString("last_name"));
                            v2.add(rs.getString("date"));
                            v2.add(rs.getString("attendance"));
                        }

                        dft.addRow(v2);

                    }

                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(Admin_Employee.class
                            .getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            } catch (NumberFormatException ex) {
                error2.setVisible(true);
            }
        } else {
            error1.setVisible(true);
        }
    }//GEN-LAST:event_search2ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AttendanceView().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    private javax.swing.JLabel Date1;
    private javax.swing.JLabel Date2;
    private javax.swing.JTable Employee;
    private javax.swing.JLabel Sbdate;
    private javax.swing.JTextField day;
    private javax.swing.JLabel empID2;
    private javax.swing.JTextField empid;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel error2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton markAtt;
    private javax.swing.JComboBox<String> month;
    private javax.swing.JLabel or;
    private javax.swing.JButton reset;
    private javax.swing.JButton search1;
    private javax.swing.JButton search2;
    private javax.swing.JLabel searchbemp;
    private javax.swing.JComboBox<String> year;
    // End of variables declaration//GEN-END:variables
}
