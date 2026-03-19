package ex3.remote;

import ex3.command.Command;

import java.util.Stack;

public class UndoManager {
    private Stack<Command> history = new Stack<>();

    public void push(Command cmd) {
        history.push(cmd);
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command cmd = history.pop();
            cmd.undo();
        } else {
            System.out.println("Không có lệnh để undo");
        }
    }
}
