package doublylinkedlist.texteditor;

class TextEditor {
    private TextState current;
    private int historySize;
    private int maxHistory = 10; // Limit history to 10 states

    public TextEditor() {
        this.current = new TextState(""); // Initial empty state
        this.historySize = 1;
    }

    // Add a new text state (typing or performing an action)
    public void addTextState(String newText) {
        TextState newState = new TextState(newText);
        newState.prev = current;
        current.next = newState;
        current = newState;
        historySize++;

        // If history exceeds max size, remove the oldest state
        if (historySize > maxHistory) {
            TextState temp = current;
            while (temp.prev != null && historySize > maxHistory) {
                temp = temp.prev;
                historySize--;
            }
            temp.prev = null; // Remove oldest reference
        }
    }

    // Undo operation (move to previous state)
    public void undo() {
        if (current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.content);
        } else {
            System.out.println("No more undo steps available.");
        }
    }

    // Redo operation (move to next state)
    public void redo() {
        if (current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.content);
        } else {
            System.out.println("No more redo steps available.");
        }
    }

    // Display current text state
    public void displayCurrentState() {
        System.out.println("Current State: " + current.content);
    }
}
