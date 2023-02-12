package br.com.kleryton.api.repositories;

import br.com.kleryton.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositorie extends JpaRepository<User, Integer> {

}
