package rs.singidunum.ac.rs.OnlineStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.singidunum.ac.rs.OnlineStore.model.Cart;
import rs.singidunum.ac.rs.OnlineStore.repository.CartRepository;
import rs.singidunum.ac.rs.OnlineStore.repository.UserRepository;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart addCart(Cart cart) {
        cart.setUser(userRepository.findById(cart.getUser().getId()));
        return cartRepository.save(cart);
    }
}
