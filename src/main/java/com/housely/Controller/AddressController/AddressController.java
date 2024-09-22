package com.housely.Controller.AddressController;

import com.housely.Model.Address.PaymentAddress;
import com.housely.Model.Address.ShippingAddress;
import com.housely.Service.PaymentAddressService;
import com.housely.Service.ShippingAddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final PaymentAddressService paymentAddressService;
    private final ShippingAddressService shippingAddressService;

    public AddressController(PaymentAddressService paymentAddressService, ShippingAddressService shippingAddressService) {
        this.paymentAddressService = paymentAddressService;
        this.shippingAddressService = shippingAddressService;
    }

    @GetMapping("/payments")
    public @ResponseBody List<PaymentAddress> getAllPaymentAddress() {
        return paymentAddressService.findAll();
    }

    @GetMapping("/shipping")
    public @ResponseBody List<ShippingAddress> getAllShippingAddress() {
        return shippingAddressService.findAll();
    }

    @GetMapping("/payment/{id}")
    public @ResponseBody PaymentAddress getPaymentAddressById(@PathVariable Long id) {
        return paymentAddressService.findById(id);
    }

    @GetMapping("/shipping/{id}")
    public @ResponseBody ShippingAddress getShippingAddressById(@PathVariable Long id) {
        return shippingAddressService.findById(id);
    }

    @DeleteMapping("/payment/{id}")
    public @ResponseBody String deletePaymentAddress(@PathVariable Long id) {
        if (paymentAddressService.findById(id) != null) {
            paymentAddressService.deleteById(id);
        }
        return String.format("Payment Address Id:%d was delete successfully!", id);
    }

    @DeleteMapping("/shipping/{id}")
    public @ResponseBody String deleteShippingAddress(@PathVariable Long id) {
        if (shippingAddressService.findById(id) != null) {
            shippingAddressService.deleteById(id);
        }
        return String.format("Shipping Address Id:%d was delete successfully!", id);
    }

    @PostMapping("/payment")
    public @ResponseBody PaymentAddress addPaymentAddress(@RequestBody PaymentAddress paymentAddress) {
        return paymentAddressService.save(paymentAddress);
    }

    @PostMapping("/shipping")
    public @ResponseBody ShippingAddress addShippingAddress(@RequestBody ShippingAddress shippingAddress) {
        return shippingAddressService.save(shippingAddress);
    }

    @PutMapping("/payment/{id}")
    public @ResponseBody PaymentAddress updatePaymentAddress(@PathVariable Long id, @RequestBody PaymentAddress paymentAddress) {
        paymentAddress.setPaymentAddressId(id);
        return paymentAddressService.save(paymentAddress);
    }

    @PutMapping("/shipping/{id}")
    public @ResponseBody ShippingAddress updateShippingAddress(@PathVariable Long id, @RequestBody ShippingAddress shippingAddress) {
        shippingAddress.setShippingAddressId(id);
        return shippingAddressService.save(shippingAddress);
    }

}
