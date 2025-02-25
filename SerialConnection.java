package com.example.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import com.fazecast.jSerialComm.SerialPort;

public class SerialConnection {
    private SerialPort serialPort;

    public SerialConnection() {
        serialPort = SerialPort.getCommPorts()[0]; // Use the first available port
        serialPort.setBaudRate(9600);
        serialPort.openPort();
    }

    public String readData() {
        InputStream in = serialPort.getInputStream();
        StringBuilder data = new StringBuilder();
        try {
            int availableBytes;
            while ((availableBytes = in.available()) > 0) {
                byte[] buffer = new byte[availableBytes];
                int bytesRead = in.read(buffer);
                data.append(new String(buffer, 0, bytesRead, StandardCharsets.UTF_8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data.toString();
    }

    public void writeData(String data) {
        OutputStream out = serialPort.getOutputStream();
        try {
            out.write(data.getBytes(StandardCharsets.UTF_8));
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}