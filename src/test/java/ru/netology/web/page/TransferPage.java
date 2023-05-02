package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {

    private SelenideElement amount = $("[data-test-id=amount] input");
    private SelenideElement fromCard = $("[data-test-id=from] input");
    private SelenideElement buttonPay = $("[data-test-id=action-transfer]");
    private SelenideElement heading2 = $(byText("Пополнение карты"));

    public void checkHeadingPaymentCards() {
        heading2.shouldBe(Condition.visible);
    }

    public void setPayCardNumber(String card, int payment) {
        amount.setValue(String.valueOf(payment));
        fromCard.setValue(card);
        buttonPay.click();
    }

    public DashboardPage validPayCard() {
        return new DashboardPage();
    }

    public void invalidPayCard() {
        $("[data-test-id=error-notification] .notification__content").shouldHave(text("Произошла ошибка"));
    }

    public void validPayExtendAmount() {
        $("[data-test-id=error-notification] .notification__content").shouldHave(text("Недостаточно средств на карте"));
    }
}