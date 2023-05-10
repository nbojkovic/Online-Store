package rs.singidunum.ac.rs.OnlineStore.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.singidunum.ac.rs.OnlineStore.model.Article;
import rs.singidunum.ac.rs.OnlineStore.model.Cart;
import rs.singidunum.ac.rs.OnlineStore.repository.CartRepository;
import rs.singidunum.ac.rs.OnlineStore.repository.UserRepository;

import java.util.List;
import java.util.Optional;

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

    public Cart updateCart(String id, Cart cart) {
        Optional<Cart> optionalCart = cartRepository.findById(new ObjectId(id));
        if (!optionalCart.isPresent()) {
            return null;
        }
        Cart existingCart = optionalCart.get();
        existingCart.setUser(userRepository.findById(cart.getUser().getId()));
        existingCart.setArticleList(cart.getArticleList());
        return cartRepository.save(existingCart);
    }

}
