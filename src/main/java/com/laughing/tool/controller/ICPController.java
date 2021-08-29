package com.laughing.tool.controller;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author : laughing
 * @create : 2021-08-29 14:21
 * @description : 数据处理
 */
public class ICPController {
    /**
     * 前端数据写入文件
     * @param list 数据集合
     * @throws IOException IO 异常
     */
    public void writeFile(List<List<String>> list, String path) throws IOException {
        // 缓冲字符流
        //String file = "test.ini";
        FileWriter fw = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(fw);
        // 头部字符写入文件
        bw.write("[TCP]");
        bw.newLine();
        bw.flush();
        // TcpIcp1 = "(*,22001,1,50,0,30,SLF-S);"
        // TcpIcp + i + =\"( + ip + , + , + port + , + mode + , + module + , + handMode + , + group + , + name + );\"
        String title = "TcpIcp";
        int count = 1;
        // 遍历集合，拼接字符串写入文件
        for (List<String> data : list) {
            String icp = "";
            for (int i = 0; i < data.size(); i++) {
                if (i == data.size() - 1) {
                    icp += data.get(i);
                    break;
                }
                icp += data.get(i) + ",";
            }
            icp = title + count + " = \"(" + icp + ");\"";
            count++;
            bw.write(icp);
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}

