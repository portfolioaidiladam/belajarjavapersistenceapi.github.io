package programmerzamannow.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/*import programmerzamannow.jpa.entity.Department;
import programmerzamannow.jpa.entity.DepartmentId;*/
import programmerzamannow.jpa.entity.Member;
import programmerzamannow.jpa.entity.Name;
import programmerzamannow.jpa.util.JpaUtil;

public class EmbeddedTest {

    @Test
    void embedded() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Name name = new Name();
        name.setTitle("Mr");
        name.setFirstName("Aidil");
        name.setMiddleName("Adam");
        name.setLastName("Baik Hati");

        Member member = new Member();
        member.setEmail("aidil@example.com");
        member.setName(name);

        entityManager.persist(member);

        entityTransaction.commit();
        entityManager.close();
    }

   /* @Test
    void embeddedId() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        DepartmentId id = new DepartmentId();
        id.setCompanyId("pzn");
        id.setDepartmentId("tech");

        Department department = new Department();
        department.setId(id);
        department.setName("Teknologi");

        entityManager.persist(department);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void embeddedIdFind() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        DepartmentId id = new DepartmentId();
        id.setCompanyId("pzn");
        id.setDepartmentId("tech");

        Department department = entityManager.find(Department.class, id);
        Assertions.assertEquals("Teknologi", department.getName());

        entityTransaction.commit();
        entityManager.close();
    }*/
}
