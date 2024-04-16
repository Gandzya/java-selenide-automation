package base;

import ch.qos.logback.classic.Logger;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.slf4j.LoggerFactory;

import java.util.*;


public class CustomTestWatcher implements TestWatcher, BeforeAllCallback, BeforeEachCallback {

	public static final Logger log = (Logger) LoggerFactory.getLogger(CustomTestWatcher.class);

	@Override
	public void testSuccessful(ExtensionContext extensionContext) {
		log.info("Test '{}' - PASSED\n", extensionContext.getDisplayName());
	}

	@Override
	public void testFailed(ExtensionContext extensionContext, Throwable e) {
		log.info("Test '{}' - FAILED\nReason: '{}'\n", extensionContext.getDisplayName(), e.getMessage());
	}

	@Override
	public void testAborted(ExtensionContext extensionContext, Throwable e) {
		log.info("Test '{}' - ABORTED\nReason: '{}'\n", extensionContext.getDisplayName(), e.getMessage());
	}

	@Override
	public void testDisabled(ExtensionContext extensionContext, Optional reason) {
		log.info("Test '{}' - ABORTED\nReason: '{}'\n", extensionContext.getDisplayName(), reason.toString());
	}

	@Override
	public void beforeAll(ExtensionContext context)  {
		log.info("Tests started on {}", Configuration.baseUrl);
		log.info("Browser: {}", Configuration.browser);
		log.info("Browser version: {}", Configuration.browserVersion);
		log.info("Browser size: {}", Configuration.browserSize);
		log.info("Selenide remote: ");
		log.info(Configuration.remote == null ? "NULL" : Configuration.remote);
	}

	@Override
	public void beforeEach(ExtensionContext context) {
		log.info("START TEST {} with Tags {}", context.getDisplayName(), context.getTags());
	}

}
