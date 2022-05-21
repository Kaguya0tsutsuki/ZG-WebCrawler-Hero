package tiss

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class History {
    static void history(String url){
        HTML html = new HTML()
        Connect connect = new Connect()

        Document historyPage = html.html(url)

        List<Element> tissHistoryTableRows = historyPage.getElementById('parent-fieldname-text').select('tbody').first().select('tr')

        int ano = 2016

        List<String[]> table = new ArrayList<>()

        for(Element row: tissHistoryTableRows){

            String competencia = row.select('td')[0].text()

            if(Integer.parseInt(competencia.split(/\w*\//)[1]) < ano){
                continue
            }

            String publicacao = row.select('td')[1].text()
            String validacao = row.select('td')[2].text()


            table<< [competencia, publicacao, validacao]
        }

        connect.connect(table)

    }
}
