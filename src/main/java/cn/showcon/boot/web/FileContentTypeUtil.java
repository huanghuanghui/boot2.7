package cn.showcon.boot.web;

public class FileContentTypeUtil {
    private static String[] ALLOW_DOC_TYPE = new String[]{".xlsx", ".xls", ".doc", ".docx", ".pdf", ".html", ".png", ".pdf"};
    private static String[] ALLOW_CONTENT_TYPE = new String[]{"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/vnd.ms-excel", "application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.wpsFileInfo", "application/pdf", "text/html", "image/png", "application/octet-stream"};

    public FileContentTypeUtil() {
    }

    public static String convertContentType(String filename) {
        return getContentType(getSuffix(filename));
    }

    public static String getContentType(String suffix) {
        String contentType = "application/pdf";

        for(int i = 0; i < ALLOW_DOC_TYPE.length; ++i) {
            if (ALLOW_DOC_TYPE[i].equals(suffix)) {
                contentType = ALLOW_DOC_TYPE[i];
                break;
            }
        }

        return contentType;
    }

    public static String getSuffix(String contentType) {
        String suffix = ".pdf";

        for(int i = 0; i < ALLOW_CONTENT_TYPE.length; ++i) {
            if (ALLOW_CONTENT_TYPE[i].equals(contentType)) {
                suffix = ALLOW_CONTENT_TYPE[i];
                break;
            }
        }

        return suffix;
    }
}