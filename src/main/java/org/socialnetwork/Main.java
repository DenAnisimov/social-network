package org.socialnetwork;

import org.socialnetwork.model.Comment;
import org.socialnetwork.model.Post;
import org.socialnetwork.model.User;
import org.socialnetwork.service.CommentServiceImpl;
import org.socialnetwork.service.PostServiceImpl;
import org.socialnetwork.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        PostServiceImpl postService = new PostServiceImpl();
        CommentServiceImpl commentService = new CommentServiceImpl();

        // Получаем всех пользователей
        List<User> users = userService.getAll();
        System.out.println("All users:");
        for (User user : users) {
            System.out.println(user);
        }

        // Получаем пользователя по ID
        User userById = userService.getById(4);
        System.out.println("User by ID:");
        System.out.println(userById);

        // Получаем все посты
        List<Post> posts = postService.getAll();
        System.out.println("All posts:");
        for (Post post : posts) {
            System.out.println(post);
        }

        // Получаем пост по ID
        Post postById = postService.getById(5);
        System.out.println("Post by ID:");
        System.out.println(postById);

        // Получаем все комментарии
        List<Comment> comments = commentService.getAll();
        System.out.println("All comments:");
        for (Comment comment : comments) {
            System.out.println(comment);
        }

        // Получаем комментарий по ID
        Comment commentById = commentService.getById(6);
        System.out.println("Comment by ID:");
        System.out.println(commentById);
    }
}