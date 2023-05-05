package rs.singidunum.ac.rs.OnlineStore.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rs.singidunum.ac.rs.OnlineStore.model.Article;

@Repository
public interface ArticleRepository extends MongoRepository<Article, ObjectId> {
    Article findById(String id);
}
