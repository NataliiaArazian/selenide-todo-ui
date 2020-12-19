package todo;

import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.CollectionCondition.noneMatch;
import static com.codeborne.selenide.Condition.text;

public class SelectUnselectAllTodoTest extends BaseTest {

    @Test
    public void selectAllTodo() {
        Todo.create("Read Book");
        Todo.toggleAll();

        Todo.count().shouldHave(text("0 items left"));
        Todo.list().shouldHave(allMatch(
                "Should be completed", el -> el.getAttribute("class").contains("completed"))
        );
    }

    @Test
    public void unselectAllTodo() {
        Todo.create("Read Book");
        Todo.create("Do your homework");
        Todo.toggleAll();
        Todo.toggleAll();

        Todo.count().shouldHave(text("2 items left"));
        Todo.list().shouldHave(noneMatch(
                "Should be not completed", el -> el.getAttribute("class").contains("completed"))
        );
    }
}
