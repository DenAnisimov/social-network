package org.socialnetwork.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    /* SessionFactory — объект, который используется для создания и управления объектами Session.
     * SessionFactory является потокобезопасным и предназначен для использования на протяжении всего
     * жизненного цикла приложения.
     * Он инициализируется один раз при запуске приложения и используется для получения сессий,
     * которые управляют взаимодействием с базой данных.*/
    private static SessionFactory sessionFactory;

    static {
        /* StandardServiceRegistry - объект, который управляет набором сервисов.
         * StandardServiceRegistryBuilder - объект, который создает объект класса StandardServiceRegistry,
         * он собирает все настройки, конфигурации, которые указаны
         * Service - объект, который выполняет задачи связанные с БД.
         * Эти задачи связаны с транзакциями, соединением к БД, кэшированием и т.д.*/
        final StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        /* MetadataSource - концепция, связанная с метаданными БД. Это неотъемлемый объект для маппинга данных.
         * Метаданные: структура БД, структура таблиц, структура столбцов. */
        try(serviceRegistry) {
            sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
