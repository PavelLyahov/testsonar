package stepdefinitions;

import cucumber.transformations.models.Book;
import io.cucumber.java.en.Given;

import java.util.List;

public class ListObjectsSteps {

    @Given("the following books")
    public void theFollowingBooks(List<Book> books) {
        for(Book book: books) {
            System.out.printf(
                    "'%s', published in %d, was written by %s\n",
                    book.getTitle(),
                    book.getYearOfPublishing(),
                    book.getAuthor()
            );
        }
    }
}
