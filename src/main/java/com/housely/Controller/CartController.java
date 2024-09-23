package com.housely.Controller;

import com.housely.Model.Cart.Cart;
import com.housely.Model.Cart.CartItem;
import com.housely.Model.Cart.CartItemKey;
import com.housely.Model.Customer.Customer;
import com.housely.Service.CartItemService;
import com.housely.Service.CartService;
import com.housely.Service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartController {
    private final CartService cartService;
    private final CustomerService  customerService;
    private final CartItemService cartItemService;

    public CartController(CartService cartService, CartItemService cartItemService, CustomerService customerService) {
        this.cartService = cartService;
        this.customerService = customerService;
        this.cartItemService = cartItemService;
    }


//    @GetMapping("/customer/{id}/cart/{cartId}")
//    public @ResponseBody Cart getCartByCustomerId(@PathVariable Long id, @PathVariable Long cartId) {
//        Customer customer = customerService.findById(id);
//        Cart cart = cartService.findById(cartId);
//        cart.setCustomer(customer);
//        return cart;
//    }
//
//    @GetMapping("/customer/{id}/cart/{cartId}/cart-item")
//    public @ResponseBody List<CartItem> getCartItemByCartId(@PathVariable Long id, @PathVariable Long cartId) {
//        Customer customer = customerService.findById(id);
//        Cart cart = cartService.findById(cartId);
//        cart.setCustomer(customer);
//        return cart.getCartItems();
//    }
//
//    @PostMapping("/customer/{id}/cart")
//    public @ResponseBody Cart addCart(@RequestBody Cart cart, @PathVariable Long id) {
//        Customer customer = customerService.findById(id);
//        cart.setCustomer(customer);
//        return cartService.save(cart);
//    }
//
//    @PostMapping("/customer/{id}/cart/{cartId}/cart-item")
//    public @ResponseBody CartItem addCartItem(@RequestBody CartItem cartItem, @PathVariable Long id, @PathVariable Long cartId) {
//        Customer customer = customerService.findById(id);
//        Cart cart = cartService.findById(cartId);
//        cart.setCustomer(customer);
//        cartItem.setCart(cart);
//        return cartItemService.save(cartItem);
//    }
//
//    @PutMapping("/customer/{id}/cart/{cartId}")
//    public @ResponseBody Cart updateCart(@RequestBody Cart cart, @PathVariable Long id, @PathVariable Long cartId) {
//        Customer customer = customerService.findById(id);
//        cart.setCartId(cartId);
//        cart.setCustomer(customer);
//        return cartService.save(cart);
//    }
//
//    @PutMapping("/customer/{id}/cart/{cartId}/cart-item/{cartItemId}")
//    public @ResponseBody CartItem updateCartItem(@RequestBody CartItem cartItem, @PathVariable Long id, @PathVariable Long cartId, @PathVariable CartItemKey cartItemId) {
//        Customer customer = customerService.findById(id);
//        Cart cart = cartService.findById(cartId);
//        cart.setCustomer(customer);
//        cartItem.setId(cartItemId);
//        cartItem.setCart(cart);
//        return cartItemService.save(cartItem);
//    }
//
//    @DeleteMapping("/customer/{id}/cart/{cartId}")
//    public @ResponseBody String deleteCart(@PathVariable Long id, @PathVariable Long cartId) {
//        Customer customer = customerService.findById(id);
//        Cart cart = cartService.findById(cartId);
//        if (cart != null && cart.getCustomer().equals(customer)) {
//            cartService.deleteById(cartId);
//        }
//        return String.format("Cart Id:%d was delete successfully!", cartId);
//    }
//
//    @DeleteMapping("/customer/{id}/cart/{cartId}/cart-item/{cartItemId}")
//    public @ResponseBody String deleteCartItem(@PathVariable Long id, @PathVariable Long cartId, @PathVariable CartItemKey cartItemId) {
//        Customer customer = customerService.findById(id);
//        Cart cart = cartService.findById(cartId);
//        CartItem cartItem = cartItemService.findById(cartItemId);
//        if (cartItem != null && cartItem.getCart().equals(cart) && cart.getCustomer().equals(customer)) {
//            cartItemService.deleteById(cartItemId);
//        }
//        return "Cart Item Id:"+cartItemId+ " was delete successfully!";
//    }

}
