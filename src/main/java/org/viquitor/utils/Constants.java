package org.viquitor.utils;

public final class Constants {
    // URLs
    public static final String TARGET_URL = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";
    public static final String BASE_URL = "https://www.gov.br";

    // File System
    public static final String RESOURCES_DIR = "src/main/resources";
    public static final String PUBLIC_DIR = "public";
    public static final String PDF_EXTENSION = ".pdf";
    public static final char PATH_SEPARATOR = '/';

    // Web Scraping
    public static final String PDF_SELECTOR = "a[href$=.pdf]";
    public static final String ANNEX_I_TEXT = "anexo i";
    public static final String ANNEX_II_TEXT = "anexo ii";
    public static final String ANNEX_I_HREF = "Anexo_I";
    public static final String ANNEX_II_HREF = "Anexo_II";

    // IO Operations
    public static final int BUFFER_SIZE = 4096;

    // Archives
    public static final String ANNEX_I_NAME = "Anexo_I_Rol_2021RN_465.2021_RN627L.2024.pdf";
    public static final String MY_NAME = "/Teste_JoãoVictorSantos.zip";
    public static final String CSV_FILE_NAME = "rol_procedimentos.csv";


    private Constants() {
    }
}