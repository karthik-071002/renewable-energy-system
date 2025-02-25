package com.example;

import com.example.controller.EnergyController;

public class Main {
    public static void main(String[] args) {
        EnergyController energyController = new EnergyController();
        energyController.startMonitoring();
    }
}