import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@RunWith(JUnitParamsRunner.class)
public class ValueTest {

	public Object paramsForOddity() {
		return new Object[][]{
				{1, true},
				{2, false},
				{7, true},
				{0, false},
				{-3, true},
				{Integer.MAX_VALUE, true}
		};
	}

	@Test
	@Parameters(method = "paramsForOddity")
	public void shouldFollowsParameters(Integer param, boolean expected) throws Exception {
		// given
		Value value = new Value(param);

		// when
		boolean actual = value.isOdd();

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void shouldThrowsIllegalArgumentExceptionForNull() throws Exception {
		Value value = new Value(null);

		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> value.isOdd())
				.withMessage("Value should not be null!")
				.withNoCause();
	}
}

