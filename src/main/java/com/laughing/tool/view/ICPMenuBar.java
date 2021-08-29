package com.laughing.tool.view;


import org.jb2011.lnf.beautyeye.ch9_menu.BEMenuItemUI;
import org.jb2011.lnf.beautyeye.ch9_menu.BEMenuUI;

import javax.swing.*;
import javax.swing.undo.UndoManager;

/**
 * @author : laughing
 * @create : 2021-08-29 14:21
 * @description : 菜单栏
 */
public class ICPMenuBar extends JMenuBar {
    private final JMenu fileMenu = new JMenu("文件");
    private final JMenu editorMenu = new JMenu("编辑");
    private final JMenu helpMenu = new JMenu("帮助");

    private final JMenuItem openFile = new JMenuItem("打开");
    private final JMenuItem saveFile = new JMenuItem("保存");
    private final JMenuItem exist = new JMenuItem("退出");

    private final JMenuItem undo = new JMenuItem("撤销");

    private final JMenuItem help = new JMenuItem("帮助");
    private final JMenuItem log = new JMenuItem("日志");
    private final JMenuItem about = new JMenuItem("关于");

    private final UndoManager undoManager = new UndoManager();

    public ICPMenuBar() {
        fileMenu.setUI(new BEMenuUI());
        editorMenu.setUI(new BEMenuUI());
        helpMenu.setUI(new BEMenuUI());
        openFile.setUI(new BEMenuItemUI());
        saveFile.setUI(new BEMenuItemUI());
        exist.setUI(new BEMenuItemUI());
        undo.setUI(new BEMenuItemUI());
        help.setUI(new BEMenuItemUI());
        log.setUI(new BEMenuItemUI());
        about.setUI(new BEMenuItemUI());
    }

    /**
     * 菜单设置
     * @param menuBar 菜单栏对象
     */
    public void initMenu(JMenuBar menuBar) {
        // 菜单栏
        menuBar.add(fileMenu);
        menuBar.add(editorMenu);
        menuBar.add(helpMenu);

        // 子菜单
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        // 分割线
        fileMenu.addSeparator();
        fileMenu.add(exist);

        editorMenu.add(undo);

        helpMenu.add(help);
        helpMenu.add(log);
        helpMenu.add(about);
    }

    public void listener() {
        openFileListener();
        saveFileListener();
        existListener();
        undoListener();
        helpListener();
        logListener();
        aboutListener();
    }

    private void openFileListener() {
        // 打开文件事件
        openFile.addActionListener(e -> {

        });
    }

    private void saveFileListener() {
        // 保存文件事件
        saveFile.addActionListener(e -> {

        });
    }

    private void existListener() {
        // 退出事件
        exist.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null, "确认退出？", "确认", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
    }

    private void undoListener() {
        undo.addActionListener(e -> {
            if (e.getSource() == undo) {
                if (undoManager.canUndo()) {
                    undoManager.undo();
                }
            }
        });
    }

    private void helpListener() {
        help.addActionListener(e -> {
            String message = "使用说明：\n" +
                    "1. 选择要配置的模块\n" +
                    "2. 输入配置信息\n" +
                    "3. 点击添加\n" +
                    "4. 选择文件保存路径\n" +
                    "5. 点击保存";
            JOptionPane.showMessageDialog(null, message,"帮助",JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private void logListener() {
        log.addActionListener(e -> {
            String msg1 = "V1.0.0\n" +
                    "1. 实现ICP通道信息配置\n" +
                    "2. 可以配置多条ICP通道信息\n" +
                    "3. 配置信息可存到文件保存在本地\n\n";
            String msg2 = "V1.0.1\n" +
                    "1. fix下拉框第一次选择无法获取数据问题\n\n";
            String msg3 = "V1.0.2\n" +
                    "1. 添加背景图片优化UI\n" +
                    "2. fix手动添加路径问题\n\n";
            String message = msg3 + msg2 + msg1;
            JOptionPane.showMessageDialog(null, message,"日志",JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private void aboutListener() {
        about.addActionListener(e -> {
            String message = "Version: V1.0.2\n" +
                    "Auth: liyunjie@eastcom.com\n" +
                    "GitHub: https://github.com/Lee-Shawn/modifier\n" +
                    "Copyright: eastcom 2021";
            JOptionPane.showMessageDialog(null, message,"关于",JOptionPane.INFORMATION_MESSAGE);
        });
    }
}

