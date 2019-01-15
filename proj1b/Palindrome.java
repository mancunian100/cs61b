/**
 * Created by mancunian100 on 2019/01/14
 */

public class Palindrome {

    /** convert the input word to a character deque. */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    /** return true if the given word is a palindrome. */
    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);
        int size = wordDeque.size();
        if (size == 0 | size == 1) {
            return true;
        } else {
            Character head = wordDeque.removeFirst();
            Character end = wordDeque.removeLast();
            if (head != end) {
                return false;
            } else {
                return isPalindrome(dequeToWord(wordDeque));
            }
        }
    }

    /** a method overloads the method isPalindrome. */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = wordToDeque(word);
        int size = wordDeque.size();
        if (size == 1 | size == 0) {
            return true;
        } else {
            Character head = wordDeque.removeFirst();
            Character end = wordDeque.removeLast();
            if (!cc.equalChars(head, end)) {
                return false;
            } else {
                return isPalindrome(dequeToWord(wordDeque), cc);
            }
        }
    }

    /** a helper method for isPalindrome. */
    private String dequeToWord(Deque deque) {
        String word = "";
        while (deque.size() > 0) {
            word += deque.removeFirst();
        }
        return word;
    }
}
