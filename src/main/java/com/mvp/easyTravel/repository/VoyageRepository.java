package com.mvp.easyTravel.repository;

import com.mvp.easyTravel.entity.Voyage;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoyageRepository extends JpaRepository<Voyage, Long> {

}
