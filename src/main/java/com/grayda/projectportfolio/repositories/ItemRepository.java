package com.grayda.projectportfolio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grayda.projectportfolio.models.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{
	List<Item> findAll();

}
