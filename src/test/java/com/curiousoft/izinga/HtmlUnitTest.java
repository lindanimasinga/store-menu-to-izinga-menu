package com.curiousoft.izinga;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HtmlUnitTest {

    private WebClient webClient;

    @Test
    public void givenAClient_whenEnteringBaeldung_thenPageTitleIsOk()
            throws Exception {
        webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);

        HtmlPage page = webClient.getPage("https://www.spursteakranches.com/za/menu/double-burgers");

        System.out.println(page.getAnchors());

        webClient.close();
    }

}
