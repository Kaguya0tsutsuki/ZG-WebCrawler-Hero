package tiss

import groovyx.net.http.HttpBuilder
import org.jsoup.nodes.Document

class HTML {
    static Document html(String url){
        Document page = HttpBuilder.configure({
            request.uri = url
        }).get()

        return page

    }
}
