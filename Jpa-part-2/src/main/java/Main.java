import entity.Brand;
import entity.Product;
import entity.ProductDetails;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
//
//        Brand brand = Brand.builder()
//                .name("Apple")
//                .description("Nasdaq > 3 trillion ")
//                .build();
//        ProductDetails productDetails = ProductDetails.builder()
//                .description("good product")
//                .ram("8 gb")
//                .color("white")
//                .weight("225 q")
//                .build();

//        Set<Product> products = Set.of(
//                Product.builder()
//                        .name("Iphone")
//                        .price(new BigDecimal(2000))
//                        .count(10)
//                        .brand(brand)
//                        .productDetails(productDetails)
//                        .build(),
//                Product.builder()
//                        .name("Ipad")
//                        .price(BigDecimal.valueOf(3000))
//                        .count(6)
//                        .productDetails(productDetails)
//                        .brand(brand)
//                        .build());


//        transaction.begin();
//
//        TypedQuery<Brand> brandTypedQuery = entityManager.createQuery("select b from Brand b", Brand.class);
//        List<Brand> resultList = brandTypedQuery.getResultList();
//        for (Brand brandDb : resultList) {
//            System.out.println(brandDb.getProducts());
//        }
//        transaction.commit();
//
//
//
//
//        transaction.begin();
//        TypedQuery<Brand> query = entityManager.createQuery("select b from Brand b where id = :id", Brand.class);
//        query.setParameter("id",1);
//        Brand brandDb = query.getSingleResult();
//        System.out.println(brandDb);
//        transaction.commit();
//
//        transaction.begin();
//        TypedQuery<Brand> typedQuery = entityManager.createNamedQuery("findByName", Brand.class);
//        String name = "appleOne";
//        String description = "sdfsfsd";
//
//
//        typedQuery.setParameter("name", "%" + name + "%");
//        typedQuery.setParameter("description", "%" + description + "%");
//        Brand singleResult = typedQuery.getSingleResult();
//        singleResult.setName("alma");
//        Set<Product> ipadAlma = singleResult.getProducts().stream()
//                .filter(product -> product.getId() == 1)
//                .peek(product -> product.setName("sdfsd"))
//                .peek(product -> product.getProductDetails().setWeight("sdfsdfsdf")).collect(Collectors.toSet());
//
//        singleResult.setProducts(ipadAlma);
//
//
//        System.out.println(singleResult);
//        entityManager.merge(singleResult);
//        transaction.commit();




//        EntityGraph<Brand> entityGraph = entityManager.createEntityGraph(Brand.class);
//        entityGraph.addAttributeNodes("products");
//
//        Subgraph<Product> subgraph = entityGraph.addSubgraph("products");
//        subgraph.addAttributeNodes("productDetails"); // to times throw left join query
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("jakarta.persistence.fetchgraph",entityGraph);
//
//        Brand brandDb = entityManager.find(Brand.class,1,map);
//        System.out.println(brandDb);
        transaction.begin();

        transaction.commit();


    }
}
