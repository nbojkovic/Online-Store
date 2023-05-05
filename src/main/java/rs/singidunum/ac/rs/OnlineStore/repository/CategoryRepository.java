package rs.singidunum.ac.rs.OnlineStore.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rs.singidunum.ac.rs.OnlineStore.model.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, ObjectId> {
    Category findById(String id);
}
