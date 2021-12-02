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
public class Emp_AttendanceView extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Database db;
    int emp;

    public Emp_AttendanceView(int emp) {
        initComponents();
        this.emp = emp;

        //making connection to database
        db = new Database();
        try {
            db.openConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Emp_AttendanceView.class.getName()).log(Level.SEVERE, null, ex);
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

            pst = con.prepareStatement("SELECT Date_format(date, \"%d\") as day, "
                    + "Date_format(date, \"%M\") as month, Date_format(date, \"%Y\") as year,"
                    + " attendance\n"
                    + "from attendance where employee_id = ?");
            pst.setInt(1, emp);
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) Employee.getModel();
            dft.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("day"));
                    v2.add(rs.getString("month"));
                    v2.add(rs.getString("year"));
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
        Date = new javax.swing.JLabel();
        day = new javax.swing.JTextField();
        search2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Employee = new javax.swing.JTable();
        Date1 = new javax.swing.JLabel();
        month = new javax.swing.JTextField();
        Date2 = new javax.swing.JLabel();
        year = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(744, 490));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 45, 71));
        jLabel1.setText("Attendance ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 10, 230, 43);

        Sbdate.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        Sbdate.setForeground(new java.awt.Color(52, 45, 71));
        Sbdate.setText("Search by Date:");
        jPanel1.add(Sbdate);
        Sbdate.setBounds(30, 120, 120, 20);

        Date.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        Date.setForeground(new java.awt.Color(52, 45, 71));
        Date.setText("Day: ");
        jPanel1.add(Date);
        Date.setBounds(30, 160, 80, 15);

        day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayActionPerformed(evt);
            }
        });
        jPanel1.add(day);
        day.setBounds(80, 150, 110, 30);

        search2.setBackground(new java.awt.Color(38, 32, 54));
        search2.setForeground(new java.awt.Color(255, 255, 255));
        search2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/search_white.png"))); // NOI18N
        search2.setText("Search");
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
        search2.setBounds(90, 300, 90, 30);

        Employee.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 12)); // NOI18N
        Employee.setForeground(new java.awt.Color(52, 45, 71));
        Employee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Day", "Month", "Year", "Attendance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false
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

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(260, 70, 460, 350);

        Date1.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        Date1.setForeground(new java.awt.Color(52, 45, 71));
        Date1.setText("Month:");
        jPanel1.add(Date1);
        Date1.setBounds(30, 210, 80, 15);

        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthActionPerformed(evt);
            }
        });
        jPanel1.add(month);
        month.setBounds(80, 200, 110, 30);

        Date2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        Date2.setForeground(new java.awt.Color(52, 45, 71));
        Date2.setText("Year:");
        jPanel1.add(Date2);
        Date2.setBounds(30, 260, 80, 15);

        year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearActionPerformed(evt);
            }
        });
        jPanel1.add(year);
        year.setBounds(80, 250, 110, 30);

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(52, 45, 71));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/dashboard_32.png"))); // NOI18N
        jLabel2.setText("Dashboard");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(630, 10, 130, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayActionPerformed

    private void monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthActionPerformed

    private void yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearActionPerformed

    private void search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search2ActionPerformed
        int c;

        String d = day.getText();
        String m = month.getText();
        String D = year.getText();
        String date = D + "-" + m + "-" + d;

        try {

            pst = con.prepareStatement("SELECT Date_format(date, \"%d\") as day, "
                    + "Date_format(date, \"%M\") as month, Date_format(date, \"%Y\") as year,"
                    + " attendance\n"
                    + "from attendance where employee_id = ? and date = str_to_date(?,'%Y-%M-%d')");
            pst.setInt(1, emp);
            pst.setString(2, date);
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) Employee.getModel();
            dft.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("day"));
                    v2.add(rs.getString("month"));
                    v2.add(rs.getString("year"));
                    v2.add(rs.getString("attendance"));
                }

                dft.addRow(v2);

            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_search2ActionPerformed

    private void search2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search2MouseEntered
        // TODO add your handling code here:
                search2.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_search2MouseEntered

    private void search2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search2MouseExited
        // TODO add your handling code here:
                search2.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_search2MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        Dashboard db = new Dashboard();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Emp_AttendanceView(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    private javax.swing.JLabel Date1;
    private javax.swing.JLabel Date2;
    private javax.swing.JTable Employee;
    private javax.swing.JLabel Sbdate;
    private javax.swing.JTextField day;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField month;
    private javax.swing.JButton search2;
    private javax.swing.JTextField year;
    // End of variables declaration//GEN-END:variables
}
