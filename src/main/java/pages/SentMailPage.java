/**
 * Copyright 2017 Alfa Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.annotations.Optional;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;

@Name("Создание письма")
public class SentMailPage extends AkitaPage {

    @FindBy(xpath = "//span[text()='Входящие']")
    @Name("Входящие")
    private SelenideElement inputMail;

    @FindBy(xpath = "//span[text()='Себе']")
    @Name("Себе")
    private SelenideElement toMeButton;

    @FindBy(xpath = "//input[contains(@class,'Field-Input-Controller')]")
    @Name("Тема")
    private SelenideElement theme;

    @FindBy(xpath = "//div[contains(@class,'cke_editable')]")
    @Name("Текст письма")
    private SelenideElement letterMessage;

    @Optional
    @FindBy(xpath = "//span[@class='mail-Bubble-Block_text']")
    @Name("Кому")
    private SelenideElement whom;

    @FindBy(xpath = "//span[text()='Отправить']")
    @Name("Отправить")
    private SelenideElement sent;

    @Optional
    @FindBy(xpath = "//div[contains(@class,'Notification-Content')]")
    @Name("Уведомление")
    private SelenideElement notification;
}
