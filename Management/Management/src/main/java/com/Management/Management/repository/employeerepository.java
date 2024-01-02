package com.Management.Management.repository;

import com.Management.Management.model.employee;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Locale;

@Repository
public interface employeerepository extends JpaRepository<employee, UUID> {

}
