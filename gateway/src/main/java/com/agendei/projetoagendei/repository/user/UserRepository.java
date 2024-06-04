package com.agendei.projetoagendei.repository.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.agendei.projetoagendei.model.user.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID>{
    UserModel findByEmail(String email);
}
