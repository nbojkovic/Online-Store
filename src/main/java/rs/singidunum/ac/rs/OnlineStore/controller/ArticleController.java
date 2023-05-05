package rs.singidunum.ac.rs.OnlineStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.singidunum.ac.rs.OnlineStore.model.Article;
import rs.singidunum.ac.rs.OnlineStore.service.ArticleService;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping()
    public ResponseEntity<List<Article>> getAllArticles() {
        return new ResponseEntity<List<Article>>(articleService.getAllArticles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getOneArticle(@PathVariable String id) {
        return new ResponseEntity<Article>(articleService.getArticleById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Article> addArticle(@RequestBody Article article) {
        Article newArticle = articleService.addArticle(article);
        return new ResponseEntity<Article>(newArticle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable String id, @RequestBody Article article) {
        Article updatedArticle = articleService.updateArticle(id, article);
        if (updatedArticle == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedArticle, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable String id) {
        articleService.deleteArticle(id);
        return new ResponseEntity<String>("Article with id " + id + " has been deleted", HttpStatus.OK);
    }
}
