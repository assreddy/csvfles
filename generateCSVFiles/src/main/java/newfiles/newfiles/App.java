package newfiles.newfiles;

import java.io.File;

import com.github.javafaker.Faker;

import au.com.anthonybruno.Gen;
import au.com.anthonybruno.generator.defaults.IntGenerator;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		Faker fakerInstance = Faker.instance();
		int noFilesToGenerate = 50;  // Change number of File to create.
		int noRows = 100; // Change value to create number of rows in the CSV file.
		for(int i =0; i<noFilesToGenerate-1;i++) {
			File fileName = new File("csv_file_"+i+".csv");
			Gen.start()
			.addField("Serial Number", () -> fakerInstance.number().numberBetween(1, 1000000000))
			.addField("First Name", () -> fakerInstance.name().firstName())
			.addField("Last Name", () -> fakerInstance.name().lastName())
			.addField("Address", () -> fakerInstance.address().fullAddress())
			.addField("Date of birth", () -> fakerInstance.date().birthday())			
			.addField("SSN", () -> fakerInstance.idNumber().ssnValid())
			.addField("Secondary School Education", () -> fakerInstance.educator().secondarySchool())
			.addField("Phone Number", () -> fakerInstance.phoneNumber().phoneNumber())
			.addField("Email Address", () -> fakerInstance.internet().emailAddress())				
			.addField("Monthly Salary in USD", new IntGenerator(5000, 15000))
			.generate(noRows) //1000 rows will be generated
			.asCsv()
			.toFile(fileName);
			System.out.println("Creating file = " +fileName);
		}
	}
}
