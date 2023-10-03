package com.example.hrpayroll.hr.payroll.services;

import com.example.hrpayroll.hr.payroll.entities.Payment;
import com.example.hrpayroll.hr.payroll.entities.Worker;
import com.example.hrpayroll.hr.payroll.feignclients.WorkerFeignClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {
    @Autowired
    private WorkerFeignClients service;

    public Payment getPayment(long workerId, int days){

        Worker worker = service.findById(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
