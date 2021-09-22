package lab;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class test {
	swlab2 counter = new swlab2();
	@DisplayName("UnitTest")
	@ParameterizedTest(name = "{index} {0} {1}")
	@MethodSource("parameterDataProvider")
	void testcase(String path,int level,String res) throws FileNotFoundException {
		assertEquals(res, counter.keycounter(path,level));
	}

	private static Stream<Arguments> parameterDataProvider() {
		return Stream.of(
				Arguments.of("C:\\Users\\lenovo\\Desktop\\text.txt",4, "total num:35\n" + 
						"switch num:2\n" + 
						"case num:3 2 \n" + 
						"if-else num:2\n" + 
						"if-elseif-else num:2\n")
				,Arguments.of("C:\\Users\\lenovo\\Desktop\\text.txt",3, "total num:35\n" + 
						"switch num:2\n" + 
						"case num:3 2 \n" + 
						"if-else num:2\n")
				,Arguments.of("C:\\Users\\lenovo\\Desktop\\text.txt",2, "total num:35\n" + 
						"switch num:2\n" + 
						"case num:3 2 " 
						)
				,Arguments.of("C:\\Users\\lenovo\\Desktop\\text.txt",1, "total num:35\n" )
				,Arguments.of("C:\\Users\\lenovo\\Desktop\\text2.txt",4, "total num:58\n" + 
						"switch num:3\n" + 
						"case num:3 3 2 \n" + 
						"if-else num:4\n" + 
						"if-elseif-else num:4\n" 
						)
				,Arguments.of("C:\\Users\\lenovo\\Desktop\\text2.txt",3, "total num:58\n" + 
						"switch num:3\n" + 
						"case num:3 3 2 \n" + 
						"if-else num:4\n"
						)
				,Arguments.of("C:\\Users\\lenovo\\Desktop\\text2.txt",2, "total num:58\n" + 
						"switch num:3\n" + 
						"case num:3 3 2 " 
						)
				,Arguments.of("C:\\Users\\lenovo\\Desktop\\text2.txt",1, "total num:58\n"
						)
				);
	}
}