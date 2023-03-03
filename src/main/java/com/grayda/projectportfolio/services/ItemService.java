package com.grayda.projectportfolio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grayda.projectportfolio.models.Item;
import com.grayda.projectportfolio.repositories.ItemRepository;

@Service
public class ItemService {
	@Autowired
	ItemRepository itemRepo;
	
	// GETTING ALL ITEM
	public List<Item> s_allItem(){
		return itemRepo.findAll();
	}
	
	// ADDING NEW ITEM
	public Item s_addItem(Item item) {
		return itemRepo.save(item);
	}

	// UPDATE EXISTING ITEM
	public Item s_updateItem(Item item) {
		return itemRepo.save(item);
	}

	//deletes an ITEM
	public void s_deleteItem(Long id) {	
		Optional<Item> optionalItem = itemRepo.findById(id);
		
		if(optionalItem.isPresent()) {
			itemRepo.deleteById(id);
		}		
	}

	// FINDING ID OF ITEM
	public Item s_findItem(Long id){
		Optional<Item> optionalItem = itemRepo.findById(id);
		
		if(optionalItem.isPresent()) {
			return optionalItem.get();
		}
		else {
			return null;
		}		
	}
}
