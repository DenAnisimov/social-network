package org.socialnetwork.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.socialnetwork.model.User;
import org.socialnetwork.utils.HibernateUtil;

import java.util.List;

public class UserServiceImpl implements Service<User> {

    @Override
    public List<User> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
            Root<User> root = criteriaQuery.from(User.class);

            criteriaQuery.select(root);

            Query<User> query = session.createQuery(criteriaQuery);

            return query.getResultList();
        }
    }

    @Override
    public User getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
            Root<User> root = criteriaQuery.from(User.class);

            Predicate predicate = builder.equal(root.get("id"), id);

            criteriaQuery.select(root).where(predicate);

            Query<User> query = session.createQuery(criteriaQuery);

            return query.getSingleResultOrNull();
        }
    }
}
