package todo;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;

public class ClearCompleteTodoTest extends BaseTest {

    @Test
    public void createTodo() {
        Todo.create("Read Book");

        Todo.markCompleted("Read Book");

        Todo.clearCompleted();

        Todo.count().shouldNot(exist);
        Todo.main().shouldNot(exist);
        Todo.footer().shouldNot(exist);
    }
}
