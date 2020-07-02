package com.abdheshnayak.typingguru.keyboard_controller;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.io.IOException;

public class keyboardController {

    public VBox key_tild, key_1, key_2, key_3, key_4, key_5, key_6, key_7, key_8, key_9, key_0, key_minus, key_plus, key_BackSpace;

    public VBox key_Tab, key_q, key_w, key_e, key_r, key_t, key_y, key_u, key_i, key_o, key_p, key_bracket_left, key_bracket_right, key_backSlash;

    public VBox key_caps, key_a, key_s, key_d, key_f, key_g, key_h, key_j, key_k, key_l, key_colan, key_quot, key_enter;

    public VBox key_shift_left, key_z, key_x, key_c, key_v, key_b, key_n, key_m, key_lt, key_gt, key_question, key_shift_right;

    public VBox key_cntrl_left, key_win_left, key_alt_left, key_space, key_alt_right, key_win_right, key_func, key_cntrl_right;

    public VBox keyboardContainer;

    public void initialize() {
        changeFont("English");
    }

    public void changeFont(String language) {

        removeFont("English");
        removeFont("Hindi");
        removeFont("Nepali");
        removeFont("Punjabi");
        removeFont("Urdu");
        removeFont("Tamil");
        removeFont("Bengali");

        key_tild.getStyleClass().add(language);;
        key_1.getStyleClass().add(language);;
        key_2.getStyleClass().add(language);;
        key_3.getStyleClass().add(language);;
        key_4.getStyleClass().add(language);;
        key_5.getStyleClass().add(language);;
        key_6.getStyleClass().add(language);;
        key_7.getStyleClass().add(language);;
        key_8.getStyleClass().add(language);;
        key_9.getStyleClass().add(language);;
        key_0.getStyleClass().add(language);;
        key_plus.getStyleClass().add(language);;
        key_minus.getStyleClass().add(language);;


        key_q.getStyleClass().add(language);;
        key_w.getStyleClass().add(language);;
        key_e.getStyleClass().add(language);;
        key_r.getStyleClass().add(language);;
        key_t.getStyleClass().add(language);;
        key_y.getStyleClass().add(language);;
        key_u.getStyleClass().add(language);;
        key_i.getStyleClass().add(language);;
        key_o.getStyleClass().add(language);;
        key_p.getStyleClass().add(language);;
        key_bracket_left.getStyleClass().add(language);;
        key_bracket_right.getStyleClass().add(language);;
        key_backSlash.getStyleClass().add(language);;

        key_a.getStyleClass().add(language);;
        key_s.getStyleClass().add(language);;
        key_d.getStyleClass().add(language);;
        key_f.getStyleClass().add(language);;
        key_g.getStyleClass().add(language);;
        key_h.getStyleClass().add(language);;
        key_j.getStyleClass().add(language);;
        key_k.getStyleClass().add(language);;
        key_p.getStyleClass().add(language);;
        key_l.getStyleClass().add(language);;
        key_colan.getStyleClass().add(language);;
        key_quot.getStyleClass().add(language);;

        key_z.getStyleClass().add(language);;
        key_x.getStyleClass().add(language);;
        key_c.getStyleClass().add(language);;
        key_v.getStyleClass().add(language);;
        key_b.getStyleClass().add(language);;
        key_n.getStyleClass().add(language);;
        key_m.getStyleClass().add(language);;
        key_lt.getStyleClass().add(language);;
        key_gt.getStyleClass().add(language);;
        key_question.getStyleClass().add(language);;


    }

    private void removeFont(String language) {

        key_tild.getStyleClass().remove(language);;
        key_1.getStyleClass().remove(language);;
        key_2.getStyleClass().remove(language);;
        key_3.getStyleClass().remove(language);;
        key_4.getStyleClass().remove(language);;
        key_5.getStyleClass().remove(language);;
        key_6.getStyleClass().remove(language);;
        key_7.getStyleClass().remove(language);;
        key_8.getStyleClass().remove(language);;
        key_9.getStyleClass().remove(language);;
        key_0.getStyleClass().remove(language);;
        key_plus.getStyleClass().remove(language);;
        key_minus.getStyleClass().remove(language);;


        key_q.getStyleClass().remove(language);;
        key_w.getStyleClass().remove(language);;
        key_e.getStyleClass().remove(language);;
        key_r.getStyleClass().remove(language);;
        key_t.getStyleClass().remove(language);;
        key_y.getStyleClass().remove(language);;
        key_u.getStyleClass().remove(language);;
        key_i.getStyleClass().remove(language);;
        key_o.getStyleClass().remove(language);;
        key_p.getStyleClass().remove(language);;
        key_bracket_left.getStyleClass().remove(language);;
        key_bracket_right.getStyleClass().remove(language);;
        key_backSlash.getStyleClass().remove(language);;

        key_a.getStyleClass().remove(language);;
        key_s.getStyleClass().remove(language);;
        key_d.getStyleClass().remove(language);;
        key_f.getStyleClass().remove(language);;
        key_g.getStyleClass().remove(language);;
        key_h.getStyleClass().remove(language);;
        key_j.getStyleClass().remove(language);;
        key_k.getStyleClass().remove(language);;
        key_p.getStyleClass().remove(language);;
        key_l.getStyleClass().remove(language);;
        key_colan.getStyleClass().remove(language);;
        key_quot.getStyleClass().remove(language);;

        key_z.getStyleClass().remove(language);;
        key_x.getStyleClass().remove(language);;
        key_c.getStyleClass().remove(language);;
        key_v.getStyleClass().remove(language);;
        key_b.getStyleClass().remove(language);;
        key_n.getStyleClass().remove(language);;
        key_m.getStyleClass().remove(language);;
        key_lt.getStyleClass().remove(language);;
        key_gt.getStyleClass().remove(language);;
        key_question.getStyleClass().remove(language);;


    }

    private void showKey(KeyEvent keyEvent) {
        int x;
        try {
            x = (int) keyEvent.getText().charAt(0);
            turnKeyOn(keyEvent.getText(), "greenbg");
        } catch (Exception e) {
            clearAllTurned("green");
            turnKeyOn(keyEvent.getCode().toString(), "greenbg");
        }
//        System.out.println(keyEvent.getCode().toString());
    }

    public void turnKeyOn(String text, String styleClass) {
//        System.out.println(text);
        if (styleClass.equals("greenbg")){
            clearAllTurned("redbg");
        }
        clearAllTurned(styleClass);
        switch (text) {

            case "~":
                key_tild.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "`":
                key_tild.getStyleClass().add(styleClass);
                break;

            case "!":
                key_1.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "1":
                key_1.getStyleClass().add(styleClass);
                break;

            case "@":
                key_2.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "2":
                key_2.getStyleClass().add(styleClass);
                break;

            case "#":
                key_3.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "3":
                key_3.getStyleClass().add(styleClass);
                break;

            case "$":
                key_4.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "4":
                key_4.getStyleClass().add(styleClass);
                break;

            case "%":
                key_5.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "5":
                key_5.getStyleClass().add(styleClass);
                break;

            case "^":
                key_6.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "6":
                key_6.getStyleClass().add(styleClass);
                break;

            case "&":
                key_7.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "7":
                key_7.getStyleClass().add(styleClass);
                break;

            case "*":
                key_8.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "8":
                key_8.getStyleClass().add(styleClass);
                break;

            case "(":
                key_9.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "9":
                key_9.getStyleClass().add(styleClass);
                break;

            case ")":
                key_0.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "0":
                key_0.getStyleClass().add(styleClass);
                break;

            case "_":
                key_minus.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "-":
                key_minus.getStyleClass().add(styleClass);
                break;

            case "+":
                key_plus.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "=":
                key_plus.getStyleClass().add(styleClass);
                break;

            case "BACK_SPACE":
                key_BackSpace.getStyleClass().add(styleClass);
                break;
            case "CAPS":
                key_caps.getStyleClass().add(styleClass);
                break;

            case "TAB":
                key_Tab.getStyleClass().add(styleClass);
                break;
            case "q":
                key_q.getStyleClass().add(styleClass);
                break;
            case "Q":
                key_q.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "w":
                key_w.getStyleClass().add(styleClass);
                break;
            case "W":
                key_w.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "e":
                key_e.getStyleClass().add(styleClass);
                break;
            case "E":
                key_e.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "r":
                key_r.getStyleClass().add(styleClass);
                break;
            case "R":
                key_r.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "t":
                key_t.getStyleClass().add(styleClass);
                break;
            case "T":
                key_t.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "y":
                key_y.getStyleClass().add(styleClass);
                break;
            case "Y":
                key_y.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "u":
                key_u.getStyleClass().add(styleClass);
                break;
            case "U":
                key_u.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "i":
                key_i.getStyleClass().add(styleClass);
                break;
            case "I":
                key_i.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "o":
                key_o.getStyleClass().add(styleClass);
                break;
            case "O":
                key_o.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "p":
                key_p.getStyleClass().add(styleClass);
                break;
            case "P":
                key_p.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "[":
                key_bracket_left.getStyleClass().add(styleClass);
                break;
            case "{":
                key_bracket_left.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "]":
                key_bracket_right.getStyleClass().add(styleClass);
                break;
            case "}":
                key_bracket_right.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "\\":
                key_backSlash.getStyleClass().add(styleClass);
                break;
            case "|":
                key_backSlash.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;


            case "a":
                key_a.getStyleClass().add(styleClass);
                break;
            case "A":
                key_a.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "s":
                key_s.getStyleClass().add(styleClass);
                break;
            case "S":
                key_s.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "d":
                key_d.getStyleClass().add(styleClass);
                break;
            case "D":
                key_d.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "f":
                key_f.getStyleClass().add(styleClass);
                break;
            case "F":
                key_f.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "g":
                key_g.getStyleClass().add(styleClass);
                break;
            case "G":
                key_g.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "h":
                key_h.getStyleClass().add(styleClass);
                break;
            case "H":
                key_h.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "j":
                key_j.getStyleClass().add(styleClass);
                break;
            case "J":
                key_j.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "k":
                key_k.getStyleClass().add(styleClass);
                break;
            case "K":
                key_k.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "l":
                key_l.getStyleClass().add(styleClass);
                break;
            case "L":
                key_l.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case ";":
                key_colan.getStyleClass().add(styleClass);
                break;
            case ":":
                key_colan.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "'":
                key_quot.getStyleClass().add(styleClass);
                break;
            case "\"":
                key_quot.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "ENTER":
                key_enter.getStyleClass().add(styleClass);
                break;


            case "z":
                key_z.getStyleClass().add(styleClass);
                break;
            case "Z":
                key_z.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "x":
                key_x.getStyleClass().add(styleClass);
                break;
            case "X":
                key_x.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "c":
                key_c.getStyleClass().add(styleClass);
                break;
            case "C":
                key_c.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "v":
                key_v.getStyleClass().add(styleClass);
                break;
            case "V":
                key_v.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "b":
                key_b.getStyleClass().add(styleClass);
                break;
            case "B":
                key_b.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "n":
                key_n.getStyleClass().add(styleClass);
                break;
            case "N":
                key_n.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "m":
                key_m.getStyleClass().add(styleClass);
                break;
            case "M":
                key_m.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case ",":
                key_lt.getStyleClass().add(styleClass);
                break;
            case "<":
                key_lt.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case ".":
                key_gt.getStyleClass().add(styleClass);
                break;
            case ">":
                key_gt.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "/":
                key_question.getStyleClass().add(styleClass);
                break;
            case "?":
                key_question.getStyleClass().add(styleClass);
                turnShiftOn(styleClass);
                break;
            case "SHIFT":
                turnShiftOn(styleClass);
                break;

            case "CONTROL":
                key_cntrl_left.getStyleClass().add(styleClass);
                key_cntrl_right.getStyleClass().add(styleClass);
                break;
            case "ALT":
                key_alt_left.getStyleClass().add(styleClass);
                key_alt_right.getStyleClass().add(styleClass);
                break;
            case " ":
                key_space.getStyleClass().add(styleClass);
        }
    }

    private void turnShiftOn(String styleClass) {
        key_shift_left.getStyleClass().add(styleClass);
        key_shift_right.getStyleClass().add(styleClass);
    }

    public void clearAllTurned(String styleClass) {

        key_tild.getStyleClass().remove(styleClass);
        key_1.getStyleClass().remove(styleClass);
        key_2.getStyleClass().remove(styleClass);
        key_3.getStyleClass().remove(styleClass);
        key_4.getStyleClass().remove(styleClass);
        key_5.getStyleClass().remove(styleClass);
        key_6.getStyleClass().remove(styleClass);
        key_7.getStyleClass().remove(styleClass);
        key_8.getStyleClass().remove(styleClass);
        key_9.getStyleClass().remove(styleClass);
        key_0.getStyleClass().remove(styleClass);
        key_plus.getStyleClass().remove(styleClass);
        key_minus.getStyleClass().remove(styleClass);
        key_BackSpace.getStyleClass().remove(styleClass);

        key_Tab.getStyleClass().remove(styleClass);
        key_q.getStyleClass().remove(styleClass);
        key_w.getStyleClass().remove(styleClass);
        key_e.getStyleClass().remove(styleClass);
        key_r.getStyleClass().remove(styleClass);
        key_t.getStyleClass().remove(styleClass);
        key_y.getStyleClass().remove(styleClass);
        key_u.getStyleClass().remove(styleClass);
        key_i.getStyleClass().remove(styleClass);
        key_o.getStyleClass().remove(styleClass);
        key_p.getStyleClass().remove(styleClass);
        key_bracket_left.getStyleClass().remove(styleClass);
        key_bracket_right.getStyleClass().remove(styleClass);
        key_backSlash.getStyleClass().remove(styleClass);

        key_caps.getStyleClass().remove(styleClass);
        key_a.getStyleClass().remove(styleClass);
        key_s.getStyleClass().remove(styleClass);
        key_d.getStyleClass().remove(styleClass);
        key_f.getStyleClass().remove(styleClass);
        key_g.getStyleClass().remove(styleClass);
        key_h.getStyleClass().remove(styleClass);
        key_j.getStyleClass().remove(styleClass);
        key_k.getStyleClass().remove(styleClass);
        key_p.getStyleClass().remove(styleClass);
        key_l.getStyleClass().remove(styleClass);
        key_colan.getStyleClass().remove(styleClass);
        key_quot.getStyleClass().remove(styleClass);
        key_enter.getStyleClass().remove(styleClass);

        key_shift_left.getStyleClass().remove(styleClass);
        key_z.getStyleClass().remove(styleClass);
        key_x.getStyleClass().remove(styleClass);
        key_c.getStyleClass().remove(styleClass);
        key_v.getStyleClass().remove(styleClass);
        key_b.getStyleClass().remove(styleClass);
        key_n.getStyleClass().remove(styleClass);
        key_m.getStyleClass().remove(styleClass);
        key_lt.getStyleClass().remove(styleClass);
        key_gt.getStyleClass().remove(styleClass);
        key_question.getStyleClass().remove(styleClass);
        key_shift_right.getStyleClass().remove(styleClass);

        key_cntrl_left.getStyleClass().remove(styleClass);
        key_cntrl_right.getStyleClass().remove(styleClass);
        key_win_left.getStyleClass().remove(styleClass);
        key_win_right.getStyleClass().remove(styleClass);
        key_alt_left.getStyleClass().remove(styleClass);
        key_alt_right.getStyleClass().remove(styleClass);
        key_func.getStyleClass().remove(styleClass);
        key_space.getStyleClass().remove(styleClass);

        if (Toolkit.getDefaultToolkit().getLockingKeyState(java.awt.event.KeyEvent.VK_CAPS_LOCK)){
            key_caps.getStyleClass().add("redbg");
        }

    }
}
