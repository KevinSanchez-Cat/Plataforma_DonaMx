/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.archivosFTP;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import static java.lang.System.console;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class SubirArchivoFTP extends HttpServlet {

    private static final long serialVersionUID = 6098745782027999297L;
    private static final String DIRECTORIO = "/home/algo/";
    private static final long MAXIMO = 1000000000;
    private static final String TIPO = "application/zip";
    private static final String TIPO2 = "application/pdf";
    private static final String TIPO3 = "text/xml";
    private static final String CONTENT_TYPE_UNACCEPTABLE = "{error: 'Archivo no subido. " + "Solo archivos *.zip,*.xml y/o *.pdf pueden subirse'}";
    private static final String SIZE_UNACCEPTABLE = "{error: 'Archivo no subido. El taman\u00d1o del archivo solo puede ser de " + MAXIMO + " bytes o menos'}";
    private static final String SUCCESS_MESSAGE = "{message: 'Archivo subido correctamente'}";

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {

        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        System.out.println("directorio de descarga: " + DIRECTORIO);

        List items = null;
        String json = null;

        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            System.out.println("error al subir archivo: [" + e + "]  la causa: [" + e.getCause() + "]");
        }

        Iterator it = items.iterator();

        while (it.hasNext()) {
            FileItem item = (FileItem) it.next();
            System.out.println("Nombre del fichero: " + item.getName());
            System.out.println("Nombre del fichero: " + item.getName());

            json = processFile(item);
        }
        response.setContentType("text/plain");
        response.getWriter().write(json);
    }

    private String processFile(FileItem item) {
        if (!isContentTypeAcceptable(item)) {
            return CONTENT_TYPE_UNACCEPTABLE;
        }

        if (!isSizeAcceptable(item)) {
            return SIZE_UNACCEPTABLE;
        }

        File uploadedFile = new File(DIRECTORIO + item.getName());
        //UnZip.unzipFile(new File(DIRECTORIO  +item.getName()));

        String message = null;
        try {
            item.write(uploadedFile);
            message = SUCCESS_MESSAGE;
            //info(">>>> " + message);
            System.out.println(message);
        } catch (Exception e) {
            System.out.println("error al subir archivo: [" + e + "]  la causa: [" + e.getCause() + "]");
        }
        return message;
    }

    private boolean isSizeAcceptable(FileItem item) {
        return item.getSize() <= MAXIMO;
    }

    private boolean isContentTypeAcceptable(FileItem item) {
        return item.getContentType().equals(TIPO) || item.getContentType().equals(TIPO2) || item.getContentType().equals(TIPO3);
    }



}
