package todo;

import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;

public class CreateTodoTest extends BaseTest {

    @Test
    public void createTodo() {
        Todo.create("Read Book");

        Todo.list().shouldHave(size(1));
        Todo.list().first().shouldHave(text("Read Book"));
        Todo.count().shouldHave(text("1 item left"));
    }
}
