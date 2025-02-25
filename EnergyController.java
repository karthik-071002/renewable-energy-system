package com.example.controller;

import com.example.model.SensorData;
import com.example.service.SensorService;

public class EnergyController {
    private SensorService sensorService;

    public EnergyController() {
        sensorService = new SensorService();
    }

    public void startMonitoring() {
        while (true) {
            SensorData sensorData = sensorService.readSensorData();
            System.out.println("Wind Speed: " + sensorData.getWindSpeed());
            System.out.println("Sunlight Intensity: " + sensorData.getSunlightIntensity());
            System.out.println("Temperature: " + sensorData.getTemperature());

            // Add logic to control energy storage based on sensor data

            try {
                Thread.sleep(5000); // Wait for 5 seconds before reading data again
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}