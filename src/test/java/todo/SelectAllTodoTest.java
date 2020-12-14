package todo;

import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.Condition.text;

public class SelectAllTodoTest extends BaseTest {

    @Test
    public void createTodo() {
        Todo.create("Read Book");
        Todo.toggleAll();

        Todo.count().shouldHave(text("0 items left"));
        Todo.list().shouldHave(allMatch(
                "Should be completed",
                el -> el.getAttribute("class").contains("completed"))
        );
    }
}
