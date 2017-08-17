package SeleniumRCTest.SeleniumRCTest;

// import static org.junit.Assert.assertNotNull;
// import static org.junit.Assert.assertThat;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PreenchimentoFormulario {

	@Test
	public void preenchimentoFormulario() throws Exception {
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "/home/andre/workspace/SeleniumTestes/chromedriver");
		driver = new ChromeDriver();
		String caminho = "Evidencias/printTeste5.jpg";
		// Visita a página da DBserver
		driver.get("http://www.dbserver.com.br/contato.html");

		// Preenche o nome
		WebElement inputName = driver.findElement(By.name("name"));
		inputName.sendKeys("André Marinho");
		// Preenche o Email
		WebElement inputEmail = driver.findElement(By.name("email"));
		inputEmail.sendKeys("andrdemelomarinho@gmail.com");
		// Preenche o assunto
		WebElement inputAssunto = driver.findElement(By.name("textAssunto"));
		inputAssunto.sendKeys("Desafio Seleção");

		Select selectSetor = new Select(driver.findElement(By.name("setor")));
		selectSetor.selectByVisibleText("Recursos Humanos");

		// Printa o formulário
		this.takeSnapShot(driver, caminho);
		driver.quit();
	}

	public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile = new File(fileWithPath);

		FileUtils.copyFile(SrcFile, DestFile);

	}

}
