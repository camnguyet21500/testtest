/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.Part;

/**
 *
 * @author home
 */
public class UploadModel {

    public boolean uploadFile(String filename, Part file, String uploadRootPath) {
        try {
            InputStream fis = file.getInputStream();
            byte[] data = new byte[fis.available()];
            fis.read(data);

            FileOutputStream out
                    = new FileOutputStream(new File(uploadRootPath + "\\" + filename));
            out.write(data);
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public String getTenFile(Part file) {
        String filename = "";
        String header = file.getHeader("Content-Disposition");

        int beginIndex = header.lastIndexOf("=");
        filename = header.substring(beginIndex + 1);

        //remove "" quotes 
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(filename);
        while (m.find()) {
            filename = m.group(1);
        }

        //danh cho IE 
        beginIndex = filename.lastIndexOf("\\");
        filename = filename.substring(beginIndex + 1);
        return filename;
    }

}
