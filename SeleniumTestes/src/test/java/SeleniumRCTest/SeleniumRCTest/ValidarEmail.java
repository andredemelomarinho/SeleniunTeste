package SeleniumRCTest.SeleniumRCTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ValidarEmail {

	@Test
	public void validarEmail() throws Exception {
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "/home/andre/workspace/SeleniumTestes/chromedriver");
		driver = new ChromeDriver();
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

		//clica no botão Buscar
		//WebElement buttonBuscar = driver.findElement(By.cssSelector("input[type='submit'"));
		//buttonBuscar.click();

		// verifica se o e-mail é o esperado
		assertEquals("info@dbserver.com.br", driver.findElement(By.name("email")).getAttribute("value"));

		driver.quit();
	}

}
