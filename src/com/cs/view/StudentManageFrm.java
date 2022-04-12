package com.cs.view;

import com.cs.dao.StudentDao;
import com.cs.model.Student;
import com.cs.util.DbUtil;
import com.cs.util.StringUtil;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class StudentManageFrm extends JInternalFrame {
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTable studentTable;
    private JTextField s_studentNameTxt;
    private JTextField s_yearsTxt;
    private JRadioButton manJrb;
    private JRadioButton femaleJrb;
    private DbUtil dbUtil = new DbUtil();
    private StudentDao studentDao = new StudentDao();
    private JTextField idTxt;
    private JTextField studentNameTxt;
    private JTextField heightTxt;
    private JTextArea studentPsTxt;
    private JTextField yearTxt;

    /**
     * Create the frame.
     */
    public StudentManageFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u5b66\u751f\u4fe1\u606f\u7ef4\u62a4");
        setBounds(100, 100, 677, 500);

        JScrollPane scrollPane = new JScrollPane();

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.LEADING, false)
                                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(scrollPane)))
                                .addContainerGap(66, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(28)
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                .addContainerGap())
        );
        JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");

        idTxt = new JTextField();
        idTxt.setEditable(false);
        idTxt.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u5b66\u751f\u59d3\u540d\uff1b");

        studentNameTxt = new JTextField();
        studentNameTxt.setColumns(10);

        JLabel label_3 = new JLabel("\u5b66\u751f\u6027\u522b\uff1a");

        manJrb = new JRadioButton("\u7537");
        buttonGroup.add(manJrb);
        manJrb.setSelected(true);

        femaleJrb = new JRadioButton("\u5973");
        buttonGroup.add(femaleJrb);

        JLabel label_4 = new JLabel("\u8eab\u9ad8\uff1a");

        heightTxt = new JTextField();
        heightTxt.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("\u5b66\u751f\u5e74\u9f84\uff1a");

        yearTxt = new JTextField();
        yearTxt.setColumns(10);

        JLabel label_5 = new JLabel("");

        JLabel noUse = new JLabel("");

        JLabel label_6 = new JLabel("\u5b66\u751f\u5907\u6ce8\uff1a");

        studentPsTxt = new JTextArea();

        JButton button_1 = new JButton("\u4FEE\u6539");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                studentUpdateActionPerformed(evt);
            }
        });
        button_1.setIcon(new ImageIcon(StudentManageFrm.class.getResource("/images/modify.png")));

        JButton button_2 = new JButton("\u5220\u9664");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                studentDeleteActionPerformed(evt);
            }
        });
        button_2.setIcon(new ImageIcon(StudentManageFrm.class.getResource("/images/delete.png")));
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(19)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addComponent(button_1)
                                                .addGap(18)
                                                .addComponent(button_2)
                                                .addGap(386))
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                                .addComponent(label_6)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(studentPsTxt))
                                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
                                                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                                                .addComponent(label_4)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(heightTxt))
                                                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                                                .addComponent(lblNewLabel)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(26)
                                                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
                                                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_1)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(studentNameTxt, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_2)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(yearTxt)))
                                                                .addGap(26)
                                                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
                                                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                                                .addComponent(label_3)
                                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                .addComponent(manJrb)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(femaleJrb))
                                                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                                                .addComponent(label_5)
                                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                .addComponent(noUse, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                                .addContainerGap(86, Short.MAX_VALUE))))
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(21)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(studentNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_3)
                                        .addComponent(manJrb)
                                        .addComponent(femaleJrb))
                                .addGap(18)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label_4)
                                        .addComponent(heightTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(yearTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_5)
                                        .addComponent(noUse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                        .addComponent(label_6)
                                        .addComponent(studentPsTxt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(button_1)
                                        .addComponent(button_2)))
        );
        panel_1.setLayout(gl_panel_1);
        JLabel label = new JLabel("\u5b66\u751f\u59d3\u540d\uff1a");

        s_studentNameTxt = new JTextField();
        s_studentNameTxt.setColumns(10);

        JLabel label_1 = new JLabel("\u5b66\u751f\u5e74\u9f84\uff1a");

        s_yearsTxt = new JTextField();

        s_yearsTxt.setColumns(10);

        JLabel label_2 = new JLabel("");//图书类别，下同

        JLabel s_studentTypeJcb = new JLabel("");

        JButton button = new JButton("\u67E5\u8BE2");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                studentSearchActionPerformed(e);
            }
        });
        button.setIcon(new ImageIcon(StudentManageFrm.class.getResource("/images/search.png")));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGap(19)
                                .addComponent(label)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(s_studentNameTxt, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(label_1)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(s_yearsTxt, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(label_2)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(s_studentTypeJcb, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(button)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label)
                                        .addComponent(s_studentNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_1)
                                        .addComponent(s_yearsTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_2)
                                        .addComponent(s_studentTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button))
                                .addGap(16))
        );
        panel.setLayout(gl_panel);


        studentTable = new JTable();
        studentTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent met) {
                studentTableMousePressed(met);
            }
        });
        scrollPane.setViewportView(studentTable);
        studentTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "\u7F16\u53F7", "\u5b66\u751f\u59d3\u540d", "\u5b66\u751f\u5e74\u9f84", "\u5b66\u751f\u6027\u522b", "\u5b66\u751f\u8eab\u9ad8", "\u5b66\u751f\u5907\u6ce8"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                    false, false, false, false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        studentTable.getColumnModel().getColumn(5).setPreferredWidth(119);
        getContentPane().setLayout(groupLayout);

        this.fillTable(new Student());
    }//

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentManageFrm frame = new StudentManageFrm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }//学生管理更能界面UI，及查询，修改与一体的界面，也是借助插件辅助生成的（也很丑）

    /**
     * 查询事件处理
     */
    private void studentSearchActionPerformed(ActionEvent evt) {
        String studentName = this.s_studentNameTxt.getText();
        String years = this.s_yearsTxt.getText();

        Student student = new Student(studentName, years);
        this.fillTable(student);
    }


    /**
     * 初始化表格数据
     */
    private void fillTable(Student student) {
        DefaultTableModel dtm = (DefaultTableModel) studentTable.getModel();
        dtm.setRowCount(0); //设置成0行
        Connection con = null;
        try {
            con = dbUtil.getCon();
            ResultSet rs = studentDao.list(con, student);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("year"));
                v.add(rs.getString("sex"));
                v.add(rs.getDouble("height"));
                v.add(rs.getString("ps"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 表格点击事件处理
     */
    private void studentTableMousePressed(MouseEvent met) {
        int row = this.studentTable.getSelectedRow();
        this.idTxt.setText((String) studentTable.getValueAt(row, 0));
        this.studentNameTxt.setText((String) studentTable.getValueAt(row, 1));
        this.yearTxt.setText((String) studentTable.getValueAt(row, 2));
        String sex = (String) studentTable.getValueAt(row, 3);
        if ("男".equals(sex)) {
            this.manJrb.setSelected(true);
        } else if ("女".equals(sex)) {
            this.femaleJrb.setSelected(true);
        }
        this.heightTxt.setText(studentTable.getValueAt(row, 4) + "");
        this.studentPsTxt.setText((String) studentTable.getValueAt(row, 5));
    }

    private void studentUpdateActionPerformed(ActionEvent evt) {
        String id = this.idTxt.getText();
        if (StringUtil.isEmpty(id)) {
            JOptionPane.showMessageDialog(null, "请选择要修改的记录");
            return;
        }

        String studentName = this.studentNameTxt.getText();
        String year = this.yearTxt.getText();
        String height = this.heightTxt.getText();
        String studentPs = this.studentPsTxt.getText();

        if (StringUtil.isEmpty(studentName)) {
            JOptionPane.showMessageDialog(null, "学生名称不能为空！");
            return;
        }

        if (StringUtil.isEmpty(year)) {
            JOptionPane.showMessageDialog(null, "学生年龄不能为空！");
            return;
        }

        if (StringUtil.isEmpty(height)) {
            JOptionPane.showMessageDialog(null, "学生身高不能为空！");
            return;
        }

        String sex = "";
        if (manJrb.isSelected()) {
            sex = "男";
        } else if (femaleJrb.isSelected()) {
            sex = "女";
        }


        Student student = new Student(Integer.parseInt(id), studentName, year, sex, Double.parseDouble(height), studentPs);
        Connection con = null;
        try {
            con = dbUtil.getCon();
            int addNum = StudentDao.update(con, student);
            if (addNum == 1) {
                JOptionPane.showMessageDialog(null, "学生信息修改成功！");
                resetValue();
                this.fillTable(new Student());
            } else {
                JOptionPane.showMessageDialog(null, "学生信息修改失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "学生信息修改失败！");
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void studentDeleteActionPerformed(ActionEvent evt) {
        String id = idTxt.getText();
        if (StringUtil.isEmpty(id)) {
            JOptionPane.showMessageDialog(null, "请选择要删除的记录");
            return;
        }
        int n = JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
        if (n == 0) {
            Connection con = null;
            try {
                con = dbUtil.getCon();
                int deleteNum = StudentDao.delete(con, id);
                if (deleteNum == 1) {
                    JOptionPane.showMessageDialog(null, "删除成功");
                    this.resetValue();
                    this.fillTable(new Student());
                } else {
                    JOptionPane.showMessageDialog(null, "删除失败");
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "删除失败");
            } finally {
                try {
                    dbUtil.closeCon(con);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void resetValue() {
        this.idTxt.setText("");
        this.studentNameTxt.setText("");
        this.yearTxt.setText("");
        this.heightTxt.setText("");
        this.manJrb.setSelected(true);
        this.studentPsTxt.setText("");
    }
}


