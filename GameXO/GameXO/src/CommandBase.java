public abstract class CommandBase {
    protected Control  control ;
    protected App app;

    public CommandBase(Control control,App app) {
        this.control = control;
        this.app= app;
    }

    public abstract void execute();
}
