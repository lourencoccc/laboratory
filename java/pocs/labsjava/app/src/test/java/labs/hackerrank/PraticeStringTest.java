package labs.hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class PraticeStringTest {

	@Test
	public void shouldGetLengthStringOrderAndCaptilize() {
		// Given
		var A = "hello";
		var B = "java";

		// When
		int lengthSum = A.length() + B.length();
		String lexicoComparation = A.compareTo(B) > 0 ? "Yes" : "No";
		A = A.substring(0, 1).toUpperCase() + A.substring(1);
		B = B.substring(0, 1).toUpperCase() + B.substring(1);

		// Then
		assertEquals(9, lengthSum);
		assertEquals("No", lexicoComparation);
		assertEquals("Hello Java", A + " " + B);
	}

	@Test
	public void shouldSplitStringAndCompare() {
		// Given
		var s = "welcometojava";
		int k = 3;
		String smallest;
		String largest;

		// When
		List<String> words = new ArrayList<>();
		for (int i = 0; i < s.length() - (k - 1); i++) {
			words.add(s.substring(i, k + i));
		}

		words.sort((o1, o2) -> o1.compareTo(o2));
		smallest = words.get(0);
		largest = words.get(words.size() - 1);

		// Then
		assertEquals(11, words.size());
		assertEquals("ava", smallest);
		assertEquals("wel", largest);
	}

	@Test
	public void shouldValidAPolindrome() {
		// Given
		var word = "madam";
		String result = "No";
		boolean isPolindrome = false;
		// When
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == word.charAt(word.length() - (i + 1))) {
				isPolindrome = true;
			} else {
				isPolindrome = false;
			}
		}

		result = isPolindrome ? "Yes" : "No";

		// Then
		assertEquals("Yes", result);
	}

	@Test
	public void shouldValidAPolindromeWithReverse() {
		// Given
		var word = "madam";
		String result = "No";
		boolean isPolindrome = false;
		// When
		var sb = new StringBuilder(word);
		result = word.equals(sb.reverse().toString()) ? "Yes" : "No";

		// Then
		assertEquals("Yes", result);
	}

	@Test
	public void shouldIndentifyAnagram() {
		// Given
		var a = "Hello";
		var b = "hello";
		var isAnagram = false;

		// When
		Map<String, Long> aFreq = Stream.of(a.toLowerCase().split(""))
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()));

		Map<String, Long> bFreq = Stream.of(b.toLowerCase().split(""))
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()));

		isAnagram = aFreq.size() == bFreq.size() 
				&& aFreq.keySet().stream()
				.allMatch(k -> bFreq.containsKey(k) && bFreq.get(k) == aFreq.get(k));
		

		// Then
		assertTrue(isAnagram);

	}
}
