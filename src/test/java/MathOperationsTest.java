
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MathOperationsTest {

	static MathOperations mat;
	TestInfo testInfo;
	TestReporter testReporter;
	
	
	static MathOperationsService mathService=Mockito.mock(MathOperationsService.class);
	
//	@Mock
//	static
//	MathOperationsService mathService;
	
	@BeforeAll
	static void beforeAllMethods() {
		mat=new MathOperations(mathService);
	}
	
	
	@BeforeEach
	void beforeEachMethod(TestInfo testInfo,TestReporter testReporter) {
		this.testInfo=testInfo;
		this.testReporter=testReporter;
		testReporter.publishEntry("Running "+testInfo.getDisplayName()+" with tag "+testInfo.getTags());
	}
	
	
	
	@Test
	@DisplayName("addTest")
	@Tag("math")
	public void addTest() {
		when(mathService.perform(2, 3)).thenReturn(5);
		assertEquals(5,mat.add(2, 3));
//        System.out.println("Running "+testInfo.getDisplayName()+" with tag "+testInfo.getTags());
	}
	
	@Test
	@DisplayName("subTest")
	@Tag("math")
	public void subTest() {
		assertAll(
				()->assertEquals(2,mat.sub(5, 3)),
				()->assertEquals(-8,mat.sub(-3,5))
				);
	}
	
	@Nested
	@Tag("math")
	class MultiplyTest{
		@Test
		public void multiplyTestPos() {
			assertEquals(9,mat.multiply(3, 3));
		}
		
		@Test
		public void multiplyTestNeg() {
			assertEquals(-6,mat.multiply(3, -2));
		}
	}
	
	@Test
	@DisplayName("divideTest")
	@Tag("math")
	public void divideTest() {
		assertThrows(ArithmeticException.class,()->mat.divide(2, 0));
	}
}
