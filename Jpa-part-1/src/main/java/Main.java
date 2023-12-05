import entity.User;
import entity.embeded.UserDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        User user = User.builder()
                .username("srthealik")
                .birthdate(LocalDate.now())
                .password("123456")
                .userDetails(UserDetails.builder()
                        .phoneNumber("0556936692")
                        .email("ali.cab@div.edu.az")
                        .address("Baku")
                        .build())
                .description("asdfghjkl")
                .notes(Arrays.asList("asdfg","asdfgh","sdfghfghj"))
                .build();

        transaction.begin();

        entityManager.persist(user);
//        User userDb = entityManager.find(User.class, 2);
//        userDb.setUsername("alicab");
//        entityManager.merge(userDb);
//        entityManager.remove(userDb);

        transaction.commit();
//
//        System.out.println("-------------------------------------------\n\n\n\n\n\n\n\n"+
//                userDb+"\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
