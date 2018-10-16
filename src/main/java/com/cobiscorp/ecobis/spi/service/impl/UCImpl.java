package com.cobiscorp.ecobis.spi.service.impl;

import com.cobiscorp.ecobis.spi.service.api.UC;

import javax.jws.WebService;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jcraft.jsch.*;
import org.apache.commons.net.ftp.FTPSClient;

@WebService(endpointInterface = "com.cobiscorp.ecobis.spi.service.api.UC",
        serviceName = "UCImplService")
public class UCImpl implements UC
{

    private final static String local = System.getProperty("local.path"); // Ejm: /home/pestupinan/ach/local
    private final static String remote = System.getProperty("remote.path"); // Ejm: /home/pestupinan/ach/remote
    private final static String ftp_type = System.getProperty("ftp.type"); // Ejm: sftp/ftps
    // Ofuscado para evitar lectura de memoria
    private final static String uuu = System.getProperty("sftp.user"); // Ejm: pestupinan
    // Ofuscado para evitar lectura de memoria
    private final static String $$$ = System.getProperty("sftp.pass"); //" Ejm: queTeImporta
    private final static String host = System.getProperty("sftp.host"); //" Ejm: localhost
    private final static String port = System.getProperty("sftp.port"); //" Ejm: 22

    @Override
    public Response execute(Request request) {
        Response response = new Response();
        // Se genera archivo en carpeta local
        if(generateFile(request)) {
            // Se genera archivo en carpeta remota SFTP/FTPS,
            // si el proceso falla se setea el status del response con null
            response.setStatus(copyToSFTP(request.getBceSecuential()));
            // Se elimina archivo de carpeta local
            deleteOnLocal(request.getBceSecuential());
        }
        else
            response.setStatus(false);
        return response;
    }

    private void deleteOnLocal(String bceSecuential) {
        File srcFile = new File(local+"/"+bceSecuential+".xml");
        srcFile.delete();
    }

    private boolean generateFile(Request request) {
        File localFolder = new File(local);
        localFolder.getParentFile().mkdirs();
        localFolder.mkdir();
        try (PrintWriter out = new PrintWriter(local+"/"+request.getBceSecuential()+".xml")) {
            out.println(request.getXmlStr());
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean copyToSFTP(String bceSecuential) {
        switch (ftp_type){
            case "sftp":
                return sftp(bceSecuential);

            case "ftps":
                return ftps(bceSecuential);

            default: return false;
        }
    }

    private boolean ftps(String bceSecuential) {
        File srcFile = new File(local+"/"+bceSecuential+".xml");

        try {
            FTPSClient ftpClient = new FTPSClient();
            ftpClient.connect(host, Integer.valueOf(port));
            ftpClient.login(uuu, $$$);

            // TODO: Implementar envio de archivo a servidor FTPS

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean sftp(String bceSecuential) {
        File srcFile = new File(local+"/"+bceSecuential+".xml");

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(uuu, host, Integer.valueOf(port));
            session.setPassword($$$);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();
            try{
                sftpChannel.mkdir(remote);
            } catch(SftpException e){
            }
            sftpChannel.put(srcFile.getAbsolutePath(), remote+"/"+renameFile(bceSecuential));
            return true;
        } catch (JSchException | SftpException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String renameFile(String bceSecuential){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String newDate = formatter.format(date);
        final String fileName = "SPI-" + newDate + "-" + bceSecuential + ".xml";
        return fileName;
    }
}