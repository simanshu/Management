package com.Management.Management.repository;

import com.Management.Management.model.boss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface bossrepository extends JpaRepository<boss, UUID> {
}
