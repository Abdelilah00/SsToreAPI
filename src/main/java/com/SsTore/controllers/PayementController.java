package com.SsTore.controllers;

import com.SsTore.services.utils.Payements.PaypalService;
import com.configuration.Exception.ApiResponse;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/payments")
public class PayementController {
    public static final String SUCCESS_URL = "http://localhost:4200/home/checkout/success";
    public static final String CANCEL_URL = "http://localhost:4200/home/six";
    @Autowired
    PaypalService paypalService;

    //paypalIntent: sale, authorize,order
    @PostMapping("/pay")
    public ApiResponse pay() {
        try {
            Payment payment = paypalService.createPayment(10D, "USD", "paypal",
                    "sale", "only for test", CANCEL_URL, SUCCESS_URL);

            for (Links link : payment.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    return new ApiResponse(true, link.getHref());
                }
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return new ApiResponse(false, "Oooops Some thing wrrong");
    }

    @GetMapping(value = CANCEL_URL)
    public ApiResponse cancelPay() {
        return new ApiResponse(false, "You canceled");
    }

    @GetMapping(value = SUCCESS_URL)
    public ApiResponse successPay(@RequestParam("paymentId") String paymentId, @RequestParam("payerId") String payerId) {
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return new ApiResponse(true, "All Done");
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return new ApiResponse(false, "Oooops Some thing Wrong");
    }
}
