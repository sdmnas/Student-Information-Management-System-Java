package com.cs.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrm extends JFrame {

    private JPanel contentPane;
    private JDesktopPane table =null;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrm frame = new MainFrm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainFrm() {
        setTitle("\u5B66\u751F\u4FE1\u606F\u7CFB\u7EDF\u7BA1\u7406\u4E3B\u754C\u9762");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
        mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
        menuBar.add(mnNewMenu);


        JMenu mnNewMenu_2 = new JMenu("\u5b66\u751f\u4fe1\u606f\u7ba1\u7406");
        mnNewMenu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookManager.png")));
        mnNewMenu.add(mnNewMenu_2);

        JMenuItem menuItem_2 = new JMenuItem("\u5b66\u751f\u4fe1\u606f\u6dfb\u52a0");
        menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
        mnNewMenu_2.add(menuItem_2);
        menuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                StudentAddFrm StudentAddFrm=new StudentAddFrm();
                StudentAddFrm.setVisible(true);
                table.add(StudentAddFrm);
            }
        });
        
        JMenuItem menuItem_3 = new JMenuItem("\u5b66\u751f\u4fe1\u606f\u7ef4\u62a4");
        menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
        mnNewMenu_2.add(menuItem_3);
        menuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                StudentManageFrm studentManageFrm=new StudentManageFrm();
                studentManageFrm.setVisible(true);
                table.add(studentManageFrm);
            }
        });

        JMenuItem menuItem_4 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
        menuItem_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result=JOptionPane.showConfirmDialog(null, "是否退出系统");
                if(result==0){
                    dispose();
                }
            }
        });
        menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
        mnNewMenu.add(menuItem_4);

        JMenu menu = new JMenu("\u5173\u4E8E\u6211\u4EEC");
        menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
        menuBar.add(menu);

        JMenuItem mntmjava = new JMenuItem("\u5173\u4E8Esdmnas");
        mntmjava.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                AboutFrm AboutFrm=new AboutFrm();
                AboutFrm.setVisible(true);
                table.add(AboutFrm);
            }
        });
        mntmjava.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
        menu.add(mntmjava);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        table = new JDesktopPane();
        contentPane.add(table, BorderLayout.CENTER);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
