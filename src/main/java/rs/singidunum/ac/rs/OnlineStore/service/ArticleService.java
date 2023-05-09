package rs.singidunum.ac.rs.OnlineStore.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.singidunum.ac.rs.OnlineStore.model.Article;
import rs.singidunum.ac.rs.OnlineStore.repository.ArticleRepository;
import rs.singidunum.ac.rs.OnlineStore.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(String id) {
        return articleRepository.findById(id);
    }

    public Article addArticle(Article article) {
        article.setCategory(categoryRepository.findByName(article.getCategory().getName()));
        return articleRepository.save(article);
    }

    public Article updateArticle(String id, Article article) {
        Optional<Article> optionalArticle = articleRepository.findById(new ObjectId(id));
        if (!optionalArticle.isPresent()) {
            return null;
        }
        Article existingArticle = optionalArticle.get();
        existingArticle.setTitle(article.getTitle());
        existingArticle.setDescription(article.getDescription());
        existingArticle.setCategory(categoryRepository.findByName(article.getCategory().getName()));
        existingArticle.setPrice(article.getPrice());
        return articleRepository.save(existingArticle);
    }

    public void deleteArticle(String id) {
        articleRepository.deleteById(new ObjectId(id));
    }
}
