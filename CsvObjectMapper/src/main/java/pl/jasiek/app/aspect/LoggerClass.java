package pl.jasiek.app.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import static pl.jasiek.app.aspect.Colors.ANSI_GREEN;
import static pl.jasiek.app.aspect.Colors.ANSI_RESET;

@Aspect
public class LoggerClass {

    @Pointcut("execution(void pl.jasiek.app.controller.ModifyItemCommand.execute(..))")
    private void everyItemModifyExecute() {}

    @Pointcut("execution(void pl.jasiek.app.controller.AddItemCommand.execute(..))")
    private void everyItemAddExecute() {}

    @Pointcut("execution(void pl.jasiek.app.controller.RemoveItemCommand.execute(..))")
    private void everyItemRemoveExecute() {}

    @Before(value = "everyItemModifyExecute()")
    public void logBeforeItemModification() {
        System.out.println("The item modification starts...");
    }

    @After(value = "everyItemModifyExecute()")
    public void logAfterItemModification() {
        Cleaner.clean();
        System.out.println(ANSI_GREEN + "The item modification has been finished!" + ANSI_RESET);
    }

    @Before(value = "everyItemAddExecute()")
    public void logBeforeItemCreating() {
        System.out.println("The item creating starts...");
    }

    @After(value = "everyItemAddExecute()")
    public void logAfterItemCreating() {
        Cleaner.clean();
        System.out.println(ANSI_GREEN + "The item creating has been finished!" + ANSI_RESET);
    }

    @Before(value = "everyItemRemoveExecute()")
    public void logBeforeItemRemoving() {
        System.out.println("The item removing starts...");
    }

    @After(value = "everyItemRemoveExecute()")
    public void logAfterItemRemoving() {
        Cleaner.clean();
        System.out.println(ANSI_GREEN + "The item removing has been finished!" + ANSI_RESET);
    }
}
