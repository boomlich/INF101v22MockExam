package inf101v22.mockexam.fridge;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Fridge implements IFridge {
	
	private final int maxItems = 20;
	private List<FridgeItem> items;
	
	public Fridge() {
		items = new ArrayList<FridgeItem>();
	}
	
	public Fridge(List<FridgeItem> items) {
		if (items.size() > maxItems)
			throw new IndexOutOfBoundsException("Cannot store that many items in the fridge ");
		this.items = items;
	}

	@Override
	public int nItemsInFridge() {
		return items.size();
	}

	@Override
	public int totalSize() {
		return maxItems;
	}

	@Override
	public boolean placeIn(FridgeItem item) {
		if (item == null)
			throw new IllegalArgumentException("Cannot add null to the fridge.");
		if (items.size() >= maxItems)
			return false;
		
		return items.add(item);
	}

	@Override
	public void takeOut(FridgeItem item) {
		if (!items.contains(item)) {
            throw new NoSuchElementException("This item is not in the fridge.");
        }
		items.remove(item);
	}

	@Override
	public void emptyFridge() {
		items.clear();
	}

	@Override
	public List<FridgeItem> removeExpiredFood() {
		List<FridgeItem> expiredItems = new ArrayList<>();
		for (FridgeItem item : items) {
			if (item.hasExpired())
				expiredItems.add(item);
		}
		for (FridgeItem item : expiredItems)
			items.remove(item);
		
		return expiredItems;
	}
	
}
