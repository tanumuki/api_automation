package pagination;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PaginationValidator {

    private static boolean hasDuplicateItems(List<String> items) {
        List<String> temp = new ArrayList<String>();

        for (String item : items) {
            if (temp.indexOf(item)!=-1) {
//                if the item is already present in the list
                log.error("FAILED: Duplicates found! \"" + item + "\" has been seen earlier!");
                return false;
            }
            else {
                temp.add(item);
            }
        }
        return true;
    }

    public static boolean paginationDuplicateValidator(List<String> items) {
        return hasDuplicateItems(items);
    }
}
