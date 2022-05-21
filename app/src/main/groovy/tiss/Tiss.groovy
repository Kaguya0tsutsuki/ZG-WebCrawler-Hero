package tiss

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class Tiss {
    static void tiss(String url){
        HTML html = new HTML()
        Version version = new Version()
        History history = new History()
        Table table = new Table()

        Document page = html.html(url)

        String urlProviderSpace = page.getElementById("ce89116a-3e62-47ac-9325-ebec8ea95473").select('a').first().attr('href')

        Document consumerPage = html.html(urlProviderSpace)

        String tissUrl = consumerPage.select('a.govbr-card-content').attr('href')

        Document tissPage = html.html(tissUrl)

        List<Element> TissList = tissPage.select('.callout').select('a')
        List<String> TissUrlList = new ArrayList<>()

        for(Element element : TissList){
            TissUrlList << element.attr('href')
        }

        String versionUrl = TissUrlList[0]
        String historyUrl = TissUrlList[1]
        String tableUrl = TissUrlList[2]

        version.version(versionUrl)
        history.history(historyUrl)
        table.table(tableUrl)


    }
}
