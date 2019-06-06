package schoolData;

import java.io.BufferedWriter;
import java.io.IOException;

public class School {
	private static final String COMMA_SPACE = "| ";
	String americanIndian_count;
	String asian_count;
	String black_count;
	String caucasian_count;
	String econDisadv_count;
	String ell_count;
	String ethnicMinority_count;
	String female_count;
	String grade_count_1;
	String grade_count_10;
	String grade_count_11;
	String grade_count_12;
	String grade_count_2;
	String grade_count_3;
	String grade_count_4;
	String grade_count_5;
	String grade_count_6;
	String grade_count_7;
	String grade_count_8;
	String grade_count_9;

	String grade_count_k;

	String hispanic_count;

	String male_count;
	String multiRace_count;

	String name;

	String pacificIslander_count;

	String specialEd_count;

	String url;
	String gender_undeclared_count;
	
	public String getGender_undeclared_count() {
		return gender_undeclared_count;
	}

	public void setGender_undeclared_count(String gender_undeclared_count) {
		this.gender_undeclared_count = gender_undeclared_count;
	}

	public static void printHeader(BufferedWriter writer) throws IOException
	{
		writer.write("Name| URL| Grade K| Grade 1| Grade 2| Grade 3| Grade 4| Grade 5| Grade 6| Grade 7| Grade 8| Grade 9| Grade 10| Grade 11| Grade 12| Ethnicity: American Indian| Ethnicity: Asian| "
				+ "Ethnicity: Black| Ethnicity: Caucasian| Ethnicity: Hispanic| Ethnicity: Multi Race| Gender: Female| Gender: Male| Gender: Undeclared| SubGroup: Econ Disadv| SubGroup: ELL| Subgroup: Ethnic Minority| Subgroup: Special Ed");
		writer.newLine();
		System.out.println("Name, URL, Grade K, Grade 1, Grade 2, Grade 3, Grade 4, Grade 5, Grade 6, Grade 7, Grade 8, Grade 9, Grade 10, Grade 11, Grade 12, Ethnicity: American Indian, Ethnicity: Asian, "
				+ "Ethnicity: Black, Ethnicity: Caucasian, Ethnicity: Hispanic, Ethnicity: Multi Race, Gender: Female, Gender: Male, Gender:Undeclared, SubGroup: Econ Disadv, SubGroup: ELL, Subgroup: Ethnic Minority, Subgroup: Special Ed");
	}
	
	public String print(BufferedWriter writer) throws IOException {
		StringBuilder line = new StringBuilder();
		
		line.append(name).append(COMMA_SPACE);
		line.append(url).append(COMMA_SPACE);
		
		line.append(grade_count_k).append(COMMA_SPACE);
		line.append(grade_count_1).append(COMMA_SPACE);
		line.append(grade_count_2).append(COMMA_SPACE);
		line.append(grade_count_3).append(COMMA_SPACE);
		line.append(grade_count_4).append(COMMA_SPACE);
		line.append(grade_count_5).append(COMMA_SPACE);
		line.append(grade_count_6).append(COMMA_SPACE);
		line.append(grade_count_7).append(COMMA_SPACE);
		line.append(grade_count_8).append(COMMA_SPACE);
		line.append(grade_count_9).append(COMMA_SPACE);
		line.append(grade_count_10).append(COMMA_SPACE);
		line.append(grade_count_11).append(COMMA_SPACE);
		line.append(grade_count_12).append(COMMA_SPACE);
		
		line.append(americanIndian_count).append(COMMA_SPACE);
		line.append(asian_count).append(COMMA_SPACE);
		line.append(black_count).append(COMMA_SPACE);
		line.append(caucasian_count).append(COMMA_SPACE);
		line.append(hispanic_count).append(COMMA_SPACE);
		line.append(multiRace_count).append(COMMA_SPACE);
		
		line.append(female_count).append(COMMA_SPACE);
		line.append(male_count).append(COMMA_SPACE);
		line.append(gender_undeclared_count).append(COMMA_SPACE);
		
		line.append(econDisadv_count).append(COMMA_SPACE);
		line.append(ell_count).append(COMMA_SPACE);
		line.append(ethnicMinority_count).append(COMMA_SPACE);
		line.append(specialEd_count);
		
		writer.write(line.toString());
		writer.newLine();
		System.out.println(line.toString());
		return line.toString();
		//System.out.print(", ");
	}

	public String getAmericanIndian_count() {
		return americanIndian_count;
	}

	public String getAsian_count() {
		return asian_count;
	}

	public String getBlack_count() {
		return black_count;
	}

	public String getCaucasian_count() {
		return caucasian_count;
	}

	public String getEconDisadv_count() {
		return econDisadv_count;
	}

	public String getEll_count() {
		return ell_count;
	}

	public String getEthnicMinority_count() {
		return ethnicMinority_count;
	}

	public String getFemale_count() {
		return female_count;
	}

	public String getGrade_count_1() {
		return grade_count_1;
	}

	public String getGrade_count_10() {
		return grade_count_10;
	}

	public String getGrade_count_11() {
		return grade_count_11;
	}

	public String getGrade_count_12() {
		return grade_count_12;
	}

	public String getGrade_count_2() {
		return grade_count_2;
	}

	public String getGrade_count_3() {
		return grade_count_3;
	}

	public String getGrade_count_4() {
		return grade_count_4;
	}

	public String getGrade_count_5() {
		return grade_count_5;
	}

	public String getGrade_count_6() {
		return grade_count_6;
	}

	public String getGrade_count_7() {
		return grade_count_7;
	}

	public String getGrade_count_8() {
		return grade_count_8;
	}

	public String getGrade_count_9() {
		return grade_count_9;
	}

	public String getGrade_count_k() {
		return grade_count_k;
	}

	public String getHispanic_count() {
		return hispanic_count;
	}

	public String getMale_count() {
		return male_count;
	}

	public String getMultiRace_count() {
		return multiRace_count;
	}

	public String getName() {
		return name;
	}

	public String getPacificIslander_count() {
		return pacificIslander_count;
	}

	public String getSpecialEd_count() {
		return specialEd_count;
	}

	public String getUrl() {
		return url;
	}

	public void setAmericanIndian_count(String americanIndian_count) {
		this.americanIndian_count = americanIndian_count;
	}

	public void setAsian_count(String asian_count) {
		this.asian_count = asian_count;
	}

	public void setBlack_count(String black_count) {
		this.black_count = black_count;
	}

	public void setCaucasian_count(String caucasian_count) {
		this.caucasian_count = caucasian_count;
	}

	public void setEconDisadv_count(String econDisadv_count) {
		this.econDisadv_count = econDisadv_count;
	}

	public void setEll_count(String ell_count) {
		this.ell_count = ell_count;
	}

	public void setEthnicMinority_count(String ethnicMinority_count) {
		this.ethnicMinority_count = ethnicMinority_count;
	}

	public void setFemale_count(String female_count) {
		this.female_count = female_count;
	}

	public void setGrade_count_1(String grade_count_1) {
		this.grade_count_1 = grade_count_1;
	}

	public void setGrade_count_10(String grade_count_10) {
		this.grade_count_10 = grade_count_10;
	}

	public void setGrade_count_11(String grade_count_11) {
		this.grade_count_11 = grade_count_11;
	}

	public void setGrade_count_12(String grade_count_12) {
		this.grade_count_12 = grade_count_12;
	}

	public void setGrade_count_2(String grade_count_2) {
		this.grade_count_2 = grade_count_2;
	}

	public void setGrade_count_3(String grade_count_3) {
		this.grade_count_3 = grade_count_3;
	}

	public void setGrade_count_4(String grade_count_4) {
		this.grade_count_4 = grade_count_4;
	}

	public void setGrade_count_5(String grade_count_5) {
		this.grade_count_5 = grade_count_5;
	}

	public void setGrade_count_6(String grade_count_6) {
		this.grade_count_6 = grade_count_6;
	}

	public void setGrade_count_7(String grade_count_7) {
		this.grade_count_7 = grade_count_7;
	}

	public void setGrade_count_8(String grade_count_8) {
		this.grade_count_8 = grade_count_8;
	}

	public void setGrade_count_9(String grade_count_9) {
		this.grade_count_9 = grade_count_9;
	}

	public void setGrade_count_k(String grade_count_k) {
		this.grade_count_k = grade_count_k;
	}

	public void setHispanic_count(String hispanic_count) {
		this.hispanic_count = hispanic_count;
	}

	public void setMale_count(String male_count) {
		this.male_count = male_count;
	}
	public void setMultiRace_count(String multiRace_count) {
		this.multiRace_count = multiRace_count;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPacificIslander_count(String pacificIslander_count) {
		this.pacificIslander_count = pacificIslander_count;
	}
	public void setSpecialEd_count(String specialEd_count) {
		this.specialEd_count = specialEd_count;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
