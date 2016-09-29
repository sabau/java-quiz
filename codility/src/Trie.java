import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Trie {

	private final Map<Character, HashMap> root = new HashMap<>();
	private final Character END_CHARACTER = '$';

	public Trie() {
	}

	public Trie(final String s) {
		internalAdd(s);
	}

	public Trie(final Collection<String> collection) {
		for (String s : collection) {
			internalAdd(s);
		}
	}

	public void add(final String s) {
		internalAdd(s);
	}

	private void internalAdd(final String s) {
		Map<Character, HashMap> node = root;

		for (int i = 0; i < s.length(); i++) {
			Character character = s.charAt(i);
			if (node.isEmpty() || !node.containsKey(character)) {
				internalAdd(s.substring(i), node);
				break;
			}
			node = node.get(character);
		}
		node.put(END_CHARACTER, new HashMap<>());
	}

	private void internalAdd(final String s, Map<Character, HashMap> node) {
		for (int i = 0; i < s.length(); i++) {
			Character character = s.charAt(i);
			node.put(character, new HashMap<>());
			node = node.get(character);
		}
	}

	public boolean contains(final String s) {
		Map<Character, HashMap> node = root;

		for (int i = 0; i < s.length(); i++) {
			if (node.isEmpty()) {
				return false;
			}
			Character character = s.charAt(i);
			if (node.containsKey(character)) {
				node = node.get(character);
			} else {
				return false;
			}
		}
		return node.containsKey(END_CHARACTER);
	}
}