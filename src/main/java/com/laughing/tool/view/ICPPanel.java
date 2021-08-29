package com.laughing.tool.view;


import com.formdev.flatlaf.FlatLightLaf;
import com.laughing.tool.common.Constant;
import com.laughing.tool.controller.ICPController;
import org.jb2011.lnf.beautyeye.ch14_combox.BEComboBoxUI;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import org.jb2011.lnf.beautyeye.ch6_textcoms.BETextFieldUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author : laughing
 * @create : 2021-08-29 14:21
 * @description : 面板
 */
public class ICPPanel extends JPanel {
    private final JLabel moduleLabel = new JLabel("模块：");
    private JComboBox<String> module;
    private final JLabel ipLabel = new JLabel("IP：");
    private final JTextField ip = new JTextField(10);
    private final JLabel portLabel = new JLabel("端口：");
    private final JTextField port = new JTextField();
    private final JLabel modeLabel = new JLabel("模式：");
    private JComboBox<String> mode;
    private final JLabel moduleNumLabel = new JLabel("对端模块号：");
    private final JTextField moduleNum = new JTextField(10);
    private final JLabel handModeLabel = new JLabel("HandMode：");
    private JComboBox<String> handMode;
    private final JLabel groupLabel = new JLabel("组编号：");
    private final JTextField group = new JTextField();
    private final JLabel nickNameLabel = new JLabel("昵称：");
    private final JTextField nickName = new JTextField(10);
    private final JLabel funcNumLabel = new JLabel("对端功能块号：");
    private final JTextField funcNum = new JTextField(10);
    private final JButton add = new JButton("添加");
    private final JButton save = new JButton("保存");
    private final JLabel pathLabel = new JLabel("文件保存路径：");
    private final JTextField message = new JTextField(30);
    private final JButton path = new JButton("浏览");
    private final ImageIcon image = new ImageIcon(Objects.requireNonNull(ICPPanel.class.getClassLoader().getResource("image/img.png")));
    final JLabel imageLabel = new JLabel();

    List<List<String>> list = new ArrayList<>();
    String modeText = "--请选择--";
    String handModeText = "--请选择--";
    String filePath;

    ICPController controller = new ICPController();

    public ICPPanel() {
        // 修改swing外观
        try {
            /*for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }*/
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Panel 面板布局
     *
     * @param panel 面板
     */
    public void addComponent(JPanel panel) {
        // 绝对布局
        panel.setLayout(null);
        // 模块
        moduleLabel.setBounds(Constant.X * 2, Constant.Y * 3, Constant.WIDTH, Constant.HEIGHT);
        panel.add(moduleLabel);
        String[] moduleList = new String[]{"easc", "esip", "ivps", "ksrs", "mif", "msip", "rtds", "scmd", "sif"};
        module = new JComboBox<>(moduleList);
        module.setBounds(Constant.X * 4, Constant.Y * 3, Constant.WIDTH * 2, Constant.HEIGHT);
        module.setUI(new BEComboBoxUI());
        panel.add(module);
        // IP
        ipLabel.setBounds(Constant.X * 2, Constant.Y * 4, Constant.WIDTH, Constant.HEIGHT);
        panel.add(ipLabel);
        ip.setBounds(Constant.X * 4, Constant.Y * 4, Constant.WIDTH * 3, Constant.HEIGHT);
        ip.setFont(new Font(null, Font.PLAIN, Constant.SIZE));
        ip.setUI(new BETextFieldUI());
        panel.add(ip);
        // 端口
        portLabel.setBounds(Constant.X * 2, Constant.Y * 5, Constant.WIDTH, Constant.HEIGHT);
        panel.add(portLabel);
        port.setBounds(Constant.X * 4, Constant.Y * 5, Constant.WIDTH * 3, Constant.HEIGHT);
        port.setFont(new Font(null, Font.PLAIN, Constant.SIZE));
        port.setUI(new BETextFieldUI());
        panel.add(port);
        // 模式
        modeLabel.setBounds(Constant.X * 2, Constant.Y * 6, Constant.WIDTH * 2, Constant.HEIGHT);
        panel.add(modeLabel);
        mode = new JComboBox<>();
        mode.setUI(new BEComboBoxUI());
        panel.add(mode);
        mode.addItem("--请选择--");
        mode.addItem("0");
        mode.addItem("1");
        mode.setBounds(Constant.X * 4, Constant.Y * 6, Constant.WIDTH * 2, Constant.HEIGHT);
        mode.setToolTipText("0：客户端，1：服务端");
        // 对端模块号
        moduleNumLabel.setBounds(Constant.X * 2, Constant.Y * 7, Constant.WIDTH * 2, Constant.HEIGHT);
        panel.add(moduleNumLabel);
        moduleNum.setBounds(Constant.X * 4, Constant.Y * 7, Constant.WIDTH * 3, Constant.HEIGHT);
        moduleNum.setFont(new Font(null, Font.PLAIN, Constant.SIZE));
        moduleNum.setUI(new BETextFieldUI());
        panel.add(moduleNum);
        // handMode
        handModeLabel.setBounds(Constant.X * 2, Constant.Y * 8, Constant.WIDTH * 2, Constant.HEIGHT);
        panel.add(handModeLabel);
        //Integer[] handModeList = new Integer[]{0, 1};
        handMode = new JComboBox<>();
        handMode.addItem("--请选择--");
        handMode.addItem("0");
        handMode.addItem("1");
        handMode.setBounds(Constant.X * 4, Constant.Y * 8, Constant.WIDTH * 2, Constant.HEIGHT);
        handMode.setUI(new BEComboBoxUI());
        panel.add(handMode);
        // 组编号
        groupLabel.setBounds(Constant.X * 2, Constant.Y * 9, Constant.WIDTH * 2, Constant.HEIGHT);
        panel.add(groupLabel);
        group.setBounds(Constant.X * 4, Constant.Y * 9, Constant.WIDTH * 3, Constant.HEIGHT);
        group.setFont(new Font(null, Font.PLAIN, Constant.SIZE));
        group.setUI(new BETextFieldUI());
        panel.add(group);
        // 昵称
        nickNameLabel.setBounds(Constant.X * 2, Constant.Y * 10, Constant.WIDTH * 2, Constant.HEIGHT);
        panel.add(nickNameLabel);
        nickName.setBounds(Constant.X * 4, Constant.Y * 10, Constant.WIDTH * 3, Constant.HEIGHT);
        nickName.setFont(new Font(null, Font.PLAIN, Constant.SIZE));
        nickName.setUI(new BETextFieldUI());
        panel.add(nickName);
        // 对端功能块号 TODO 有些模块不需要配置
        funcNumLabel.setBounds(Constant.X * 2, Constant.Y * 11, Constant.WIDTH * 2, Constant.HEIGHT);
        panel.add(funcNumLabel);
        funcNum.setBounds(Constant.X * 4, Constant.Y * 11, Constant.WIDTH * 3, Constant.HEIGHT);
        funcNum.setFont(new Font(null, Font.PLAIN, Constant.SIZE));
        funcNum.setUI(new BETextFieldUI());
        panel.add(funcNum);
        // 保存文件
        pathLabel.setBounds(Constant.X * 2, Constant.Y * 12, Constant.WIDTH * 2, Constant.HEIGHT);
        panel.add(pathLabel);
        message.setBounds(Constant.X * 3 + 20, Constant.Y * 12, Constant.WIDTH * 4, Constant.HEIGHT);
        message.setFont(new Font(null, Font.PLAIN, Constant.SIZE));
        message.setText("未选择路径");
        message.setUI(new BETextFieldUI());
        panel.add(message);
        path.setBounds(Constant.X * 6, Constant.Y * 12, Constant.WIDTH + 10, Constant.HEIGHT);
        path.setUI(new BEButtonUI());
        panel.add(path);
        // 添加
        add.setBounds(Constant.X * 2 + 50, Constant.Y * 13, Constant.WIDTH + 10, Constant.HEIGHT * 2);
        add.setUI(new BEButtonUI());
        panel.add(add);
        // 保存
        save.setBounds(Constant.X * 4 + 50, Constant.Y * 13, Constant.WIDTH + 10, Constant.HEIGHT * 2);
        save.setUI(new BEButtonUI());
        panel.add(save);
        // 背景图片
        imageLabel.setIcon(image);
        imageLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        // 设置为透明
        panel.setOpaque(false);
        panel.add(imageLabel);
    }

    /**
     * 事件监听，获取输入的数据
     */
    public void listener() {
        addDataListener();
        choosePathListener();
        generatorFileListener();
    }

    /**
     * 添加数据事件
     */
    private void addDataListener() {
        mode.addItemListener(e1 -> {
            if (e1.getStateChange() == ItemEvent.SELECTED) {
                modeText = Objects.requireNonNull(mode.getSelectedItem()).toString();
            }
        });
        handMode.addItemListener(e2 -> {
            if (e2.getStateChange() == ItemEvent.SELECTED) {
                handModeText = Objects.requireNonNull(handMode.getSelectedItem()).toString();
            }
        });
        add.addActionListener(e -> {
            List<String> data = new ArrayList<>();
            String ipText = ip.getText();
            String portText = port.getText();
            String moduleNumText = moduleNum.getText();
            String groupText = group.getText();
            String nickNameText = nickName.getText();
            String funcNumText = funcNum.getText();

            if (ipText == null || "".equals(ipText)) {
                JOptionPane.showMessageDialog(null, "IP不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
            } else if (portText == null || "".equals(portText)) {
                JOptionPane.showMessageDialog(null, "端口不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
            } else if ("--请选择--".equals(modeText)) {
                JOptionPane.showMessageDialog(null, "模式不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
            } else if (moduleNumText == null || "".equals(moduleNumText)) {
                JOptionPane.showMessageDialog(null, "对端模块号不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
            } else if ("--请选择--".equals(handModeText)) {
                JOptionPane.showMessageDialog(null, "handMode不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
            } else if (groupText == null || "".equals(groupText)) {
                JOptionPane.showMessageDialog(null, "组编号不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
            } else if (nickNameText == null || "".equals(nickNameText)) {
                JOptionPane.showMessageDialog(null, "昵称不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
            } else if (funcNumText == null || "".equals(funcNumText)) {
                JOptionPane.showMessageDialog(null, "对端功能块号不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
            } else {
                data.add(ipText);
                data.add(portText);
                data.add(modeText);
                data.add(moduleNumText);
                data.add(funcNumText);
                data.add(handModeText);
                data.add(groupText);
                data.add(nickNameText);
                list.add(data);
            }
        });
    }

    /**
     * 选择保存路径事件
     */
    private void choosePathListener() {
        path.addActionListener(e -> {
            // 文件选择器
            JFileChooser fileChooser = new JFileChooser("C:/");
            // 默认文件名
            fileChooser.setSelectedFile(new File("com_config.ini"));
            // 选择路径
            int savePath = fileChooser.showSaveDialog(null);
            if (savePath == JFileChooser.APPROVE_OPTION) {
                filePath = fileChooser.getSelectedFile().getPath();
                message.setText(filePath);
            } else {
                message.setText("未选择路径");
            }
        });
    }

    /**
     * 生成文件事件
     */
    private void generatorFileListener() {
        save.addActionListener(e -> {
            try {
                if (list.size() == 0) {
                    JOptionPane.showMessageDialog(null, "请先添加配置再生成！", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                filePath = message.getText();
                File file = new File(filePath);
                if (!file.isDirectory()) {
                    JOptionPane.showMessageDialog(null, "路径不存在！", "错误", JOptionPane.ERROR_MESSAGE);
                } else if (filePath == null || "".equals(filePath)) {
                    JOptionPane.showMessageDialog(null, "请选择文件保存路径！", "错误", JOptionPane.ERROR_MESSAGE);
                } else {
                    controller.writeFile(list, filePath);
                    JOptionPane.showMessageDialog(null, "生成配置文件成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, ioe.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
