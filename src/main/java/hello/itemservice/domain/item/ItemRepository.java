package hello.itemservice.domain.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {

	private static final Map<Long, Item> store = new HashMap<>(); //static
	private static long sequence = 0L; //static

	public Item save(Item item) {
		item.setId(++sequence);
		store.put(item.getId(), item);
		return item;
	}

	public Item findById(Long id) {
		return store.get(id);
	}

	public List<Item> findAll() {
		return new ArrayList<>(store.values());
	}

	public void update(Long itemId, Item updateParam) {
		Item findItem = findById(itemId);
		findItem.setItemName(updateParam.getItemName());
		findItem.setPrice(updateParam.getPrice());
		findItem.setQuantity(updateParam.getQuantity());
		findItem.setOpen(updateParam.getOpen());
		findItem.setDeliveryCode(updateParam.getDeliveryCode());
		findItem.setRegions(updateParam.getRegions());
		findItem.setItemType(updateParam.getItemType());
	}

	public void clearStore() {
		store.clear();
	}

}
