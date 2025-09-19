package com.decision;

import org.w3c.dom.Text;

import java.util.Map;

public class Dialog {
    private String id;
    private String text;
    private Map<String, String> options;

    public void setId(String ID) {
        id=ID;
    }

    public void setTexto(String Text) {
        text=Text;
    }


    public void setOptions(Map<String, String> Options) {
        options = Options;
    }

    public String getText() {
        return text;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public void setText(String Text) {
        text = Text;
    }

    public String getId() {
        return id;
    }
}