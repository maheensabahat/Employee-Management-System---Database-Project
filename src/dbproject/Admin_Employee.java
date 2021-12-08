package dbproject;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Hp
 */
public class Admin_Employee extends javax.swing.JFrame {
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Database db;
    
    public Admin_Employee() throws SQLException {
        initComponents();
        
        error.setVisible(false);
        error1.setVisible(false);
        error2.setVisible(false);
        error3.setVisible(false);
        error4.setVisible(false);
        
        db = new Database();
        db.openConnection();
        
        con = db.con;
        pst = db.pst;
        rs = db.rs;
        
        tableupdate();

        //38, 32, 54
//        Employee.getTableHeader().setOpaque(true);
//        Employee.getTableHeader().setBackground(new java.awt.Color(64, 56, 84));
        Employee.getTableHeader().setFont(new java.awt.Font("Rockwell", 1, 10));
        Employee.getTableHeader().setForeground(new java.awt.Color(52, 45, 71));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Employee = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        first_name = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        first_name1 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        first_name2 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        first_name3 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        first_name4 = new javax.swing.JLabel();
        bankacc = new javax.swing.JTextField();
        first_name6 = new javax.swing.JLabel();
        hiredate = new javax.swing.JTextField();
        first_name7 = new javax.swing.JLabel();
        deptid = new javax.swing.JTextField();
        first_name8 = new javax.swing.JLabel();
        empID = new javax.swing.JLabel();
        empid = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        add = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        search = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        error = new javax.swing.JLabel();
        error1 = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        error2 = new javax.swing.JLabel();
        error3 = new javax.swing.JLabel();
        error4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(755, 520));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(744, 490));
        jPanel1.setLayout(null);

        Employee.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 12)); // NOI18N
        Employee.setForeground(new java.awt.Color(52, 45, 71));
        Employee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "First Name", "Last Name", "Email", "Department", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Employee.setGridColor(new java.awt.Color(52, 45, 71));
        Employee.setSelectionBackground(new java.awt.Color(130, 120, 158));
        Employee.getTableHeader().setReorderingAllowed(false);
        Employee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmployeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Employee);
        if (Employee.getColumnModel().getColumnCount() > 0) {
            Employee.getColumnModel().getColumn(0).setResizable(false);
            Employee.getColumnModel().getColumn(1).setResizable(false);
            Employee.getColumnModel().getColumn(2).setResizable(false);
            Employee.getColumnModel().getColumn(3).setResizable(false);
            Employee.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(289, 90, 430, 340);

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 45, 71));
        jLabel1.setText("Employee");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 10, 180, 43);

        first_name.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        first_name.setForeground(new java.awt.Color(52, 45, 71));
        first_name.setText("*First Name:");
        jPanel1.add(first_name);
        first_name.setBounds(30, 70, 100, 20);

        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        jPanel1.add(fname);
        fname.setBounds(30, 90, 110, 30);

        first_name1.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        first_name1.setForeground(new java.awt.Color(52, 45, 71));
        first_name1.setText("*Last Name:");
        jPanel1.add(first_name1);
        first_name1.setBounds(150, 70, 100, 20);

        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        jPanel1.add(lname);
        lname.setBounds(150, 90, 120, 30);

        first_name2.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        first_name2.setForeground(new java.awt.Color(52, 45, 71));
        first_name2.setText("Email:");
        jPanel1.add(first_name2);
        first_name2.setBounds(30, 120, 100, 20);

        email.setEditable(false);
        email.setFocusable(false);
        email.setRequestFocusEnabled(false);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel1.add(email);
        email.setBounds(30, 140, 245, 30);

        first_name3.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        first_name3.setForeground(new java.awt.Color(52, 45, 71));
        first_name3.setText("*Address:");
        jPanel1.add(first_name3);
        first_name3.setBounds(30, 170, 100, 20);

        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        jPanel1.add(address);
        address.setBounds(30, 190, 245, 30);

        first_name4.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        first_name4.setForeground(new java.awt.Color(52, 45, 71));
        first_name4.setText("*Bank Account:");
        jPanel1.add(first_name4);
        first_name4.setBounds(30, 220, 100, 20);

        bankacc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankaccActionPerformed(evt);
            }
        });
        bankacc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bankaccKeyPressed(evt);
            }
        });
        jPanel1.add(bankacc);
        bankacc.setBounds(30, 240, 245, 30);

        first_name6.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        first_name6.setForeground(new java.awt.Color(52, 45, 71));
        first_name6.setText("Hiredate:");
        jPanel1.add(first_name6);
        first_name6.setBounds(30, 320, 100, 20);

        hiredate.setEditable(false);
        hiredate.setFocusable(false);
        hiredate.setRequestFocusEnabled(false);
        hiredate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hiredateActionPerformed(evt);
            }
        });
        jPanel1.add(hiredate);
        hiredate.setBounds(30, 340, 245, 30);

        first_name7.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        first_name7.setForeground(new java.awt.Color(52, 45, 71));
        first_name7.setText("Department ID:");
        jPanel1.add(first_name7);
        first_name7.setBounds(30, 270, 100, 20);

        deptid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptidActionPerformed(evt);
            }
        });
        deptid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                deptidKeyPressed(evt);
            }
        });
        jPanel1.add(deptid);
        deptid.setBounds(30, 290, 245, 30);

        first_name8.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        first_name8.setForeground(new java.awt.Color(52, 45, 71));
        first_name8.setText("*Password:");
        jPanel1.add(first_name8);
        first_name8.setBounds(30, 370, 100, 20);

        empID.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        empID.setForeground(new java.awt.Color(52, 45, 71));
        empID.setText("Employee ID:");
        jPanel1.add(empID);
        empID.setBounds(290, 70, 80, 14);

        empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empidActionPerformed(evt);
            }
        });
        jPanel1.add(empid);
        empid.setBounds(370, 55, 80, 30);

        delete.setBackground(new java.awt.Color(38, 32, 54));
        delete.setFont(new java.awt.Font("Rockwell", 1, 9)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/delete.png"))); // NOI18N
        delete.setText("Delete");
        delete.setFocusable(false);
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteMouseExited(evt);
            }
        });
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel1.add(delete);
        delete.setBounds(192, 440, 86, 30);

        add.setBackground(new java.awt.Color(38, 32, 54));
        add.setFont(new java.awt.Font("Rockwell", 1, 9)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/add_new.png"))); // NOI18N
        add.setText("Add");
        add.setFocusable(false);
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add);
        add.setBounds(29, 440, 70, 30);

        Update.setBackground(new java.awt.Color(38, 32, 54));
        Update.setFont(new java.awt.Font("Rockwell", 1, 9)); // NOI18N
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/update.png"))); // NOI18N
        Update.setText("Update");
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
        Update.setBounds(102, 440, 87, 30);

        search.setBackground(new java.awt.Color(38, 32, 54));
        search.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        search.setForeground(java.awt.Color.white);
        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/search_white.png"))); // NOI18N
        search.setText("Search");
        search.setFocusable(false);
        search.setRequestFocusEnabled(false);
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchMouseExited(evt);
            }
        });
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search);
        search.setBounds(460, 57, 90, 25);
        jPanel1.add(password);
        password.setBounds(30, 390, 245, 30);

        error.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        error.setForeground(new java.awt.Color(255, 0, 51));
        error.setText("numeric values are accepted only");
        jPanel1.add(error);
        error.setBounds(114, 265, 200, 30);

        error1.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error1.setForeground(new java.awt.Color(255, 0, 51));
        error1.setText("*enter required fields to proceed");
        jPanel1.add(error1);
        error1.setBounds(40, 418, 200, 30);

        reset.setBackground(new java.awt.Color(38, 32, 54));
        reset.setFont(new java.awt.Font("Rockwell", 0, 10)); // NOI18N
        reset.setForeground(java.awt.Color.white);
        reset.setText("Reset Table");
        reset.setFocusPainted(false);
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
        reset.setBounds(620, 435, 100, 20);

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
        jLabel2.setBounds(600, 10, 130, 40);

        error2.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        error2.setForeground(new java.awt.Color(255, 0, 51));
        error2.setText("Invalid Department ID");
        jPanel1.add(error2);
        error2.setBounds(114, 265, 200, 30);

        error3.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error3.setForeground(new java.awt.Color(255, 0, 51));
        error3.setText("Select a record from table to delete/update.");
        jPanel1.add(error3);
        error3.setBounds(28, 418, 280, 30);

        error4.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        error4.setForeground(new java.awt.Color(255, 0, 51));
        error4.setText(" Invalid Bank Account.");
        jPanel1.add(error4);
        error4.setBounds(110, 210, 200, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void bankaccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankaccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bankaccActionPerformed

    private void hiredateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hiredateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hiredateActionPerformed

    private void deptidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deptidActionPerformed

    private void empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empidActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        //req fields are there
        if (!checkfields()) {

            //gets Data of selected record from table
            DefaultTableModel model = (DefaultTableModel) Employee.getModel();
            int selectedIndex = Employee.getSelectedRow();
            
            if (Employee.getSelectedRow() != -1) {

                //emp id of selected record, used to update record
                int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
                String s = model.getValueAt(selectedIndex, 5).toString();
                
                if (s.equals("Working")) {
                    String Fname = fname.getText().trim();
                    Fname = Fname.substring(0, 1).toUpperCase() + Fname.substring(1).toLowerCase();
                    String Lname = lname.getText().trim();
                    Lname = Lname.substring(0, 1).toUpperCase() + Lname.substring(1).toLowerCase();
                    String Email = email.getText();
                    String add = address.getText();
                    String bacc = bankacc.getText().toUpperCase();
                    if (validBankAccount(bacc)) {
                        String pw = password.getText();
                        try {
                            int dept = Integer.parseInt(deptid.getText());
                            
                            try {
                                
                                String query = "update Employee set first_name = ?, last_name = ?,"
                                        + " address = ?, Bank_account = ?, password = ?, "
                                        + "department_id = ? where Employee_ID = ?";
                                pst = con.prepareStatement(query);
                                pst.setString(1, Fname);
                                pst.setString(2, Lname);
                                pst.setString(3, add);
                                pst.setString(4, bacc);
                                pst.setString(5, pw);
                                pst.setInt(6, dept);
                                pst.setInt(7, id);
                                pst.executeUpdate();

                                //Table updated after edits
                                tableupdate();

                                //fields set empty
                                setfieldsEmpty();
                                error.setVisible(false);
                                
                            } catch (SQLIntegrityConstraintViolationException e) {
                                error2.setVisible(true);
                            } catch (SQLException ex) {
                                java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(this, ex);
                            }
                            
                        } catch (NumberFormatException ex) {
                            error.setVisible(true);
                        }
                    } else {
                        error4.setVisible(true);
                    }
                } else {
                    setfieldsEmpty();
                }
            } else {
                error3.setVisible(true);
            }
        }
    }//GEN-LAST:event_UpdateActionPerformed
    
    private boolean checkfields() { //check if required fields are there
        if (fname.getText().equals("") || lname.getText().equals("")
                || password.getText().equals("") || address.getText().equals("")
                || bankacc.getText().equals("")) {
            error1.setVisible(true);
            
            if (fname.getText().trim().isEmpty()) {
                fname.grabFocus();
                return true;
            } else if (lname.getText().trim().isEmpty()) {
                lname.grabFocus();
                return true;
            } else if (address.getText().trim().isEmpty()) {
                address.grabFocus();
                return true;
            } else if (bankacc.getText().trim().isEmpty()) {
                bankacc.grabFocus();
                return true;
            } else if (password.getText().trim().isEmpty()) {
                password.grabFocus();
                return true;
            }
        }
        
        return false;
        
    }
    
    private boolean validBankAccount(String ba) {
        if (ba.length() != 9) {
            return false;
        } else {
            for (int i = 0; i < 2; i++) {
                if (!Character.isLetter(ba.charAt(i))) {
                    return false;
                }
            }
            for (int i = 2; i < ba.length(); i++) {
                if (!Character.isDigit(ba.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void tableupdate() { //table updated after every change
        int c;
        try {
            
            pst = con.prepareStatement("select employee_id, first_name, last_name,"
                    + " email,department_id, status from Employee");
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
                    v2.add(rs.getString("email"));
                    v2.add(rs.getString("department_id"));
                    v2.add(rs.getString("status"));
                }
                
                dft.addRow(v2);
                
            }
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }
    
    private void setfieldsEmpty() {
        fname.setText("");
        lname.setText("");
        email.setText("");
        password.setText("");
        address.setText("");
        bankacc.setText("");
        hiredate.setText("");
        deptid.setText("");
        fname.requestFocus();
        
    }

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        //req fields are there
        if (!checkfields()) {
            
            String Fname = fname.getText().trim();
            Fname = Fname.substring(0, 1).toUpperCase() + Fname.substring(1).toLowerCase();
            String Lname = lname.getText().trim();
            Lname = Lname.substring(0, 1).toUpperCase() + Lname.substring(1).toLowerCase();
            String Email = Fname.toLowerCase() + "." + Lname.toLowerCase() + "@emp.com.pk";
            String add = address.getText();
            String bacc = bankacc.getText().toUpperCase();
            if (validBankAccount(bacc)) {
                String pw = password.getText();
                try {
                    int dept = 0;
                    String query = "";
                    boolean x;
                    if (!deptid.getText().isEmpty()) {
                        dept = Integer.parseInt(deptid.getText());
                        query = "insert into Employee(first_name, last_name, address, "
                                + "email, bank_account, password, status, department_id)"
                                + " values(?,?,?,?,?,?,?,?)";
                        x = true;
                    } else {
                        query = "insert into Employee(first_name, last_name, address, "
                                + "email, bank_account, password, status)"
                                + " values(?,?,?,?,?,?,?)";
                        x = false;
                    }
                    try {
                        
                        pst = con.prepareStatement(query);
                        pst.setString(1, Fname);
                        pst.setString(2, Lname);
                        pst.setString(3, add);
                        pst.setString(4, Email);
                        pst.setString(5, bacc);
                        pst.setString(6, pw);
                        pst.setString(7, "Working");
                        if (x) {
                            pst.setInt(8, dept);
                            
                        }
                        
                        pst.execute();
                        pst.close();

                        //Table updates after insertion
                        tableupdate();
                        
                    } catch (SQLIntegrityConstraintViolationException e) {
                        error2.setVisible(true);
                        
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(Admin_Employee.class
                                .getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, ex);
                    }

                    //fields are set empty again
                    setfieldsEmpty();
                    error.setVisible(false);
                    
                } catch (NumberFormatException ex) {
                    error.setVisible(true);
                }
            } else {
                error4.setVisible(true);
            }
        }
    }//GEN-LAST:event_addActionPerformed

    private void EmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeMouseClicked
        error1.setVisible(false);
        error2.setVisible(false);
        error3.setVisible(false);

        //setting text fields as a record is selected
        DefaultTableModel model = (DefaultTableModel) Employee.getModel();
        int selectedIndex = Employee.getSelectedRow();
        
        int emp = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        fname.setText(model.getValueAt(selectedIndex, 1).toString());
        lname.setText(model.getValueAt(selectedIndex, 2).toString());
        email.setText(model.getValueAt(selectedIndex, 3).toString());
        if (model.getValueAt(selectedIndex, 4) == null) {
            deptid.setText("");
        } else {
            deptid.setText(model.getValueAt(selectedIndex, 4).toString());
        }

        //bring other fields from table
        try {
            pst = con.prepareStatement("select * from Employee where employee_ID = ?");
            pst.setInt(1, emp);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                address.setText(rs.getString("address"));
                bankacc.setText(rs.getString("bank_account"));
                hiredate.setText(rs.getString("hire_date"));
                password.setText(rs.getString("password"));
                deptid.setText(rs.getString("Department_ID"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Employee.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EmployeeMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        //gets Data of selected record from table
        DefaultTableModel model = (DefaultTableModel) Employee.getModel();
        int selectedIndex = Employee.getSelectedRow();
        
        if (Employee.getSelectedRow() != -1) {
            //emp id of selected record, used to update record
            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
            String s = model.getValueAt(selectedIndex, 5).toString();
            
            if (s.equals("Working")) {
                Object[] options1 = {"Left?", "Fired?", "Cancel"};
                
                int dialogresult = JOptionPane.showOptionDialog(null, "How did the employee leave?",
                        "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null,
                        options1,
                        null);
                
                String status = "";
                if (dialogresult == 0) {
                    status = "Left";
                } else if (dialogresult == 1) {
                    status = "Fired";
                }
                if (dialogresult != 2) {
                    try {
                        
                        String query = "update Employee set status = ?"
                                + "where Employee_ID = ?";
                        pst = con.prepareStatement(query);
                        pst.setString(1, status);
                        pst.setInt(2, id);
                        pst.executeUpdate();
                        pst.close();
                        
                        query = "update department set manager_id = Null "
                                + "where manager_ID = ?";
                        pst = con.prepareStatement(query);
                        pst.setInt(1, id);
                        pst.executeUpdate();
                        pst.close();
                        JOptionPane.showMessageDialog(this, "Employee status updated.");

                        //Table updated after edits
                        tableupdate();
                        
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, ex);
                    }
                }
                setfieldsEmpty();
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        if (!empid.getText().isEmpty()) {
            try {
                int emp = Integer.parseInt(empid.getText());
                
                try {
                    pst = con.prepareStatement("select * from Employee where employee_ID = ?");
                    pst.setInt(1, emp);
                    rs = pst.executeQuery();
                    
                    ResultSetMetaData rsd = rs.getMetaData();
                    DefaultTableModel dft = (DefaultTableModel) Employee.getModel();
                    dft.setRowCount(0);
                    
                    if (rs.next()) {
                        Vector v2 = new Vector();
                        v2.add(rs.getString("employee_id"));
                        v2.add(rs.getString("first_name"));
                        v2.add(rs.getString("last_name"));
                        v2.add(rs.getString("email"));
                        v2.add(rs.getString("department_id"));
                        v2.add(rs.getString("status"));
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
    }//GEN-LAST:event_searchActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        tableupdate();
        empid.setText("");
    }//GEN-LAST:event_resetActionPerformed

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        add.setBackground(new java.awt.Color(79, 70, 102));
    }//GEN-LAST:event_addMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        add.setBackground(new java.awt.Color(38, 32, 54));
    }//GEN-LAST:event_addMouseExited

    private void UpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseEntered
        Update.setBackground(new java.awt.Color(79, 70, 102));
    }//GEN-LAST:event_UpdateMouseEntered

    private void deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseEntered
        delete.setBackground(new java.awt.Color(79, 70, 102));
    }//GEN-LAST:event_deleteMouseEntered

    private void UpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseExited
        Update.setBackground(new java.awt.Color(38, 32, 54));
    }//GEN-LAST:event_UpdateMouseExited

    private void deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseExited
        delete.setBackground(new java.awt.Color(38, 32, 54));
    }//GEN-LAST:event_deleteMouseExited

    private void searchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseEntered
        search.setBackground(new java.awt.Color(79, 70, 102));
    }//GEN-LAST:event_searchMouseEntered

    private void searchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseExited
        search.setBackground(new java.awt.Color(38, 32, 54));
    }//GEN-LAST:event_searchMouseExited

    private void resetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseEntered
        reset.setBackground(new java.awt.Color(79, 70, 102));
    }//GEN-LAST:event_resetMouseEntered

    private void resetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseExited
        reset.setBackground(new java.awt.Color(38, 32, 54));
    }//GEN-LAST:event_resetMouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        Dashboard db = new Dashboard();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void deptidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deptidKeyPressed
        error1.setVisible(false);
        error2.setVisible(false);
    }//GEN-LAST:event_deptidKeyPressed

    private void bankaccKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bankaccKeyPressed
        error4.setVisible(false);
    }//GEN-LAST:event_bankaccKeyPressed

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
//
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Admin_Employee.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Admin_Employee.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Admin_Employee.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Admin_Employee.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new Admin_Employee().setVisible(true);
//
//                } catch (SQLException ex) {
//                    Logger.getLogger(Admin_Employee.class
//                            .getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Employee;
    private javax.swing.JButton Update;
    private javax.swing.JButton add;
    private javax.swing.JTextField address;
    private javax.swing.JTextField bankacc;
    private javax.swing.JButton delete;
    private javax.swing.JTextField deptid;
    private javax.swing.JTextField email;
    private javax.swing.JLabel empID;
    private javax.swing.JTextField empid;
    private javax.swing.JLabel error;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel error2;
    private javax.swing.JLabel error3;
    private javax.swing.JLabel error4;
    private javax.swing.JLabel first_name;
    private javax.swing.JLabel first_name1;
    private javax.swing.JLabel first_name2;
    private javax.swing.JLabel first_name3;
    private javax.swing.JLabel first_name4;
    private javax.swing.JLabel first_name6;
    private javax.swing.JLabel first_name7;
    private javax.swing.JLabel first_name8;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField hiredate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lname;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton reset;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
