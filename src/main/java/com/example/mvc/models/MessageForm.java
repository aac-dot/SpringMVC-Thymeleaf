package com.example.mvc.models;

/**
 * Represent the fields that the webpage form has.
 * Use it in the controller to receive the information came from the form.
 * */

public class MessageForm {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
