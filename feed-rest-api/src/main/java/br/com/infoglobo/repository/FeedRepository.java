package br.com.infoglobo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.infoglobo.domain.Feed;

@Repository
public interface FeedRepository extends MongoRepository<Feed, String> {
	Feed findTopByOrderByCreatedDesc();
}
