package org.socialnetwork.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.socialnetwork.model.Post;
import org.socialnetwork.utils.HibernateUtil;

import java.util.List;

public class PostServiceImpl implements Service<Post> {
    @Override
    public List<Post> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Post> criteriaQuery = builder.createQuery(Post.class);
            Root<Post> root = criteriaQuery.from(Post.class);

            criteriaQuery.select(root);

            Query<Post> query = session.createQuery(criteriaQuery);

            return query.getResultList();
        }
    }

    @Override
    public Post getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Post> criteriaQuery = builder.createQuery(Post.class);
            Root<Post> root = criteriaQuery.from(Post.class);

            Predicate predicate = builder.equal(root.get("id"), id);

            criteriaQuery.select(root).where(predicate);

            Query<Post> query = session.createQuery(criteriaQuery);

            return query.getSingleResultOrNull();
        }
    }
}
