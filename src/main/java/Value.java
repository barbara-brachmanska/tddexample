public class Value {

	private Integer value;

	public Value(Integer value) {
		this.value = value;
	}

	public boolean isOdd() {
		if (value == null) {
			throw new IllegalArgumentException("Value should not be null!");
		}
		return value % 2 != 0;
	}
}
