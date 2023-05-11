package rs.singidunum.ac.rs.OnlineStore.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rs.singidunum.ac.rs.OnlineStore.model.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, ObjectId> {
    Cart findById(String id);
    Cart findByUserId(String userId);
}
