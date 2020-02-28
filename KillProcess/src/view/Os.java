package view;

public class Os {

	private String osName = System.getProperty("os.name");
	private String osVersion = System.getProperty("os.version");
	private String osArch = System.getProperty("os.arch");

	public String getOsName() {
		return osName;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public String getOsArch() {
		return osArch;
	}

}
