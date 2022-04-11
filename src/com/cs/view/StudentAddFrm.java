package com.cs.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.cs.dao.StudentDao;
import com.cs.model.Student;
import com.cs.util.DbUtil;
import com.cs.util.StringUtil;

public class StudentAddFrm extends JInternalFrame {
    private JTextField studentNameTxt;
    private JTextField yearsTxt;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField heightTxt;
    private JTextArea studentPsTxt;
    private JRadioButton manJrb;
    private JRadioButton femaleJrb;

    private DbUtil dbUtil=new DbUtil();
    private StudentDao studentDao=new StudentDao();

    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentAddFrm frame = new StudentAddFrm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public StudentAddFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u5b66\u751f\u4fe1\u606f\u6dfb\u52a0");
        setBounds(100, 100, 450, 467);

        JLabel label = new JLabel("\u5b66\u751f\u59d3\u540d\uff1a");

        studentNameTxt = new JTextField();
        studentNameTxt.setColumns(10);

        JLabel label_1 = new JLabel("\u5b66\u751f\u5e74\u9f84\uff1a");

        yearsTxt = new JTextField();
        yearsTxt.setColumns(10);

        JLabel label_2 = new JLabel("\u5b66\u751f\u6027\u522b\uff1a");

        manJrb = new JRadioButton("\u7537");
        buttonGroup.add(manJrb);
        manJrb.setSelected(true);

        femaleJrb = new JRadioButton("\u5973");
        buttonGroup.add(femaleJrb);

        JLabel label_3 = new JLabel("\u5b66\u751f\u8eab\u9ad8\uff1a");

        heightTxt = new JTextField();
        heightTxt.setColumns(10);

        JLabel label_4 = new JLabel("\u5b66\u751f\u5907\u6ce8\uff1a");

        studentPsTxt = new JTextArea();

        JLabel label_5 = new JLabel("");
        
        

        JButton button = new JButton("\u6DFB\u52A0");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                studentAddActionPerformed(e);
            }
        });
        button.setIcon(new ImageIcon(StudentAddFrm.class.getResource("/images/add.png")));

        JButton button_1 = new JButton("\u91CD\u7F6E");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetValueActionPerformed(e);
            }
        });
        button_1.setIcon(new ImageIcon(StudentAddFrm.class.getResource("/images/reset.png")));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(42)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(button)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(button_1)
                                                .addGap(232))
                                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                .addComponent(label_5)
                                                .addGroup(groupLayout.createSequentialGroup()
                                                        .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                                                .addComponent(label_4)
                                                                .addComponent(label_2)
                                                                .addComponent(label))
                                                        .addPreferredGap(ComponentPlacement.RELATED)
                                                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                                .addGroup(groupLayout.createSequentialGroup()
                                                                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                                                                .addComponent(studentNameTxt, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(groupLayout.createSequentialGroup()
                                                                                        .addComponent(manJrb)
                                                                                        .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                        .addComponent(femaleJrb))
                                                                                .addComponent(label_5, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGap(35)
                                                                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                                                                .addGroup(groupLayout.createSequentialGroup()
                                                                                        .addComponent(label_1)
                                                                                        .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                        .addComponent(yearsTxt, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(groupLayout.createSequentialGroup()
                                                                                        .addComponent(label_3)
                                                                                        .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                        .addComponent(heightTxt))))
                                                                .addComponent(studentPsTxt))
                                                        .addContainerGap(44, Short.MAX_VALUE)))))
                                                        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(42)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label)
                                        .addComponent(studentNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_1)
                                        .addComponent(yearsTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(29)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label_2)
                                        .addComponent(manJrb)
                                        .addComponent(femaleJrb)
                                        .addComponent(label_3)
                                        .addComponent(heightTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(33)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label_5)
                                        .addComponent(label_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(30)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(label_4)
                                        .addComponent(studentPsTxt, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(button)
                                        .addComponent(button_1))
                                .addGap(42))
        );
        getContentPane().setLayout(groupLayout);

        // �����ı���߿�
        studentPsTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
        
    }
    private void resetValueActionPerformed(ActionEvent e) {
        this.resetValue();
    }

    /**
     * 学生信息添加
     */
    private void studentAddActionPerformed(ActionEvent evt) {
        String studentName=this.studentNameTxt.getText();
        String years= this.yearsTxt.getText();
        Double height= Double.valueOf(this.heightTxt.getText());
        String studentPs=this.studentPsTxt.getText();

        if(StringUtil.isEmpty(studentName)){
            JOptionPane.showMessageDialog(null, "学生姓名不能为空！");
            return;
        }

        if(StringUtil.isEmpty(years)){
            JOptionPane.showMessageDialog(null, "学生年龄不能为空！");
            return;
        }

        if(StringUtil.isEmpty(String.valueOf(height))){
            JOptionPane.showMessageDialog(null, "学生身高不能为空");
            return;
        }

        String sex="";
        if(manJrb.isSelected()){
            sex="男";
        }else if(femaleJrb.isSelected()){
            sex="女";
        }

        Student student=new Student(studentName,years,sex,height,studentPs);

        Connection con=null;
        try{
            con=dbUtil.getCon();
            int addNum=studentDao.add(con, student);
            if(addNum==1){
                JOptionPane.showMessageDialog(null, "学生信息添加成功！");
                resetValue();
            }else{
                JOptionPane.showMessageDialog(null, "学生信息添加失败！");
            }
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "学生信息添加失败！");
        }finally{
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 重置
     */
    private void resetValue(){
        this.studentNameTxt.setText("");
        this.yearsTxt.setText("");
        this.heightTxt.setText("");
        this.manJrb.setSelected(true);
        this.studentPsTxt.setText("");
    }
}
