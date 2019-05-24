package com.shoestore.repo;

import com.shoestore.domain.ShoeInventory;
import com.shoestore.domain.ShoeModel;

//TODO: Repository needs to be implemented!
public interface ShoeInventoryRepo {

	ShoeInventory getShoeInventoryByShoeModel(ShoeModel model);

	ShoeInventory commit(ShoeInventory inventory);
	void rollback(ShoeInventory inventory);

}
