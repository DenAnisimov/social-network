package org.socialnetwork.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.socialnetwork.model.Comment;
import org.socialnetwork.utils.HibernateUtil;

import java.util.List;

public class CommentServiceImpl implements Service<Comment> {
    @Override
    public List<Comment> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Comment> criteriaQuery = builder.createQuery(Comment.class);
            Root<Comment> root = criteriaQuery.from(Comment.class);

            criteriaQuery.select(root);

            Query<Comment> query = session.createQuery(criteriaQuery);

            return query.getResultList();
        }
    }

    @Override
    public Comment getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Comment> criteriaQuery = builder.createQuery(Comment.class);
            Root<Comment> root = criteriaQuery.from(Comment.class);

            Predicate predicate = builder.equal(root.get("id"), id);

            criteriaQuery.select(root).where(predicate);

            Query<Comment> query = session.createQuery(criteriaQuery);
            return query.getSingleResultOrNull();
        }
    }
}
