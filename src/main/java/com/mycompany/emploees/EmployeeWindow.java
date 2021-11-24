package com.mycompany.emploees;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class EmployeeWindow extends javax.swing.JFrame {

    List<Employee> userList = new ArrayList<>();
    DepartmenController departmenController = new DepartmenController();

    private boolean dialogForEdit = false;

    public EmployeeWindow() {
        initComponents();
        sortTableUsers();
        departmenController.readDepartmenstFromFile();
        readUsersFromFile();
        updateTableDataUsers(userList);
        sortTableDepartments();
        updateTableDepartments(departmenController.departmentsList);

    }

    public int getNumberUsersFromDepartmen(Long id) {
        int num = 0;
        for (int i = 0; i < userList.size(); i++) {
            if (id == userList.get(i).departmentId) {
                num++;
            }

        }
        return num;
    }

    public Department getSelectDepartment() {

        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Not selected Department", "Title", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        int rowAfterSort = jTable2.getRowSorter().convertRowIndexToModel(selectedRow);

        if (rowAfterSort == -1) {
            return null;
        } else {
            if (selectedRow >= departmenController.departmentsList.size()) {
                return null;
            }

        }
        return departmenController.departmentsList.get(rowAfterSort);
    }

    public Employee getSelectUser() {

        int selectRow = jTable1.getSelectedRow();
        if (selectRow == -1) {
            JOptionPane.showMessageDialog(this, "Not selected User", "Title", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        int rowAfterSort = jTable1.getRowSorter().convertRowIndexToModel(selectRow);
        System.out.println("selectRow : " + selectRow);
        System.out.println("rowAfterSort : " + rowAfterSort);

        if (rowAfterSort == -1) {
            return null;
        } else if (selectRow >= userList.size()) {
            return null;
        }

        return userList.get(rowAfterSort);
    }

    public void sortTableDepartments() {
        jTable2.setRowSorter(new TableRowSorter<>(jTable2.getModel()));

        List<RowSorter.SortKey> sortKeys = new ArrayList<>(20);
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        jTable2.getRowSorter().setSortKeys(sortKeys);
    }

    public void updateTableDepartments(List<Department> list) {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        for (Department department : list) {
            model.addRow(new Object[]{department.departmentName, getNumberUsersFromDepartmen(department.departmentId), department.timeCreate});

        }
    }

    public void sortTableUsers() {
        jTable1.setRowSorter(new TableRowSorter<>(jTable1.getModel()));

        List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));//set sorting for column idx: 1 in jTable
        jTable1.getRowSorter().setSortKeys(sortKeys);
    }

    private void updateTableDataUsers(List<Employee> list) {
        //Temp add some rows to the table
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        //remove all rows
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        for (Employee employee : list) {
//            model.addRow(new Object[]{employee.name, departmenController.getDepartmentById(employee.departmentId).departmentName, employee.salary, employee.id});
        }

    }

    public void readUsersFromFile() {

        try {
            File toRead = new File("C:\\Users\\kamen\\Documents\\UserData.txt");
            Scanner myReader = new Scanner(toRead);
            String line;
            System.out.println("START READING USER");
            while (myReader.hasNextLine()) {
                line = myReader.nextLine();
                System.out.println("Read : " + line);
                try {
                    Employee readUser = new Employee(line);
                    userList.add(readUser);

                } catch (Exception ex) {
                    System.out.println("Error reading no save users");
                }
            }

            System.out.println("Succssesful reading. read users: " + userList.size());
            myReader.close();
            System.out.println("END READING USER");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
//        System.out.println("USER LIST : " + userList);
    }

    public void saveUsersToFile() {
        String toWrite = "";

        for (int i = 0; i < userList.size(); i++) {
            toWrite += userList.get(i) + "\n";
        }

        System.out.println("START WRITTING TO USERS");

        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\kamen\\Documents\\UserData.txt");
            System.out.println("Write: " + toWrite);
            myWriter.write(toWrite);
            myWriter.close();
        } catch (IOException ex) {
            System.out.println("An error occurred.");
        }

        System.out.println("Successfully wrote to the file. Total Users: " + userList.size());
        System.out.println("END WRITTING USERS");

        updateTableDataUsers(userList);
        updateTableDepartments(departmenController.departmentsList);
    }

    public void updateJComboBox() {
        jComboBox1.removeAllItems();
        for (int i = 0; i < departmenController.departmentsList.size(); i++) {
            jComboBox1.addItem(departmenController.departmentsList.get(i).departmentName);
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

        jDialogEditUser = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldSalary = new javax.swing.JTextField();
        jTextFieldName = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButtonAddNewDepartment = new javax.swing.JButton();
        jDialogDepartment = new javax.swing.JDialog();
        jTextFieldDepartmentName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonAddDepartment = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButtonEditDepartment = new javax.swing.JButton();
        jButton2Edit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextFieldSearch = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jDialogEditUser.setMinimumSize(new java.awt.Dimension(600, 300));
        jDialogEditUser.setModal(true);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("NAME");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("DEPARTMENT");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("SALARY");

        jButton2.setText("SAVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setToolTipText("\"NOT SECECTED\"");
        jComboBox1.setName(""); // NOI18N
        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeVisible(evt);
            }
        });

        jButtonAddNewDepartment.setText("ADD NEW ");
        jButtonAddNewDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddNewDepartmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogEditUserLayout = new javax.swing.GroupLayout(jDialogEditUser.getContentPane());
        jDialogEditUser.getContentPane().setLayout(jDialogEditUserLayout);
        jDialogEditUserLayout.setHorizontalGroup(
            jDialogEditUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEditUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogEditUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogEditUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(jDialogEditUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldSalary)
                        .addComponent(jTextFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                    .addGroup(jDialogEditUserLayout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAddNewDepartment)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jDialogEditUserLayout.setVerticalGroup(
            jDialogEditUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEditUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogEditUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jDialogEditUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddNewDepartment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogEditUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        jDialogDepartment.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jDialogDepartment.setMinimumSize(new java.awt.Dimension(600, 500));
        jDialogDepartment.setModal(true);
        jDialogDepartment.setPreferredSize(new java.awt.Dimension(400, 160));

        jLabel4.setText("Enter New Name");

        jButtonAddDepartment.setText("SAVE");
        jButtonAddDepartment.setMinimumSize(new java.awt.Dimension(59, 25));
        jButtonAddDepartment.setPreferredSize(new java.awt.Dimension(59, 25));
        jButtonAddDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddDepartmentActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Department Name", "Number of Employees", "ID"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButtonEditDepartment.setText("EDIT");
        jButtonEditDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditDepartmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogDepartmentLayout = new javax.swing.GroupLayout(jDialogDepartment.getContentPane());
        jDialogDepartment.getContentPane().setLayout(jDialogDepartmentLayout);
        jDialogDepartmentLayout.setHorizontalGroup(
            jDialogDepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogDepartmentLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogDepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldDepartmentName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialogDepartmentLayout.createSequentialGroup()
                        .addComponent(jButtonEditDepartment)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAddDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
        );
        jDialogDepartmentLayout.setVerticalGroup(
            jDialogDepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogDepartmentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDialogDepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDepartmentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogDepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEditDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                formAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });

        jButton2Edit.setText("EDIT USER");
        jButton2Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2EditActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "DEPARTMENT", "SALARY", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButton1.setText("DELETE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("NEW USER");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });

        jLabel6.setText("SEARCH");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jButton3)
                        .addGap(125, 125, 125)
                        .addComponent(jButton2Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(179, 179, 179)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2EditActionPerformed
        System.out.println("Edit button");
        dialogForEdit = true;
        Employee selectUser = getSelectUser();
        if (selectUser != null) {
            updateJComboBox();
            jTextFieldName.setText(selectUser.name);
            jTextFieldSalary.setText(String.valueOf(selectUser.salary));

            jDialogEditUser.setVisible(true);
        }

    }//GEN-LAST:event_jButton2EditActionPerformed

    private void formAncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorMoved

    }//GEN-LAST:event_formAncestorMoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (getSelectUser() != null) {
            userList.remove(getSelectUser());
            saveUsersToFile();
            updateTableDataUsers(userList);
            updateTableDepartments(departmenController.departmentsList);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    @SuppressWarnings("empty-statement")
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (dialogForEdit) {
            try {
                // when saving edited user
                Employee selectUser = getSelectUser();
                selectUser.name = jTextFieldName.getText();
                selectUser.departmentId = departmenController.getDepartmentByName(jComboBox1.getSelectedItem().toString());
                selectUser.salary = Integer.valueOf(jTextFieldSalary.getText());
                jDialogEditUser.setVisible(false);
                saveUsersToFile();
//                updateTableDepartments(departmenController.departmentsList);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Greshno 4islo brat", "Title", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            // when save new user
            System.out.println("SAVE BUTTON");
            Employee user = new Employee();
            user.name = jTextFieldName.getText();
            user.departmentId = departmenController.getDepartmentByName(jComboBox1.getSelectedItem().toString());
            user.salary = Integer.valueOf(jTextFieldSalary.getText());
            userList.add(user);
            System.out.println("INPUT: " + user.decodeUser());
            System.out.println("Size of List: " + userList.size());
            jDialogEditUser.setVisible(false);
            saveUsersToFile();
//            updateTableDepartments(departmenController.departmentsList);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dialogForEdit = false;
        jTextFieldName.setText("");
        jTextFieldSalary.setText(String.valueOf(""));
        updateJComboBox();
        jDialogEditUser.setVisible(true);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeVisible


    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeVisible

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        String searchText = jTextFieldSearch.getText();

        RowFilter<DefaultTableModel, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter(jTextFieldSearch.getText(), 0);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        TableRowSorter<DefaultTableModel> rowSorter = (TableRowSorter<DefaultTableModel>) jTable1.getRowSorter();
        rowSorter.setRowFilter(rf);

    }//GEN-LAST:event_jTextFieldSearchKeyReleased

    private void jButtonAddNewDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddNewDepartmentActionPerformed
        jDialogDepartment.setVisible(true);
        updateTableDepartments(departmenController.departmentsList);


    }//GEN-LAST:event_jButtonAddNewDepartmentActionPerformed

    private void jButtonAddDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddDepartmentActionPerformed

        
        
        for (int i = 0; i < departmenController.departmentsList.size(); i++) {
            if (departmenController.departmentsList.get(i).departmentName.equals(jTextFieldDepartmentName.getText())) {
                JOptionPane.showMessageDialog(this, "Name exist", "Title", JOptionPane.WARNING_MESSAGE);
                jTextFieldDepartmentName.setText("");
            }
            break;
        }
        if (!jTextFieldDepartmentName.getText().isEmpty()) {

            Department newDepartment = new Department();
            newDepartment.departmentName = jTextFieldDepartmentName.getText();
            departmenController.departmentsList.add(newDepartment);
            departmenController.saveToDepartmentsFile();
            jDialogDepartment.setVisible(false);
            updateJComboBox();
        }
        jTextFieldDepartmentName.setText("");
        updateTableDepartments(departmenController.departmentsList);
    }//GEN-LAST:event_jButtonAddDepartmentActionPerformed

    private void jButtonEditDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditDepartmentActionPerformed

        jTextFieldDepartmentName.setText(getSelectDepartment().departmentName);

    }//GEN-LAST:event_jButtonEditDepartmentActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton2Edit;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAddDepartment;
    private javax.swing.JButton jButtonAddNewDepartment;
    private javax.swing.JButton jButtonEditDepartment;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDialog jDialogDepartment;
    private javax.swing.JDialog jDialogEditUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextFieldDepartmentName;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldSalary;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}
