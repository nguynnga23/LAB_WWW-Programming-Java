package com.example.bai06_uploadfile;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/upload")
public class MultiFilesUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String UPLOAD_DIRECTORY = "upload";
    private static final int THRESHOLD_SIZE  = 1024 * 1024 * 3;
    private static final int MAX_FILE_SIZE  = 1024 * 1024 * 10;
    private static final int REQUEST_SIZE  = 1024 * 1024 * 50;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!ServletFileUpload.isMultipartContent((RequestContext) req)){
            resp.getWriter().println("Does not support!");
            return;
        }

        // Cau hinh tham so
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(THRESHOLD_SIZE);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(REQUEST_SIZE);

        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

        // Tao thu muc neu chua ton tai thu muc nay
        File uploadDir = new File(uploadPath);
        if(!uploadDir.exists()){
            uploadDir.mkdirs();
        }

        try {
            List formItems = upload.parseRequest((RequestContext) req);
            Iterator iter = formItems.iterator();
            while(iter.hasNext()){
                FileItem item = (FileItem) iter.next();
                if(!item.isFormField()){
                    String fileName = new File(item.getName()).getName();
                    String filePath = uploadPath + File.separator + fileName;
                    File storeFile = new File(filePath);

                    item.write(storeFile);
                }
            }
            req.setAttribute("message", "Upload has been done successfully!");
        }catch (Exception ex){
            req.setAttribute("message", "There was an error: " + ex.getMessage());
            ex.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/upload.jsp").forward(req, resp);
    }
}
