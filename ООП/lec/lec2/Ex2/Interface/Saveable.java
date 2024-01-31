package lec.lec2.Ex2.Interface;

import lec.lec2.Ex2.Document.TextDocument;;

public interface Saveable {
    void SaveAs(TextDocument document, String path);
}
