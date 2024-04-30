package algorithmOne.codeKata.baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class editorSolve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Character> list = new LinkedList<>(); // Use LinkedList for efficient editing
        String initialText = br.readLine(); // Initial text
        int commandsCount = Integer.parseInt(br.readLine()); // Read number of commands

        // Initialize the list with initial text
        for (char c : initialText.toCharArray()) {
            list.add(c);
        }

        ListIterator<Character> iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.next(); // Move iterator to the end of the list
        }

        for (int i = 0; i < commandsCount; i++) {
            String command = br.readLine();
            switch (command.charAt(0)) {
                case 'L':
                    if (iterator.hasPrevious()) iterator.previous();
                    break;
                case 'D':
                    if (iterator.hasNext()) iterator.next();
                    break;
                case 'B':
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                case 'P':
                    char toInsert = command.split(" ")[1].charAt(0);
                    iterator.add(toInsert);
                    break;
            }
        }

        for (char c : list) {
            bufferedWriter.write(c);
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
