package doublylinkedlist.texteditor;

public class TextEditorApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        // Adding text states
        editor.addTextState("Hello");
        editor.addTextState("Hello, World");
        editor.addTextState("Hello, World! This is a test.");
        editor.addTextState("Hello, World! This is a text editor.");

        // Display current state
        editor.displayCurrentState();

        // Undo operations
        editor.undo();
        editor.undo();

        // Redo operation
        editor.redo();

        // Display current state
        editor.displayCurrentState();
    }
}
