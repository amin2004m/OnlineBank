package az.bank.onlineBank.repositories;

import az.bank.onlineBank.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query("SELECT u FROM User u LEFT JOIN FETCH u.accounts WHERE u.username = :username AND u.password = :password")
    Optional<User> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.accounts WHERE u.username = :username")
    Optional<User> findByUsername(@Param("username") String username);

    Optional<User> findById(Long id);
}
