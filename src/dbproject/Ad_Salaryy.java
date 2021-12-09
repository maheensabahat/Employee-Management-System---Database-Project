/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dbproject;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abc
 */
public class Ad_Salaryy extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    Database db;

    /**
     * Creates new form Ad_Salaryy
     */
    public Ad_Salaryy() {
        initComponents();
        error.setVisible(false);
        error3.setVisible(false);
        error4.setVisible(false);
        error5.setVisible(false);
        error6.setVisible(false);

        db = new Database();
        try {
            db.openConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Ad_Salaryy.class.getName()).log(Level.SEVERE, null, ex);
        }

        con = db.con;
        pst = db.pst;
        rs = db.rs;

        DateFormat df = new SimpleDateFormat("MMMMM yyyy");
        Date dateobj = new Date();
        date.setText(df.format(dateobj));

        tableupdate();
        sal.getTableHeader().setOpaque(true);
//        sal.getTableHeader().setBackground(new java.awt.Color(64, 56, 84));
        sal.getTableHeader().setFont(new java.awt.Font("Rockwell", 1, 10));
        sal.getTableHeader().setForeground(new java.awt.Color(52, 45, 71));
    }

    private void tableupdate() { //table updated after every change
        int c;
        try {

            ResultSet rs;
            //working employees record
            pst = con.prepareStatement("select employee_id from Employee"
                    + " where status = 'Working'");
            rs = pst.executeQuery();

            while (rs.next()) {
                int emp = Integer.parseInt(rs.getString("employee_id"));

                //generate attendance list
                //check if list for day not exists
                PreparedStatement pst1 = con.prepareStatement("select * from monthly_salary "
                        + "where Employee_ID = ? and date = Date_format(sysdate(), '%M %Y')");
                pst1.setInt(1, emp);
                ResultSet rs1 = pst1.executeQuery();

                //
                if (!rs1.next()) {
                    pst1 = con.prepareStatement("insert into monthly_salary(employee_id, date) "
                            + "values (?, Date_format(sysdate(),'%M %Y'))");
                    pst1.setInt(1, emp);
                    pst1.executeUpdate();
                }
            }

            pst = con.prepareStatement("SELECT s.Employee_ID, CONCAT_WS(\" \", e.first_name, e.last_name) as name,"
                    + " s.date, s.salary, s.bonus, s.travel_allowance, s.medical_allowance, e.status\n"
                    + "FROM monthly_salary s\n"
                    + "INNER JOIN Employee e using (Employee_ID) where status = 'Working'");
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) sal.getModel();
            dft.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("employee_id"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("date"));
                    v2.add(rs.getString("salary"));
                    v2.add(rs.getString("bonus"));
                    v2.add(rs.getString("travel_allowance"));
                    v2.add(rs.getString("medical_allowance"));
                }

                dft.addRow(v2);

            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    private void tableupdate2() { //table for this month
        int c;
        try {
            pst = con.prepareStatement("SELECT s.Employee_ID, CONCAT_WS(\" \", e.first_name, e.last_name) as name,"
                    + " s.date, s.salary, s.bonus, s.travel_allowance, s.medical_allowance, e.status\n"
                    + "FROM monthly_salary s\n"
                    + "INNER JOIN Employee e using (Employee_ID) where"
                    + " status = 'Working' and date =  Date_format(sysdate(),'%M %Y')");
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) sal.getModel();
            dft.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("employee_id"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("date"));
                    v2.add(rs.getString("salary"));
                    v2.add(rs.getString("bonus"));
                    v2.add(rs.getString("travel_allowance"));
                    v2.add(rs.getString("medical_allowance"));
                }

                dft.addRow(v2);

            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    private void setfieldsEmpty() {
        empid.setText("");
        salary.setText("");
        bonus.setText("");
        medical.setText("");
        travel.setText("");
        empid.requestFocus();

    }

    public boolean checkEmployeeExist(int emp) {
        try {
            pst = con.prepareStatement("select * from Employee where"
                    + " employee_ID = ? and status = 'Working'");
            pst.setInt(1, emp);
            rs = pst.executeQuery();

            if (!rs.isBeforeFirst()) { //employee not exists
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mark_Attendance2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private boolean checkfields() { //check if required fields are there
        if (empid.getText().equals("") || salary.getText().equals("")) {
            error.setVisible(true);

            if (empid.getText().trim().isEmpty()) {
                empid.grabFocus();
                return true;
            } else if (salary.getText().trim().isEmpty()) {
                System.out.println("y");
                salary.grabFocus();
                return true;
            }
        }
        return false;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        sal = new javax.swing.JTable();
        Salary_txt = new javax.swing.JLabel();
        emp_id_txt = new javax.swing.JLabel();
        empid = new javax.swing.JTextField();
        date_txt = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        base_salary = new javax.swing.JLabel();
        salary = new javax.swing.JTextField();
        bonus_txt = new javax.swing.JLabel();
        bonus = new javax.swing.JTextField();
        travel_allowance = new javax.swing.JLabel();
        travel = new javax.swing.JTextField();
        empID = new javax.swing.JLabel();
        emp = new javax.swing.JTextField();
        Update = new javax.swing.JButton();
        search1 = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        medical_allowance = new javax.swing.JLabel();
        medical = new javax.swing.JTextField();
        error3 = new javax.swing.JLabel();
        error4 = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        error5 = new javax.swing.JLabel();
        Today = new javax.swing.JButton();
        error6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);
        setPreferredSize(new java.awt.Dimension(775, 490));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(52, 45, 71));
        jPanel1.setLayout(null);

        sal.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 11)); // NOI18N
        sal.setForeground(new java.awt.Color(52, 45, 71));
        sal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Name", "Date", "Base Salary", "Bonus", "Travel Allowance", "Medical Allowance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sal.setFocusable(false);
        sal.setGridColor(new java.awt.Color(52, 45, 71));
        sal.setSelectionBackground(new java.awt.Color(130, 120, 158));
        sal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(sal);
        sal.setForeground(new java.awt.Color(52, 45, 71));

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(270, 100, 480, 310);

        Salary_txt.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        Salary_txt.setForeground(new java.awt.Color(52, 45, 71));
        Salary_txt.setText("Salary");
        jPanel1.add(Salary_txt);
        Salary_txt.setBounds(20, 10, 330, 43);

        emp_id_txt.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        emp_id_txt.setForeground(new java.awt.Color(52, 45, 71));
        emp_id_txt.setText("Employee ID:");
        jPanel1.add(emp_id_txt);
        emp_id_txt.setBounds(30, 100, 90, 20);

        empid.setEditable(false);
        empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empidActionPerformed(evt);
            }
        });
        empid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                empidKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                empidKeyTyped(evt);
            }
        });
        jPanel1.add(empid);
        empid.setBounds(30, 120, 90, 30);

        date_txt.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        date_txt.setForeground(new java.awt.Color(52, 45, 71));
        date_txt.setText("Date:");
        jPanel1.add(date_txt);
        date_txt.setBounds(130, 100, 90, 20);

        date.setEditable(false);
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });
        jPanel1.add(date);
        date.setBounds(130, 120, 110, 30);

        base_salary.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        base_salary.setForeground(new java.awt.Color(52, 45, 71));
        base_salary.setText("*Base Salary:");
        jPanel1.add(base_salary);
        base_salary.setBounds(30, 160, 120, 13);

        salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryActionPerformed(evt);
            }
        });
        jPanel1.add(salary);
        salary.setBounds(30, 180, 210, 30);

        bonus_txt.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        bonus_txt.setForeground(new java.awt.Color(52, 45, 71));
        bonus_txt.setText("Bonus:");
        jPanel1.add(bonus_txt);
        bonus_txt.setBounds(30, 220, 110, 13);

        bonus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bonusActionPerformed(evt);
            }
        });
        jPanel1.add(bonus);
        bonus.setBounds(30, 240, 210, 30);

        travel_allowance.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        travel_allowance.setForeground(new java.awt.Color(52, 45, 71));
        travel_allowance.setText("Travel allowance:");
        jPanel1.add(travel_allowance);
        travel_allowance.setBounds(30, 280, 100, 13);

        travel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                travelActionPerformed(evt);
            }
        });
        jPanel1.add(travel);
        travel.setBounds(30, 300, 210, 30);

        empID.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        empID.setForeground(new java.awt.Color(52, 45, 71));
        empID.setText("Employee ID:");
        jPanel1.add(empID);
        empID.setBounds(480, 70, 80, 13);

        emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empActionPerformed(evt);
            }
        });
        emp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                empKeyTyped(evt);
            }
        });
        jPanel1.add(emp);
        emp.setBounds(560, 60, 80, 30);

        Update.setBackground(new java.awt.Color(38, 32, 54));
        Update.setFont(new java.awt.Font("Rockwell", 0, 10)); // NOI18N
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/update.png"))); // NOI18N
        Update.setText("UPDATE");
        Update.setFocusable(false);
        Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UpdateMouseExited(evt);
            }
        });
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jPanel1.add(Update);
        Update.setBounds(90, 410, 100, 30);

        search1.setBackground(new java.awt.Color(38, 32, 54));
        search1.setForeground(new java.awt.Color(255, 255, 255));
        search1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/search_white.png"))); // NOI18N
        search1.setText("Search ");
        search1.setFocusable(false);
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
        search1.setBounds(650, 62, 90, 25);

        error.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error.setForeground(new java.awt.Color(255, 0, 51));
        error.setText("*enter required fields to proceed");
        jPanel1.add(error);
        error.setBounds(40, 380, 200, 40);

        medical_allowance.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        medical_allowance.setForeground(new java.awt.Color(52, 45, 71));
        medical_allowance.setText("Medical Allowance:");
        jPanel1.add(medical_allowance);
        medical_allowance.setBounds(30, 340, 110, 13);

        medical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicalActionPerformed(evt);
            }
        });
        jPanel1.add(medical);
        medical.setBounds(30, 360, 210, 30);

        error3.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error3.setForeground(new java.awt.Color(255, 0, 51));
        error3.setText("Salary for this month has been entered.");
        jPanel1.add(error3);
        error3.setBounds(30, 80, 240, 30);

        error4.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error4.setForeground(new java.awt.Color(255, 0, 51));
        error4.setText("Employee does not exists.");
        jPanel1.add(error4);
        error4.setBounds(30, 80, 220, 30);

        reset.setBackground(new java.awt.Color(38, 32, 54));
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("Reset Table");
        reset.setFocusable(false);
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
        reset.setBounds(650, 420, 100, 20);

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

        error5.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error5.setForeground(new java.awt.Color(255, 0, 51));
        error5.setText("Select a record from table to update.");
        jPanel1.add(error5);
        error5.setBounds(30, 390, 280, 20);

        Today.setBackground(new java.awt.Color(38, 32, 54));
        Today.setForeground(new java.awt.Color(255, 255, 255));
        Today.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/calendar.png"))); // NOI18N
        Today.setText("This Month");
        Today.setFocusPainted(false);
        Today.setFocusable(false);
        Today.setRequestFocusEnabled(false);
        Today.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TodayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TodayMouseExited(evt);
            }
        });
        Today.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TodayActionPerformed(evt);
            }
        });
        jPanel1.add(Today);
        Today.setBounds(270, 70, 130, 25);

        error6.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error6.setForeground(new java.awt.Color(255, 0, 51));
        error6.setText("Previous months salaries can't be changed.");
        jPanel1.add(error6);
        error6.setBounds(10, 80, 300, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 780, 500);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void salMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salMouseClicked
        error5.setVisible(false);
        error6.setVisible(false);
        error.setVisible(false);
        error3.setVisible(false);
        error4.setVisible(false);

        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) sal.getModel();
        int selectedIndex = sal.getSelectedRow();

        empid.setText(model.getValueAt(selectedIndex, 0).toString());
        date.setText(model.getValueAt(selectedIndex, 2).toString());
        if (model.getValueAt(selectedIndex, 3) != null) {
            salary.setText(model.getValueAt(selectedIndex, 3).toString());
        } else {
            salary.setText("");
        }
        if (model.getValueAt(selectedIndex, 4) != null) {
            bonus.setText(model.getValueAt(selectedIndex, 4).toString());
        } else {
            bonus.setText("");
        }
        if (model.getValueAt(selectedIndex, 5) != null) {
            travel.setText(model.getValueAt(selectedIndex, 5).toString());
        } else {
            travel.setText("");
        }
        if (model.getValueAt(selectedIndex, 6) != null) {
            medical.setText(model.getValueAt(selectedIndex, 6).toString());
        } else {
            medical.setText("");
        }

    }//GEN-LAST:event_salMouseClicked

    private void empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empidActionPerformed

    private void empidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_empidKeyTyped

    }//GEN-LAST:event_empidKeyTyped

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaryActionPerformed

    private void bonusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bonusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bonusActionPerformed

    private void travelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_travelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_travelActionPerformed

    private void empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empActionPerformed

    private void empKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_empKeyTyped
        // TODO add your handling code here:
        tableupdate();
        empid.setText("");
    }//GEN-LAST:event_empKeyTyped

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
        error3.setVisible(false);
        error4.setVisible(false);

        //req fields are there
        if (!checkfields()) {

            //gets Data of selected record from table
            DefaultTableModel model = (DefaultTableModel) sal.getModel();
            int selectedIndex = sal.getSelectedRow();

            String saldate = date.getText();
            DateFormat df = new SimpleDateFormat("MMMMM yyyy");
            Date dateobj = new Date();
            String toddate = (df.format(dateobj)).toString();
            System.out.println(toddate);

            Double bsal = Double.parseDouble(salary.getText());
            Double b = 0.0;
            Double TA = 0.0;
            Double MA = 0.0;
            if (!bonus.getText().isEmpty()) {
                b = Double.parseDouble(bonus.getText());
            }
            if (!medical.getText().isEmpty()) {
                MA = Double.parseDouble(medical.getText());
            }
            if (!travel.getText().isEmpty()) {
                TA = Double.parseDouble(travel.getText());
            }

            if (selectedIndex != -1) {
                try {
                    int id = Integer.parseInt(empid.getText());

                    if (saldate.equals(toddate)) {

                        try {

                            String query = "update Monthly_salary set Salary = ?, bonus = ?,"
                                    + " medical_allowance = ?, travel_allowance= ? "
                                    + "where Employee_ID = ? and date = Date_format(sysdate(),'%M %Y')";
                            pst = con.prepareStatement(query);
                            pst.setDouble(1, bsal);
                            pst.setDouble(2, b);
                            pst.setDouble(3, MA);
                            pst.setDouble(4, TA);
                            pst.setInt(5, id);
                            pst.executeUpdate();
                            pst.close();

                            //Table updated after edits
                            tableupdate2();

                        } catch (SQLIntegrityConstraintViolationException e) {
                            if (checkEmployeeExist(id)) {
                                error3.setVisible(true);
                            } else {
                                error4.setVisible(true);

                            }
                        } catch (SQLException ex) {
                            java.util.logging.Logger.getLogger(Admin_Employee.class
                                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(this, ex);
                        }

                        //fields set empty
                        setfieldsEmpty();
                        error.setVisible(false);
                    } else {
                        error6.setVisible(true);
                    }
                } catch (NumberFormatException ex) {
                    error.setVisible(true);
                }
            } else {
                error5.setVisible(true);
            }
        }

    }//GEN-LAST:event_UpdateActionPerformed

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
        // TODO add your handling code here:
        if (!emp.getText().isEmpty()) {
            try {
                int vemp = Integer.parseInt(emp.getText());

                try {
                    pst = con.prepareStatement("SELECT s.Employee_ID, CONCAT_WS(\"-\", e.first_name, e.last_name) as name,"
                            + " s.date, s.salary, s.bonus, s.travel_allowance, s.medical_allowance\n"
                            + "FROM monthly_salary s\n"
                            + "INNER JOIN Employee e using (Employee_ID) where employee_ID = ?");
                    pst.setInt(1, vemp);
                    rs = pst.executeQuery();

                    ResultSetMetaData rsd = rs.getMetaData();
                    DefaultTableModel dft = (DefaultTableModel) sal.getModel();
                    dft.setRowCount(0);

                    while (rs.next()) {
                        Vector v2 = new Vector();
                        v2.add(rs.getString("employee_id"));
                        v2.add(rs.getString("name"));
                        v2.add(rs.getString("date"));
                        v2.add(rs.getString("salary"));
                        v2.add(rs.getString("bonus"));
                        v2.add(rs.getString("travel_allowance"));
                        v2.add(rs.getString("medical_allowance"));
                        dft.addRow(v2);

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Admin_Employee.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            } catch (NumberFormatException ex) {
                empid.setText("");
            }
        }
    }//GEN-LAST:event_search1ActionPerformed

    private void medicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medicalActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        tableupdate();
        empid.setText("");
    }//GEN-LAST:event_resetActionPerformed

    private void UpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseExited
        // TODO add your handling code here:
        Update.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_UpdateMouseExited

    private void UpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseEntered
        // TODO add your handling code here:
        Update.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_UpdateMouseEntered

    private void search1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search1MouseEntered
        // TODO add your handling code here:
        search1.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_search1MouseEntered

    private void resetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseEntered
        // TODO add your handling code here:
        reset.setBackground(new java.awt.Color(79, 70, 102));

    }//GEN-LAST:event_resetMouseEntered

    private void search1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search1MouseExited
        // TODO add your handling code here:
        search1.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_search1MouseExited

    private void resetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseExited
        // TODO add your handling code here:
        reset.setBackground(new java.awt.Color(38, 32, 54));

    }//GEN-LAST:event_resetMouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        Dashboard db = new Dashboard();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void empidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_empidKeyPressed

    }//GEN-LAST:event_empidKeyPressed

    private void TodayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TodayMouseEntered
        // TODO add your handling code here:
        Today.setBackground(new java.awt.Color(79, 70, 102));
    }//GEN-LAST:event_TodayMouseEntered

    private void TodayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TodayMouseExited
        // TODO add your handling code here:
        Today.setBackground(new java.awt.Color(38, 32, 54));
    }//GEN-LAST:event_TodayMouseExited

    private void TodayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TodayActionPerformed
        tableupdate2();
    }//GEN-LAST:event_TodayActionPerformed

//    /**
//     * @param args the command line arguments
//     */
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
//
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Ad_Salaryy.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Ad_Salaryy.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Ad_Salaryy.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Ad_Salaryy.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Ad_Salaryy().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Salary_txt;
    private javax.swing.JButton Today;
    private javax.swing.JButton Update;
    private javax.swing.JLabel base_salary;
    private javax.swing.JTextField bonus;
    private javax.swing.JLabel bonus_txt;
    private javax.swing.JTextField date;
    private javax.swing.JLabel date_txt;
    private javax.swing.JTextField emp;
    private javax.swing.JLabel empID;
    private javax.swing.JLabel emp_id_txt;
    private javax.swing.JTextField empid;
    private javax.swing.JLabel error;
    private javax.swing.JLabel error3;
    private javax.swing.JLabel error4;
    private javax.swing.JLabel error5;
    private javax.swing.JLabel error6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField medical;
    private javax.swing.JLabel medical_allowance;
    private javax.swing.JButton reset;
    private javax.swing.JTable sal;
    private javax.swing.JTextField salary;
    private javax.swing.JButton search1;
    private javax.swing.JTextField travel;
    private javax.swing.JLabel travel_allowance;
    // End of variables declaration//GEN-END:variables
}
