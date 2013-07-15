package test;

import org.testng.annotations.Test;



public class groupCreationTest extends TestBase {
  @Test
  public void testValidGroupCanBeCreated() throws Exception {
	GroupObject validGroup = new GroupObject("habrahabr", "labrabar", "xerahabr");
	createGroup(validGroup);
  }

  @Test
  public void testGroupWithEmptyDataCanBeCreated() throws Exception {
	GroupObject emptyDataGroup = new GroupObject("", "", "");
	createGroup(emptyDataGroup);
  }
}
