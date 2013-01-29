package org.argus.core.qualityone;

import org.argus.core.Artifact;

public class QualityOneAdapter {

	public static String translate(Artifact artifact) {
		String groupId = artifact.getGroupId();
		String artifactId = artifact.getArtifactId();
		String retval = "QualityOne/SonarViolationChangeReportServlet?groupId=" + groupId
				+ "&artifactId=" + artifactId;
		return retval;
	}
}
