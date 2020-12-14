package todo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Todo {
    public static void create(String title) {
        $(".new-todo").val(title).pressEnter();
    }

    public static ElementsCollection list() {
        return $$(".todo-list li");
    }

    public static SelenideElement count() {
        return $(".todo-count");
    }

    public static void markCompleted(String title) {
        Todo.list().find(Condition.text(title)).parent().$(".toggle").click();
    }

    public static void clearCompleted() {
        $(".clear-completed").click();
    }

    public static SelenideElement main() {
        return $(".main");
    }

    public static SelenideElement footer() {
        return $(".footer");
    }

    public static void toggleAll() {
        $("#toggle-all").click();

    }
}
