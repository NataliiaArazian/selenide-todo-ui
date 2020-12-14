package todo;

import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.Condition.text;

public class CompleteTodoTest extends BaseTest {

    @Test
    public void shouldMarkTodoItemAsCompleted() {
        Todo.create("Read Book");

        Todo.markCompleted("Read Book");

        Todo.count().shouldHave(text("0 items left"));
        Todo.list().shouldHave(allMatch(
                "Should be completed",
                el -> el.getAttribute("class").contains("completed"))
        );
    }
}
