package com.bh3_whatsapp_bot.controller;

import java.io.IOException;
import java.nio.file.*;

/**
 * 9/1/2023
 *
 * @author bhugs -"Howard Mabhugu"
 * Bh3 WhatsApp bot
 **/
public class Base64Help {
    static public String getPDFtring() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/main/resources/pdf.txt")));
    }

    static  public String getMP3String() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/main/resources/mp3.txt")));
    }

    static public String getJPEG() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/main/resources/jpeg.txt")));
    }

    static public String getDOC() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/main/resources/doc.txt")));
    }

}
