package rs.singidunum.ac.rs.OnlineStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.singidunum.ac.rs.OnlineStore.model.User;
import rs.singidunum.ac.rs.OnlineStore.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
