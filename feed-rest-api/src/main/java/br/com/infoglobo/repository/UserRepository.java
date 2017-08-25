package br.com.infoglobo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.infoglobo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
}
