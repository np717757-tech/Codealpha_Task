import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CodeAlpha_Chatbot {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChatFrame().setVisible(true));
    }
}

class ChatFrame extends JFrame {
    private JTextArea chatArea = new JTextArea(12, 40);
    private JTextField inputField = new JTextField(30);
    private JButton sendBtn = new JButton("Send");

    ChatFrame() {
        setTitle("CodeAlpha Simple Chatbot");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chatArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(chatArea);
        JPanel bottom = new JPanel();
        bottom.add(inputField);
        bottom.add(sendBtn);
        add(scroll, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);

        sendBtn.addActionListener(e -> processInput());
        inputField.addActionListener(e -> processInput());

        appendBot("Hello! I'm CodeAlpha. Ask me about: hello, time, help, grades, bye.");
    }

    private void processInput() {
        String user = inputField.getText().trim();
        if (user.isEmpty()) return;
        appendUser(user);
        String reply = respond(user);
        appendBot(reply);
        inputField.setText("");
    }

    private void appendUser(String s) {
        chatArea.append("You: " + s + "\n");
    }

    private void appendBot(String s) {
        chatArea.append("Bot: " + s + "\n\n");
    }

    private String respond(String input) {
        String low = input.toLowerCase();

        if (low.contains("hello") || low.contains("hi") || low.contains("hey")) {
            return "Hi! How can I help you today?";
        }
        if (low.contains("time")) {
            return "I don't have a real clock in this demo, but you can use java.time in real projects.";
        }
        if (low.contains("grades") || low.contains("grade") || low.contains("score")) {
            return "I can calculate grades. Provide marks and I'll return a letter grade (A-F).";
        }
        if (low.contains("help") || low.contains("what can you do")) {
            return "I can answer simple questions and respond to keywords. Try: hello, time, grades, bye.";
        }
        if (low.contains("bye") || low.contains("exit") || low.contains("quit")) {
            return "Goodbye! Have a nice day.";
        }

        // fallback: simple small-talk rules
        if (low.contains("how are you")) {
            return "I'm a program, so I'm always okay! :)";
        }

        // generic fallback
        return "Sorry, I don't understand that yet. Try: hello, time, grades, help, bye.";
    }
}
