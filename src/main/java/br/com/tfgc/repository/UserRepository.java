package br.com.tfgc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.tfgc.domain.UserDomain;

@Repository
public interface UserRepository extends CrudRepository<UserDomain, Long> {

	List<UserDomain> findByNameContainingIgnoreCase(String name);
	
}
