package schoolData;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Schools {
	
	public static void main (String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		List<String> links = new ArrayList<>();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("d:/sreeja.csv"));
	    
	    		
		try {
			System.setProperty("webdriver.chrome.driver", "D:\\Documents\\chromedriver.exe");
			//driver.get("https://datagateway.schools.utah.gov/Schools/83700");
			driver.get("https://www.schools.utah.gov/schoolsdirectory");
			Thread.sleep(30000);
			List<WebElement> statsLinks = driver.findElements(By.xpath("//a[starts-with(@href, 'https://datagateway.schools.utah.gov/Schools')]"));
			for(WebElement link: statsLinks) {
				links.add(link.getAttribute("href"));
			}
			
			System.out.println("Found " +  links.size() + " schools to export");
			School.printHeader(writer);
			for (String link: links) {
				
				School school = new School();
				//System.out.println("Now looking at " + link );
				school.setUrl(link);
				driver.get(link);
				Thread.sleep(5000);
				if(driver.findElements(By.xpath("//div[contains(@class, 'alert-danger')]")).size() > 0 ) {
					//System.out.println("No information for school. Skipping");
					school.print(writer);
					continue;
				}
				school.setName(driver.findElement(By.xpath("//h3")).getText());
				//System.out.println("School is " + driver.findElement(By.xpath("//h3")).getText());
				
				if (driver.findElements(By.xpath("//h4[contains(text(), 'Enrollment by Grade')]")).size() == 0) {
					continue;
				}
				WebElement gradeSection = driver.findElement(By.xpath("//h4[contains(text(), 'Enrollment by Grade')]"));
				//System.out.println(gradeSection.getText());
				WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript(
                        "return arguments[0].parentNode;", gradeSection);
				WebElement gradesDiv = parent.findElement(By.xpath(".//dl"));
				List<WebElement> grades =  gradesDiv.findElements(By.xpath(".//*"));
				//System.out.println("Found " + grades.size() + " children");
				String gradeTag = null;
				processGrades(school, grades, gradeTag);
				
				
				
				
				if (driver.findElements(By.xpath("//h4[contains(text(), 'Enrollment by Ethnicity')]")).size() == 0) {
					continue;
				}
				WebElement ethnicitySection = driver.findElement(By.xpath("//h4[contains(text(), 'Enrollment by Ethnicity')]"));
				//System.out.println(ethnicitySection.getText());
				WebElement enthnicityParent = (WebElement) ((JavascriptExecutor) driver).executeScript(
                        "return arguments[0].parentNode;", ethnicitySection);
				WebElement ethnicityDiv = enthnicityParent.findElement(By.xpath(".//dl"));
				List<WebElement> ethnicities =  ethnicityDiv.findElements(By.xpath(".//*"));
				//System.out.println("Found " + ethnicities.size() + " children");
				String ethnicityTag = null;
				for (WebElement ethnicity:ethnicities) {
					if(ethnicity.getTagName().equals("dt")) {
						//System.out.print(ethnicity.getText());
						ethnicityTag = ethnicity.getText();
					} else if (ethnicity.getTagName().equals("dd")) {
						//System.out.println(" : " + ethnicity.getText());
						setEthnicities(school, ethnicityTag, ethnicity);
					}
				}
				
				//System.out.println("Testing Ethnicity Set. American Indian count is " + school.getAmericanIndian_count());
				
				//System.out.println("Testing Grade Set. Grade K count is " + school.getGrade_count_k());
				
				
				
				
				if (driver.findElements(By.xpath("//h4[contains(text(), 'Enrollment by Gender')]")).size() == 0) {
					continue;
				}
				WebElement genderSection = driver.findElement(By.xpath("//h4[contains(text(), 'Enrollment by Gender')]"));
				//System.out.println(genderSection.getText());
				WebElement genderParent = (WebElement) ((JavascriptExecutor) driver).executeScript(
                        "return arguments[0].parentNode;", genderSection);
				WebElement genderDiv = genderParent.findElement(By.xpath(".//dl"));
				List<WebElement> genders =  genderDiv.findElements(By.xpath(".//*"));
				//System.out.println("Found " + genders.size() + " children");
				String genderTag = null;
				for (WebElement gender:genders) {
					if(gender.getTagName().equals("dt")) {
						//System.out.print(gender.getText());
						genderTag = gender.getText();
					} else if (gender.getTagName().equals("dd")) {
						//System.out.println(" : " + gender.getText());
						processGenders(school, genderTag, gender);
					}
				}
				
				
				
				if (driver.findElements(By.xpath("//h4[contains(text(), 'Subgroup Percentages')]")).size() == 0) {
					continue;
				}
				WebElement subgroupSection = driver.findElement(By.xpath("//h4[contains(text(), 'Subgroup Percentages')]"));
				//System.out.println(subgroupSection.getText());
				WebElement subgroupParent = (WebElement) ((JavascriptExecutor) driver).executeScript(
                        "return arguments[0].parentNode;", subgroupSection);
				WebElement subgroupDiv = subgroupParent.findElement(By.xpath(".//dl"));
				List<WebElement> subgroups =  subgroupDiv.findElements(By.xpath(".//*"));
				//System.out.println("Found " + subgroups.size() + " children");
				String subgroupTag = null;
				for (WebElement subgroup:subgroups) {
					if(subgroup.getTagName().equals("dt")) {
						//System.out.print(subgroup.getText());
						subgroupTag = subgroup.getText();
					} else if (subgroup.getTagName().equals("dd")) {
						//System.out.println(" : " + subgroup.getText());
						processSubGroups(school, subgroupTag, subgroup);
					}
				}
				school.print(writer);
				writer.flush();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.close();
			writer.close();

		}
		
		
	}

	private static void processSubGroups(School school, String subgroupTag, WebElement subgroup) {
		switch (subgroupTag) {
		case "Econ Disadv:" :
			school.setEconDisadv_count(subgroup.getText());
			break;
			
		case "ELL:" :
			school.setEll_count(subgroup.getText());
			break;
			
		case "Ethnic Minority:" :
			school.setEthnicMinority_count(subgroup.getText());
			break;						
			
		case "Special Ed:" :
			school.setSpecialEd_count(subgroup.getText());
			break;

		default:
			System.err.println("Unhandled Subgroup Tag " + subgroupTag + " . Fix THIS!!!!");
			break;
		}
	}

	private static void processGenders(School school, String genderTag, WebElement gender) {
		switch (genderTag) {
		case "Female:":
			school.setFemale_count(gender.getText());
			break;
			
		case "Male:":
			school.setMale_count(gender.getText());
			break;
			
		case "Undeclared:":
			school.setGender_undeclared_count(gender.getText());
			break;

		default:
			System.err.println("Unhanded Gender " + genderTag + " . Fix THIS!!!");
			break;
		}
	}

	private static void setEthnicities(School school, String ethnicityTag, WebElement ethnicity) {
		switch (ethnicityTag) {
		case "American Indian:":
			school.setAmericanIndian_count(ethnicity.getText());
			break;
			
		case "Asian:":
			school.setAsian_count(ethnicity.getText());
			break;
			
		case "Black:":
			school.setBlack_count(ethnicity.getText());
			break;
			
		case "Caucasian:":
			school.setCaucasian_count(ethnicity.getText());
			break;
			
		case "Hispanic:":
			school.setHispanic_count(ethnicity.getText());
			break;
			
		case "Multi Race:":
			school.setMultiRace_count(ethnicity.getText());
			break;

		case "Pacific Islander:":
			school.setPacificIslander_count(ethnicity.getText());
			break;
			
		default:
			System.err.println("Unhandled Ethnicity Tag " + ethnicityTag + " . FIX THIS!!!!");
			break;
		}
	}
	
	private static void processGrades(School school, List<WebElement> grades, String gradeTag) {
		for (WebElement grade:grades) {
			if(grade.getTagName().equals("dt")) {
				//System.out.print(grade.getText());
				gradeTag = grade.getText();
				
			} else if (grade.getTagName().equals("dd")) {
				//System.out.println(" : " + grade.getText());
				
				setGrade(school, gradeTag, grade);
			}
		}
	}

	private static void setGrade(School school, String gradeTag, WebElement grade) {
		switch (gradeTag) {
		case "Grade K:":
			school.setGrade_count_k(grade.getText());
			break;
			
		case "Grade 1:":
			school.setGrade_count_1(grade.getText());
			break;
			
		case "Grade 2:":
			school.setGrade_count_2(grade.getText());
			break;
			
		case "Grade 3:":
			school.setGrade_count_3(grade.getText());
			break;
			
		case "Grade 4:":
			school.setGrade_count_4(grade.getText());
			break;
			
		case "Grade 5:":
			school.setGrade_count_5(grade.getText());
			break;
			
		case "Grade 6:":
			school.setGrade_count_6(grade.getText());
			break;
			
		case "Grade 7:":
			school.setGrade_count_7(grade.getText());
			break;
			
		case "Grade 8:":
			school.setGrade_count_8(grade.getText());
			break;
			
		case "Grade 9:":
			school.setGrade_count_9(grade.getText());
			break;
			
		case "Grade 10:":
			school.setGrade_count_10(grade.getText());
			break;
			
		case "Grade 11:":
			school.setGrade_count_11(grade.getText());
			break;
			
		case "Grade 12:":
			school.setGrade_count_12(grade.getText());
			break;

		default:
			System.err.println("Unhandled Grade Level " + gradeTag + " . Fix THIS!!!!!");
			break;
		}
	}

}
