package rs.singidunum.ac.rs.OnlineStore.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rs.singidunum.ac.rs.OnlineStore.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findById(String id);
}
