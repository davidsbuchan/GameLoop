package uk.co.ashndave.game;

public final class Licence {

	private static final String BriefLicence1 = "Copyright (C) %s David Strachan Buchan.";
	private static final String BriefLicence2 = "License GPLv3+: GNU GPL version 3 or later <http://gnu.org/licenses/gpl.html>.";
	private static final String BriefLicence3 = "This is free software: you are free to change and redistribute it.";
	private static final String BriefLicence4 = "There is NO WARRANTY, to the extent permitted by law.";
	private static final String BriefLicence5 = "Written by David Strachan Buchan.";
	
	private static final String BriefLicence = String.format("%s%n%s%n%s%n%s%n%s",
			BriefLicence1,
			BriefLicence2,
			BriefLicence3,
			BriefLicence4,
			BriefLicence5);
	
	public static String GetLicence(String yearOrYears) {
		return String.format(BriefLicence, yearOrYears);
	}
}
