package ex3.command;


import ex3.device.Fan;

public class FanOnCommand implements Command {
    private Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.on();
    }

    @Override
    public void undo() {
        System.out.print("Undo: ");
        fan.off();
    }
}
