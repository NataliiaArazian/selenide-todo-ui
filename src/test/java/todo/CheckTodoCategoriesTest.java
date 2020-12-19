package todo;

import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;

public class CheckTodoCategoriesTest extends BaseTest{

    @Test
    public void shouldReturnAllTodoCategories() {
        Todo.create("Read Book");
        Todo.create("Do your homework");
        Todo.markCompleted("Read Book");

        Todo.list().shouldHave(size(2));
    }

    @Test
    public void shouldReturnActiveTodoCategories() {
        Todo.create("Read Book");
        Todo.create("Do your homework");
        Todo.markCompleted("Read Book");
        Todo.selectActiveTodos();

        Todo.list().shouldHave(size(1));
        Todo.list().first().shouldHave(text("Do your homework"));
    }

    @Test
    public void shouldReturnCompleteTodoCategories() {
        Todo.create("Read Book");
        Todo.create("Do your homework");
        Todo.markCompleted("Read Book");
        Todo.selectCompletedTodos();

        Todo.list().shouldHave(size(1));
        Todo.list().first().shouldHave(text("Read Book"));
    }

}
