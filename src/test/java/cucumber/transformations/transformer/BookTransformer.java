package cucumber.transformations.transformer;

import cucumber.transformations.models.Book;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class BookTransformer {

    @DataTableType
    public Book bookEntryTransformer(Map<String, String> row) {
        return new Book(
                row.get("title"),
                row.get("author"),
                Integer.parseInt(row.get("yearOfPublishing"))
        );
    }

}
