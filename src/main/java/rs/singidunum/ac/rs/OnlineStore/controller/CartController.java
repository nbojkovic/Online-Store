package rs.singidunum.ac.rs.OnlineStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.singidunum.ac.rs.OnlineStore.model.Article;
import rs.singidunum.ac.rs.OnlineStore.model.Cart;
import rs.singidunum.ac.rs.OnlineStore.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping()
    public ResponseEntity<List<Cart>> getAllCarts() {
        return new ResponseEntity<List<Cart>>(cartService.getAllCarts(),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Cart> addCart(@RequestBody  Cart cart) {
        return new ResponseEntity<Cart>(cartService.addCart(cart), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Cart> getCartByUserId(@PathVariable String userId) {
        return new ResponseEntity<Cart>(cartService.getCartByUserId(userId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable String id, @RequestBody Cart cart) {
        Cart updatedCart = cartService.updateCart(id, cart);
        if (updatedCart == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<Cart> addedArticleToCart(@PathVariable String userId, @RequestBody Article article) {
        return new ResponseEntity<>(cartService.addArticleToCart(userId, article), HttpStatus.OK);
    }
}
