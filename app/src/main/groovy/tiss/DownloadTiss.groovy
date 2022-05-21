package tiss

import groovyx.net.http.HttpBuilder
import groovyx.net.http.optional.Download

class DownloadTiss {
    static void download(String url, String fileName)throws IOException{

        String filePath = "./downloads/${fileName}.xlsx"
        File newFile = new File(filePath)

        File build = HttpBuilder.configure ({
            request.uri = url
        }).get({
            Download.toFile(delegate,newFile)
        })

        build.createNewFile()
    }
}
