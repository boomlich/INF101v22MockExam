package inf101v22.mockexam.fridge;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class EasyFridge implements IFridge{

    ArrayList<FridgeItem> items = new ArrayList<FridgeItem>();
    
    @Override
    public int nItemsInFridge() {
        return items.size();
    }

    @Override
    public int totalSize() {
        return 1;
    }

    @Override
    public boolean placeIn(FridgeItem item) {
        if(items.isEmpty()) {
            items.add(item);
            return true;
        }
        return false;
    }

    @Override
    public void takeOut(FridgeItem item) {
        if(items.isEmpty())
            throw new NoSuchElementException("Fridge is empty");
        
    }

    @Override
    public void emptyFridge() {
        items.clear();
    }

    @Override
    public List<FridgeItem> removeExpiredFood() {
        ArrayList<FridgeItem> toReturn = new ArrayList<FridgeItem>();
        toReturn.addAll(items);
        emptyFridge();
        return toReturn;
    }

}
