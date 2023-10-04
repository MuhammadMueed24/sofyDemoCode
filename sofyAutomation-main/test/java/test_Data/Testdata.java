package test_Data;

import org.testng.annotations.DataProvider;

public class Testdata {
	
	@DataProvider(name="WelcometoSofy")

	public Object[][] welcomeSofy() {
		Object[][] obj = new Object[][] {{"Welcome to Sofy!","With Sofy, you can quickly create tests without a single line of code, and run them at scale on our library of hundreds of real devices. ",
			"We've pre-loaded a simple calculator app so you can start testing right away. ",
			"Click on the Acquire button under any device to start testing.","Ready? Let's get started!"}};
		return obj;
	}
	
	@DataProvider(name="signup")
	public Object[][] signup() {
		Object[][] obj = new Object[][] {{"Required field."}};
		return obj;
	}
	
	@DataProvider(name="passcheck")
	public Object[][] passcheck() {
		Object[][] obj = new Object[][] {{"QW123","Your password must be between 8-16 characters, containing 3 out of 4 of the following: Lowercase characters, uppercase characters, digits (0-9), and one or more of the following symbols: @ # $ % ^ & * - _ + = [ ] { } | \\ : ' , ? / ` ~ \" ( ) ; ."}};
		return obj;
	}
	
	@DataProvider(name="validCred")
	public Object[][] validCred() {
		Object[][] obj = new Object[][] {{"Franky123@","Great, we’re getting things set up","We’ve emailed you a verification link. Check your email and click the verification link to confirm your email address, and we’ll meet you right back here.",
			"See you soon,", "The Sofy Team."}};
		return obj;
	}
	
	@DataProvider(name="autofilled")
	public Object[][] autofilled() {
		Object[][] obj = new Object[][] {{"Name","Email Address"}};
		return obj;
	}
	
	@DataProvider(name="verifySave")
	public Object[][] verifySave() {
		Object[][] obj = new Object[][] {{"User profile detail updated."}};
		return obj;
	}
	
	@DataProvider(name="apiKey")
	public Object[][] apiKey() {
		Object[][] obj = new Object[][] {{"Your API key is:","Do you want to re-generate the access key?"}};
		return obj;
	}
	
	@DataProvider(name="password")
	public Object[][] password() {
		Object[][] obj = new Object[][] {{"This field is required.", "Save changes"}};
		return obj;
	}
	
	@DataProvider(name="passinvalid")
	public Object[][] passvalid() {
		Object[][] obj = new Object[][] {{"Franky123@", "New password should not be the same as current password"}};
		return obj;
	}
	
	@DataProvider(name="retype")
	public Object[][] retype() {
		Object[][] obj = new Object[][] {{"Franky123@", "New password should not be the same as current password"}};
		return obj;
	}
	
	@DataProvider(name="mismatch")
	public Object[][] mismatch() {
		Object[][] obj = new Object[][] {{"Franky123@", "Franky123", "Franky12", "The password entry fields do not match. Please enter the same password in both fields and try again."}};
		return obj;
	}
	@DataProvider(name="changepass")
	public Object[][] changepass() {
		Object[][] obj = new Object[][] {{"Franky123@", "Franky123", "Password Updated."}};
		return obj;
	}
	@DataProvider(name="invaliduser")
	public Object[][] invaliduser() {
		Object[][] obj = new Object[][] {{"Franky123@", "Franky123", "Password Updated."}};
		return obj;
	}
	@DataProvider(name="checkmail")
	public Object[][] checkmail() {
		Object[][] obj = new Object[][] {{"ab@getnada.com", "user@gmail.com"}};
		return obj;
	}
	@DataProvider(name="hourused")
	public Object[][] hourused() {
		Object[][] obj = new Object[][] {{"Minutes Used This Month", "Plan Total:"}};
		return obj;
	}
	
	@DataProvider(name="device")
	public Object[][] device() {
		Object[][] obj = new Object[][] {{"Galaxy S8"}};
		return obj;
	}
	@DataProvider(name="placeholder")
	public Object[][] placeholder() {
		Object[][] obj = new Object[][] {{"Samsung"}};
		return obj;
	}
	@DataProvider(name="searchusage")
	public Object[][] searchusage() {
		Object[][] obj = new Object[][] {{"Search Usage"}};
		return obj;
	}
	@DataProvider(name="filterusage")
	public Object[][] filterusage() {
		Object[][] obj = new Object[][] {{"Filter Usage Details"}};
		return obj;
	}
	@DataProvider(name="testingtype")
	public Object[][] testingtype() {
		Object[][] obj = new Object[][] {{"Scheduled","TestFlight","LabSession", "No Records Found"}};
		return obj;
	}
	
	@DataProvider(name="headers")
	public Object[][] headers() {
		Object[][] obj = new Object[][] {{"APP TYPE","DATE","START", "END", "DURATION", "USER EMAIL", "TYPE", "DEVICE"}};
		return obj;
	}
	
	@DataProvider(name="packagename")
	public Object[][] packagename() {
		Object[][] obj = new Object[][] {{"com.google.android.calculator", "https://portal.sofy.ai/assets/icons/android.svg"}};
		return obj;
	}
	
	@DataProvider(name="drapApp")
	public Object[][] drapApp() {
		Object[][] obj = new Object[][] {{"Drag and Drop your Application File", "OR","Browse Files"}};
		return obj;
	}
	
	@DataProvider(name="alerts")
	public Object[][] alerts() {
		Object[][] obj = new Object[][] {{"Notifications Cleared Successfully.","https://portal.sofy.ai/assets/arrows/greendot.svg","https://portal.sofy.ai/assets/arrows/notification.svg",
			"com.google.android.calculator", "https://portal.sofy.ai/assets/icons/android.svg"}};
		return obj;
	}
	
	@DataProvider(name="helpin")
	public Object[][] helpin() {
		Object[][] obj = new Object[][] {{"Help & Insights","Getting started with Sofy","Uploading Android or iOS Apps",
			"Testing iOS apps using Sofy","Creating your first no-code test","Interacting with devices",
			"Automated test scheduling and playback"}};
		return obj;
	}
	@DataProvider(name="allArticle")
	public Object[][] allArticle() {
		Object[][] obj = new Object[][] {{"All Articles"}};
		return obj;
	}
	@DataProvider(name="whathappen")
	public Object[][] whathappen() {
		Object[][] obj = new Object[][] {{"What's Happening?","Device Hours","Builds Uploaded","Tests Created","Tests Runs"}};
		return obj;
	}
	@DataProvider(name="selectdate")
	public Object[][] selectdate() {
		Object[][] obj = new Object[][] {{"ng-option-selected"}};
		return obj;
	}
	@DataProvider(name="threeTabs")
	public Object[][] threeTabs() {
		Object[][] obj = new Object[][] {{"Test Cases","Results","Scheduled", "selected"}};
		return obj;
	}
	@DataProvider(name="schType")
	public Object[][] schType(){
		Object[][] obj = new Object[][] {{"selected", "Today", "Tomorrow", "Week"}};
		return obj;
	}
	@DataProvider(name="installedapps")
	public Object[][] installedapps(){
		Object[][] obj = new Object[][] {{"com.google.android.calculator", "com.rccl.royalcaribbean.excalibur", "com.hilton.hhonors"}};
		return obj;
	}
	@DataProvider(name="appUpload")
	public Object[][] appUpload(){
		Object[][] obj = new Object[][] {{"Application Uploading", "Upload Successful", "com.hilton.hhonors"}};
		return obj;
	}
	
	@DataProvider(name="tesdata")
	public Object[][] tesdata(){
		Object[][] obj = new Object[][] {{"One", "1", "Value","1 in word"}};
		return obj;
	}
	
	@DataProvider(name="dropdown")
	public Object[][] dropdown(){
		Object[][] obj = new Object[][] {{"Create New Test Case", "Import from Azure Devops", "Import from CSV"}};
		return obj;
	}
	
	@DataProvider(name="header")
	public Object[][] header(){
		Object[][] obj = new Object[][] {{"TITLE", "CREATED ON", "MODIFIED ON","ASSIGNED TO","IMPORTED","ACTION"}};
		return obj;
	}
	
	@DataProvider(name="createTest")
	public Object[][] createTest(){
		Object[][] obj = new Object[][] {{"TC", "CREATED ON", "MODIFIED ON","ASSIGNED TO","IMPORTED","ACTION"}};
		return obj;
	}
	@DataProvider(name="nodata")
	public Object[][] nodata(){
		Object[][] obj = new Object[][] {{"com.google.android.calculator", "https://portal.sofy.ai/assets/icons/android.svg","There are no automated test cases create for your application.\nFollow the steps here to create your first automated test case."}};
		return obj;
	}
	@DataProvider(name="filter")
	public Object[][] filter(){
		Object[][] obj = new Object[][] {{"com.google.android.calculator", "https://portal.sofy.ai/assets/icons/android.svg","Filter My Selection","Created By","Priority","Created Between", "Clear Filter","Done"}};
		return obj;
	}
	@DataProvider(name="creatby")
	public Object[][] creatby(){
		Object[][] obj = new Object[][] {{"com.google.android.calculator", "https://portal.sofy.ai/assets/icons/android.svg","mueed@sofy.ai"}};
		return obj;
	}
	@DataProvider(name="priority")
	public Object[][] priority(){
		Object[][] obj = new Object[][] {{"com.google.android.calculator", "https://portal.sofy.ai/assets/icons/android.svg","High","Medium","Low"}};
		return obj;
	}
	@DataProvider(name="tcHead")
	public Object[][] tcheaders(){
		Object[][] obj = new Object[][] {{"TEST CASE NAME", "CREATED ON","MODIFIED ON","CREATED BY","PRIORITY","ACTIONS"}};
		return obj;
	}
	@DataProvider(name="tsHead")
	public Object[][] tshead(){
		Object[][] obj = new Object[][] {{"TITLE", "MODIFIED ON","MODIFIED BY","TEST CASES","ACTIONS"}};
		return obj;
	}
}