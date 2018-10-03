package TestSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import dummyTests.ContactMessTest;
import dummyTests.NavigationLinksTest;
import dummyTests.WebAppPageTitleTest;

@RunWith(Suite.class)
@Suite.SuiteClasses ({
	ContactMessTest.class,
	NavigationLinksTest.class,
	WebAppPageTitleTest.class
})

public class AllTestSuite {}
