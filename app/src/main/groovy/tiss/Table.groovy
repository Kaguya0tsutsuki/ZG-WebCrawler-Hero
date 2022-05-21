package tiss

import org.jsoup.nodes.Document

class Table {

    static void table(String url){
        DownloadTiss download = new DownloadTiss()
        HTML html = new HTML()

        Document relatedTablePage = html.html(url)

        String errorOnSendingTableURL = relatedTablePage.select('a.internal-link').first().attr('href')

        download.download(errorOnSendingTableURL, 'Table')

    }
}
