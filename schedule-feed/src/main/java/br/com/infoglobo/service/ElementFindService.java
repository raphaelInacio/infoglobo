package br.com.infoglobo.service;

import java.util.List;
import java.util.Optional;

import br.com.infoglobo.domain.Description;

public interface ElementFindService {
	public List<Description> find(Optional<String> content);
}
