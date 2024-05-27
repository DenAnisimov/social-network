package org.socialnetwork.service;

import org.hibernate.Session;
import org.socialnetwork.model.Comment;
import org.socialnetwork.model.Post;
import org.socialnetwork.model.User;
import org.socialnetwork.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class DataInitializer {
    public static void init() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<User> users = new ArrayList<>();
            for (int i = 1; i <= 20; i++) {
                User user = new User();
                user.setLogin("user" + i);
                user.setPassword("password" + i);
                user.setEmail("user" + i + "@example.com");
                users.add(user);
                session.persist(user);
            }

            List<Post> posts = new ArrayList<>();
            for (int i = 1; i <= 20; i++) {
                Post post = new Post();
                post.setContent("Post content " + i);
                post.setUser(users.get(i - 1));
                posts.add(post);
                session.persist(post);
            }

            for (int i = 1; i <= 20; i++) {
                Comment comment = new Comment();
                comment.setContent("Comment content " + i);
                comment.setUser(users.get(i - 1));
                comment.setPost(posts.get((i - 1) / 2));
                session.persist(comment);
            }
            session.getTransaction().commit();
        }
    }
}
