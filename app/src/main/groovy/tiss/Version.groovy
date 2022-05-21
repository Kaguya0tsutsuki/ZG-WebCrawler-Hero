package tiss

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class Version {

    static void version(String url){
        DownloadTiss download = new DownloadTiss()
        HTML html = new HTML()

        Document versionPage = html.html(url)

        List<Element> tissTableRows = versionPage.select('table.table-bordered').select('tbody').first().select('tr')

        for(Element row: tissTableRows){
            if(!row.select('td').first().text().matches('Comunicação')){
                continue
            }

            String downloadUrl = row.select('a').first().attr('href')

            download.download(downloadUrl, 'latestTiss')

        }

    }
}
