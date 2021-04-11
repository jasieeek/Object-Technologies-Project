package pl.jasiek.app.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggerClass {

    @Before(value = "execution(void pl.jasiek.app.controller.ModifyItemCommand.execute(..))")
    public void logBeforeItemModification() {
        System.out.println("The item modification starts...");
    }

    @After(value = "execution(void pl.jasiek.app.controller.ModifyItemCommand.execute(..))")
    public void logAfterItemModification() {
        clean();
        System.out.println("The item modification has been finished!");
    }

    @Before(value = "execution(void pl.jasiek.app.controller.AddItemCommand.execute(..))")
    public void logBeforeItemCreating() {
        System.out.println("The item creating starts...");
    }

    @After(value = "execution(void pl.jasiek.app.controller.AddItemCommand.execute(..))")
    public void logAfterItemCreating() {
        clean();
        System.out.println("The item creating has been finished!");
    }

    @Before(value = "execution(void pl.jasiek.app.controller.RemoveItemCommand.execute(..))")
    public void logBeforeItemRemoving() {
        System.out.println("The item removing starts...");
    }

    @After(value = "execution(void pl.jasiek.app.controller.RemoveItemCommand.execute(..))")
    public void logAfterItemRemoving() {
        clean();
        System.out.println("The item removing has been finished!");
    }

    private void clean() {
        final int limit = 25;
        for (int i = 0; i < limit; i++) {
            System.out.println("\n");
        }
    }
}
