package com.thex.clients.repository;

import java.util.List;

import com.thex.clients.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository Interface Choice:
 * This class extends the JpaRepository interface, which offers a wide range
 * of CRUD operations as well as pagination and sorting functionality. It is
 * convenient to use when you need a repository with comprehensive operations
 * and do not require granular control over repository operations.
 *
 * Alternatively, you can extend the PagingAndSortingRepository and CrudRepository
 * interfaces separately if you need more specific functionality or detailed control
 * over operations.
 */
public interface ClientRepository extends JpaRepository<ClientModel, Long> {}


