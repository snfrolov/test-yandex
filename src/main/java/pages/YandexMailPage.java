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

import java.util.List;

@Name("Яндекс.Почта")
public class YandexMailPage extends AkitaPage {

    @FindBy(xpath = "//span[@class='mail-ComposeButton-Text']")
    @Name("Написать")
    private SelenideElement writeButton;

    @FindBy(xpath = "//span[text()='Общение']")
    @Name("Общение")
    private SelenideElement communication;

    @FindBy(xpath = "//span[@class='mail-LabelList-Item_count']")
    @Name("Количество избранных писем")
    private SelenideElement favoriteMailCounter;

    @FindBy(xpath = "//span[contains(@class,'js-message-snippet-importance')]")
    @Name("Флаги добавления в избранное")
    private List<SelenideElement> favoriteFlagList;

    @Optional
    @FindBy(xpath = "//span[contains(@class,'js-message-snippet-subject')]//span[@title]")
    @Name("Темы писем")
    private List<SelenideElement> themeList;
}
