package au.com.agic.apptesting.utils.impl;

import au.com.agic.apptesting.constants.Constants;
import au.com.agic.apptesting.utils.CleanupUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * An implementation of the cleanup service
 */
public class CleanupUtilsImpl implements CleanupUtils {

	private static final Pattern REPORT_RE = Pattern.compile(Constants.THREAD_NAME_PREFIX + "\\d+\\.(html|xml|txt|json)");

	@Override
	public void cleanupOldReports() {
		Arrays.stream(new File(".").listFiles())
			.filter(file -> REPORT_RE.matcher(file.getName()).matches())
			.forEach(FileUtils::deleteQuietly);
	}
}
