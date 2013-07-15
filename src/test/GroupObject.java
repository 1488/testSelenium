package test;

public class GroupObject {
	private String name;
	private String header;
	private String footer;

	public GroupObject(String name, String header, String footer) {
		this.name = name;
		this.header = header;
		this.footer = footer;
	}

	public String getName() {
		return name;
	}

	public String getHeader() {
		return header;
	}

	public String getFooter() {
		return footer;
	}
}