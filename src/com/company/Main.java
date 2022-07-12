package com.company;

import javax.swing.*;
import java.awt.*;

public class Main{

    public static void main(String[] args) {
        Animation an = new Animation();
        Thread thread = new Thread(an);
        thread.start();
    }
}
