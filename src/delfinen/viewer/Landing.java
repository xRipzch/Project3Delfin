package delfinen.viewer;

import delfinen.misc.ConsoleColors;


import delfinen.misc.ConsoleColors;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.concurrent.TimeUnit;


public class Landing {
    private static final String SOUND_FILE = "src/delfinen/viewer/sound.wav";

    public void intro1() {
        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT);
        System.out.println();
        System.out.println();
        System.out.println("                      Delfinen Swimclub!                      ");
        System.out.println("                         Please hold.                        ");
        System.out.println();
        sleep();
        playSound();
        System.out.println("                                  __");
        System.out.println("                               _.-~  )");
        System.out.println("                    _..--~~~~,'   ,-/     _");
        sleep();
        System.out.println("                 .-'. . . .'   ,-','    ,' )");
        System.out.println("               ,'. . . _   ,--~,-'__..-'  ,'");
        System.out.println("             ,'. . .  (@)' ---~~~~      ,'");
        sleep();
        System.out.println("           //. . . . '~~             ,-'");
        System.out.println("          //. . . . .             ,-'");
        System.out.println("          ; . . . .  - .        ,'");
        sleep();
        System.out.println("         : . . . .       _     /");
        System.out.println("        . . . . .          `- .:");
        System.out.println("       . . . ./  - .          )");
        System.out.println("      .  . . |  _____..---.._/ _____");
        System.out.println("~---~~~~----~~~~             ~~");
        System.out.println(ConsoleColors.RESET);
        sleep();
    }
    private void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\delfinen\\viewer\\sound.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.err.println("Error playing sound: " + e.getMessage());
        }
    }


    public void sleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(350);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

