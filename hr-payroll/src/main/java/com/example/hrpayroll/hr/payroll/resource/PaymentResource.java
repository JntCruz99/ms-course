package com.example.hrpayroll.hr.payroll.resource;

import com.example.hrpayroll.hr.payroll.entities.Payment;
import com.example.hrpayroll.hr.payroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @GetMapping("/{workerid}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerid, @PathVariable Integer days){
        Payment payment = service.getPayment(workerid, days);
        return ResponseEntity.ok(payment);
    }

}
