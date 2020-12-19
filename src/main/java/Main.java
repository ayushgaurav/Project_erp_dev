import com.example.projecterp.bean.Domains;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
//            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
//            for (EntityType<?> entityType : metamodel.getEntities()) {
//                final String entityName = entityType.getName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
            Domains domains = new Domains("computer",simpleDateFormat.parse("2020"),100,"undergraduate");

            Transaction transaction = session.beginTransaction();

            session.save(domains);

            transaction.commit();
            session.close();


//            domains.setProgram("computer");
//            domains.setBatch(simpleDateFormat.parse("2020"));
//            domains.setCapacity(100);
//            domains.setQualification("undergraduate");
//




        } finally {
            session.close();
        }
    }
}