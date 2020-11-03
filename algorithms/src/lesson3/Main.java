package lesson3;

public class Main {
    public static void main(String[] args) {
        String text = "Hello world";

        Stack<Character> queue = new Stack<>(text.length());

        for (int i = 0; i < text.length(); i++) {
            queue.push(text.charAt(i));
        }

        StringBuilder outText = new StringBuilder();

        while( !queue.isEmpty() ){
            outText.append(queue.pop());
        }

        System.out.println("текст до    - " + text);
        System.out.println("текст после - " + outText);
    }
}
