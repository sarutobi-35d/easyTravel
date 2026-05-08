package com.mvp.easyTravel.repository;

import com.mvp.easyTravel.entity.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Long, Utilisateurs> {

}
