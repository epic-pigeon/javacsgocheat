package org.xena;

import org.xena.plugin.official.ShowWeaponsWindow;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class Test{
   public static void main(String[] k) throws InterruptedException {
       ArrayList<String> args = new ArrayList<>() {{
           add("kar1");
           add("kar2");
           add("kar3");
       }};
       ShowWeaponsWindow window = ShowWeaponsWindow.open(args);
       TimeUnit.SECONDS.sleep(10);
       args.add("kar4");
       window.repaint(args);
   }
}