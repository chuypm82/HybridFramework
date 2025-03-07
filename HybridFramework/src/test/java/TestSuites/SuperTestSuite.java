package TestSuites;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*
 * This is a test suite class that we will create to run all our tests
 * Follow along to see how its done Pay special attention to annotations
 */

@RunWith(Categories.class)
@Categories.IncludeCategory( // Choose only one category to run
		RunLocalTestInterface.class // use test suite in @Suite.SuiteClasses RunLocalTestSuite
		// SeleniumGridInterface.class
		// SeleniumGrid_EdgeInterface.class
		)
@Categories.ExcludeCategory(
		// RunLocalTestInterface.class // use test suite in @Suite.SuiteClasses RunLocalTestSuite
		// SeleniumGridInterface.class
		// SeleniumGrid_EdgeInterface.class
		)
@Suite.SuiteClasses({
	RunLocalTestSuite.class, // Corresponding to RunLocalInterface.class
	// SeleniumGridTestSuite.class
	// SeleniumGrid_EdgeTestSuite.class	
})

public class SuperTestSuite {

}
