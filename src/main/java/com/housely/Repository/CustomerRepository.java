package com.housely.Repository;

import com.housely.Model.Customer.Customer;
import com.housely.Model.Favorite.FavoriteList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT f FROM FavoriteList f WHERE f.customer.id = :customerId")
    Optional<List<FavoriteList>> findFavoritesByCustomerId(@Param("customerId") Long customerId);

    Optional<Customer> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<Customer> findByPassword(String password);
    Optional<Customer> findByEmailAndPassword(String email, String password);
}
