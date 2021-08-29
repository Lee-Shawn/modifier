package com.laughing.tool.view;


import com.laughing.tool.common.Constant;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author : laughing
 * @create : 2021-08-29 14:22
 * @description : 窗体
 */
public class ICPFrame extends JFrame {
    ICPPanel icpPanel = new ICPPanel();
    ICPMenuBar menuBar = new ICPMenuBar();

    public ICPFrame() {
        // 开启panel线程 TODO
        //new Thread(panel).start();
        // 窗口大小
        this.setSize(Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT);
        // 窗口位置
        this.setLocationRelativeTo(null);
        // 窗口标题
        this.setTitle("ICP通道配置工具箱 V1.0.2");
        // 显示窗口
        this.setVisible(true);
        // 设置窗口大小不可变
        this.setResizable(false);
        // 把panel添加到frame
        this.add(icpPanel);
        icpPanel.addComponent(icpPanel);
        // 添加监听

        icpPanel.listener();
        // 菜单添加到frame
        this.setJMenuBar(menuBar);
        menuBar.initMenu(menuBar);
        menuBar.listener();
        // 获取面板，显示图片
        this.getLayeredPane().add(icpPanel.imageLabel, new Integer(Integer.MIN_VALUE));
        JPanel container = (JPanel) this.getContentPane();
        container.setOpaque(false);
        // 退出程序
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 退出确认
        EventQueue.invokeLater(() ->{
            // 不执行任何操作，在 windowClosing 中处理
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            // 监听窗口退出事件
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    int result = JOptionPane.showConfirmDialog(null, "确认退出？", "确认", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        // 退出保存 TODO
                        System.exit(0);
                    }
                }
            });
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ICPFrame::new);
    }
}
